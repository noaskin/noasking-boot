package com.noasking.netty.server.config;

import io.netty.channel.Channel;
import io.netty.channel.socket.SocketChannel;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by MaJing on 2017/9/25.
 */
public class NettyChannelMap {

    private static Map<String, SocketChannel> map = new ConcurrentHashMap<String, SocketChannel>();

    public static void add(String token, SocketChannel socketChannel) {
        map.put(token, socketChannel);
    }

    public static Channel get(String token) {
        return map.get(token);
    }

    public static void remove(SocketChannel socketChannel) {
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() == socketChannel) {
                map.remove(entry.getKey());
            }
        }
    }

    public static Set<String> getAllToken() {
        return map.keySet();
    }

}
