package com.noasking.netty.common.model;

/**
 * 登录验证类型的消息
 */
public class LoginMsg extends BaseMsg {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 错误消息
     */
    private String errorMsg;

    public LoginMsg() {
        super();
        setType(MsgType.LOGIN);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
