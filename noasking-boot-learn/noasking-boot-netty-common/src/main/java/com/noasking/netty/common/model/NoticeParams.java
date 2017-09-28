package com.noasking.netty.common.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 通知消息的内容
 */
public class NoticeParams implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 更新的表名
     */
    private String tablename;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否是全量：true：全量；false：增量；
     */
    private boolean allImport;

    /**
     * 增量字段
     */
    private String updateCol;


    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isAllImport() {
        return allImport;
    }

    public void setAllImport(boolean allImport) {
        this.allImport = allImport;
    }

    public String getUpdateCol() {
        return updateCol;
    }

    public void setUpdateCol(String updateCol) {
        this.updateCol = updateCol;
    }

    @Override
    public String toString() {
        return "NoticeParams{" +
                "tablename='" + tablename + '\'' +
                ", updateTime=" + updateTime +
                ", allImport=" + allImport +
                ", updateCol='" + updateCol + '\'' +
                '}';
    }
}
