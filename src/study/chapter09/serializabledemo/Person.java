package study.chapter09.serializabledemo;

import java.io.Serializable;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.serializabledemo
 * @data 2020/5/3 16:16
 */
public class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
