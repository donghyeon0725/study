package com.studyall.study.annotationProcessor;

public class Person {
    private int age;
    private String name;

    @BuilderProperty
    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    @BuilderProperty
    public Person setName(String name) {
        this.name = name;
        return this;
    }
}
