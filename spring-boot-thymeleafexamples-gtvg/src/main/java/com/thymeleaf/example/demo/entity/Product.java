package com.thymeleaf.example.demo.entity;


import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Data
public class Product {

    private Integer id = null;

    private String name = null;

    private boolean inStock = false;

    private BigDecimal price = null;

    private List<Comment> comments = new ArrayList<>();

    public Product(Integer id, String name, boolean inStock, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.inStock = inStock;
        this.price = price;
    }

}
