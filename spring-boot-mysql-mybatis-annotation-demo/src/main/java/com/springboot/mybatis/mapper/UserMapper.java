package com.springboot.mybatis.mapper;

import com.springboot.mybatis.domain.User;
import com.springboot.mybatis.enums.UserGender;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "userName",column = "user_name"),
            @Result(property = "nickName",column = "nick_name"),
            @Result(property = "gender",column = "gender",javaType = UserGender.class)
    })
    List<User> findAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "userName",column = "user_name"),
            @Result(property = "nickName",column = "nick_name"),
            @Result(property = "gender",column = "gender",javaType = UserGender.class)
    })
    User findById(Integer id);

    @Insert("INSERT INTO user(user_name,nick_name,password,gender)" +
            "VALUES(#{userName},#{nickName},#{password},#{gender})")
    void insert(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteById(Integer id);

    @Update("UPDATE user SET user_name = #{userName},nick_name = #{nickName}," +
            "password = #{password},gender = #{gender}")
    void update(User user);
}
