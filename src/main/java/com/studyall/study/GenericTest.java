package com.studyall.study;

import java.util.ArrayList;
import java.util.Collections;

public class GenericTest {
    public static void main(String[] args) {
        GenericClass<Integer> genericClass = new <String>GenericClass(40404);
        genericClass.setValue(999);

        ArrayList<ArrayList<Object>> list = new ArrayList<>();
        ArrayList<Object> newList = new ArrayList<>();
        newList.add("a");
        Collections.addAll(list, newList);
        System.out.println(list);
    }
}
