package com.noasking.netty.client.config;

import com.noasking.netty.common.model.*;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;

/**
 *
 */
public class NettyClientHandler extends SimpleChannelInboundHandler<BaseMsg> {

    private AbsClient absClient;

    private NettyClientBootstrap nettyClientBootstrap;


    public NettyClientHandler(AbsClient absClient, NettyClientBootstrap nettyClientBootstrap) {
        super();
        this.absClient = absClient;
        this.nettyClientBootstrap = nettyClientBootstrap;
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        System.out.println("断线重练");
        Thread.currentThread().sleep(3000L);
        nettyClientBootstrap.doConnect();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            switch (e.state()) {
                case WRITER_IDLE:
                    PingMsg pingMsg = new PingMsg();
                    pingMsg.setToken(absClient.getToken());
                    ctx.writeAndFlush(pingMsg);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, BaseMsg baseMsg) throws Exception {
        MsgType msgType = baseMsg.getType();
        switch (msgType) {
            case LOGIN: {
                //这里表示服务器向服务器发起登录
                if (null == baseMsg.getToken() || "".equals(baseMsg.getToken())) {
                    channelHandlerContext.writeAndFlush(absClient.login());
                } else { //接受服务器返回的Token
                    absClient.setToken(baseMsg.getToken());
                }
            }
            break;
            case PING: {
                absClient.ping();
            }
            break;
            case NOTICE: {
                //这里表示接收到
                NoticeMsg noticeMsg = (NoticeMsg) baseMsg;
                //这里做处理
                absClient.doNotice(noticeMsg.getParams());
            }
            break;
            default:
                break;
        }
        ReferenceCountUtil.release(msgType);
    }
}
