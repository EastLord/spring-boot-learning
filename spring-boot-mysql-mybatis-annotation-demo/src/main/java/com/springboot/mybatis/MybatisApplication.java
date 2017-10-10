package com.springboot.mybatis;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class MybatisApplication
 * 启动类
 * @version        1.0, 17/10/10
 * @author         DongJun
 */
@SpringBootApplication
@MapperScan("com.springboot.mybatis.mapper")
public class MybatisApplication {

    /**
     * Method main
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }
}
