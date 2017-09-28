package com.noasking.netty.server.config;

import com.noasking.netty.common.model.*;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;
import org.springframework.util.StringUtils;

/**
 * Created by yaozb on 15-4-11.
 */
public class NettyClientHandler extends SimpleChannelInboundHandler<BaseMsg> {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            switch (e.state()) {
                case WRITER_IDLE:
                    PingMsg pingMsg = new PingMsg();
                    ctx.writeAndFlush(pingMsg);
                    System.out.println("send ping to server----------");
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
                LoginMsg loginMsg = (LoginMsg) baseMsg;
                if (!StringUtils.isEmpty(loginMsg.getUserName())) {
                    //登录成功,把channel信息传入
                    String token = Constants.getToken(loginMsg.getUserName());
                    System.out.println(loginMsg.getUserName()+"---"+token);
                    if(NettyChannelMap.getAllToken().contains(token)) {
                        NettyChannelMap.remove((SocketChannel) NettyChannelMap.get(token));
                    }
                    SocketChannel socketChannel = (SocketChannel) channelHandlerContext.channel();
                    loginMsg.setToken(token);
                    //把token信息发送给客户端
                    socketChannel.writeAndFlush(loginMsg);
                    NettyChannelMap.add(token, socketChannel);
                }
            }
            break;
            case PING: {
                System.out.println("receive ping from server----------");
            }
            break;
            case NOTICE: {
                //这里表示接收到
                NoticeMsg noticeMsg = (NoticeMsg) baseMsg;
                //这里做处理
                System.out.println(noticeMsg.getParams());
            }
            break;
            default:
                break;
        }
        ReferenceCountUtil.release(msgType);
    }
}
