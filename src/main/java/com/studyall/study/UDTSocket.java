package com.studyall.study;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class UDTSocket {
    public static void main(String[] args) throws SocketException, InterruptedException {
        Thread serverComputer = new Thread(() -> {
            try (
                    DatagramSocket server = new DatagramSocket(8080);
            ) {
                int bufferLength = 256;
                byte[] buffer = new byte[bufferLength];
                DatagramPacket packet = new DatagramPacket(buffer, bufferLength);

                while (true) {
                    System.out.println("server waiting for request");

                    server.receive(packet);

                    int dataLength = packet.getLength();
                    System.out.println("server received. data length = " + dataLength);

                    String data = new String(packet.getData(), 0, dataLength);
                    System.out.println("received data " + data);

                    if ("EXIT".equalsIgnoreCase(data)) {
                        System.out.println("stop datagram server");
                        break;
                    }
                }

                System.out.println("------------");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread clientComputer = new Thread(() -> {
            try (
                DatagramSocket client = new DatagramSocket();
            ){
                InetAddress address = InetAddress.getByName("localhost");
                String data = "hello world";
                byte[] buffer = data.getBytes(StandardCharsets.UTF_8);

                DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length, address, 8080);

                client.send(packet);

                System.out.println("send data");
                client.close();

                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        serverComputer.start();
        clientComputer.start();

        serverComputer.join();
        clientComputer.join();
    }
}
