# spring-boot 入门学习

`	git clone https://github.com/EastLord/spring-boot-learning.git`

​	用IDEA打开项目，在右侧的maven projects 中点击Add Maven Projects按钮（绿色的加号），添加相应模块的pom.xml即可

- [spring-boot-helloworld](https://github.com/EastLord/spring-boot-learning/tree/master/spring-boot-helloword) spring boot hello world 示例
- [spring-boot-banner](https://github.com/EastLord/spring-boot-learning/tree/master/spring-boot-banner) spring boot 自定义banner
- [spring-boot-mysql-jpa](https://github.com/EastLord/spring-boot-learning/tree/master/spring-boot-mysql-jpa) spring boot 整合JPA
- [spring-boot-mysql-mybatis-annotation](https://github.com/EastLord/spring-boot-learning/tree/master/spring-boot-mysql-mybatis-annotation) spring boot 整合mybatis注解示例
- [ spring-boot-mysql-mybatis-xml](https://github.com/EastLord/spring-boot-learning/tree/master/spring-boot-mysql-mybatis-xml) spring boot 整合mybatis xml示例
- [spring-boot-swagger2](https://github.com/EastLord/spring-boot-learning/tree/master/spring-boot-swagger2)     spring boot 整合 jpa Swagger2 构建RESTful APIs  
- [spring-boot-druid](https://github.com/EastLord/spring-boot-learning/tree/master/spring-boot-druid)   在[spring-boot-swagger2](https://github.com/EastLord/spring-boot-learning/tree/master/spring-boot-swagger2)  这个例子基础上整合了阿里数据库连接池druid
- [spring-boot-thymeleaf-jpa-curd](https://github.com/EastLord/spring-boot-learning/tree/master/spring-boot-thymeleaf-jpa-curd) 应用了spring boot官方推荐的模板引擎Thymeleaf，持久层使用JPA，并启用热部署spring-boot-devtools
- [spring-boot-mail](https://github.com/EastLord/spring-boot-learning/tree/master/spring-boot-mail)  spring boot send mail with Thymeleaf
- [spring-boot-thymeleafexamples-gtvg](https://github.com/EastLord/spring-boot-learning/tree/master/spring-boot-thymeleafexamples-gtvg)  根据Thymeleaf官方网站上的示例进行修改的spring boot版本


使用IDEA的Spring Initializr 新建项目:

​	注意Initializr Service URL 为 https://start.spring.io 这将会连接网络，以查询Spring Boot当前可用版本和组件列表，大体需要三步:

**1.选择类型**

![](https://raw.githubusercontent.com/EastLord/spring-boot-learning/master/image/0-1.png)

![](https://raw.githubusercontent.com/EastLord/spring-boot-learning/master/image/0-2.png)

**2.选择Spring Boot版本和组件**

​	选择Spring Boot版本和Spring Boot组件，例如在Spring Boot Version中选择1.5.7，并勾选Web项目组件，然后点击Next进入下一步

![](https://raw.githubusercontent.com/EastLord/spring-boot-learning/master/image/0-3.png)

**3.输入项目名称**

![](https://raw.githubusercontent.com/EastLord/spring-boot-learning/master/image/0-4.png)