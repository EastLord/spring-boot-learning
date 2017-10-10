package com.mybatis.demo.service;

import java.util.List;

import com.mybatis.demo.domain.User;

/**
 * Interface UserService
 *
 * @version        1.0, 17/10/10
 * @author         DongJun
 */
public interface UserService {

    /**
     * Method findAll
     *
     * @return List<User>
     */
    public List<User> findAll();
}
