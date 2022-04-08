package com.studyall.study.temp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class NIOTest {
    public static void main(String[] args) throws Exception {
        NIOTest test = new NIOTest();

        test.writeFile("nio.txt", "read buffer");
        test.readFile("nio.txt");
    }

    public void writeFile(String fileName, String data) throws Exception {
        FileChannel channel = new FileOutputStream(fileName).getChannel();

        ByteBuffer buffer = ByteBuffer.wrap(data.getBytes(StandardCharsets.UTF_8));
        channel.write(buffer);

        channel.close();
    }


    public void readFile(String fileName) throws Exception {
        FileChannel channel = new FileInputStream(fileName).getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);


        buffer.flip();

        while (buffer.hasRemaining()) {
            System.out.print((char) buffer.get());
        }

        channel.close();
    }

}
