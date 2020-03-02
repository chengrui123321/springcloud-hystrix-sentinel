package com.wb.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @Auther: r.cheng
 * @Date: 2020/3/1 11:40
 * @Description:
 * @Version: 1.0
 */
@Entity
@Table(name = "tb_product")
@Data
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class Product {

    @Id
    private Long id;
    @Column(name = "product_name")
    private String productName;
    private Integer status;
    private BigDecimal price;
    @Column(name = "product_desc")
    private String productDesc;
    private String caption;
    private Integer inventory;

}
