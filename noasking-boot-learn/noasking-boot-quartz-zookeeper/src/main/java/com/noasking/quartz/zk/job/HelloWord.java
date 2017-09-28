package com.noasking.quartz.zk.job;

import com.noasking.quartz.zk.config.ZookeeperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloWord {

	@Autowired
	private ZookeeperFactory zookeeperFactory;

	public void sayHello() throws Exception {
		int i = new Date().getSeconds();
		System.out.println("----------------------------------------------------------------------");
		System.out.println(i+"测试开始"+new SimpleDateFormat("hh:MM:ss").format(new Date()));
		Thread.currentThread().sleep(7000L);
		System.out.println(i+"测试结束"+new SimpleDateFormat("hh:MM:ss").format(new Date()));
		System.out.println("----------------------------------------------------------------------");
	}
}
