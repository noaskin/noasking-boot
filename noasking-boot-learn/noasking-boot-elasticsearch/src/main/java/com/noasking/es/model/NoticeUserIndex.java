package com.noasking.es.model;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * Created by MaJing on 2017/9/25.
 */
@Document(indexName = "noticeuser", type = "noticeUser", indexStoreType = "fs", shards = 5, replicas = 1, refreshInterval = "-1")
public class NoticeUserIndex implements Serializable {

    private Long id;

    private String token;
    /**
     * 发送给用户最后一条消息的时间
     */
    private long lastGetDate;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getLastGetDate() {
        return lastGetDate;
    }

    public void setLastGetDate(long lastGetDate) {
        this.lastGetDate = lastGetDate;
    }
}
