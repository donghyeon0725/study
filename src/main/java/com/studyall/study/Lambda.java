package com.studyall.study;

import java.util.function.*;

public class Lambda {
    @FunctionalInterface
    interface Functional {
        int operation(int a, int b);
    }

    public static void main(String[] args) {
        /**
         * 람다는 함수형 인터페이스를 구현할 때 사용할 수 있음
         * 이는 가독성 떨어지고 복잡한 익명 클래스를 대체할 수 있기 때문에 의의가 있음
         * */
        Functional lambda = (a, b) -> a + b;

        /**
         * java.util.Function 클래스는 함수형 인터페이스의 구현체 형태를 정의할 때 사용할 수 있음
         * 함수형 인터페이스는 람다로 표현 가능하기에 의미가 있는데, 이런 람다의 형태를 정의할 수 있음
         * 그리고
         * */

        // 특정 값을 받아서 조건을 만족하는지 검사
        Predicate<Integer> predicate = (intParam) -> intParam > 10;
        Supplier<Integer> supplier = () -> null;
        Consumer<Integer> consumer = (param) -> {};
        Function<Integer, Integer> function = (param) -> null;
        UnaryOperator<Integer> unaryOperator = (param) -> param;
        BinaryOperator<Integer> binaryOperator = (a, b) -> a + b;


        Predicate<Integer> predicate1 = (a) -> a > 10;
        Predicate<Integer> predicate2 = (a) -> a < 100;


        // 논리연산자를 사용하는 것 처럼 조건을 걸 수도 있음
        int target = 20;
        System.out.println(predicate1.and(predicate2).test(target));


    }
}
