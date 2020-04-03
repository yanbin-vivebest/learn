package com.learn.demo.netty_protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MyDataInfo.MyMessage s) throws Exception {
        //读取服务端发来的数据

        //该例子中只要在active中发送数据即可
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int randomInt = new Random().nextInt(3);//0,1,2

        MyDataInfo.MyMessage myMessage = null;
        if(0 == randomInt){
            MyDataInfo.Person person = MyDataInfo.Person.newBuilder().setName("yanbin").setAge(25).setAddress("beijing").build();
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.PersonType).setPerson(person).build();
        }else if (1 == randomInt){
            MyDataInfo.Dog dog = MyDataInfo.Dog.newBuilder().setName("一只狗").setAge(25).build();
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.DogType).setDog(dog).build();
        }else{
            MyDataInfo.Cat cat = MyDataInfo.Cat.newBuilder().setName("一只猫").setCity("beijing").build();
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.CatType).setCat(cat).build();
        }
        ctx.channel().writeAndFlush(myMessage);
    }
}
