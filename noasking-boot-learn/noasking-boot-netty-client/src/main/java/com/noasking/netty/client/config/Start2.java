package com.noasking.netty.client.config;

/**
 * Created by MaJing on 2017/9/26.
 */
public class Start2 {

    public static void main(String[] args) throws InterruptedException {
        //IP地址和端口
        AbsClient absClient = new AbsClient("username2", "123456");
        NettyClientBootstrap bootstrap = new NettyClientBootstrap(28081, "localhost", absClient);
    }

}
