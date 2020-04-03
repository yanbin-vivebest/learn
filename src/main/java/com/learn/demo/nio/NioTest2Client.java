package com.learn.demo.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioTest2Client {

	public static void main(String[] args) throws Exception {
		try {
			SocketChannel socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);

			Selector selector = Selector.open();
			socketChannel.register(selector, SelectionKey.OP_CONNECT);

			socketChannel.connect(new InetSocketAddress("127.0.0.1",8899));

			while(true) {
				selector.select();

				Set<SelectionKey> selectionKeys = selector.selectedKeys();

                selectionKeys.forEach(selectionKey -> {
                	if(selectionKey.isConnectable()) { //已经建立好了连接
                		SocketChannel client = (SocketChannel)selectionKey.channel();
                		if(client.isConnectionPending()) { //是否在一个挂起的状态
							try {
								client.finishConnect(); //完成连接，真正建立好了，接下来就真正可以写了
							} catch (IOException e) {
 								e.printStackTrace();
							}

							ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
							byteBuffer.put((LocalDateTime.now() + "连接成功").getBytes());

							byteBuffer.flip();
							try {
								client.write(byteBuffer); //写出去
							} catch (IOException e) {
								e.printStackTrace();
							}
							ExecutorService executorService = Executors.newSingleThreadExecutor();
							executorService.submit(new Runnable() {
								@Override
								public void run() {
									while(true) {
										byteBuffer.clear();

										InputStreamReader input = new InputStreamReader(System.in);
										BufferedReader br = new BufferedReader(input);

										String sendMessage = "";
										try {
											sendMessage = br.readLine();
										} catch (IOException e) {
											e.printStackTrace();
										}
										byteBuffer.put(sendMessage.getBytes());
										byteBuffer.flip();
										try {
											client.write(byteBuffer);
										} catch (IOException e) {
											e.printStackTrace();
										}

									}
								}
							});
                		}
                        try {
                            client.register(selector,SelectionKey.OP_READ); //在当前位置注册读时间
                        } catch (ClosedChannelException e) {
                            e.printStackTrace();
                        }
                    }else if(selectionKey.isReadable()){
                        SocketChannel sockChannel = (SocketChannel)selectionKey.channel();
                        ByteBuffer read = ByteBuffer.allocate(1024);

                        //先读到buffer里面
                        int count = 0;
                        try {
                            count = sockChannel.read(read);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if(count > 0){
                            String receiveMessage = new String (read.array());
                            System.out.println("客户端recievedMessage:" + receiveMessage);
                        }
                    }
                });
                selectionKeys.clear();//处理完之后一定要清空
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
