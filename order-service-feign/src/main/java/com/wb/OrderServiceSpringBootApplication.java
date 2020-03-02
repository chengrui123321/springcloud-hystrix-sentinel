package com.wb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 订单服务主程序
 */
@EnableCircuitBreaker // 开启服务熔断支持
@EnableFeignClients // 开启Feign支持
@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrixDashboard // 开启HystrixDashboard监控支持
public class OrderServiceSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceSpringBootApplication.class, args);
    }

}
