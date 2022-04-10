package com.studyall.study.thread;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;

public class DisruptorSample {
    public static void main(String[] args) {
        Disruptor<Integer> disruptor = new Disruptor<Integer>((EventFactory<Integer>) null, 100, (Executor) null);

        ArrayBlockingQueue queue = new ArrayBlockingQueue(1000);
    }
}
