package com.noasking.boot.learn.prop;

import com.noasking.boot.learn.prop.properties.PropsConfig;
import com.noasking.boot.learn.prop.properties.YmlConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by MaJing on 2017/8/21.
 */
@SpringBootApplication
@EnableConfigurationProperties({PropsConfig.class,YmlConfig.class})
public class LearnPropApplication {

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(LearnPropApplication.class, args);
    }

}
