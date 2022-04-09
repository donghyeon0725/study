package com.studyall.study.jmc;

import java.util.ArrayList;
import java.util.List;

public class JMCTestApplication {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        while (true) {

            for (int i=0; i<1000; i++) {
                list.add(i);
                System.out.println(i + " 번");
            }

            JMCTestApplication jmcTestApplication = new JMCTestApplication();
            jmcTestApplication = null;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
