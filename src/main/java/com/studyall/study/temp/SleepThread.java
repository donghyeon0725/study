package com.studyall.study.temp;

public class SleepThread extends Thread {

    private long sleepSecond;

    public SleepThread(String name, long sleepSecond) {
        super(name);
        this.sleepSecond = sleepSecond;
    }

    @Override
    public void run() {
        try {
            System.out.println(super.getName() + " start sleep");
            Thread.sleep(sleepSecond);
            System.out.println(super.getName() + " end sleep");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
