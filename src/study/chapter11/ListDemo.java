package study.chapter11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter11
 * @data 2020/5/5 20:14
 */
public class ListDemo {
    public static void main(String[] args) {
        /*
         * List接口        public interface List<E> extends Collection<E>
         *       List子接口实现了对Collection父接口的扩充
         *               1 获取指定索引上的数据    E get(int index);
         *               2 修改指定索引数据    E set(int index, E element);
         *               3 返回ListIterator接口对象   ListIterator<E> listIterator();
         *
         *               静态方法：of()
         *       List接口 特点：
         *                   1 其保存顺序就是存储顺序；
         *                   2 List集合中允许有重复数据；
         *
         *   常用List子类：1 ArrayList  2 Vector 3 LinkedList
         *               1 ArrayList public class ArrayList<E> extends AbstractList<E>
         *                                      implements List<E>, RandomAccess, Cloneable, java.io.Serializable
         *                   构造方法：
         *                           1 无参构造   public ArrayList()
         *                           2 有参构造   public ArrayList(int initialCapacity) 【定义了一个初始化容量】
         *                       JDK1.9之前使用无参构造初始化的集合使用的是默认容量为 10  的数组
         *                       JDK1.9之后使用无参构造初始化的集合使用的是空数组，当使用时才会开辟容量。默认开辟容量为 10
         *
         *               2  LinkedList      public class LinkedList<E> extends AbstractSequentialList<E>
         *                                            implements List<E>, Deque<E>, Cloneable, java.io.Serializable
         *
         *                     构造方法：
         *                              1 无参    public LinkedList()
         *
         *
         *              3 Vector    public class Vector<E>extends AbstractList<E>
         *                          implements List<E>, RandomAccess, Cloneable, java.io.Serializable【继承结构与ArrayList相同】
         *
         *                       构造方法：
         *                              1  public Vector() {      this(10);}
         *                      Vector中的操作方法都是线程安全的
         *
         *
         *
         *  ArrayList与LinkedList区别？
         * 1 ArrayList数组实现的集合操作，而LinkedList时链表实现的集合操作
         * 2 使用get()查询数据ArrayList的时间复杂度为O(1)，而LinkedList为O(n)
         * 3 JDK1.9之前ArrayList使用无参构造初始化的集合使用的是默认容量为 10  的数组 ，容量不足时成倍的扩充容量
         *
         *
         *
         * */
        /*使用List静态方法of()*/
        List<String> list = List.of("hello", "World", "!");
        System.out.println(list);

        /*使用 ArrayList实现List父接口*/
        List<String> arr = new ArrayList<>();
        arr.add("A");
        arr.add("A");
        arr.add("A");
        /*利用迭代器Foreach方法输出*/
        arr.forEach((str) -> System.out.print(str + "、"));

        /*测试ArrayList保存*/
        List<Person> peoples = new ArrayList<>();
        peoples.add(new Person("张三", 12));
        peoples.add(new Person("李四", 20));
        peoples.add(new Person("王五", 40));

        /*若想更好的实现 contains方法或remove方法 一定要覆写元素对象的equals方法*/
        System.out.println(peoples.contains(new Per("王五", 40)));
        peoples.forEach(System.out::println);


    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
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
        Person pera = (Person) obj;
        return this.name.equals(pera.name) && this.age == pera.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
