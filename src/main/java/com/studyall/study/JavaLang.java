package com.studyall.study;

import java.util.*;

public class JavaLang {
    public static void main(String[] args) {
        System.out.println(System.nanoTime());
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getenv("JAVA_HOME"));
        System.out.println(System.nanoTime());

        // thread safe
        Vector vector = new Vector();
        // non thread safe
        ArrayList arrayList = new ArrayList();

        run();
    }

    private static void run() {

        System.out.println("=========");

        ArrayList<String> list = new ArrayList<>();

        list.add("string1");
        list.add("string2");
        list.add("string3");

        String[] array = new String[2];
        String[] strings = list.toArray(array);

        for (String s : strings) {
            System.out.println(s);
        }

        List<Object> objects = Collections.synchronizedList(new ArrayList<>());

        Stack stack = new Stack();

        Collection collections = null;

        for (Object o : collections) {

        }

        HashSet<String> set = new HashSet();

        for (String s : set) {
            System.out.println(s);
        }
    }
}
