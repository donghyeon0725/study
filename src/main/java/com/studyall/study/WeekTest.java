package com.studyall.study;

import org.springframework.cglib.core.Local;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class WeekTest {
    public static void main(String[] args) {
        printDayOfWeek();
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
}
