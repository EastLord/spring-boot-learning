package com.dongjun.springbootswagger2.entity;

import com.dongjun.springbootswagger2.enums.UserGender;
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

    private String userName;

    private String nickName;

    private String password;

    private UserGender gender;
}
