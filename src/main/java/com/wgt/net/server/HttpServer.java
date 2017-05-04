package com.wgt.net.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模仿网站的Http服务
 */
public class HttpServer {

    private ServerSocket server;


    public static void main(String[] args) throws IOException {
        HttpServer server = new HttpServer();
        server.start();
    }

    public void start(){
        try {
            server = new ServerSocket(80);

            this.receive();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void receive(){
        try {
            Socket socket= server.accept();
            StringBuilder sb = new StringBuilder();
            String msg = null;
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while ((msg = br.readLine()).length()>0){
                sb.append(msg);
                sb.append("\r\n");
                if (null==msg){
                    break;
                }
            }
            String requestInfo = sb.toString();
            System.out.println(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
