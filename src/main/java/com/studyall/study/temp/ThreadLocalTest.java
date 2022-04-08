package com.studyall.study.temp;

public class ThreadLocalTest {
    private static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
           local.set("thread1 test1");
           local.set("thread1 test2");

            System.out.println(local.get());
            System.out.println(local.get());
        });


        Thread thread2 = new Thread(() -> {
           local.set("thread2 test1");
           local.set("thread2 test2");

            System.out.println(local.get());
            System.out.println(local.get());
        });

        thread1.start();
        thread2.start();
    }
}
