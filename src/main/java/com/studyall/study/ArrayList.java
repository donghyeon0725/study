package com.studyall.study;

import java.util.Arrays;

public class ArrayList {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};

        int i = Arrays.binarySearch(array, 6);
        System.out.println(array[i]);
    }
}
