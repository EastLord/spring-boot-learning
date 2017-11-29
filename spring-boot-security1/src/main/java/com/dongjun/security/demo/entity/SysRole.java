package com.dongjun.security.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author dongjun
 */
@Entity
@Data
@Table(name = "sys_role")
public class SysRole implements Serializable{

    /**
     * 主键 id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 权限名称 name
     */
    @Column(name = "name")
    private String name;

}
