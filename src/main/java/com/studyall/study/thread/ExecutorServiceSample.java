package com.studyall.study.thread;

import java.util.concurrent.*;

public class ExecutorServiceSample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();


        ExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);

        Future<String> submit1 = newScheduledThreadPool.submit(() -> {
            Thread.sleep(3000);

            return "thread 1 result";
        });

        Future<String> submit2 = newScheduledThreadPool.submit(() -> {
            Thread.sleep(3000);

            return "thread 2 result";
        });

        // blocking 으로 작업 완료를 기다렸다가 처리
        Thread thread1 = new Thread(() -> {
            try {
                String result = submit1.get();

                System.out.println("thread 1 end => " + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        // pooling 으로 확인
        Thread thread2 = new Thread(() -> {

            while (true) {
                System.out.println("thread 2 wait result");

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (submit2.isDone()) {
                    break;
                }
            }

            try {
                System.out.println("thread 2 end => " + submit2.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


        newScheduledThreadPool.shutdown();
    }
}
