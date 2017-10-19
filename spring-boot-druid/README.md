在spring boot swagger2 示例的基础上整合了阿里巴巴数据库连接池Druid

项目结构:

```
├─main
│  ├─java
│  │  └─com
│  │      └─druid
│  │          └─springbootdruid
│  │              │  SpringbootdruidApplication.java
│  │              │  Swagger2.java
│  │              │  
│  │              ├─config
│  │              │      DruidConfiguration.java
│  │              │      JpaConfiguration.java
│  │              │      
│  │              ├─domain
│  │              │      User.java
│  │              │      UserRepository.java
│  │              │      
│  │              ├─enums
│  │              │      UserGender.java
│  │              │      
│  │              └─web
│  │                      UserController.java
│  │                      
│  └─resources
│          application.yml
│          
└─test
    └─java
        └─com
            └─druid
                └─springbootdruid
                        SpringbootdruidApplicationTests.java
```

**1.在pom.xml中添加Maven 依赖:**

```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
   <groupId>mysql</groupId>
   <artifactId>mysql-connector-java</artifactId>
   <scope>runtime</scope>
</dependency>
<dependency>
   <groupId>org.projectlombok</groupId>
   <artifactId>lombok</artifactId>
   <optional>true</optional>
</dependency>
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-test</artifactId>
   <scope>test</scope>
</dependency>
<!--集成阿里Druid数据库连接池和监控-->
<dependency>
   <groupId>com.alibaba</groupId>
   <artifactId>druid-spring-boot-starter</artifactId>
   <version>1.1.4</version>
</dependency>
<!--添加Swagger2依赖-->
<dependency>
   <groupId>io.springfox</groupId>
   <artifactId>springfox-swagger2</artifactId>
   <version>2.7.0</version>
</dependency>
<dependency>
   <groupId>io.springfox</groupId>
   <artifactId>springfox-swagger-ui</artifactId>
   <version>2.7.0</version>
</dependency>
```

**2.在application.yml添加相关配置:**

```yaml
spring:
  datasource:
    druid:
      url: jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false
      username: root
      password: root
      driver-class-name: com.mysql.jdbc.Driver
      initial-size: 5
      min-idle: 5
      max-active: 20
      max-wait: 60000
      time-between-eviction-runs-millis: 60000
      min-evictable-idle-time-millis: 300000
      validation-query: SELECT 1 FROM DUAL
      test-while-idle: true
      test-on-borrow: false
      test-on-return: false
      pool-prepared-statements: false
      max-pool-prepared-statement-per-connection-size: 20
      filters: stat,wall,log4j
      connection-properties:
      filter:
        stat:
          merge-sql: true
          slow-sql-millis: 5000
      stat-view-servlet:
        enabled: true
        allow: 192.168.1.218,127.0.0.1
        deny: 192.168.1.100
        login-username: admin
        login-password: admin
        reset-enable: false
      web-stat-filter:
        enabled: true
        url-pattern: /*
        #在这儿被坑了挺长时间
        exclusions: /druid/*,*.js,*.gif,*.jpg,*.png,*.css,*.ico
  jpa:
    show-sql: true
    properties:
      hibernate:
        hbm2ddl:
          auto: update
  #开启颜色输出
  output:
    ansi:
      enabled: always
```

**3.启动项目后访问http://localhost:8080/druid 登录名密码都是admin**

![](https://raw.githubusercontent.com/EastLord/spring-boot-learning/master/image/6-1.png)

![](https://raw.githubusercontent.com/EastLord/spring-boot-learning/master/image/6-2.png)