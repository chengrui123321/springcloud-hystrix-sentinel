package com.wb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Turbine 监控主程序
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine // 开启Turbine监控
public class HystrixTurbineSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineSpringBootApplication.class, args);
    }

}
