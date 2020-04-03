package com.learn.demo.proto_grpc;

import com.learn.demo.proto.*;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

public class MyStudentServiceImpl extends MyStudentServiceGrpc.MyStudentServiceImplBase {
    /**
     *
     * @param request 接收的参数
     * @param responseObserver 用于返回的对象
     * 注意：grpc和thrift有点不一样，thrift在idl文件中定义了服务的返回，那么实现类中就是返回的对象
     *       而grpc在idl文件中定义了服务的返回，实现类中并不是返回的对象，而是void，其实是通过responseObserver就行返回的
     */
    @Override
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        //0-0
        System.out.println("接收到客户端信息:" + request.getUsername());

        responseObserver.onNext(MyResponse.newBuilder().setRealName("serName_yanbin").build());

        //表示方法调用结束了
        responseObserver.onCompleted();
    }

    /**
     * 流式的返回
     * @param request
     * @param responseObserver
     */
    @Override
    public void getStudentsByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        //0-1
        System.out.println("stream接收到客户端信息:" + request.getAge());

        //多次返回
        responseObserver.onNext(StudentResponse.newBuilder().setName("yanbin").setCity("beijing").setAge(23).build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("yanbin2").setCity("beijing1").setAge(24).build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("yanbin3").setCity("beijing2").setAge(25).build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("yanbin4").setCity("beijing3").setAge(26).build());

        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<StudentRequest> getStudentWrapperByAges(StreamObserver<StudentResponseList> responseObserver) {
        System.out.println("接收到了请求，方式：1-0");
        return new StreamObserver<StudentRequest>() {

            //接收客户端的请求，请求一次调用一次，流式的请求
            @Override
            public void onNext(StudentRequest studentRequest) {
                System.out.println("onNext:" + studentRequest.getAge());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            //当客户端请求全部发送完毕，服务端就返回给客户端
            @Override
            public void onCompleted() {
                StudentResponse s1 =   StudentResponse.newBuilder().setName("zhangsan").setAge(23).setCity("shenzhen").build();
                StudentResponse s2 =   StudentResponse.newBuilder().setName("zhangsan2").setAge(23).setCity("guangzhou").build();
                StudentResponseList resp = StudentResponseList.newBuilder().addStudentResponse(s1).addStudentResponse(s2).build();
                responseObserver.onNext(resp); //一次返回
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<StreamRequest> biTalk(StreamObserver<StreamResponse> responseObserver) {
        System.out.println("接收到了请求，方式：1-1");
        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest streamRequest) {
                System.out.println("双向-服务端接收：" + streamRequest.getRequestInfo() );

                //返回
                responseObserver.onNext(StreamResponse.newBuilder().setResponseInfo(UUID.randomUUID().toString()).build());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };

    }
}
