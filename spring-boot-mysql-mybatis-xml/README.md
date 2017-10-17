项目结构

```
├─main
│  ├─java
│  │  └─com
│  │      └─mybatis
│  │          └─demo
│  │              │  DemoApplication.java
│  │              │  
│  │              ├─domain
│  │              │      User.java
│  │              │      
│  │              ├─enums
│  │              │      UserGender.java
│  │              │      
│  │              ├─mapper
│  │              │      UserMapper.java
│  │              │      
│  │              ├─service
│  │              │  │  UserService.java
│  │              │  │  
│  │              │  └─impl
│  │              │          UserServiceImpl.java
│  │              │          
│  │              └─web
│  │                      UserController.java
│  │                      
│  └─resources
│      │  application.yml
│      │  
│      └─mybatis
│          │  mybatis-config.xml
│          │  
│          └─mapper
│                  UserMapper.xml
│                  
└─test
    └─java
        └─com
            └─mybatis
                └─demo
                    │  DemoApplicationTests.java
                    │  
                    └─mapper
                            UserMapperTest.java
```

**1.在pom.xml中添加Maven 依赖:**

```xml
<dependency>
   <groupId>org.mybatis.spring.boot</groupId>
   <artifactId>mybatis-spring-boot-starter</artifactId>
   <version>1.3.1</version>
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
```

**2.在application.yml添加相关配置:**

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false
    username: root
    password: root
  #开启颜色输出
  output:
    ansi:
      enabled: always
mybatis:
  #指定mybatis基础配置文件地址
  config-location: classpath:mybatis/mybatis-config.xml
  #指定mybatis实体类映射文件地址
  mapper-locations: classpath:mybatis/mapper/*.xml
```

此版本和注解版本类似