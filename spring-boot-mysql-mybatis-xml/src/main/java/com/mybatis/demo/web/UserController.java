package com.mybatis.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybatis.demo.entity.User;
import com.mybatis.demo.service.UserService;

/**
 * Class UserController
 *
 * @version        1.0, 17/10/10
 * @author         DongJun
 */
@RestController
public class UserController {

    /** Field userService */
    @Autowired
    private UserService userService;

    /**
     * Method getUsers
     *
     * @return List<User>
     */
    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        return userService.findAll();
    }
}

