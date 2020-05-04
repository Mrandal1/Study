package study.chapter10;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter10
 * @data 2020/5/3 21:13
 */
public class Person extends AbsPerson implements Runnable, Cloneable {
    private String name;
    private int age;
    public int pubint;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    private void absMethod(){}
    private Person(String name){}
    public Person(String str, int age) {
        this.name=str;
        this.age=age;
    }

    public Person() {
        System.out.println("无参构造执行了！");
    }

    @Override
    public void run() {
        System.out.println("接口Runnable");
    }

    @Override
    void go() {
        System.out.println("父类AbsPerson");
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
