package com.hong.springbootstudy12demo;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.zip.GZIPInputStream;

@Log4j2
@SpringBootTest
public class IOTest {

    @Test
    public void testFileInputStream() {

        try {

            FileInputStream fileInputStream = new FileInputStream("F:\\Java Project\\spring-boot-study-12-demo\\src\\main\\resources\\static\\example.txt");

            int data;

            while ((data = fileInputStream.read()) != -1) {
                System.out.print((char) data);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void testFileReader() {

        try {
            FileReader fileReader = new FileReader("F:\\Java Project\\spring-boot-study-12-demo\\src\\main\\resources\\static\\example.txt");

            int data;

            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void testPipedInputStream() {

        try {
            PipedInputStream pipedInputStream = new PipedInputStream();

            PipedOutputStream pipedOutputStream = new PipedOutputStream(pipedInputStream);

            // 另外一种方法
//            PipedOutputStream pipedOutputStream = new PipedOutputStream();
//            pipedOutputStream.connect(pipedInputStream);

            Thread writeThread = new Thread(() -> {

                try {
                    // 创建写线程
                    for (int i = 0; i < 5; i++) {
                        pipedOutputStream.write(("test:" + i + "\n").getBytes());
                        Thread.sleep(500);
                    }
                    pipedOutputStream.close();
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });

            Thread readThread = new Thread(() -> {

                int data;

                try {
                    while ((data = pipedInputStream.read()) != -1) {
                        System.out.print((char) data);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            });

            writeThread.start();
            readThread.start();

            writeThread.join();
            readThread.join();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void testByteArrayInputStream() {

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("hello world!".getBytes());

        int data;

        // reset，重新开始读
//        for (int i = 0; i < 10; i++) {
//            System.out.print((char) byteArrayInputStream.read());
//            byteArrayInputStream.reset();
//        }

        while ((data = byteArrayInputStream.read()) != -1) {
            System.out.print((char) data);
        }

        // 底层调用的read方法是native，C语言写的

    }

    @Test
    public void testPushBackInputStream() {

        try {
            FileInputStream fileInputStream = new FileInputStream("F:\\Java Project\\spring-boot-study-12-demo\\src\\main\\resources\\static\\example.txt");

            PushbackInputStream pushbackInputStream = new PushbackInputStream(fileInputStream);

            int data;

            while ((data = pushbackInputStream.read() ) != -1) {

                if ('e' == (char) data) {
                    System.out.println("scan e, continue");
                    // 这一步会无限循环
                    pushbackInputStream.unread(data);
                }

                System.out.println("read:" + data);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void testBufferedInputStreamReadLine() {

        try {

            FileReader fileReader = new FileReader("F:\\Java Project\\spring-boot-study-12-demo\\src\\main\\resources\\static\\example.txt");

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String print;

            while ((print = bufferedReader.readLine()) != null) {
                System.out.println(print);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
