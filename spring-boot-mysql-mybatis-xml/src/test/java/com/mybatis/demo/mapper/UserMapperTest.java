package com.mybatis.demo.mapper;

import com.mybatis.demo.entity.User;
import com.mybatis.demo.enums.UserGender;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




/**
 * Class UserMapperTest
 *
 * @version        1.0, 17/10/10
 * @author         DongJun
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserMapperTest {

    /** Field userMapper */
    @Autowired
    private UserMapper userMapper;

    /**
     * Method testDelete
     *
     * @throws SQLException
     */
    @Test
    public void testDelete() throws SQLException {
        userMapper.deleteById(2);
    }

    /**
     * Method testGetAll
     *
     * @throws SQLException
     */
    @Test
    public void testGetAll() throws SQLException {
        System.out.println(userMapper.findAll().toString());
    }

    /**
     * Method testInsert
     *
     * @throws SQLException
     */
    @Test
    public void testInsert() throws SQLException {
        User user = new User();

        for (int i = 0; i < 5; i++) {
            user.setNickName("user" + i);
            user.setUserName("username" + i);
            user.setPassword("123456");
            user.setGender(UserGender.MAN);
            userMapper.insert(user);
        }

        Assert.assertEquals(5, userMapper.findAll().size());
    }

    /**
     * Method testUpdate
     *
     * @throws SQLException
     */
    @Test
    public void testUpdate() throws SQLException {
        User user = userMapper.findById(1);

        System.out.println(user.toString());
        user.setNickName("EastLord");
        userMapper.update(user);
        Assert.assertEquals("EastLord", userMapper.findById(1).getNickName());
    }
}
