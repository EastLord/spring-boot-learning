package com.thymeleaf.example.demo.service;

import com.thymeleaf.example.demo.entity.Order;
import com.thymeleaf.example.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    public OrderService() {
        super();
    }

    public List<Order> findAll() {
        return OrderRepository.getInstance().findAll();
    }

    public Order findById(final Integer id) {
        return OrderRepository.getInstance().findById(id);
    }

    public List<Order> findByCustomerId(final Integer customerId) {
        return OrderRepository.getInstance().findByCustomerId(customerId);
    }

}
