package com.noasking.quartz.zk;

import org.springframework.stereotype.Component;

public class CronTriggerBean extends TriggerBean {

    /**
     * CRON表达式
     */
    private String cronExpression;

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }
}

  