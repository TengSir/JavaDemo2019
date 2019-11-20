package com.oracle.java.advance.t10;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args)  throws Exception{
            ServerSocket  server=new ServerSocket(9999);//65535
            System.out.println("服务器启动成功");

            Socket  client=server.accept();//阻塞方法(如果没有任何人链接服务器，这行代码将永远等待)，可以接受一个人链接
            System.out.println("已经有一个客户端链接进来了");
            System.out.println(client.getInetAddress().getHostAddress());

            //封装一个控制台输入字符流，用来读取服务器想发出去的话
            BufferedReader consoleInput=new BufferedReader(new InputStreamReader( System.in));

            //一旦客户端链接成功后，就可以使用socket的io对象来进行数据输入和输出
            BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            //网络通道的输入流
            BufferedReader  reader=new BufferedReader(new InputStreamReader(client.getInputStream()));

            //为了让读写代码互不影响，我们将发送消息的代码单独运行在一个线程中
            new Thread(){
                @Override
                public void run() {
                 try{
                    while(true){
                        String recivedMessage= reader.readLine();//读取客户端给我发过来的一句话
                        System.out.println("客户端说："+recivedMessage);
                    }

                 }catch (Exception e){
                     e.printStackTrace();
                 }
                }
            }.start();

            while(true) {
                System.out.println("请输入您想发给客户端的话：");
                String willSend = consoleInput.readLine();//阻塞代码
                writer.write(willSend);
                writer.newLine();
                writer.flush();
            }


    }

}
