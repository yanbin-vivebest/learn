package com.learn.demo.nio2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<SocketChannel> list = new ArrayList();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.bind(new InetSocketAddress(8899));
            ssc.configureBlocking(false);
            while (true){
                System.out.println("----------------------------------");
                SocketChannel socketChannel = ssc.accept();
                if(socketChannel==null){
                    Thread.sleep(1000);
                    System.out.println("没人连接 : "+ LocalDateTime.now().toString());
                    for (SocketChannel channel : list) {
                        System.out.println("没人连接,循环: " + channel.toString());
                        Thread.sleep(5000);
                        int k =channel.read(byteBuffer);
                        System.out.println("没人连接k值 : "+ k);
                        if(k!=0){
                            byteBuffer.flip();
                            System.out.println(new String(byteBuffer.array()));
                        }
                    }
                }else{
                    socketChannel.configureBlocking(false);

                    list.add(socketChannel);
                    //得到套接字，循环所有的套接字，通过套接字获取数据
                    for (SocketChannel channel : list) {
                        System.out.println("连接,循环: " + channel.toString());
                        Thread.sleep(5000);
                        int k =channel.read(byteBuffer);
                        System.out.println("连接k值 : "+ k);
                        if(k!=0){
                            byteBuffer.flip();
                            System.out.println(new String(byteBuffer.array()));
                        }
                    }
//
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
