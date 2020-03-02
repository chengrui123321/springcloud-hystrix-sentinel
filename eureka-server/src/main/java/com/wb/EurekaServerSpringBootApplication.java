package com.wb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka 服务端启动类
 */
@EnableEurekaServer // 开启Eureka Server
@SpringBootApplication
public class EurekaServerSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerSpringBootApplication.class, args);
    }

}
