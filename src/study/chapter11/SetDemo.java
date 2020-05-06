package study.chapter11;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter11
 * @data 2020/5/6 15:25
 */
public class SetDemo {
    public static void main(String[] args) {
        /*
         * Set集合不允许保存重复元素
         *       public interface Set<E> extends Collection<E>
         *   Set集合像List集合那样扩充了许多新方法，所以在Set中无法获取指定索引的数据获取
         *
         *           HashSet是应用最多的子类  其保存的数据是无序的 其判断重复元素的方式是通过hashcode完成的
         *                                  对象编码：public native int hashCode();
         *                                  对象比较； public boolean equals(Object obj)
         *
         *           TreeSet保存的数据是有序的  参与排序的对象要实现Comparable接口 并且对象所有属性要参与比较匹配，否则只有某属性相同的两个对象也会被认定为相同元素
         *
         *
         *
         *
         *
         * */

        /*验证Set方法*/
        Set<Integer> set = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        /*有序输出*/
        set.forEach(temp -> System.out.print(temp + "、"));

        System.out.println("\n");

        /*验证HashSet*/
        Set<String> hashSet = new HashSet<>();
        hashSet.add("AD");
        hashSet.add("A");
        hashSet.add("BA");
        hashSet.add("BA");

        hashSet.forEach(temp -> System.out.print(temp + "、"));

        System.out.println("\n");

        /*验证TreeSet*/
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("A");
        treeSet.add("C");
        treeSet.add("B");
        treeSet.add("D");
        treeSet.forEach(temp -> System.out.print(temp + "、"));

        System.out.println("\n");

        /*验证自定义比较器*/
        Set<Per> pers = new TreeSet<>();
        pers.add(new Per("张三", 12));
        pers.add(new Per("张三", 13));
        pers.add(new Per("李四", 13));
        pers.add(new Per("王五", 15));
        pers.add(new Per("11", 12));
        pers.forEach(temp -> System.out.print(temp.toString() + "、"));


    }
}

class Per implements Comparable<Per> {
    private String name;
    private int age;

    public Per(String name, int age) {
        this.name = name;
        this.age = age;
    }

   /* @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Per)) {
            return false;
        }
        Per per = (Per) obj;
        return this.name.equals(per.name) && this.age == per.age;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Per per = (Per) o;
        return age == per.age &&
                Objects.equals(name, per.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Per o) {
        if (this.age > o.age) {
            return 1;
        } else if (this.age < o.age) {
            return -1;
        } else {
            return this.name.compareTo(o.name);
        }

    }
}

