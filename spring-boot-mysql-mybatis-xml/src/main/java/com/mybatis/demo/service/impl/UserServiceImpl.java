package com.mybatis.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.demo.domain.User;
import com.mybatis.demo.mapper.UserMapper;
import com.mybatis.demo.service.UserService;

/**
 * Class UserServiceImpl
 *
 * @version        1.0, 17/10/10
 * @author         DongJun
 */
@Service
public class UserServiceImpl implements UserService {

    /** Field userMapper */
    @Autowired
    private UserMapper userMapper;

    /**
     * Method findAll
     *
     * @return List<User>
     */
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
