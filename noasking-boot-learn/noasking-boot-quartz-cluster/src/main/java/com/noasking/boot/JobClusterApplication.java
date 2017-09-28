package com.noasking.boot;

import com.corundumstudio.socketio.*;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

/**
 * Created by MaJing on 2017/9/21.
 */
@SpringBootApplication
public class JobClusterApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobClusterApplication.class, args);

    }


}
