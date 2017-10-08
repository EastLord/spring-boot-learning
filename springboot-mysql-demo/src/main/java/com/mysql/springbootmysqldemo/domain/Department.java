package com.mysql.springbootmysqldemo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
    @GeneratedValue
    private Integer id;

    /** Field 部门名称 */
    private String name;
}
