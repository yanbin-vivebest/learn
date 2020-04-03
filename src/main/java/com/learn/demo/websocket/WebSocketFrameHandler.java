package com.learn.demo.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.time.LocalDateTime;

public class WebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> { //这个泛型为需要吹里的类型，专门处理文本的Frame

    @Override
    protected void channelRead0(ChannelHandlerContext ch, TextWebSocketFrame msg) throws Exception {

        System.out.println("收到消息:" + msg.text());

        //读取消息后往回写
        ch.channel().writeAndFlush(new TextWebSocketFrame("服务器时间:" + LocalDateTime.now())); //不能直接写一个字符串

    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //每一个channel都会有一个id
        System.out.println("handlerAdded:" + ctx.channel().id().asLongText());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("异常发生");
        cause.printStackTrace();//关闭连接
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemoved:" + ctx.channel().id().asLongText());
    }
}
