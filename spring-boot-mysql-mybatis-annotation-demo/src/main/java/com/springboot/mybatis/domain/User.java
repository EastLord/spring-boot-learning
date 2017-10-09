package com.springboot.mybatis.domain;

import com.springboot.mybatis.enums.UserGender;
import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable{

    private Integer id;

    private String userName;

    private String nickName;

    private String password;

    private UserGender gender;

}
