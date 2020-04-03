package com.learn.demo.zero_copy.second;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

//使用零拷贝
public class NewIOServer {
    public static void main(String[] args) throws  Exception {
        InetSocketAddress address = new InetSocketAddress(8899);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(address);

        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
        while(true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(true); //配置成阻塞
            int readCount = 0;
            while(-1 != readCount){
                try {
                    readCount = socketChannel.read(byteBuffer); //读到后直接丢弃
                    byteBuffer.rewind();//一定要执行该代码
//                    byteBuffer.clear();// 这里用clear是否也是可以的？
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }



    }
}
