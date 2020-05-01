package study.chapter08.comparatordemo;

import java.util.Arrays;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter08
 * @data 2020/5/1 11:57
 */
public class ComparatorDemo {
    public static void main(String[] args) {
        /*
         *
         * Comparator主要用于解决一些 没有实现Comparable接口定义 排序的类的对象数组排序
         *
         * Arrays中基于Comparator的排序方法
         *      public static <T> void sort(T[] a, Comparator<? super T> c)
         *
         *  Comparator中的方法
         *   int compare(T o1, T o2);
         *
         * Comparable与Comparator的区别？
         * 1   java.lang.Comparable是类定义时候实现的父接口，主要用于定义排序规则，接口中只有一个CompareTo方法
         * 2   java.util.comparator 是用于设置独立排序规则的接口，需要单独的排序规则类 ，里面有Compare()方法
         *
         *
         *
         * */
        Person[] data = new Person[]{
                new Person("张三", 20),
                new Person("李四", 40),
                new Person("王五", 30)
        };

        /*使用外部定义的排序规则*/
        Arrays.sort(data, new PersonComparator());
        for (Person p : data) {
            System.out.println(p);
        }

    }
}
