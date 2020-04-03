package com.learn.demo.netty_protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TestServerHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MyDataInfo.MyMessage s) throws Exception {
        MyDataInfo.MyMessage.DataType dataType = s.getDataType();

        if(dataType == MyDataInfo.MyMessage.DataType.PersonType){
            MyDataInfo.Person personInfo = s.getPerson();

            System.out.println(personInfo.getAge());
            System.out.println(personInfo.getName());
            System.out.println(personInfo.getAddress());

        }else if(dataType == MyDataInfo.MyMessage.DataType.DogType){
            MyDataInfo.Dog dogInfo = s.getDog();
            System.out.println(dogInfo.getAge());
            System.out.println(dogInfo.getName());
        }else{
            MyDataInfo.Cat catInfo = s.getCat();
            System.out.println(catInfo.getName());
            System.out.println(catInfo.getCity());
        }

    }

}
