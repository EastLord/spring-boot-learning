package com.springboot.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.springboot.mybatis.entity.User;
import com.springboot.mybatis.enums.UserGender;
import org.springframework.stereotype.Repository;

/**
 * Interface UserMapper
 *
 * @author DongJun
 * @version 1.0, 17/10/10
 */
@Repository
public interface UserMapper {

    /**
     * Method deleteById
     *
     * @param id
     */
    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteById(Integer id);

    /**
     * Method findAll
     *
     * @return List<User>
     */
    @Select("SELECT * FROM user")
    @Results({@Result(
            property = "userName",
            column = "user_name"
    ), @Result(
            property = "nickName",
            column = "nick_name"
    ), @Result(
            property = "gender",
            column = "gender",
            javaType = UserGender.class
    )})
    List<User> findAll();

    /**
     * Method findById
     *
     * @param id
     * @return User
     */
    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({@Result(
            property = "userName",
            column = "user_name"
    ), @Result(
            property = "nickName",
            column = "nick_name"
    ), @Result(
            property = "gender",
            column = "gender",
            javaType = UserGender.class
    )})
    User findById(Integer id);

    /**
     * Method insert
     *
     * @param user
     */
    @Insert("INSERT INTO user(user_name,nick_name,password,gender)"
            + "VALUES(#{userName},#{nickName},#{password},#{gender})")
    void insert(User user);

    /**
     * Method update
     *
     * @param user
     */
    @Update("UPDATE user SET user_name = #{userName},nick_name = #{nickName},"
            + "password = #{password},gender = #{gender}")
    void update(User user);
}
