package com.studyall.study;

public class ThreadTest {
    public static void main(String[] args) {
//        daemonSample();
//        thisSyncLockTest();
//        resourceInstanceSyncLockTest();
        syncTest();
    }

    public static void syncTest() {
        Calculate calculate = new Calculate();
        int loop = 10000;

        Thread thread1 = new Thread(() -> {
            for (int i=0; i<loop; i++) {
                calculate.plus(1);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i=0; i<loop; i++) {
                calculate.plus(1);
            }
        });


        Thread thread3 = new Thread(() -> {
            for (int i=0; i<loop; i++) {
                calculate.plus(1);
            }
        });

        Thread thread4 = new Thread(() -> {
            for (int i=0; i<loop; i++) {
                calculate.plus(1);
            }
        });

        Thread thread5 = new Thread(() -> {
            for (int i=0; i<loop; i++) {
                calculate.plus(1);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();

            System.out.println(calculate.getAmount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void classLock() {
        Sync object1 = new Sync("sync1");
        Sync object2 = new Sync("sync2");
        Thread thread1 = new Thread(() -> {
            object1.executeClassLock("name1");
        });

        Thread thread2 = new Thread(() -> {
            object1.executeClassLock("name2");
        });

        Thread thread3 = new Thread(() -> {
            object2.executeClassLock("name3");
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static void resourceInstanceSyncLockTest() {
        Sync object = new Sync("sync1");
        Thread thread1 = new Thread(() -> {
            object.executeResourceInstanceLock("name1");
        });

        Thread thread2 = new Thread(() -> {
            object.executeResourceInstanceLock("name2");
        });

        Thread thread3 = new Thread(() -> {
            new Sync("sync2").executeResourceInstanceLock("name3");
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static void thisSyncLockTest() {
        Sync object = new Sync("sync");
        Thread thread1 = new Thread(() -> {
            object.executeInstanceLock("name1");
        });

        Thread thread2 = new Thread(() -> {
            object.executeInstanceLock("name2");
        });

        thread1.start();
        thread2.start();
    }

    public static void daemonSample() {
        Thread daemon = new Thread(() -> {
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        daemon.setDaemon(true);

        daemon.start();
    }

    public static void threadSample() {
        Thread thread = new Thread(() -> {
            System.out.println("스레드 입니다 하핳핳");
        });

        System.out.println(thread.getId());

        System.out.println(thread.getPriority());

        System.out.println(thread.isDaemon());

        System.out.println(thread.isAlive());

        thread.setDaemon(true);

        System.out.println(thread.isDaemon());


        StackTraceElement[] stackTrace = thread.getStackTrace();

        for (StackTraceElement element : stackTrace) {
            System.out.println(element.toString());
        }

        System.out.println(thread.getState());
    }
}
