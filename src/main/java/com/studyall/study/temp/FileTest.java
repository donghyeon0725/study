package com.studyall.study.temp;

import java.io.*;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
        int data = 0;

        if (!file.exists()) {
            file.createNewFile();
        }

        try (
            OutputStream out = new FileOutputStream(file);
        ) {
            while ((data = System.in.read()) != -1) {
                out.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
