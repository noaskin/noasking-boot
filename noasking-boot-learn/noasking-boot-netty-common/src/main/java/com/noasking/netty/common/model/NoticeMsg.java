package com.noasking.netty.common.model;

/**
 * 通知消息
 */
public class NoticeMsg extends BaseMsg {
    public NoticeMsg() {
        super();
        setType(MsgType.NOTICE);
    }

    private NoticeParams params;

    public NoticeParams getParams() {
        return params;
    }

    public void setParams(NoticeParams params) {
        this.params = params;
    }


}
