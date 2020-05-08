package study.chapter11;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter11
 * @data 2020/5/8 17:07
 */
public class StreamDemo {
    public static void main(String[] args) {
        /*
         *       再Collection中获取Stream接口对象        default Stream<E> stream()
         *           基础操作：
         *      对数据分页处理：1 设置取出的最大数据量  Stream<T> limit(long maxSize);
         *                    2 跳过指定数据量     Stream<T> skip(long n);
         *
         *
         * */

        /*通过Stream进行数据分析*/
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "AA", "AB", "AC", "BD","AF","FH","BD","BJ");
        /*获取stream对象*/
        Stream<String> stream = list.stream();
        /*输出元素个数*/
        System.out.println(stream.count());
        /*使用流分析操作  过滤符合条件的选项  并进行下一步操作*/
        Stream<String> stream1 = list.stream();
        System.out.println(stream1.filter((ele) -> ele.toLowerCase().contains("b")).count());
        /*将结果数据收集到一个List结构中*/
        Stream<String> stream2 = list.stream();
        List<String> result = stream2.filter((ele) -> ele.toLowerCase().contains("b")).collect(Collectors.toList());
        /*stream2.filter((ele) -> ele.toLowerCase().contains("b")).collect(Collectors.toCollection(TreeSet::new));*/
        System.out.println(result);

        /*对数据分页处理  跳过两个 取出两个*/
        Stream<String> stream3 = list.stream();
        List<String> result2 = stream3.filter((ele) -> ele.toLowerCase().contains("b")).skip(2).limit(2).collect(Collectors.toList());
        System.out.println(result2);
    }
}
