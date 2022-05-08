package com.studyall.study.genericTest;

import java.util.HashMap;
import java.util.Map;

public class GenericTest {
    public static void main(String[] args) {
        // 컴파일 후 Generic Element Type 은 Erasure 될까?
        Map<String, Object> map = new HashMap<>();
        map.put("1", 1);
    }
}
