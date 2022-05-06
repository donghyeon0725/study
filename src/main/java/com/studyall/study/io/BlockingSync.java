package com.studyall.study.io;

import java.util.Scanner;

public class BlockingSync {
    public static void main(String[] args) {
        System.out.print("출력하고 싶은 메세지를 입력해주세요 : ");
        final Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        System.out.println(message);
    }
}
