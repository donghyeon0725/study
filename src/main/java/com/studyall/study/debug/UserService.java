package com.studyall.study.debug;

import org.junit.Test;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private List<User> userList = new ArrayList(Arrays.asList(new User("user1", 20), new User("user2", 22)));


    public void addUser(User user) {
        userList.add(user);
    }

    @Test
    public User findUser(String name) {

        for (User user : userList) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }

        return null;
    }
}
