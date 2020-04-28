package study.chapter06.clonedemo;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter06.clonedemo
 * @data 2020/4/28 15:55
 */
public class Member implements Cloneable {
    private String name;
    private int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "[" + super.toString() + "]" + "name" + this.name + "age" + this.age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
