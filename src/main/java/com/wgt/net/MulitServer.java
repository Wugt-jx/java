package com.wgt.net;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2017/5/3.
 */
public class MulitServer {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8888);
        String msg = "欢迎使用微服务！";
        boolean flag =true;
        while(flag){
            Socket socket = server.accept();
            System.out.println("客户机"+socket.getInetAddress().getHostName()+"连接，地址是："+socket.getInetAddress().getHostAddress()+",端口："+socket.getPort());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(msg);
            dos.flush();
        }
    }


}
