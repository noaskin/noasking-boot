package com.noasking.netty.client.config;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.concurrent.TimeUnit;


/**
 * Created by MaJing on 2017/9/25.
 */
public class NettyClientBootstrap {
    private NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup(4);
    private Bootstrap bootstrap;
    private int port;
    private String host;
    private Channel socketChannel;
    private static final EventExecutorGroup group = new DefaultEventExecutorGroup(20);
    private AbsClient absClient;

    public NettyClientBootstrap(int port, String host, AbsClient absClient) throws InterruptedException {
        this.port = port;
        this.host = host;
        this.absClient = absClient;
        start();
    }

    private void start() throws InterruptedException {
        eventLoopGroup = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.group(eventLoopGroup);
        bootstrap.remoteAddress(host, port);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new IdleStateHandler(20, 10, 0));
                socketChannel.pipeline().addLast(new ObjectEncoder());
                socketChannel.pipeline().addLast(new ObjectDecoder(ClassResolvers.cacheDisabled(null)));
                socketChannel.pipeline().addLast(new NettyClientHandler(absClient, NettyClientBootstrap.this));
            }
        });
        doConnect();
    }

    protected void doConnect() {
        if (socketChannel != null && socketChannel.isActive()) {
            return;
        }
        ChannelFuture future = bootstrap.connect(host, port);
//        if (future.isSuccess()) {
//            socketChannel = future.channel();
//            absClient.connected();
//        }
//        socketChannel.writeAndFlush(absClient.login());


        future.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture futureListener) throws Exception {
                if (futureListener.isSuccess()) {
                    socketChannel = futureListener.channel();
                    absClient.connected();
                    socketChannel.writeAndFlush(absClient.login());
                    System.out.println("Connect to server successfully!");
                } else {
                    System.out.println("Failed to connect to server, try connect after 10s");
                    futureListener.channel().eventLoop().schedule(new Runnable() {
                        @Override
                        public void run() {
                            doConnect();
                        }
                    }, 10, TimeUnit.SECONDS);
                }
            }
        });
    }

}
