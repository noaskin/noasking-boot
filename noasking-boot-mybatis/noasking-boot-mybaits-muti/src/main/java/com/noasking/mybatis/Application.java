package com.noasking.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by MaJing on 2017/8/2.
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.noasking.mybatis.dao","com.noasking.mybatis.common"}) //Mybatis的数据持久层路径
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
