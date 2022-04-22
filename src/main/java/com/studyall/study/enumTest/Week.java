package com.studyall.study.enumTest;


public enum Week {
    SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7);

    private int index;

    Week(int index) {
        this.index = index;
    }

    public static Week getWeek(int index) {
        for (Week week : Week.values()) {
            if (week.index == index) {
                return week;
            }
        }
        throw new RuntimeException("could not found week");
    }
}
