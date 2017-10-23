package com.mysql.springbootmysqldemo.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface RoleRepository
 *
 * @version        1.0, 17/10/08
 * @author         qiutiandong
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {}
