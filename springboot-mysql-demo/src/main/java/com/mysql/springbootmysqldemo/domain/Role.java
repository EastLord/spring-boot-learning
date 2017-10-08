package com.mysql.springbootmysqldemo.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Role implements Serializable{

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
}
