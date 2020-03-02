package com.wb.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wb.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Order接口控制层
 * 如果多个方法需要熔断，可以使用@DefaultProperties指定熔断方法
 */
//@DefaultProperties(defaultFallback = "fallback")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback") // 标记该接口需要熔断机制，熔断调用fallback方法
//    @HystrixCommand
    @GetMapping("/get/{id}")
    public Product get(@PathVariable Long id) {
        if (id == 1) {
            throw new RuntimeException("出现异常");
        }
        return restTemplate.getForObject("http://PRODUCT-SERVICE/product/get/" + id, Product.class);
    }


    /**
     * 服务熔断方法
     * @param id
     * @return
     */
    public Product fallback(Long id) {
        Product product = new Product()
                .setProductName("触发服务熔断");

        return product;
    }

}
