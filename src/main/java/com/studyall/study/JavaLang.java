package com.studyall.study;

import java.util.ArrayList;
import java.util.Vector;

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
    }
}
