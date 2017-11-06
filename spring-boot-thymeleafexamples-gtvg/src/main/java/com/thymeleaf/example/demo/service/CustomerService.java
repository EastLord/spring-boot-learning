package com.thymeleaf.example.demo.service;

import com.thymeleaf.example.demo.entity.Customer;
import com.thymeleaf.example.demo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    public CustomerService() {
        super();
    }

    public List<Customer> findAll() {
        return CustomerRepository.getInstance().findAll();
    }

    public Customer findById(final Integer id) {
        return CustomerRepository.getInstance().findById(id);
    }

}
