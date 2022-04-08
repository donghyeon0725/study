package com.studyall.study.temp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDTServerSocket {
    public static void main(String[] args) {
        try (
            DatagramSocket server = new DatagramSocket(8080);
        ) {
            byte[] buffer = new byte[1024];

            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

            server.receive(packet);

            String string = new String(buffer, 0, packet.getLength());

            System.out.println(String.format("server received '%s'", string));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
