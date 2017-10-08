package com.mysql.springbootmysqldemo.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Department implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
}
