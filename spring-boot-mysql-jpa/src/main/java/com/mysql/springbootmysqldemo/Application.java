package com.mysql.springbootmysqldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class SpringbootMysqlDemoApplication
 *
 * @version        1.0, 17/10/08
 * @author         qiutiandong
 */
@SpringBootApplication
public class Application {

    /**
     * Method main
     *
     * @param args
     */
    // 程序启动入口
    // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
