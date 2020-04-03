package com.learn.demo.websocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class WebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new ChunkedWriteHandler()); //以块的方式去写。
        pipeline.addLast(new HttpObjectAggregator(8192));//将段聚合到一起 比如讲httpcontext，httprequest，变成一个Full,及完整的。
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

        pipeline.addLast(new WebSocketFrameHandler());//放置我们自己的websocket。

    }

}
