# spring boot hello world 

项目结构图

```
├─main
│  ├─java
│  │  └─com
│  │      └─dongjun
│  │          └─springboothelloword
│  │              │  SpringBootHellowordApplication.java
│  │              │  
│  │              └─web
│  │                      HelloWorldController.java
│  │                      
│  └─resources
│          application.yml
│          
└─test
    └─java
        └─com
            └─dongjun
                └─springboothelloword
                        SpringBootHellowordApplicationTests.java
```

1.在pom.xml中添加Maven 依赖:

```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

2.在controller中编写如下内容:

```java
@RestController
public class HelloWorldController {

    /**
     * Method HelloWorld
     *
     * @return String
     */
    @GetMapping(value = "/")
    public String HelloWorld() {
        return "Hello World!";
    }
}
```

@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用

此controller的方法会以json格式输出

启动项目后访问http://localhost:8080

![](https://raw.githubusercontent.com/EastLord/spring-boot-learning/master/image/1-1.png)