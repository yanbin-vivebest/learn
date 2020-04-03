package com.learn.demo.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * 关于Buffer的Scattering和Gathering
 */
public class NioTest1 {
    public static void main(String[] args) throws  Exception {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        InetSocketAddress address = new InetSocketAddress(8899);
        serverSocketChannel.socket().bind(address);
        int messageLength = 2+3+4;
        ByteBuffer[] byteBuffers = new ByteBuffer[3];
        byteBuffers[0] = ByteBuffer.allocate(2);
        byteBuffers[1] = ByteBuffer.allocate(3);
        byteBuffers[2] = ByteBuffer.allocate(4);

        SocketChannel socketChannel = serverSocketChannel.accept();
        System.out.println("客户端连接上...");
        while (true){

            int byteRead = 0;
            while(byteRead < messageLength){
                long r = socketChannel.read(byteBuffers);
                byteRead += r;

                System.out.println("byteRead:" + byteRead);

                Arrays.asList(byteBuffers).stream().forEach(buffer -> {
                    System.out.println("position:"+ buffer.position() + ",limit:" + buffer.limit());
                });

            }
            Arrays.asList(byteBuffers).stream().forEach(buffer->{
                buffer.flip();//将每个buffer进行反转操作
            });

            long byteWriter = 0;
            while(byteWriter<messageLength){
               long w =  socketChannel.write(byteBuffers);
                byteWriter += w;
            }

            Arrays.asList(byteBuffers).stream().forEach(buffer->{
                buffer.clear();//将每个buffer的参数位置复原
            });

            System.out.println("byteRead:"+byteRead+",byteWriter:"+byteWriter+",messageLength:" + messageLength);

        }
    }
}
