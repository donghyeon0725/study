package com.studyall.study.latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LatchSample implements Runnable {

    private final CountDownLatch latch;

    public LatchSample(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Done API Call");

        try {
            latch.countDown();
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " Continue processing");
    }


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch apiLatch = new CountDownLatch(5);

        ExecutorService pool = Executors.newFixedThreadPool(5);

        for (int i=0; i<5; i++) {
            pool.submit(new LatchSample(apiLatch));
        }

        System.out.println(Thread.currentThread().getName() + " about to await on main");
        apiLatch.await();
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
