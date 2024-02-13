package com.hong.springbootstudy12demo.demos.web.test;

import com.hong.springbootstudy12demo.demos.web.entity.Person;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author hzuck7
 */
public class SerializableTest {

    /**
     * 测试序列化
     */
    @Test
    public void test() throws IOException {

        Person person = new Person();
        person.setAge(10);
        person.setName("hcl");


        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\hzuck7\\Desktop\\test.txt"))) {
            // output writeObject入参的对象必须实现序列化，否则序列化报错
            objectOutputStream.writeObject(person);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        try(ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(Paths.get("C:\\Users\\hzuck7\\Desktop\\test.txt")))) {
            // input readObject 对象必须实现序列化，否则反序列化报错
            Person input = (Person) objectInputStream.readObject();
            System.out.println(input);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }


}
