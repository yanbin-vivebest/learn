package com.learn.demo.proto_grpc;

import com.learn.demo.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.time.LocalDateTime;
import java.util.Iterator;

public class GrpcClient {
    public static void main(String[] args) {

        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost",8899).
                usePlaintext().build();

        MyStudentServiceGrpc.MyStudentServiceBlockingStub blockingStub = MyStudentServiceGrpc.newBlockingStub(managedChannel);
        MyResponse resp = blockingStub.getRealNameByUsername(MyRequest.newBuilder().setUsername("yanbin").build());

        System.out.println("客户端收到结果:" + resp.getRealName());

        System.out.println("---------------------------");

        //接收流
        Iterator<StudentResponse> iter =  blockingStub.getStudentsByAge(StudentRequest.newBuilder().setAge(20).build());

        while(iter.hasNext()){
            StudentResponse tmp = iter.next();
            System.out.println(tmp.getName() + "," + tmp.getCity() + "," +tmp.getAge());
        }
        System.out.println("finish!");


        System.out.println("-----------------------");

        //这里不能用blockingStub的方式去发送，因为blockingStub是阻塞式的，而流式发送必须是异步的,所以使用下面的方式去方式
        MyStudentServiceGrpc.MyStudentServiceStub stub = MyStudentServiceGrpc.newStub(managedChannel);

        StreamObserver<StudentRequest> req = stub.getStudentWrapperByAges(new StreamObserver<StudentResponseList>() { //匿名内部类的回调
            @Override
            public void onNext(StudentResponseList studentResponseList) {
                studentResponseList.getStudentResponseList().forEach(response -> {
                    System.out.println(response.getName() + "," + response.getAge() + "," + response.getCity());
                });
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("completed!");
            }
        });
        req.onNext(StudentRequest.newBuilder().setAge(20).build());
        req.onNext(StudentRequest.newBuilder().setAge(30).build());
        req.onNext(StudentRequest.newBuilder().setAge(40).build());
        req.onNext(StudentRequest.newBuilder().setAge(50).build());
        req.onCompleted();

        try {
            //如果不休眠一段时间，程序什么也不会打印，因为这种方式是异步的，发送完之后就紧接着执行后面的代码，还没来得及发送完或者接收完，程序就结束了。
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("-----双向流式-----");

        StreamObserver<StreamRequest> requestStreamObserver = stub.biTalk(new StreamObserver<StreamResponse>() {
            @Override
            public void onNext(StreamResponse streamResponse) {
                System.out.println(streamResponse.getResponseInfo());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("流式双向completed!");
            }
        });
        for(int i = 0;i<10;i++){
            requestStreamObserver.onNext(StreamRequest.newBuilder().setRequestInfo(LocalDateTime.now().toString()).build());
            try {
                //为了效果(流式的方式传输)，睡眠1秒钟
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
