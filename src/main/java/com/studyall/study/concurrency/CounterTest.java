package com.studyall.study.concurrency;

public class CounterTest {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        int loop = 100;

        Thread thread1 = new Thread(() -> {
            for (int i=0; i<loop; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i=0; i<loop; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter.getI()); // 177
    }
}
