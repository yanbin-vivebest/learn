package com.learn.demo.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 *服务(接口)
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.27.2)",
    comments = "Source: MyStudent.proto")
public final class MyStudentServiceGrpc {

  private MyStudentServiceGrpc() {}

  public static final String SERVICE_NAME = "com.learn.demo.proto.MyStudentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.learn.demo.proto.MyRequest,
      com.learn.demo.proto.MyResponse> getGetRealNameByUsernameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRealNameByUsername",
      requestType = com.learn.demo.proto.MyRequest.class,
      responseType = com.learn.demo.proto.MyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.learn.demo.proto.MyRequest,
      com.learn.demo.proto.MyResponse> getGetRealNameByUsernameMethod() {
    io.grpc.MethodDescriptor<com.learn.demo.proto.MyRequest, com.learn.demo.proto.MyResponse> getGetRealNameByUsernameMethod;
    if ((getGetRealNameByUsernameMethod = MyStudentServiceGrpc.getGetRealNameByUsernameMethod) == null) {
      synchronized (MyStudentServiceGrpc.class) {
        if ((getGetRealNameByUsernameMethod = MyStudentServiceGrpc.getGetRealNameByUsernameMethod) == null) {
          MyStudentServiceGrpc.getGetRealNameByUsernameMethod = getGetRealNameByUsernameMethod =
              io.grpc.MethodDescriptor.<com.learn.demo.proto.MyRequest, com.learn.demo.proto.MyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRealNameByUsername"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.demo.proto.MyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.demo.proto.MyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MyStudentServiceMethodDescriptorSupplier("GetRealNameByUsername"))
              .build();
        }
      }
    }
    return getGetRealNameByUsernameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.learn.demo.proto.StudentRequest,
      com.learn.demo.proto.StudentResponse> getGetStudentsByAgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentsByAge",
      requestType = com.learn.demo.proto.StudentRequest.class,
      responseType = com.learn.demo.proto.StudentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.learn.demo.proto.StudentRequest,
      com.learn.demo.proto.StudentResponse> getGetStudentsByAgeMethod() {
    io.grpc.MethodDescriptor<com.learn.demo.proto.StudentRequest, com.learn.demo.proto.StudentResponse> getGetStudentsByAgeMethod;
    if ((getGetStudentsByAgeMethod = MyStudentServiceGrpc.getGetStudentsByAgeMethod) == null) {
      synchronized (MyStudentServiceGrpc.class) {
        if ((getGetStudentsByAgeMethod = MyStudentServiceGrpc.getGetStudentsByAgeMethod) == null) {
          MyStudentServiceGrpc.getGetStudentsByAgeMethod = getGetStudentsByAgeMethod =
              io.grpc.MethodDescriptor.<com.learn.demo.proto.StudentRequest, com.learn.demo.proto.StudentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStudentsByAge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.demo.proto.StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.demo.proto.StudentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MyStudentServiceMethodDescriptorSupplier("GetStudentsByAge"))
              .build();
        }
      }
    }
    return getGetStudentsByAgeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.learn.demo.proto.StudentRequest,
      com.learn.demo.proto.StudentResponseList> getGetStudentWrapperByAgesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentWrapperByAges",
      requestType = com.learn.demo.proto.StudentRequest.class,
      responseType = com.learn.demo.proto.StudentResponseList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.learn.demo.proto.StudentRequest,
      com.learn.demo.proto.StudentResponseList> getGetStudentWrapperByAgesMethod() {
    io.grpc.MethodDescriptor<com.learn.demo.proto.StudentRequest, com.learn.demo.proto.StudentResponseList> getGetStudentWrapperByAgesMethod;
    if ((getGetStudentWrapperByAgesMethod = MyStudentServiceGrpc.getGetStudentWrapperByAgesMethod) == null) {
      synchronized (MyStudentServiceGrpc.class) {
        if ((getGetStudentWrapperByAgesMethod = MyStudentServiceGrpc.getGetStudentWrapperByAgesMethod) == null) {
          MyStudentServiceGrpc.getGetStudentWrapperByAgesMethod = getGetStudentWrapperByAgesMethod =
              io.grpc.MethodDescriptor.<com.learn.demo.proto.StudentRequest, com.learn.demo.proto.StudentResponseList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStudentWrapperByAges"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.demo.proto.StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.demo.proto.StudentResponseList.getDefaultInstance()))
              .setSchemaDescriptor(new MyStudentServiceMethodDescriptorSupplier("GetStudentWrapperByAges"))
              .build();
        }
      }
    }
    return getGetStudentWrapperByAgesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.learn.demo.proto.StreamRequest,
      com.learn.demo.proto.StreamResponse> getBiTalkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BiTalk",
      requestType = com.learn.demo.proto.StreamRequest.class,
      responseType = com.learn.demo.proto.StreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.learn.demo.proto.StreamRequest,
      com.learn.demo.proto.StreamResponse> getBiTalkMethod() {
    io.grpc.MethodDescriptor<com.learn.demo.proto.StreamRequest, com.learn.demo.proto.StreamResponse> getBiTalkMethod;
    if ((getBiTalkMethod = MyStudentServiceGrpc.getBiTalkMethod) == null) {
      synchronized (MyStudentServiceGrpc.class) {
        if ((getBiTalkMethod = MyStudentServiceGrpc.getBiTalkMethod) == null) {
          MyStudentServiceGrpc.getBiTalkMethod = getBiTalkMethod =
              io.grpc.MethodDescriptor.<com.learn.demo.proto.StreamRequest, com.learn.demo.proto.StreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BiTalk"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.demo.proto.StreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.learn.demo.proto.StreamResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MyStudentServiceMethodDescriptorSupplier("BiTalk"))
              .build();
        }
      }
    }
    return getBiTalkMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MyStudentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MyStudentServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MyStudentServiceStub>() {
        @java.lang.Override
        public MyStudentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MyStudentServiceStub(channel, callOptions);
        }
      };
    return MyStudentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MyStudentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MyStudentServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MyStudentServiceBlockingStub>() {
        @java.lang.Override
        public MyStudentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MyStudentServiceBlockingStub(channel, callOptions);
        }
      };
    return MyStudentServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MyStudentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MyStudentServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MyStudentServiceFutureStub>() {
        @java.lang.Override
        public MyStudentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MyStudentServiceFutureStub(channel, callOptions);
        }
      };
    return MyStudentServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *服务(接口)
   * </pre>
   */
  public static abstract class MyStudentServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *0-0
     * </pre>
     */
    public void getRealNameByUsername(com.learn.demo.proto.MyRequest request,
        io.grpc.stub.StreamObserver<com.learn.demo.proto.MyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRealNameByUsernameMethod(), responseObserver);
    }

    /**
     * <pre>
     *需要改成下面的方式   一次发送，一次接受，然后多次返回，一次接收。 0-1
     * </pre>
     */
    public void getStudentsByAge(com.learn.demo.proto.StudentRequest request,
        io.grpc.stub.StreamObserver<com.learn.demo.proto.StudentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStudentsByAgeMethod(), responseObserver);
    }

    /**
     * <pre>
     *1-0
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.learn.demo.proto.StudentRequest> getStudentWrapperByAges(
        io.grpc.stub.StreamObserver<com.learn.demo.proto.StudentResponseList> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetStudentWrapperByAgesMethod(), responseObserver);
    }

    /**
     * <pre>
     *0-0  双向流式数据传递
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.learn.demo.proto.StreamRequest> biTalk(
        io.grpc.stub.StreamObserver<com.learn.demo.proto.StreamResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getBiTalkMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetRealNameByUsernameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.learn.demo.proto.MyRequest,
                com.learn.demo.proto.MyResponse>(
                  this, METHODID_GET_REAL_NAME_BY_USERNAME)))
          .addMethod(
            getGetStudentsByAgeMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.learn.demo.proto.StudentRequest,
                com.learn.demo.proto.StudentResponse>(
                  this, METHODID_GET_STUDENTS_BY_AGE)))
          .addMethod(
            getGetStudentWrapperByAgesMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.learn.demo.proto.StudentRequest,
                com.learn.demo.proto.StudentResponseList>(
                  this, METHODID_GET_STUDENT_WRAPPER_BY_AGES)))
          .addMethod(
            getBiTalkMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.learn.demo.proto.StreamRequest,
                com.learn.demo.proto.StreamResponse>(
                  this, METHODID_BI_TALK)))
          .build();
    }
  }

  /**
   * <pre>
   *服务(接口)
   * </pre>
   */
  public static final class MyStudentServiceStub extends io.grpc.stub.AbstractAsyncStub<MyStudentServiceStub> {
    private MyStudentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MyStudentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MyStudentServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *0-0
     * </pre>
     */
    public void getRealNameByUsername(com.learn.demo.proto.MyRequest request,
        io.grpc.stub.StreamObserver<com.learn.demo.proto.MyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRealNameByUsernameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *需要改成下面的方式   一次发送，一次接受，然后多次返回，一次接收。 0-1
     * </pre>
     */
    public void getStudentsByAge(com.learn.demo.proto.StudentRequest request,
        io.grpc.stub.StreamObserver<com.learn.demo.proto.StudentResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetStudentsByAgeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *1-0
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.learn.demo.proto.StudentRequest> getStudentWrapperByAges(
        io.grpc.stub.StreamObserver<com.learn.demo.proto.StudentResponseList> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetStudentWrapperByAgesMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *0-0  双向流式数据传递
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.learn.demo.proto.StreamRequest> biTalk(
        io.grpc.stub.StreamObserver<com.learn.demo.proto.StreamResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBiTalkMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *服务(接口)
   * </pre>
   */
  public static final class MyStudentServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<MyStudentServiceBlockingStub> {
    private MyStudentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MyStudentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MyStudentServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *0-0
     * </pre>
     */
    public com.learn.demo.proto.MyResponse getRealNameByUsername(com.learn.demo.proto.MyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRealNameByUsernameMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *需要改成下面的方式   一次发送，一次接受，然后多次返回，一次接收。 0-1
     * </pre>
     */
    public java.util.Iterator<com.learn.demo.proto.StudentResponse> getStudentsByAge(
        com.learn.demo.proto.StudentRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetStudentsByAgeMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *服务(接口)
   * </pre>
   */
  public static final class MyStudentServiceFutureStub extends io.grpc.stub.AbstractFutureStub<MyStudentServiceFutureStub> {
    private MyStudentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MyStudentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MyStudentServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *0-0
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.learn.demo.proto.MyResponse> getRealNameByUsername(
        com.learn.demo.proto.MyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRealNameByUsernameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REAL_NAME_BY_USERNAME = 0;
  private static final int METHODID_GET_STUDENTS_BY_AGE = 1;
  private static final int METHODID_GET_STUDENT_WRAPPER_BY_AGES = 2;
  private static final int METHODID_BI_TALK = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MyStudentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MyStudentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REAL_NAME_BY_USERNAME:
          serviceImpl.getRealNameByUsername((com.learn.demo.proto.MyRequest) request,
              (io.grpc.stub.StreamObserver<com.learn.demo.proto.MyResponse>) responseObserver);
          break;
        case METHODID_GET_STUDENTS_BY_AGE:
          serviceImpl.getStudentsByAge((com.learn.demo.proto.StudentRequest) request,
              (io.grpc.stub.StreamObserver<com.learn.demo.proto.StudentResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STUDENT_WRAPPER_BY_AGES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getStudentWrapperByAges(
              (io.grpc.stub.StreamObserver<com.learn.demo.proto.StudentResponseList>) responseObserver);
        case METHODID_BI_TALK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.biTalk(
              (io.grpc.stub.StreamObserver<com.learn.demo.proto.StreamResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MyStudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MyStudentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.learn.demo.proto.MyStudentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MyStudentService");
    }
  }

  private static final class MyStudentServiceFileDescriptorSupplier
      extends MyStudentServiceBaseDescriptorSupplier {
    MyStudentServiceFileDescriptorSupplier() {}
  }

  private static final class MyStudentServiceMethodDescriptorSupplier
      extends MyStudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MyStudentServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MyStudentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MyStudentServiceFileDescriptorSupplier())
              .addMethod(getGetRealNameByUsernameMethod())
              .addMethod(getGetStudentsByAgeMethod())
              .addMethod(getGetStudentWrapperByAgesMethod())
              .addMethod(getBiTalkMethod())
              .build();
        }
      }
    }
    return result;
  }
}
