package com.studyall.study.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicsSample {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger();
        int i = integer.incrementAndGet();
    }
}
