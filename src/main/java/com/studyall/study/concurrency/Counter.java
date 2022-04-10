package com.studyall.study.concurrency;

public class Counter {
    private int i = 0;

    public int increment() {
        return i = i + 1;
    }
    /**
     *     Code:
     *        0: aload_0
     *        1: aload_0
     *        2: getfield      #7                  // Field i:I
     *        5: iconst_1
     *        6: iadd
     *        7: dup_x1
     *        8: putfield      #7                  // Field i:I
     *       11: ireturn
     * */

    public int getI() {
        return i;
    }
}
