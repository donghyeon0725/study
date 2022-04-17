package com.studyall.study.gc;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.*;


public class ReferenceClassTest {
    private static List<WeakReference<BigData>> weakReferences = new LinkedList<>();
    private static List<SoftReference<BigData>> softReferences = new LinkedList<>();
    private static List<BigData> strongReferences = new LinkedList<>();



    public static void main(String[] args) throws InterruptedException {
        weakReferenceTest();
//        softReferenceTest();
//        strongReferenceTest();
    }

    static class BigData {
        private int[] array = new int[2500];
    }


    static class Sample {
        private String name;
        public Sample(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Sample{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void weakReferenceTest() {
        // visualGC 를 켜기 전에 while 연산으로 들어가면 중간에 jvm info 를 interrupt 를 할 수 없어서인지 열리지 않으므로
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            long i = 0;
            while (true) {
                weakReferences.add(new WeakReference<BigData>(new BigData()));
            }
        } catch (OutOfMemoryError e) {
            System.out.println("out of memory");
        }
    }

    public static void softReferenceTest() {

        // visualGC 를 켜기 전에 while 연산으로 들어가면 중간에 jvm info 를 interrupt 를 할 수 없어서인지 열리지 않으므로
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            while (true) {
                softReferences.add(new SoftReference<>(new BigData()));
            }
        } catch (OutOfMemoryError e) {
            System.out.println("out of memory");
        }
    }

    public static void strongReferenceTest() {
        // visualGC 를 켜기 전에 while 연산으로 들어가면 중간에 jvm info 를 interrupt 를 할 수 없어서인지 열리지 않으므로
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            while (true) {
                strongReferences.add(new BigData());
            }
        } catch (OutOfMemoryError e) {
            System.out.println("out of memory");
        }

    }


    public static void hashMapCacheTest() {
        // visualGC 를 켜기 전에 while 연산으로 들어가면 중간에 jvm info 를 interrupt 를 할 수 없어서인지 열리지 않으므로
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Map<Integer, Sample> map = new HashMap<>();
        int i=0;


        while (true) {
            Integer key = ++i;
            map.put(key, new Sample("이름1"));
            key = null;
        }
    }

    public static void weakHashMapCacheTest () {
        // visualGC 를 켜기 전에 while 연산으로 들어가면 중간에 jvm info 를 interrupt 를 할 수 없어서인지 열리지 않으므로
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WeakHashMap<Integer, Sample> map = new WeakHashMap<>();
        int i=0;

        while (true) {
            Integer key = ++i;
            map.put(key, new Sample("이름1"));
            key = null;
        }
    }
}
