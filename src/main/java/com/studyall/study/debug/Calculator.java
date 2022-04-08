package com.studyall.study.debug;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
    public int calculate(int a, int b) {
        return a + b;
    }
}
