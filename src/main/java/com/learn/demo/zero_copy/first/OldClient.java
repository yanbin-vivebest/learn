package com.learn.demo.zero_copy.first;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

public class OldClient {
    public static void main(String[] args)throws  Exception {
        Socket socket = new Socket("localhost",8899);

        String fileName = "E:\\BaiduNetdiskDownload\\26_gRPC服务器流式调用实现.7z";
        InputStream inputStream = new FileInputStream(fileName);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] buffer = new byte[4096];
        long readCount = 0;
        long total = 0;

        long startTime = System.currentTimeMillis();
        System.out.println("开始时间:" + startTime);
        while((readCount = inputStream.read(buffer)) >= 0){
            total += readCount;
            dataOutputStream.write(buffer);
        }
        System.out.println("发送总字节数：" + total+",耗时:" + (System.currentTimeMillis()-startTime));
        dataOutputStream.close();
        socket.close();
        inputStream.close();

    }
}
