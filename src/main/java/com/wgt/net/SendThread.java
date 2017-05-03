package com.wgt.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Administrator on 2017/5/3.
 */
public class SendThread implements Runnable {

    private BufferedReader console;
    private DataOutputStream dos;
    private boolean isRunnable = true;

    /**
     * 构造发送线程体
     * @param socket
     */
    public SendThread(Socket socket) {
        console= new BufferedReader(new InputStreamReader(System.in));
        try {
            dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            //e.printStackTrace();
            isRunnable=false;
            CloseUtil.closeAll(console,dos);
        }

    }

    public void run() {
        while (isRunnable){
            send();
        }
    }


    //获取控制台输入的信息
    private String getMessage(){
        try {
            return console.readLine();
        }catch (IOException e) {
            return "";
        }
    }

    //将获取到的信息打包发送
    public void send(){
        String msg = getMessage();
        if (null!=msg&&!"".equals(msg)){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                isRunnable=false;
                CloseUtil.closeAll(dos,console);
            }

        }
    }

}
