package com.oracle.java.advance.t10.socketTransferFile;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args)  throws Exception{
        Socket  client=new Socket("172.19.22.141",9999);
        InputStream in=client.getInputStream();
        FileOutputStream  fileOut=new FileOutputStream("D:\\接受.jpg");
        int b=-1;
        while((b=in.read())!=-1){
            fileOut.write(b);
            System.out.println(b);
        }
        fileOut.close();
        in.close();
        System.out.println("文件已经接受完毕");
    }
}
