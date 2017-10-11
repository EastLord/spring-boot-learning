package com.dongjun.springbootswagger2.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


public interface UserRepository extends JpaRepository<User,Integer> {

    User findById(Integer id);

    @Transactional
    void deleteById(Integer id);

}
