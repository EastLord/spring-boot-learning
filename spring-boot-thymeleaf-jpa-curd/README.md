# spring boot thymeleaf jpa curd 

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

**4.运行UserRepositoryTest测试类，初始化数据**

**5.运行项目后访问http://localhost:8080**

![](https://raw.githubusercontent.com/EastLord/spring-boot-learning/master/image/7-4.png)

![](https://raw.githubusercontent.com/EastLord/spring-boot-learning/master/image/7-5.png)

![](https://raw.githubusercontent.com/EastLord/spring-boot-learning/master/image/7-6.png)

**6.注意事项:**

thymeleaf 设置不校验html标签:

默认配置下，thymeleaf对.html的内容要求很严格，比如，如果少封闭符号/，就会报错而转到错误页。也比如你在使用Vue.js这样的库，然后有<div v-cloak></div>这样的html代码，也会被thymeleaf认为不符合要求而抛出错误。

通过设置thymeleaf模板可以解决这个问题，下面是具体的配置:

```properties
spring.thymeleaf.cache=false
spring.thymeleaf.mode=LEGACYHTML5
```

LEGACYHTML5需要搭配一个额外的库NekoHTML才可用 项目中使用的构建工具是Maven添加如下的依赖即可完成:

```xml
<dependency>
	<groupId>net.sourceforge.nekohtml</groupId>
	<artifactId>nekohtml</artifactId>
	<version>1.9.22</version>
</dependency>
```

参考:[thymeleaf模板对没有结束符的HTML5标签解析出错的解决办法](http://blog.csdn.net/yalishadaa/article/details/60768811)