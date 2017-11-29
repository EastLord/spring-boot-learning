package com.dongjun.security.demo.service;

import com.dongjun.security.demo.entity.SysUser;

/**
 * @author dongjun
 */
public interface UserService {

    /**
     * 通过username查找SysUser实体
     * @param username
     * @return
     */
    SysUser findByUsername(String username);

}
