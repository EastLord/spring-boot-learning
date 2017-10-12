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
    // 程序启动入口
    // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }
}
