package com.noasking.quartz.zk.config;

import com.noasking.quartz.zk.CronTriggerBean;
import com.noasking.quartz.zk.SchedulerFactoryBean;
import com.noasking.quartz.zk.TriggerBean;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MaJing on 2017/9/21.
 */
@Configuration
@ImportResource(locations = {"classpath:quartz.xml"})
public class QuartzConfig {

}
