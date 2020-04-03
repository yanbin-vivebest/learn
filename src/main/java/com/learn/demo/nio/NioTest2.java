package com.learn.demo.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class NioTest2 {

    private static Map<String,SocketChannel> allClients = new HashMap<>();

    public static void main(String[] args) throws  Exception {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);

        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8899)); //绑定端口

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT); //将channel注册到给定的selector中

        //注册完之后就进行事件处理
        while(true){
            try {
                int number = selector.select();//当有事件发生的才有返回，返回所关注的事件的数量
                System.out.println("number:" + number);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                selectionKeys.forEach(selectionKey -> {
                    final  SocketChannel client ;
                    try {
                        if(selectionKey.isAcceptable()){ //客户端向服务端发起连接
                            ServerSocketChannel ssc  = (ServerSocketChannel) selectionKey.channel();
                            client = ssc.accept();
                            client.configureBlocking(false);
                            client.register(selector,SelectionKey.OP_READ);

                            String key = "[" + UUID.randomUUID().toString()+"]";
                            allClients.put(key,client);

                        }else if(selectionKey.isReadable()){
                            client = (SocketChannel)selectionKey.channel();
                            ByteBuffer readBuffer = ByteBuffer.allocate(512);
                            int count = client.read(readBuffer);
                            if(count > 0){
                                readBuffer.flip();

                                //字符集编码
                                Charset charset = Charset.forName("utf-8");
                                String reciveMessage = String.valueOf(charset.decode(readBuffer).array());
                                System.out.println("recieveMessage: " + reciveMessage);

                                //分发给所有连接的客户端
                                String sendKey = null;
                                for(Map.Entry<String, SocketChannel> entry:allClients.entrySet()) { //获取发送者的key
                                    if(client == entry.getValue()) {
                                        sendKey = entry.getKey();
                                    }
                                }
                                for(Map.Entry<String, SocketChannel> entry:allClients.entrySet()) {
                                    SocketChannel socketChannel = entry.getValue();

                                    ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                                    writeBuffer.put((sendKey + ":" + reciveMessage).getBytes()); //读

                                    writeBuffer.flip();

                                    socketChannel.write(writeBuffer);//写
                                }
                            }
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                });
                selectionKeys.clear();//一定要清空
            }catch (Exception e){
                e.printStackTrace();
            }

        }








    }
}
