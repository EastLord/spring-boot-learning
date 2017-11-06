package com.thymeleaf.example.demo.entity;

import lombok.Data;

import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class Order {

    private Integer id = null;

    private Calendar date = null;

    private Customer customer = null;

    private Set<OrderLine> orderLines = new LinkedHashSet<>();

}
