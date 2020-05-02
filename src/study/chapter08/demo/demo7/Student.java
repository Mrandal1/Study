package study.chapter08.demo.demo7;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter08.demo.demo7
 * @data 2020/5/2 14:00
 */
public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "学生信息{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if (this.score>o.score){
            return 1;
        }else if (this.score<o.score){
            return -1;
        }
        return this.age-o.age;
    }
}
