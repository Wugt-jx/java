package com.wgt.net;

import java.io.IOException;
import java.net.Socket;

/**
 * 聊天室客户端
 */
public class MulitClient {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1",8888);


        new Thread(new SendThread(client));



        /*BufferedReader console = new BufferedReader(new InputStreamReader(System.in));  //控制台输入要发送的信息

        String info = console.readLine();   //获取发送的信息

        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF(info);
        dos.flush();*/
    }
}
