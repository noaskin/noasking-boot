package com.noasking.netty.common.model;

import java.io.Serializable;

/**
 * 基础消息
 * Created by MaJing on 2017/9/25.
 */
public abstract class BaseMsg implements Serializable {
    private static final long serialVersionUID = 1L;
    private MsgType type;
    //必须唯一，否则会出现channel调用混乱
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public MsgType getType() {
        return type;
    }

    public void setType(MsgType type) {
        this.type = type;
    }
}
