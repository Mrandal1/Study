package study.chapter11;


import java.util.*;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter11
 * @data 2020/5/6 17:07
 */
public class IteratorDemo {
    public static void main(String[] args) {
        /*
         * 一般集合操作有四种输出形式：
         *               1 Iterator 迭代输出      【最主要】 实现由前向后输出
         *               2 ListIterator 双向迭代输出  专属于List子类 其他接口类无法获取
         *               3 Enumeration 枚举输出      只为了Vector类服务
         *               4 foreach 输出
         *        Collection子类获取迭代器方法  Iterator<E> iterator();
         *
         *        Iterator接口中方法：
         *                      1  判断是否有数据 boolean hasNext();
         *                      2  获取当前数据 E next();
         *                      3  删除 default void remove()
         *          可以看出 Scanner类就是实现了Iterator接口
         *
         *          ListIterator接口中主要方法：
         *                      1 判断是否有前一个元素 boolean hasPrevious(); 【首先迭代器需要迭代到队尾】
         *                      2 返回前一个元素  E previous();
         *
         *
         *          Enumeration接口中主要方法：
         *                      1 判断是否由下一个元素   boolean hasMoreElements();
         *                      2 获取当前数据    E nextElement();
         *
         *
         * Collection中的remove()与Iterator中的remove()的区别？
         * 1 在进行迭代输出时若使用Collection.remove()会造成并发更新的异常 ConcurrentModificationException
         *      因此如果要进行删除，要使用Iterator的remove();
         *
         * */

        /*使用迭代器*/
        Set<String> strings = Set.of("A", "B", "2", "D");
        /*实例化Iterator*/
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
        System.out.println("\n");


        Set<String> hashSet = new HashSet<>();
        hashSet.add("A");
        hashSet.add("M");
        hashSet.add("F");
        hashSet.add("S");
        hashSet.add("B");
        Iterator<String> iterator1 = hashSet.iterator();
        /*错误的使用*/
        while (iterator1.hasNext()) {
            if ("A".equals(iterator1.next())) {
                hashSet.remove("A");
                /*iterator1.remove();*/
            } else {
                System.out.print(iterator1.next());
            }

        }
        System.out.println("\n");

        /*使用ListIterator*/
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        ListIterator<String> listIterator = list.listIterator();
        /*由前向后输出*/
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + "、");
        }
        System.out.println("\n");
        /*由后向前输出     迭代器必须先迭代到队尾才能判断前一个元素*/
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + "、");
        }

        System.out.println("\n");

        /*获取Enumeration*/
        Vector<String> vec = new Vector<>();
        vec.add("B");
        vec.add("A");
        vec.add("D");
        vec.add("A");
        Enumeration<String> enu = vec.elements();
        while (enu.hasMoreElements()) {
            System.out.println(enu.nextElement());
        }

        System.out.println("\n");

        /*使用通用的foreach输出元素*/
        for (String i : vec) {
            System.out.print(i + "、");
        }

    }
}
