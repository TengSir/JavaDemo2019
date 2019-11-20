package com.oracle.java.advance.t10.socketTransferFile;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception{

        ServerSocket  server=new ServerSocket(9999);
        while(true) {
            Socket client = server.accept();
            System.out.println(client.getInetAddress().getHostAddress()+"链接进来了");

            OutputStream out = client.getOutputStream();

            FileInputStream fileInput = new FileInputStream("/Users/tengsir/1.jpg");

            byte[] bs = new byte[1024 * 1024 * 10];
            int b = -1;
            while ((b = fileInput.read(bs)) != -1) {
                out.write(bs, 0, b);
                System.out.println(b);
            }
            out.close();
            fileInput.close();
            System.out.println("文件已经发送完毕");
        }


    }
}
