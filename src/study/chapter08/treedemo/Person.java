package study.chapter08.treedemo;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter08.treedemo
 * @data 2020/5/1 12:51
 */
public class Person implements Comparable<Person> {
    private String name;
    private int age;

    @Override
    public int compareTo(Person o) {
        return this.getAge() - o.getAge();
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
