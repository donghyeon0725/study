package com.studyall.study.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LatchSample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);

        ExecutorService pool = Executors.newFixedThreadPool(5);

        for (int i=0; i<5; i++) {
            pool.submit(new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " Done API Call");

                try {
                    latch.countDown();
                    latch.await(); // latch count 가 0 이 될 때 까지 대기
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " Continue processing");
            }));
        }

        System.out.println(Thread.currentThread().getName() + " about to await on main");
        latch.await();
        System.out.println(Thread.currentThread().getName() + " done awaiting on main..");

        pool.shutdown();

        try {
            pool.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("API Processing Complete");
    }

}
