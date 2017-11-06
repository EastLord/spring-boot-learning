package com.thymeleaf.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String firstName = null;

    private String lastName = null;

    private String nationality = null;

    private Integer age = null;

    public String getName() {
        return this.firstName + " " + this.lastName;
    }
}
