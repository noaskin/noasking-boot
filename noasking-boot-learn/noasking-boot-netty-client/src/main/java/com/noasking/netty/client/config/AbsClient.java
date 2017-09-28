package com.noasking.netty.client.config;


import com.noasking.netty.common.model.*;

/**
 * Created by MaJing on 2017/9/26.
 */
public class AbsClient {

    /**
     * 用户名 参考审计日志的userid
     */
    private String username;

    /**
     * 密码 目前随便填写
     */
    private String password;

    private String token;

    public AbsClient(String username, String password) {
        this.username = username;
        this.password = password;
    }

    protected LoginMsg login() {
        LoginMsg loginMsg = new LoginMsg();
        loginMsg.setPassword(password); //用户名 参考审计日志的userid
        loginMsg.setUserName(username); //密码 目前随便填写
        return loginMsg;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    /**
     * 链接成功答应消息
     */
    protected void connected() {
        System.out.println("connect success---");
    }

    protected void ping() {
        System.out.println("ping---");
    }

    protected void doNotice(NoticeParams noticeParams) {
        System.out.println(noticeParams);
    }


}
