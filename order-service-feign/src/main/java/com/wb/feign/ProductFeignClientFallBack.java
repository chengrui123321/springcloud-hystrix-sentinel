package com.wb.feign;

import com.wb.entity.Product;
import org.springframework.stereotype.Component;

/**
 * 实现类实现ProductFeignClient，为每个Feign接口编写熔断方法
 */
@Component
public class ProductFeignClientFallBack implements ProductFeignClient {
    @Override
    public Product findOne(Long id) {
        return new Product().setProductName("服务熔断:基于Feign接口实现类");
    }
}
