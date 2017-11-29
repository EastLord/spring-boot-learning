package com.dongjun.security.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author dongjun
 */
@Entity
@Data
@Table(name = "sys_user")
public class SysUser implements Serializable{

    /**
     * 主键 id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 用户名 username
     */
    @Column(name = "user_name")
    private String username;

    /**
     * 用户密码 password
     */
    @Column(name = "password")
    private String password;

    /**
     * 权限列表
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "sys_role_user",
            inverseJoinColumns = @JoinColumn(name = "user_id"),
            joinColumns = @JoinColumn(name = "role_id")
    )
    private List<SysRole> roles;

}
