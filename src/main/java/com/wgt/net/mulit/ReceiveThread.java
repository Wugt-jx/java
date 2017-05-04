package com.wgt.net.mulit;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Administrator on 2017/5/3.
 */
public class ReceiveThread implements Runnable {

    private DataInputStream dis ;
    private boolean isRunnable = true;


    public ReceiveThread(Socket client) {
        try {
            this.dis = new DataInputStream(client.getInputStream());
        }catch (IOException e){
            isRunnable = false;
            CloseUtil.closeAll(dis);
        }

    }

    public void run() {
        while (isRunnable){
            System.out.println(receive());
        }
    }



    public String receive() {
        String msg = "";
        try {
            msg = dis.readUTF();
        }catch (IOException e){
            isRunnable=false;
            CloseUtil.closeAll(dis);
        }
        return msg;
    }

}
