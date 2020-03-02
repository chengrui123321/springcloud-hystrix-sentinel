package com.wb.dao;

import com.wb.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Auther: r.cheng
 * @Date: 2020/3/1 11:43
 * @Description:
 * @Version: 1.0
 */
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
}
