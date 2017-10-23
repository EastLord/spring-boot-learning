package com.dongjun.demo.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Transactional
    void deleteById(Integer id);

    User findById(Integer id);
}
