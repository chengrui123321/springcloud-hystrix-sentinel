package com.wb.controller;

import com.wb.entity.Product;
import com.wb.feign.ProductFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Order接口控制层
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    ProductFeignClient productFeignClient;

    @GetMapping("/get/{id}")
    public Product get(@PathVariable Long id) {
        return productFeignClient.findOne(id);
    }

    @GetMapping("/{id}")
    public String test(@PathVariable Long id) {
        return "压力测试";
    }

}
