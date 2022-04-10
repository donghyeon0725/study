package com.studyall.study.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceSample {
    public static void main(String[] args) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);
    }
}
