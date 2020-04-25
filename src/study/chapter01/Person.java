package study.chapter01;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter01
 * @data 2020/4/23 20:14
 */
public class Person {
    private String name;
    private int age;
    private Sex sex;

    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name  +
                ", age=" + age +
                ", sex=" + sex +
                '}';//这里写sex.toString()或sex效果一致 直接引用类会调用toString()输出
    }
}
