package com.wb.service.impl;

import com.wb.dao.ProductRepository;
import com.wb.entity.Product;
import com.wb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: r.cheng
 * @Date: 2020/3/1 15:11
 * @Description:
 * @Version: 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product findOne(Long id) {
        return productRepository.getOne(id);
    }

    @Override
    public void insert(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
