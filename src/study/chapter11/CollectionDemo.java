package study.chapter11;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter11
 * @data 2020/5/5 18:36
 */
public class CollectionDemo {
    public static void main(String[] args) {
        /*
        *
        * java.util.Collection是单值集合操作的最大父接口
        *           public interface Collection<E> extends Iterable<E>
        *
        *               主要方法；
        *           1 向集合保存数据    boolean add(E e);
        *           2 追加一组数据      boolean addAll(Collection<? extends E> c);
        *           3 清空集合（让根节点为空，并GC ） void clear();
        *           4 查询数据是否存在   boolean contains(Object o);
        *           5 数据删除          boolean remove(Object o);
        *           6 获取数据长度       int size();
        *           7 将集合变为对象数组   Object[] toArray();
        *           8 将集合变为Iterator接口返回  Iterator<E> iterator();
        *
        *       Collection的子接口：允许重复的List    public interface List<E> extends Collection<E>
         *                          不允许重复的Set   public interface Set<E> extends Collection<E>
        *
        *
        *
        * */


    }
}