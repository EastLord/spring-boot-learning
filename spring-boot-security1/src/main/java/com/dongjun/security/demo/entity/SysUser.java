package com.dongjun.security.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author dongjun
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "sys_role_user",
            inverseJoinColumns = @JoinColumn(name = "user_id"),
            joinColumns = @JoinColumn(name = "role_id")
    )
    private Set<SysRole> roles;

}
