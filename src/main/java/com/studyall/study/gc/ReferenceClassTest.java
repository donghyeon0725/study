package com.studyall.study.gc;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.*;


public class ReferenceClassTest {
    private static List<WeakReference<BigData>> weakReferences = new LinkedList<>();
    private static List<SoftReference<BigData>> softReferences = new LinkedList<>();
    private static List<BigData> strongReferences = new LinkedList<>();
    private static ReferenceQueue referenceQueue = new ReferenceQueue();

    public static void main(String[] args) throws InterruptedException {
//        weakReferenceTestWithReferenceQueue();
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
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            while (true) {
                weakReferences.add(new WeakReference<>(new BigData()));
            }
        } catch (OutOfMemoryError e) {
            System.out.println("out of memory");
        }
    }

    // ReferenceQueue 에 값이 잘 수거되고 있지 않기 때문에 Old Gen 메모리 상에 무엇인가 남는 것인지 확인해봤는데, 아님. 큐에 데이터 잘 쌓이고 있음
    public static void weakReferenceTestWithReferenceQueue() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Reference reference = null;

        try {
            while (true) {
                weakReferences.add(new WeakReference<>(new BigData(), referenceQueue));


                while ((reference = referenceQueue.poll()) != null) {

                    System.out.println("데이터 있음");

                    reference = null;
                }
            }
        } catch (OutOfMemoryError e) {
            System.out.println("out of memory");
        }
    }

    public static void softReferenceTest() {

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
