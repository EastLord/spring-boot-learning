package com.thymeleaf.example.demo.service;

import com.thymeleaf.example.demo.entity.Product;
import com.thymeleaf.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public ProductService() {
        super();
    }

    public List<Product> findAll() {
        return ProductRepository.getInstance().findAll();
    }

    public Product findById(final Integer id) {
        return ProductRepository.getInstance().findById(id);
    }

}
