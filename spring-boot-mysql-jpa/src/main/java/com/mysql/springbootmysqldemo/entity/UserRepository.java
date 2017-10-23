package com.mysql.springbootmysqldemo.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Interface UserRepository
 *
 * @version        1.0, 17/10/08
 * @author         qiutiandong
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where  u.name=:name")
    User findUser(@Param("name") String name);

    User findByName(@Param("name") String name);
}