package com.learn.demo.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorTest {
    public static void main(String[] args) throws  Exception {
        int[] ports = new int[5];
        ports[0] = 5000;
        ports[1] = 5001;
        ports[2] = 5002;
        ports[3] = 5003;
        ports[4] = 5004;

        Selector selector = Selector.open();

        for (int i = 0;i<ports.length;i++){
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.configureBlocking(false);
            channel.socket().bind(new InetSocketAddress("localhost",ports[i]));

            SelectionKey register = channel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("监听端口:" + ports[i]);
        }
        while(true){
            int number = selector.select();//
            System.out.println("number:" + number);

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("selectionKeys:" + selectionKeys);

            Iterator<SelectionKey> iter = selectionKeys.iterator();
            while(iter.hasNext()){
                SelectionKey selectionKey = iter.next();
                if(selectionKey.isAcceptable()){
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel(); //表示真正关联的channel对象
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector,SelectionKey.OP_READ);

                    iter.remove();

                    System.out.println("获得客户端连接:" + socketChannel);
                }else if(selectionKey.isReadable()){
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel(); //表示真正关联的channel对象

                    int byteRead = 0;
                    while(true){
                        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                        byteBuffer.clear();
                        int read = socketChannel.read(byteBuffer);
                        if(read<=0){
                            break;
                        }
                        byteBuffer.flip();
                        socketChannel.write(byteBuffer);
                        byteRead += read;
                    }
                    System.out.println("读取: " + byteRead+",来自于:" + socketChannel);
                    iter.remove();
                }
            }
        }
    }
}
