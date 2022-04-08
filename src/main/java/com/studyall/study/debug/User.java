package com.studyall.study.debug;

import lombok.Data;
import lombok.Getter;

@Getter
public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
