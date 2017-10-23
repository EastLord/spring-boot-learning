package com.mysql.springbootmysqldemo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Class User
 *
 * @version        1.0, 17/10/08
 * @author         qiutiandong
 */
@Entity
@Data
public class User implements Serializable {

    /** Field 用户编号 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** Field 用户名称 */
    private String name;

    /** Field 创建日期 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    /** Field 部门 */
    @ManyToOne
    @JoinColumn(name = "did")
    @JsonBackReference
    private Department department;

    /** Field 权限 */
    @ManyToMany(
        cascade            = {},
        fetch              = FetchType.EAGER
    )
    @JoinTable(
        name               = "user_role",
        joinColumns        = { @JoinColumn(name = "user_id") },
        inverseJoinColumns = { @JoinColumn(name = "roles_id") }
    )
    private List<Role> roles;
}
