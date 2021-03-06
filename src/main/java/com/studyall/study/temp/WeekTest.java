package com.studyall.study.temp;

import org.springframework.cglib.core.Local;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class WeekTest {
    public static void main(String[] args) {
//        printDayOfWeek();
        printMondayOfOtherLocale();
        Semaphore semaphore = new Semaphore(1, false);
        ConcurrentHashMap map = new ConcurrentHashMap();
    }

    public static void printDayOfWeek() {
        DayOfWeek[] dayOfWeeks = DayOfWeek.values();

        Locale locale = Locale.getDefault();

        for (DayOfWeek day : dayOfWeeks) {
            System.out.println(day.getDisplayName(TextStyle.FULL, locale));
            System.out.println(day.getDisplayName(TextStyle.SHORT, locale));
            System.out.println(day.getDisplayName(TextStyle.NARROW, locale));
        }
    }

    public static void printMondayOfOtherLocale() {
        DayOfWeek day = DayOfWeek.MONDAY;

        Locale[] locales = Locale.getAvailableLocales();

        for (Locale locale : locales) {
            System.out.println(day.getDisplayName(TextStyle.FULL, locale));
            System.out.println(day.getDisplayName(TextStyle.SHORT, locale));
            System.out.println(day.getDisplayName(TextStyle.NARROW, locale));
        }
    }
}
