package com.dongjun.demo.service;

import com.dongjun.demo.entity.User;

import java.util.List;

public interface UserService {

     void addUser(User user);

     void deleteUserById(Integer id);

     void editUser(User user);

     List<User> findAllUser();

     User findById(Integer id);
}
