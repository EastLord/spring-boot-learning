# spring-boot-mysql-jpa

项目结构图：

```
├─main
│  ├─java
│  │  └─com
│  │      └─mysql
│  │          └─springbootmysqldemo
│  │              │  SpringbootMysqlDemoApplication.java
│  │              │  
│  │              └─domain
│  │                      Department.java
│  │                      DepartmentRepository.java
│  │                      Role.java
│  │                      RoleRepository.java
│  │                      User.java
│  │                      UserRepository.java
│  │                      
│  └─resources
│          application.yml
│          
└─test
    └─java
        └─com
            └─mysql
                └─springbootmysqldemo
                    │  SpringbootMysqlDemoApplicationTests.java
                    │  
                    └─mysql
                            JpaConfiguration.java
                            MysqlTest.java
```

**1.在pom.xml中添加Maven 依赖:**

```xml
      <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-data-jpa</artifactId>
      </dependency>

      <dependency>
         <groupId>mysql</groupId>
         <artifactId>mysql-connector-java</artifactId>
         <scope>runtime</scope>
      </dependency>
      <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-test</artifactId>
         <scope>test</scope>
      </dependency>
      <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
      <dependency>
         <groupId>org.projectlombok</groupId>
         <artifactId>lombok</artifactId>
         <version>1.16.8</version>
         <scope>provided</scope>
      </dependency>
      <dependency>
          <groupId>com.fasterxml.jackson.core</groupId>
          <artifactId>jackson-annotations</artifactId>
          <version>2.8.4</version>
      </dependency>
```

> Lombok是一个可以通过简单的注解形式来帮助我们简化消除一些必须有但显得很臃肿的Java代码的工具，通过使用对应的注解，可以在编译源码的时候生成对应的方法

**IntelliJ IDEA要使用它应该先安装插件，搜索Lombok后安装重启IDEA**

以下是几个常用的注解

@Getter / @Setter，让lombok自动生成默认的getter / setter方法。

@ToString 生成toString()方法。

@NoArgsConstructor生成一个无参构造方法。

@AllArgsConstructor 生成一个全参数的构造方法。

@EqualsAndHashCode 生成hashCode()和equals()方法。

@RequiredArgsConstructor会生成构造方法（可能带参数也可能不带参数），如果带参数，这参数只能是以final修饰的未经初始化的字段，或者是以@NonNull注解的未经初始化的字段。@RequiredArgsConstructor(staticName = "of")会生成一个of()的静态方法，并把构造方法设置为私有的

@Data 包含了@ToString，@EqualsAndHashCode，@Getter / @Setter和@RequiredArgsConstructor的功能。

**2.在application.yml添加相关配置:**

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
  #开启颜色输出
  output:
    ansi:
      enabled: always
```

> 在使用spring boot jpa的情况下设置spring.jpa.hibernate.ddl-auto的属性设置为 create or create-drop的时候，spring boot 启动时默认会扫描classpath下面（项目中一般是resources目录）是否有import.sql，如果有机会执行import.sql脚本。

```yaml
spring:
    datasource:
      schema: database/data.sql
      sql-script-encoding: utf-8
```

- schema ：设置脚本的路径
- sql-script-encoding：设置脚本的编码

**3.实体建模:**

![](https://raw.githubusercontent.com/EastLord/spring-boot-learning/master/image/2-1.png)

- 在Department类中，注解@Id定义了一条记录的唯一标识，并结合注解@GeneratedValue将其设置为自增


- 在User类中，注解@ManyToOne定义它与部门的多对一关系，并在数据库中表中用字段did表示部门的ID

  注解@ManyToMany定义与角色实体的多对多关系，并且用中间表user_role来存储它们各自的ID，以表示它们的对应关系。

- @DateTimeFormat 日期类型的数据

- @JsonBackReference用来防止关系对象的递归访问

**4.创建数据访问接口**

每一个实体类都对应一个实体访问接口，该接口继承自`JpaRepository`，该接口本身已经实现了创建（save）、更新（save）、删除（delete）、查询（findAll、findOne）等基本操作的函数，因此对于这些基础操作的数据访问就不需要开发者再自己定义。

同时，我们可以自定义增删改查的方法，根据方法名来自动生成SQL，主要的语法是`findXXBy`,`readAXXBy`,`queryXXBy`,`countXXBy`, `getXXBy`后面跟属性名称

```java
User findByName(@Param("name") String name);
```

**具体的关键字，使用方法和生产成SQL如下表所示**

| Keyword           | Sample                                  | JPQL snippet                             |
| ----------------- | --------------------------------------- | ---------------------------------------- |
| And               | findByLastnameAndFirstname              | … where x.lastname = ?1 and x.firstname = ?2 |
| Or                | findByLastnameOrFirstname               | … where x.lastname = ?1 or x.firstname = ?2 |
| Is,Equals         | findByFirstnameIs,findByFirstnameEquals | … where x.firstname = ?1                 |
| Between           | findByStartDateBetween                  | … where x.startDate between ?1 and ?2    |
| LessThan          | findByAgeLessThan                       | … where x.age < ?1                       |
| LessThanEqual     | findByAgeLessThanEqual                  | … where x.age ⇐ ?1                       |
| GreaterThan       | findByAgeGreaterThan                    | … where x.age > ?1                       |
| GreaterThanEqual  | findByAgeGreaterThanEqual               | … where x.age >= ?1                      |
| After             | findByStartDateAfter                    | … where x.startDate > ?1                 |
| Before            | findByStartDateBefore                   | … where x.startDate < ?1                 |
| IsNull            | findByAgeIsNull                         | … where x.age is null                    |
| IsNotNull,NotNull | findByAge(Is)NotNull                    | … where x.age not null                   |
| Like              | findByFirstnameLike                     | … where x.firstname like ?1              |
| NotLike           | findByFirstnameNotLike                  | … where x.firstname not like ?1          |
| StartingWith      | findByFirstnameStartingWith             | … where x.firstname like ?1 (parameter bound with appended %) |
| EndingWith        | findByFirstnameEndingWith               | … where x.firstname like ?1 (parameter bound with prepended %) |
| Containing        | findByFirstnameContaining               | … where x.firstname like ?1 (parameter bound wrapped in %) |
| OrderBy           | findByAgeOrderByLastnameDesc            | … where x.age = ?1 order by x.lastname desc |
| Not               | findByLastnameNot                       | … where x.lastname <> ?1                 |
| In                | findByAgeIn(Collection ages)            | … where x.age in ?1                      |
| NotIn             | findByAgeNotIn(Collection age)          | … where x.age not in ?1                  |
| TRUE              | findByActiveTrue()                      | … where x.active = true                  |
| FALSE             | findByActiveFalse()                     | … where x.active = false                 |
| IgnoreCase        | findByFirstnameIgnoreCase               | … where UPPER(x.firstame) = UPPER(?1)    |

**5.运行测试类**

`MysqlTest.java`

