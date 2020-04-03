package com.learn.demo.zero_copy.first;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class OldServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8899);
        while(true){
            Socket socket = serverSocket.accept(); //阻塞的方法
            System.out.println("客户端连接上了...");
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            try {
                byte[] byteArray = new byte[4096];
                while (true){
                    int readCount = dataInputStream.read(byteArray, 0, byteArray.length);
                    if( -1 == readCount){
//                        System.out.println("读取文件： " + new String(byteArray));
                    }else{
                        break;
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
