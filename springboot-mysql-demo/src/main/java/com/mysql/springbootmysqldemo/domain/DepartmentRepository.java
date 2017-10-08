package com.mysql.springbootmysqldemo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface DepartmentRepository
 *
 * @version        1.0, 17/10/08
 * @author         qiutiandong
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {}
