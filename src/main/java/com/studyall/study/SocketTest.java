package com.studyall.study;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketTest {
    public static void main(String[] args) throws IOException, InterruptedException {
//        Socket socket = new Socket();

        Thread server = new Thread(() -> {
            try (
                    ServerSocket serverSocket = new ServerSocket(8080);
                    Socket socket = serverSocket.accept();
            ) {
                InputStream inputStream = socket.getInputStream();

                int data = 0;
                while ((data = inputStream.read()) != -1) {
                    System.out.print((char) data);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        Thread client = new Thread(() -> {

            // 잠시 휴식
            try {
                Thread.sleep(11000);
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
        });


        server.start();
        client.start();


        server.join();
        client.join();
    }
}
