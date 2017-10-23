package com.mybatis.demo.entity;


import com.mybatis.demo.enums.UserGender;
import lombok.Data;

import java.io.Serializable;

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
