package com.dongjun.springbootswagger2.controller;

import com.dongjun.springbootswagger2.domain.User;
import com.dongjun.springbootswagger2.domain.UserRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value="/users")     // 通过这里配置使下面的映射都在/users下，可去除
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value="获取用户列表", notes="")
    @GetMapping(value = "")
    public List<User> getUserList() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping(value = "/add")
    public String postUser(@RequestBody User user) {
        userRepository.save(user);
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @PutMapping(value = "/{id}")
    public String putUser(@PathVariable Integer id, @RequestBody User newUser) {
        User oldUser = userRepository.findById(id);
        oldUser.setNickName(newUser.getNickName());
        oldUser.setGender(newUser.getGender());
        oldUser.setPassword(newUser.getPassword());
        oldUser.setUserName(newUser.getUserName());
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
        return "success";
    }

}
