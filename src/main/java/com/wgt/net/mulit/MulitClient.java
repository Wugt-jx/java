package com.wgt.net.mulit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 聊天室客户端
 */
public class MulitClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.print("请输入本次群聊使用的名称：");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReader.readLine();
        if (name == null && name.trim().equals("")) {
            System.out.println("名称格式不正确，将退出程序");
            Thread.sleep(3000);
            return;
        }


        Socket client = new Socket("127.0.0.1", 8888);
        new Thread(new SendThread(client, name)).start();
        new Thread(new ReceiveThread(client)).start();
    }
}
