package com.learn.demo.proto_grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {
    private Server server;

    //启动方法
    private void start(){
        try {
            this.server = ServerBuilder.forPort(8899).addService(new MyStudentServiceImpl()).build().start();
            System.out.println("server started!");

            //关闭JVM后会执行该方法
            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("关闭jvm");
                }
            }));
            System.out.println("执行到这里!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //关闭方法
    private void stop(){
        if(null != this.server){
            server.shutdown();
        }
    }

    //等待方法，这里有thrift不一样，thrift启动后就一直在阻塞，而grpc是不会的
    private void awaitTermination(){
        if(null != this.server){
            try {
                this.server.awaitTermination();
//                this.server.awaitTermination(3000, TimeUnit.MILLISECONDS); //3秒钟未收到请求就关闭连接
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        GrpcServer server = new GrpcServer();
        server.start();

        server.awaitTermination();
    }


}
