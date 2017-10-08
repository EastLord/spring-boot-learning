package com.mysql.springbootmysqldemo.mysql;

import com.mysql.springbootmysqldemo.domain.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Class MysqlTest
 *
 * @version        1.0, 17/10/08
 * @author         qiutiandong
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.mysql.springbootmysqldemo.mysql.JpaConfiguration.class })
public class MysqlTest {

    /** Field logger */
    private static Logger logger = LoggerFactory.getLogger(MysqlTest.class);

    /** Field userRepository */
    @Autowired
    private UserRepository userRepository;

    /** Field departmentRepository */
    @Autowired
    private DepartmentRepository departmentRepository;

    /** Field roleRepository */
    @Autowired
    private RoleRepository roleRepository;

    /**
     * Method findPage
     */
    @Test
    public void findPage() {
        Pageable   pageable = new PageRequest(0, 10, new Sort(Sort.Direction.ASC, "id"));
        Page<User> page     = userRepository.findAll(pageable);

        Assert.assertNotNull(page);

        for (User user : page.getContent()) {
            logger.info("====user==== user name:{},department name{},role name{}",
                        user.getName(),
                        user.getDepartment().getName(),
                        user.getRoles().get(0).getName());
        }
    }

    /**
     * Method initData
     *  初始化数据
     */
    @Before
    public void initData() {
        userRepository.deleteAll();
        departmentRepository.deleteAll();
        roleRepository.deleteAll();

        Department department = new Department();

        department.setName("测试部");
        departmentRepository.save(department);
        Assert.assertNotNull(department.getId());

        Role role = new Role();

        role.setName("admin");
        roleRepository.save(role);
        Assert.assertNotNull(role.getId());

        User user = new User();

        user.setName("user");
        user.setDepartment(department);
        user.setCreateDate(new Date());

        List<Role> roles = roleRepository.findAll();

        Assert.assertNotNull(roles);
        user.setRoles(roles);
        userRepository.save(user);
        Assert.assertNotNull(user.getId());
    }
}
