package com.studyall.study;

import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientSocket {
    public static void main(String[] args) {
        // 잠시 휴식
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("create request");
        try (
                Socket request = new Socket("localhost", 8080);
        ) {
            OutputStream outputStream = request.getOutputStream();

            String data = "hello world";
            outputStream.write(data.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
