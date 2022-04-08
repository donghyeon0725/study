package com.studyall.study.temp;

import java.io.File;
import java.util.Date;

public class MakeDir {
    public static void main(String[] args) {
//        getFileInfo("/Users/kimdonghyeon/study/test/test1/test2");

//        createFile("/Users/kimdonghyeon/study/test/test1/test2", "Temp.txt");

//        checkParent("/Users/kimdonghyeon/study/test/test1/test2", "Temp.txt");
    }

    private static void checkParent(String path, String filename) {
        File file = new File(path, filename);

        System.out.println(file.getParent());
    }

    public static void createFile(String pathName, String fileName) {
        File file = new File(pathName, fileName);

        try {
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getFileInfo(String path) {
        File file = new File(path);

        file.mkdirs();


        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.isHidden());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.canExecute());
        System.out.println(new Date(file.lastModified()));
    }
}
