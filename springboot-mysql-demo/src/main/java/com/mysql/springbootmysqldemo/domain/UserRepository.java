package com.mysql.springbootmysqldemo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface UserRepository
 *
 * @version        1.0, 17/10/08
 * @author         qiutiandong
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {}