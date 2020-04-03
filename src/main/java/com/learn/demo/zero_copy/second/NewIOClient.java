package com.learn.demo.zero_copy.second;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NewIOClient {
    public static void main(String[] args) throws Exception{
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",8899));
        socketChannel.configureBlocking(false);

        String fileName = "E:\\BaiduNetdiskDownload\\26_gRPC服务器流式调用实现.7z";

        FileChannel fileChannel = new FileInputStream(fileName).getChannel();

        long startTime = System.currentTimeMillis();

        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel); //实际传送的,零拷贝方法

        System.out.println("发送总字节数:" + transferCount + ",耗时:" + (System.currentTimeMillis()-startTime));

    }
}
