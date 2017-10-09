package com.springboot.mybatis.controller;

import com.springboot.mybatis.domain.User;
import com.springboot.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userMapper.findAll();
    }

    @GetMapping("/getUser")
    public User getUser(Integer id) {
        return userMapper.findById(id);
    }

    @GetMapping("/add")
    public void add(User user) {
        userMapper.insert(user);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        userMapper.deleteById(id);
    }
}
