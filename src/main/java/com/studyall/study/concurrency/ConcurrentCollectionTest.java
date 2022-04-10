package com.studyall.study.concurrency;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConcurrentCollectionTest {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap(200000);
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList();
        CopyOnWriteArraySet<Integer> set = new CopyOnWriteArraySet();


        // map, list, set 에 값 세팅
        for (int i=0; i<100000; i++) {
            map.put("key" + i, String.valueOf(i));
            list.add(i);
            set.add(i);
        }

        // 맵에 대한 ConcurrentModificationException 확인
        Thread mapWriteThread = new Thread(() -> {

            for (int i=0; i<1000; i++) {
                map.remove("key" + i);
            }
        });

        Thread mapReadThread = new Thread(() -> {
            Set<Map.Entry<String, String>> entries = map.entrySet();

            for (Map.Entry<String, String> entry : entries) {
                System.out.println("map " + entry);
            }
        });


        // list 에 대한 ConcurrentModificationException 확인
        Thread listWriteThread = new Thread(() -> {
            for (int i=0; i<1000; i++) {
                list.remove(0);
            }
        });

        Thread listReadThread = new Thread(() -> {
           for (int i=0; i<1000; i++) {
               System.out.println("list " + i + " = " + list.get(i));
           }
        });

//        mapReadThread.start();
//        mapWriteThread.start();
        listReadThread.start();
        listWriteThread.start();

//        mapReadThread.join();
//        mapWriteThread.join();
        listReadThread.join();
        listWriteThread.join();

    }
}
