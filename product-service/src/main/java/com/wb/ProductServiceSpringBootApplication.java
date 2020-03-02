package com.wb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 商品服务主程序
 *
 * Feign默认实现Ribbon负载均衡，可以通过ribbon.XX配置负载策略
 *
 */
// 开启Eureka 客户端
@EnableDiscoveryClient
@SpringBootApplication
public class ProductServiceSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceSpringBootApplication.class, args);
    }

}
