package com.oracle.java.advance.t10;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args)  throws Exception{

        //172.19.22.141
        //localhost
        //127.0.0.1
            Socket  c=new Socket("172.19.22.141",9999);//创建一个客户端socket对象，并且指定要链接的服务器ip和端口
            System.out.println("链接服务器成功！");
            //第一，如果网络不通，第二如果对应的地址没有开启任何一个serversocket，第三，端口不对

            //准备一个控制输入流，用来读取用户从控制台输入的文字
            BufferedReader  consoleInput=new BufferedReader(new InputStreamReader(System.in));


            //一旦服务器链接成功后，就可以进行io操作了
            BufferedReader reader=new BufferedReader(new InputStreamReader(c.getInputStream()));
            //准备一个网络通道的输出流
            BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(c.getOutputStream()));

            new Thread(){
                @Override
                public void run() {
                    try{
                      while(true){
                          String message=  reader.readLine();//网络IO都是阻塞的，如果对方给没有输出，则这里的输入方法会是阻塞状态
                          System.out.println("服务器给我说:"+message);
                      }

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }.start();
             while(true){

                 System.out.println("请输入要发送给服务器的消息：");
                 String willSendMessage= consoleInput.readLine();//读取控制台一行消息，
                 writer.write(willSendMessage+"\r\n");
                 writer.flush();
             }

    }
}
