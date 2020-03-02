package com.wb.feign;

import com.wb.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign 客户端调用接口
 *      name: 指定调用服务名
 *      fallback：指定该客户端的熔断接口
 */
@FeignClient(name = "product-service", fallback = ProductFeignClientFallBack.class) // 指定需要调用的服务名称
public interface ProductFeignClient {

    @GetMapping("/product/get/{id}")
    Product findOne(@PathVariable Long id);

}
