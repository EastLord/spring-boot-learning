package com.thymeleaf.example.demo.entity;

import lombok.*;

@Data
@AllArgsConstructor
public class Comment {

    private Integer id = null;

    private String text;

}
