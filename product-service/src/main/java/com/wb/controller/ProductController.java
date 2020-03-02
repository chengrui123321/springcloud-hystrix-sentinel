package com.wb.controller;

import com.wb.entity.Product;
import com.wb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: r.cheng
 * @Date: 2020/3/1 15:13
 * @Description:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Value("${server.port}")
    private String port;

    @Value("${spring.cloud.client.ip-address}")
    private String ip;

    @GetMapping("/get/{id}")
    public Product get(@PathVariable Long id) {
        Product product = productService.findOne(id);
        product.setProductName("服务调用: " + ip + ":" + port);
        return product;
    }

}
