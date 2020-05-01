package study.chapter08.comparabledemo;

import java.util.Arrays;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter08
 * @data 2020/5/1 11:09
 */
public class comparable {
    public static void main(String[] args) {
        /*
         * Comparable接口 主要用于制定统一的比较规则
         *
         *
         *
         *
         *
         *
         *
         * */
        /*使用自定义的对象排序*/

        Person[] data = new Person[]{
                new Person("张三", 10),
                new Person("李四", 20),
                new Person("王五", 30)
        };
        Arrays.sort(data);
        for (Person p : data) {
            System.out.println(p);
        }

    }
}
