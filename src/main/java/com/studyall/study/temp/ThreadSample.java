package com.studyall.study.temp;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new SubThread(1000);
        Thread thread2 = new SubThread(1000);


        final Object valueLock = new Object();
        final Object volValueLock = new Object();

        Thread thread3 = new SyncSubThread(1000, valueLock, volValueLock);
        Thread thread4 = new SyncSubThread(1000, valueLock, volValueLock);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // 쓰레드가 종료되길 기다리지 않으면 결과를 얻을 수 없음!
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        System.out.println(ThreadSample.value);
        System.out.println(ThreadSample.volValue);
        System.out.println(ThreadSample.atomicInteger.get());

        System.out.println(ThreadSample.syncValue);
        System.out.println(ThreadSample.syncVolValue);
    }

    private static int value = 0;
    private static volatile int volValue = 0;
    private static int syncValue = 0;
    private static volatile int syncVolValue = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger();

    static class SubThread extends Thread {
        private int count;

        public SubThread(int count) {
            this.count = count;
        }

        @Override
        public void run() {
            for (int i=0; i<this.count; i++) {
                ThreadSample.value++;
                ThreadSample.atomicInteger.incrementAndGet();
                ThreadSample.volValue++;
            }
        }
    }

    static class SyncSubThread extends Thread {
        private int count;
        private Object valueLock;
        private Object volValueLock;

        public SyncSubThread(int count, Object valueLock, Object volValueLock) {
            this.count = count;
            this.valueLock = valueLock;
            this.volValueLock = volValueLock;
        }

        @Override
        public void run() {
            for (int i=0; i<this.count; i++) {
                synchronized (valueLock) {
                    ThreadSample.syncValue++;
                }
                synchronized (volValueLock) {
                    ThreadSample.syncVolValue++;
                }
            }
        }
    }
}
