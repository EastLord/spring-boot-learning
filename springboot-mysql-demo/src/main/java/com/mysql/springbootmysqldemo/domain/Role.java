package com.mysql.springbootmysqldemo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Class Role
 *
 * @version        1.0, 17/10/08
 * @author         qiutiandong
 */
@Entity
@Data
public class Role implements Serializable {

    /** Field 权限编号 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Field 权限名称 */
    private String name;
}
