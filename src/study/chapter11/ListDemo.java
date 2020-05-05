package study.chapter11;

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
        *
        *
        *   常用List子类：1 ArrayList  2 Vector 3 LinkedList
        *
        *
        *
        * */
        /*使用List静态方法of()*/
        List<String> list=List.of("hello","World","!");
        System.out.println(list);
    }
}
