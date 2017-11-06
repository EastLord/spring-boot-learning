# spring-boot-mysql-mybatis-annotation

项目结构:

```
├─main
│  ├─java
│  │  └─com
│  │      └─springboot
│  │          └─mybatis
│  │              │  MybatisApplication.java
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
│  │              └─web
│  │                      UserController.java
│  │                      
│  └─resources
│          application.yml
│          
└─test
    └─java
        └─com
            └─springboot
                └─mybatis
                    │  MybatisApplicationTests.java
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
#指定实体类路径
mybatis:
  type-aliases-package: com.springboot.mybatis.domain
```

**3.在启动类中添加对mapper包扫描`@MapperScan`**

**4.开发Mapper**

> **注意，使用#符号和$符号的不同：**

```java
// This example creates a prepared statement, something like select * from teacher where name = ?;
@Select("Select * from teacher where name = #{name}")
Teacher selectTeachForGivenName(@Param("name") String name);

// This example creates n inlined statement, something like select * from teacher where name = 'someName';
@Select("Select * from teacher where name = '${name}'")
Teacher selectTeachForGivenName(@Param("name") String name);
```

**5.测试**