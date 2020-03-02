package com.wb.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.wb.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Order接口控制层
 *
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    /**
     * @SentinelResource: 标记需要熔断的接口(资源)
     *      value: 指定资源名称
     *      blockHandler: 服务降级方法
     *      fallback：服务熔断方法
     * @param id
     * @return
     */
    @SentinelResource(value = "getOrderById", blockHandler = "blockHandler", fallback = "fallback")
    @GetMapping("/get/{id}")
    public Product get(@PathVariable Long id) {
        if (id != 2) {
            throw new RuntimeException("数据不对");
        }
        return restTemplate.getForObject("http://PRODUCT-SERVICE/product/get/" + id, Product.class);
    }


    /**
     * 服务降级方法
     * @param id
     * @return
     */
    public Product blockHandler(Long id) {
        Product product = new Product()
                .setProductName("触发服务降级");

        return product;
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
