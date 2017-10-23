# spring boot hello world 

项目结构图

```
├─main
│  ├─java
│  │  └─com
│  │      └─dongjun
│  │          └─demo
│  │              │  Application.java
│  │              ├─entity
│  │              │      User.java
│  │              │      UserRepository.java   
│  │              ├─enums
│  │              │      Gender.java   
│  │              ├─service
│  │              │  │  UserService.java 
│  │              │  └─impl
│  │              │          UserServiceImpl.java     
│  │              └─web
│  │                      UserController.java
│  │                      
│  └─resources
│      │  application.yml
│      ├─static
│      │  └─bootstrap...                 
│      └─templates
│              add.html
│              edit.html
│              index.html     
└─test
    └─java
        └─com
            └─dongjun
                └─demo
                    │  ApplicationTests.java
                    └─entity
                            UserRepositoryTest.java
```

**1.在pom.xml中添加Maven 依赖:**

```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
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

		<dependency>
			<groupId>net.sourceforge.nekohtml</groupId>
			<artifactId>nekohtml</artifactId>
		</dependency>
		<!--热部署依赖-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<optional>true</optional>
		</dependency>
```

**2.热部署相关配置**

2.1在pom.xml中添加相关依赖并添加以下插件

```xml
<plugin>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-maven-plugin</artifactId>
   <configuration>
      <!--fork :  如果没有该项配置devtools不会起作用，即应用不会restart -->
      <fork>true</fork>
      <addResources>true</addResources><!--支持静态文件热部署-->
   </configuration>
</plugin>
```

2.2打开 Preferences > Compiler , 勾选 Build project automatically

![](https://raw.githubusercontent.com/EastLord/spring-boot-learning/master/image/7-1.png)

2.3Ctrl+Shift+Alt+ /

![](https://raw.githubusercontent.com/EastLord/spring-boot-learning/master/image/7-2.png)

![](https://raw.githubusercontent.com/EastLord/spring-boot-learning/master/image/7-3.png)

**3.在application.yml中添加配置文件**

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false
    username: root
    password: root
    driver-class-name: com.mysql.jdbc.Driver
  jpa:
    database: mysql
    show-sql: true
    hibernate:
      ddl-auto: update
  thymeleaf:
    cache: false
    mode: LEGACYHTML5
  #开启颜色输出
  output:
    ansi:
      enabled: always
```

