项目结构：

```
├─main
│  ├─java
│  │  └─com
│  │      └─dongjun
│  │          └─springbootswagger2
│  │              │  Springbootswagger2Application.java
│  │              │  Swagger2.java
│  │              │  
│  │              ├─config
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
            └─dongjun
                └─springbootswagger2
                        Springbootswagger2ApplicationTests.java
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

和jpa示例的配置一样

```yaml
spring:
  datasource:
      url: jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false
      username: root
      password: root
      driver-class-name: com.mysql.jdbc.Driver
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

**3.Swagger2配置类**

```java
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dongjun.springbootswagger2.web"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     swagger2使用说明：
     @Api：用在类上，说明该类的作用
     @ApiOperation：用在方法上，说明方法的作用
     @ApiIgnore：使用该注解忽略这个API
     @ApiImplicitParams：用在方法上包含一组参数说明
     @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
     paramType：参数放在哪个地方
     header-->请求参数的获取：@RequestHeader
     query-->请求参数的获取：@RequestParam
     path（用于restful接口）-->请求参数的获取：@PathVariable
     body（不常用）
     form（不常用）
     name：参数名
     dataType：参数类型
     required：参数是否必须传
     value：参数的意思
     defaultValue：参数的默认值
     @ApiResponses：用于表示一组响应
     @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
     code：数字，例如400
     message：信息，例如"请求参数没填好"
     response：抛出异常的类
     @ApiModel：描述一个Model的信息（这种一般用在post创建的时候，使用@RequestBody这样的场景，请求参数无法使用@ApiImplicitParam注解进行描述的时候）
     @ApiModelProperty：描述一个model的属性
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("Demo")
                .contact(new Contact("EastLord","https://github.com/EastLord","qiutiandong@gmail.com"))
                .version("1.0")
                .build();
    }
}
```

**4.在web目录下的UserController中添加文档内容：**

`@ApiOperation`注解来给API增加说明、通过`@ApiImplicitParams`、`@ApiImplicitParam`注解来给参数增加说明

```java
@Resource
private UserRepository userRepository;

@ApiOperation(value="获取用户列表", notes="")
@GetMapping(value = "")
public List<User> getUserList() {
    List<User> userList = userRepository.findAll();
    return userList;
}

@ApiOperation(value="创建用户", notes="根据User对象创建用户")
@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
@PostMapping(value = "/add")
public String postUser(@RequestBody User user) {
    userRepository.save(user);
    return "success";
}

@ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer",paramType = "path")
@GetMapping(value = "/{id}")
public User getUser(@PathVariable Integer id) {
    return userRepository.findById(id);
}

@ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
@ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer",paramType = "path"),
        @ApiImplicitParam(name = "newUser", value = "用户详细实体user", required = true, dataType = "User")
})
@PutMapping(value = "/{id}")
public String putUser(@PathVariable Integer id, @RequestBody User newUser) {
    User oldUser = userRepository.findById(id);
    oldUser.setNickName(newUser.getNickName());
    oldUser.setGender(newUser.getGender());
    oldUser.setPassword(newUser.getPassword());
    oldUser.setUserName(newUser.getUserName());
    return "success";
}

@ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer",paramType = "path")
@DeleteMapping(value = "/{id}")
public String deleteUser(@PathVariable Integer id) {
    userRepository.deleteById(id);
    return "success";
}
```

5.运行项目后，访问http://localhost:8080/swagger-ui.html

![](https://raw.githubusercontent.com/EastLord/spring-boot-learning/master/image/5-1.png)

![](https://raw.githubusercontent.com/EastLord/spring-boot-learning/master/image/5-2.png)