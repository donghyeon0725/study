package com.studyall.study.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockingSample {
    public static void main(String[] args) {
//        lockingSample();
        reentrant();
    }

    public static void lockingSample() {
        ReentrantLock reentrantLock = new ReentrantLock();

        Thread thread1 = new Thread(() -> {

            try {
                reentrantLock.lock();
                System.out.println("thread1 lock started");


                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                System.out.println("thread1 lock unlocked");
                reentrantLock.unlock();
            }
        });


        Thread thread2 = new Thread(() -> {
            try {
                reentrantLock.lock();
                System.out.println("thread2 lock started");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                reentrantLock.unlock();
            }
            System.out.println("thread2 lock unlocked");
        });

        thread1.start();
        thread2.start();
    }

    public static void reentrant() {
        ReentrantLock reentrantLock = new ReentrantLock();

        reentrantLock.lock();
        reentrantLock.lock();
        System.out.println(2 == reentrantLock.getHoldCount());
        System.out.println(true == reentrantLock.isLocked());

        reentrantLock.unlock();
        System.out.println(1 == reentrantLock.getHoldCount());
        System.out.println(true == reentrantLock.isLocked());

        reentrantLock.unlock();
        System.out.println(0 == reentrantLock.getHoldCount());
        System.out.println(false == reentrantLock.isLocked());

    }
}
