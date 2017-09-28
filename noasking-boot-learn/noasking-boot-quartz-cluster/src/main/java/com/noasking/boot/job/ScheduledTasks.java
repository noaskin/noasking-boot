package com.noasking.boot.job;

import com.noasking.boot.config.DistributedLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by MaJing on 2017/9/21.
 */
@Component
@Configurable
@EnableScheduling
public class ScheduledTasks {

    @Value("${zookeeper.configList}")
    private List<String> configList = new ArrayList<String>(); //127.0.0.1:2181

    @Value("${zookeeper.lockName}")
    private String lockName;//竞争资源标志,lockName中不能包含单词lock

    private static int index = 0;

    //每1分钟执行一次
    @Scheduled(cron = "*/10 * * * * * ")
    public void reportCurrentByCron() throws InterruptedException {
        DistributedLock lock = null;
        try {
            lock = new DistributedLock(getConfig(), lockName);
            lock.lock();
            System.out.println("Scheduling Tasks Examples By Cron: The time is now " + dateFormat().format(new Date()));
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (lock != null)
                lock.unlock();
        }
    }

    /**
     * 通过枚举随机选一个zookeeper负载均衡
     */
    private String getConfig() {
        if (index + 1 == configList.size()) {
            index = 0;
        }
        return configList.get(index);
    }

    private SimpleDateFormat dateFormat() {
        return new SimpleDateFormat("HH:mm:ss");
    }


}
