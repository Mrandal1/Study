package study.chapter11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter11
 * @data 2020/5/8 16:33
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        /*
         *
         * Collections是集合工具操作类
         *
         * */
        /*使用工具类简便操作*/
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "D","A", "B", "C");
        System.out.println(list);

        System.out.println("-------------");

        /*反转*/
        Collections.reverse(list);
        System.out.println(list);

        /*二分查找(先排序，再查找)*/
        Collections.sort(list);
        System.out.println(Collections.binarySearch(list, "A"));
    }

}
