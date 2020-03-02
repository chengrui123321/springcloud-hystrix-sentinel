package com.wb;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.wb.exception.SentinelUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 订单服务主程序
 *
 * @SpringCloudApplication等同于下面三个注解组合：
 *      @SpringBootApplication
 *      @EnableDiscoveryClient
 *      @EnableCircuitBreaker
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderServiceSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceSpringBootApplication.class, args);
    }

    /**
     * @SentinelRestTemplate: 对所有的接口统一限流熔断处理
     * @return
     */
    @SentinelRestTemplate(blockHandlerClass = SentinelUtils.class, blockHandler = "handleBlock",
                            fallbackClass = SentinelUtils.class, fallback = "handleFallback")
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
