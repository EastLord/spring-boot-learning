package com.mysql.springbootmysqldemo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Class Department
 *
 * @version        1.0, 17/10/08
 * @author         qiutiandong
 */
@Entity
@Data
public class Department implements Serializable {

    /** Field 部门编号 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Field 部门名称 */
    private String name;
}
