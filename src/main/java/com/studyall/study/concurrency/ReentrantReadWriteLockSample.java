package com.studyall.study.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockSample {
    private final ReentrantReadWriteLock lockCreator = new ReentrantReadWriteLock();
    private final Lock readLock = lockCreator.readLock();
    private final Lock writeLock = lockCreator.writeLock();
    private Map<String, Integer> ageCache = new HashMap<>();

    public Integer getAge(String name) {
        readLock.lock();
        try {
            return ageCache.get(name);
        } finally {
            readLock.unlock();
        }
    }

    public void setAge(String name, Integer age) {
        writeLock.lock();

        try {
            ageCache.put(name, age);
        } finally {
            writeLock.unlock();
        }
    }
}
