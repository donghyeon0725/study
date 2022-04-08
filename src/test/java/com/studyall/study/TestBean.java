package com.studyall.study;

import com.studyall.study.debug.User;
import com.studyall.study.debug.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestBean {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        userService.addUser(new User("user3", 22));
    }
}
