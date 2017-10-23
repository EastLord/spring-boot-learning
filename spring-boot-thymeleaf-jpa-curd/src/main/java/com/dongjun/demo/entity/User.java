package com.dongjun.demo.entity;

import com.dongjun.demo.enums.Gender;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private Gender gender;

    private String city;

    private String experience;

    private Integer logins;

    private String wealth;

    private String classify;

    private Integer score;

}
