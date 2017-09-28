package com.noasking.es.model;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by MaJing on 2017/9/25.
 */
@Document(indexName = "dclog", type = "dcLog", indexStoreType = "fs", shards = 5, replicas = 1, refreshInterval = "-1")
public class TableUpdateIndex {

    /**
     * 这里
     */
    private Long id;

    private String logEventObject;
    private String logTimeLongMs;
    private String host;
    private String logEventResult;
    private String logTime;
    private String logEventType;
    private String type;
    private String requestUrl;
    private String logEventContent;
    private String thread_name;
    private String message;
    private String HOSTNAME;
    private String level;
    private String logDetailType;
    private String logLevel;
    private String userId;
    private String path;
    private String userName;
    private String logger_name;
    private String methodName;
    private String logType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogEventObject() {
        return logEventObject;
    }

    public void setLogEventObject(String logEventObject) {
        this.logEventObject = logEventObject;
    }

    public String getLogTimeLongMs() {
        return logTimeLongMs;
    }

    public void setLogTimeLongMs(String logTimeLongMs) {
        this.logTimeLongMs = logTimeLongMs;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getLogEventResult() {
        return logEventResult;
    }

    public void setLogEventResult(String logEventResult) {
        this.logEventResult = logEventResult;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public String getLogEventType() {
        return logEventType;
    }

    public void setLogEventType(String logEventType) {
        this.logEventType = logEventType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getLogEventContent() {
        return logEventContent;
    }

    public void setLogEventContent(String logEventContent) {
        this.logEventContent = logEventContent;
    }

    public String getThread_name() {
        return thread_name;
    }

    public void setThread_name(String thread_name) {
        this.thread_name = thread_name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHOSTNAME() {
        return HOSTNAME;
    }

    public void setHOSTNAME(String HOSTNAME) {
        this.HOSTNAME = HOSTNAME;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLogDetailType() {
        return logDetailType;
    }

    public void setLogDetailType(String logDetailType) {
        this.logDetailType = logDetailType;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLogger_name() {
        return logger_name;
    }

    public void setLogger_name(String logger_name) {
        this.logger_name = logger_name;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    @Override
    public String toString() {
        return "TableUpdateIndex{" +
                "logEventObject='" + logEventObject + '\'' +
                ", logTimeLongMs='" + logTimeLongMs + '\'' +
                ", host='" + host + '\'' +
                ", logEventResult='" + logEventResult + '\'' +
                ", logTime='" + logTime + '\'' +
                ", logEventType='" + logEventType + '\'' +
                ", type='" + type + '\'' +
                ", requestUrl='" + requestUrl + '\'' +
                ", logEventContent='" + logEventContent + '\'' +
                ", thread_name='" + thread_name + '\'' +
                ", message='" + message + '\'' +
                ", HOSTNAME='" + HOSTNAME + '\'' +
                ", level='" + level + '\'' +
                ", logDetailType='" + logDetailType + '\'' +
                ", logLevel='" + logLevel + '\'' +
                ", userId='" + userId + '\'' +
                ", path='" + path + '\'' +
                ", userName='" + userName + '\'' +
                ", logger_name='" + logger_name + '\'' +
                ", methodName='" + methodName + '\'' +
                ", logType='" + logType + '\'' +
                '}';
    }
}
