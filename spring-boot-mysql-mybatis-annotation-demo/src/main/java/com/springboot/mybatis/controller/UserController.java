package com.springboot.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mybatis.domain.User;
import com.springboot.mybatis.mapper.UserMapper;

/**
 * Class UserController
 *
 * @version        1.0, 17/10/10
 * @author         DongJun
 */
@RestController
public class UserController {

    /** Field userMapper */
    @Autowired
    private UserMapper userMapper;

    /**
     * Method add
     *
     * @param user
     */
    @GetMapping("/add")
    public void add(User user) {
        userMapper.insert(user);
    }

    /**
     * Method deleteById
     *
     * @param id
     */
    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        userMapper.deleteById(id);
    }

    /**
     * Method getUser
     *
     * @param id
     *
     * @return User
     */
    @GetMapping("/getUser")
    public User getUser(Integer id) {
        return userMapper.findById(id);
    }

    /**
     * Method getUsers
     *
     * @return List<User>
     */
    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userMapper.findAll();
    }
}