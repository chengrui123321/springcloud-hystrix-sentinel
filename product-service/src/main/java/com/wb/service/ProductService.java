package com.wb.service;

import com.wb.entity.Product;

import java.util.List;

/**
 * @Auther: r.cheng
 * @Date: 2020/3/1 15:10
 * @Description:
 * @Version: 1.0
 */
public interface ProductService {

    Product findOne(Long id);

    void insert(Product product);

    void update(Product product);

    void delete(Long id);

    List<Product> findAll();

}
