项目结构图：

```
├─main
│  ├─java
│  │  └─com
│  │      └─dongjun
│  │          └─mail
│  │              └─demo
│  │                  ├─business
│  │                  │  └─service
│  │                  └─web
│  │                      └─controller
│  └─resources
│      ├─mail
│      │  ├─editablehtml
│      │  │  └─images
│      │  ├─html
│      │  └─text
│      ├─static
│      │  ├─css
│      │  └─images
│      └─templates
└─test
    └─java
        └─com
            └─dongjun
                └─mail
                    └─demo
```
**1.在pom.xml中添加Maven 依赖:**

```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-mail</artifactId>
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

<dependency>
   <groupId>org.thymeleaf</groupId>
   <artifactId>thymeleaf</artifactId>
   <version>3.0.6.RELEASE</version>
</dependency>

<dependency>
   <groupId>org.thymeleaf</groupId>
   <artifactId>thymeleaf-spring4</artifactId>
   <version>3.0.6.RELEASE</version>
</dependency>

<dependency>
   <groupId>commons-io</groupId>
   <artifactId>commons-io</artifactId>
   <version>2.4</version>
</dependency>

<dependency>
   <groupId>commons-fileupload</groupId>
   <artifactId>commons-fileupload</artifactId>
   <version>1.3.1</version>
</dependency>

<dependency>
   <groupId>nz.net.ultraq.thymeleaf</groupId>
   <artifactId>thymeleaf-layout-dialect</artifactId>
   <version>2.1.2</version>
</dependency>

<dependency>
   <groupId>javax.servlet</groupId>
   <artifactId>javax.servlet-api</artifactId>
   <version>3.1.0</version>
</dependency>
```

**2.在application.yml添加相关配置:**

```yaml
spring:
  thymeleaf:
    cache: false
    mode: LEGACYHTML5
  output:
    ansi:
      enabled: always
  mail:
    default-encoding: UTF-8
server:
  port: 8088
```

**3.在emailconfig.properties需要添加邮件服务器的host,username,password:**

```properties
mail.server.host=smtp.163.com
mail.server.port=25
mail.server.protocol=smtp
mail.server.username=
mail.server.password=
mail.server.from=
```

**4.启动项目后访问http://localhost:8088**

这个示例，是在thymeleaf官网示例的基础上修改的

![](https://raw.githubusercontent.com/EastLord/spring-boot-learning/master/image/8-1.png)