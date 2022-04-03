package com.studyall.study;

import java.io.InputStream;
import java.net.Socket;

public class ServerSocket {
    public static void main(String[] args) {
        while (true) {
            try (
                    java.net.ServerSocket serverSocket = new java.net.ServerSocket(8080);
                    Socket socket = serverSocket.accept();
            ) {
                InputStream inputStream = socket.getInputStream();

                int data = 0;
                while ((data = inputStream.read()) != -1) {
                    System.out.print((char) data);
                }
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
