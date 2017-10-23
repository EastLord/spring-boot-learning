package com.springboot.mybatis.entity;

import java.io.Serializable;

import com.springboot.mybatis.enums.UserGender;

import lombok.Data;

/**
 * Class User
 *
 * @version        1.0, 17/10/10
 * @author         DongJun
 */
@Data
public class User implements Serializable {

    /** Field 用户编号 */
    private Integer id;

    /** Field 用户名 */
    private String userName;

    /** Field 昵称 */
    private String nickName;

    /** Field 密码 */
    private String password;

    /** Field 性别 */
    private UserGender gender;
}
