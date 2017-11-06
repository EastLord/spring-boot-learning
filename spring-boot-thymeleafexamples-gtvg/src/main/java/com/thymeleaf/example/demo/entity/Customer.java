package com.thymeleaf.example.demo.entity;

import lombok.Data;

import java.util.Calendar;

@Data
public class Customer {

    private Integer id = null;

    private String name = null;

    private Calendar customerSince = null;

}
