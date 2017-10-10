package com.springboot.mybatis.mapper;


import com.springboot.mybatis.domain.User;
import com.springboot.mybatis.enums.UserGender;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() throws SQLException {
        User user = new User();
        for (int i=0;i<5;i++) {
            user.setNickName("user"+i);
            user.setUserName("username"+i);
            user.setPassword("123456");
            user.setGender(UserGender.MAN);
            userMapper.insert(user);
        }

        Assert.assertEquals(5,userMapper.findAll().size());
    }

    @Test
    public void testGetAll() throws SQLException {
        System.out.println(userMapper.findAll().toString());
    }

    @Test
    public void testUpdate() throws SQLException {
        User user = userMapper.findById(1);
        System.out.println(user.toString());
        user.setNickName("EastLord");
        userMapper.update(user);
        Assert.assertEquals("EastLord",userMapper.findById(1).getNickName());
    }


}
