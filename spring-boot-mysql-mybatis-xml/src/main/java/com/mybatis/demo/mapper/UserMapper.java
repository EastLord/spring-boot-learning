package com.mybatis.demo.mapper;

import java.util.List;

import com.mybatis.demo.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Interface UserMapper
 *
 * @version        1.0, 17/10/10
 * @author         DongJun
 */
@Repository
public interface UserMapper {

    /**
     * Method deleteById
     *
     * @param id
     */
    void deleteById(Integer id);

    /**
     * Method findAll
     *
     * @return List<User>
     */
    List<User> findAll();

    /**
     * Method findById
     *
     * @param id
     *
     * @return User
     */
    User findById(Integer id);

    /**
     * Method insert
     *
     * @param user
     */
    void insert(User user);

    /**
     * Method update
     *
     * @param user
     */
    void update(User user);
}
