package com.dongjun.demo.entity;

import com.dongjun.demo.enums.Gender;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;



    @Test
    public void testSave() {
        User user = new User();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            user.setId(i);
            user.setCity("北京");
            user.setClassify("学生");
            user.setExperience(Integer.toString(random.nextInt(500)%500+1));
            user.setGender(Gender.MAN);
            user.setLogins(random.nextInt(500)%500+1);
            user.setScore(random.nextInt(500)%500+1);
            user.setUsername("用户"+i);
            user.setWealth(Integer.toString(random.nextInt(1000)%1000+1));
            userRepository.save(user);
        }
        Assert.assertEquals(20,userRepository.findAll().size());
    }

}
