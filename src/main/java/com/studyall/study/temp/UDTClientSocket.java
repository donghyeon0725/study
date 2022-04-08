package com.studyall.study.temp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UDTClientSocket {

    public static void main(String[] args) {
        try (
            DatagramSocket client = new DatagramSocket();
        ) {
            InetAddress address = InetAddress.getByName("localhost");

            String data = "hello world";
            byte[] buffer = data.getBytes(StandardCharsets.UTF_8);

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 8080);

            client.send(packet);

            System.out.println("client send data");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
