package com.wgt.net.mulit;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 聊天室小项目
 * 基于TCp的socket编程，实现的功能   发送消息和接受信息数据的独立性
 *  聊天室内有多个人，实现用户之间的独立性
 *  客户端发送一天消息到服务端，服务端把该信息分发给每个客户端
 *  使用特定的数据格式，@XXX: 可以实现私聊的功能
 */

/**
 * 聊天室服务端
 */
public class MulitServer {

    private List<MyChannle> myChannleList = new ArrayList<MyChannle>();


    public static void main(String[] args) throws IOException {
        new MulitServer().start();
    }

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(8888);

        while (true){
            Socket client = server.accept();
            System.out.println("主机"+client.getInetAddress().getHostName()+"连接，地址是"+client.getInetAddress().getHostAddress()+",端口"+client.getPort());
            MyChannle myChannle =new MyChannle(client);
            myChannleList.add(myChannle);
            new Thread(myChannle).start();
        }
    }

    /**
     * 对应客户端的线程程序
     */
    private class MyChannle implements Runnable{

        private DataOutputStream dos;
        private DataInputStream dis;
        private boolean isRunning = true;
        private String cname;


        public MyChannle(Socket client) {
            try {
                dos = new DataOutputStream(client.getOutputStream());
                dis = new DataInputStream(client.getInputStream());
                this.cname = dis.readUTF();
                this.send("欢迎 "+cname+" 进入聊天室！");
                this.sendOther("欢迎 "+cname+" 进入聊天室！");
            }catch (IOException e){
                isRunning = false;
                CloseUtil.closeAll(dos,dis);
            }
        }

        /**
         * 接受数据
         * @return
         */
        private String receive(){
            String msg = "";
            try {
                msg= dis.readUTF();
            }catch (IOException e){
                isRunning = false;
                CloseUtil.closeAll(dos,dis);
                myChannleList.remove(this);
            }
            return this.cname+"："+msg;
        }


        /**
         * 发送数据
         * @param msg
         */
        private void send(String msg){
            if (msg!=null&&!"".equals(msg)){
                try {
                    dos.writeUTF(msg);
                    dos.flush();
                }catch (IOException e){
                    isRunning = false;
                    CloseUtil.closeAll(dos,dis);
                    myChannleList.remove(this);
                }
            }
        }

        /**
         * 转发给其他客户端
         * @param msg
         */
        private void sendOther(String msg){
            if (msg.contains("@")&&msg.contains(":")){
                String oname =msg.substring(msg.indexOf("@")+1,msg.indexOf(":"));
                String content = msg.substring(msg.indexOf(":")+1);
                for (MyChannle other:myChannleList){
                    if (oname.equals(other.cname)){
                        other.send(this.cname+"悄悄对你说:"+content);
                    }
                }
            }else {
                for (MyChannle other : myChannleList) {
                    if (other == this) {
                        continue;
                    }
                    other.send(msg);
                }
            }
        }

        public void run() {
            while (isRunning){
                sendOther(receive());
            }
        }
    }


}
