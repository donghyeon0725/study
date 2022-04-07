package com.studyall.study;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        boolean findAnyElementBiggerThen5 = list.stream().anyMatch(a -> a > 5);
        boolean findAllBiggerThen5 = list.stream().allMatch(a -> a > 5);
        boolean findNoneMatch = list.stream().noneMatch(a -> a > 10);

        System.out.println(findAnyElementBiggerThen5);
        System.out.println(findAllBiggerThen5);
        System.out.println(findNoneMatch);

        Optional<Integer> first = list.stream().findFirst();
        Optional<Integer> any = list.stream().findAny();

        System.out.println(first.get());
        System.out.println(any.get());

        Optional<Integer> findMax = list.stream().reduce((a, b) -> Math.max(a, b));
        Optional<Integer> findSum = list.stream().reduce((element, sum) -> sum + element);

        System.out.println(findMax.get());
        System.out.println(findSum.get());


        String[][] namesArray = new String[][] {
            {"kim", "taeng"}, {"mad", "play"},
            {"kim", "mad"}, {"taeng", "play"}
        };

        Set<String> namesWithFlatMap = Arrays.stream(namesArray)
                .flatMap(innerArray -> Arrays.stream(innerArray))
                .filter(name -> name.length() > 3) // 2
                .collect(Collectors.toSet());

        // 2차원 배열 선언 생략
        Set<String> namesWithMap = Arrays.stream(namesArray)
                .map(innerArray -> Arrays.stream(innerArray)
                        .filter(name -> name.length() > 3)
                        .collect(Collectors.toSet()))
                .collect(HashSet::new, Set::addAll, Set::addAll);


    }
}
