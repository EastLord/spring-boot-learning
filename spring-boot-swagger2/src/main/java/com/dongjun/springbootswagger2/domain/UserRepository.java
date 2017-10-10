package com.dongjun.springbootswagger2.domain;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer> {

    User findById(Integer id);

    void deleteById(Integer id);

}
