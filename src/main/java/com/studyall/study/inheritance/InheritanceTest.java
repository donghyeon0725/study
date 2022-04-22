package com.studyall.study.inheritance;

import java.util.Arrays;

public class InheritanceTest {
    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();

        s.addAll(Arrays.asList("a", "b", "c"));


        System.out.println(s.getAddCount());
    }
}
