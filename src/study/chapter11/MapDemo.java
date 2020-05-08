package study.chapter11;

import java.util.*;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter11
 * @data 2020/5/8 12:54
 */
public class MapDemo {
    public static void main(String[] args) {
        /*
         * Map接口  public interface Map<K, V> 一般用于Key的查找
         *           核心操作方法
         *               1 向集合之中保存数据     V put(K key, V value);
         *               2 获取数据              V get(Object key);
         *               3 将Map集合转为Set集合   Set<Map.Entry<K, V>> entrySet();
         *               4 查询指定key是或存在    boolean containsKey(Object key);
         *               5 将Map集合中的Key转为Set集合   Set<K> keySet();
         *               6 根据Key删除元素             V remove(Object key);
         *
         *         1 hashMap 集合 无序存储  且k 或 v可以存储空或重复 查找时会进行内容的替换
         *                              public class HashMap<K,V> extends AbstractMap<K,V>
         *                                       implements Map<K,V>, Cloneable, Serializable
         *                      设置了相同的Key时，使用Put会返回原始的数据内容
         *                  无参构造    默认指定了容量率  容量*阈值=16*0.75=12 会提供一个容量为12的Map
         *              public HashMap() { this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted}
         *
         *                  hashMap是如何使用put()扩充的？
         *                  1   在hashMap中定义了常量 初始化默认容量16个元素；
         *                                   static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;（表示为2的幂 16）
         *                  2 当定义的元素超过了阈值（负载率）（static final float DEFAULT_LOAD_FACTOR = 0.75f;）相当于达到容量*阈值=12后会进行扩充；
         *                  3 在进行扩充的时候，hashMap采用成倍的扩充模式 每次*2
         *                  HashMap的工作原理
         *                  1 利用Node类进行数据存储，即采用链表结构或二叉树结构
         *                  2 从JDK1.8 后为适应大数据，hashMap内部提供了一个常量 static final int TREEIFY_THRESHOLD = 8;
         *                      存储数据若为超过该阈值（8）则利用链表存储，超过后会将链表转为红黑树，利用红黑树性质保证海量数据查询性能；
         *
         *          2 LinkedHashMap 相比于HashMap的无序存储，LinkedHashMap基于链表  其保存的顺序即为增加的顺序
         *                  public class LinkedHashMap<K,V>  extends HashMap<K,V>  implements Map<K,V>
         *
         *          3 hashTable 与Vector、Enumeration同属于最原始的动态数组实现形式
         *              hashTable进行存储 k 或 V 都不允许为空
         *                  public class Hashtable<K,V> extends Dictionary<K,V>
                                            implements Map<K,V>, Cloneable, java.io.Serializable
         *
         *              HashMap和HashTable的区别？
         *              1 HashMap的方法属于异步操作，线程不安全；而HashTable同步方法，线程安全
         *              2 HashMap允许设置空K 或 V      hashTable进行存储 k 或 V 都不允许为空
         *
         *
         *              Map类型数据都存储于Map.entry接口中 interface Entry<K, V>
         *                      操作方法 1 获取Key        K getKey();
         *                              2 获取Value      V getValue();
         *                   Map.entry用于Map键值对的包装处理
         *                  创建Map.entry对象     static <K, V> Entry<K, V> entry(K k, V v)
         *
         *
         *          Map中没有直接提供iterator实例化方法，而是提供了转换操作
         *              1     Set<Map.Entry<K, V>> entrySet();
         *              2 利用Set的iterator将Set转为Iterator
         *
         *
         *
         *              如果在使用HashMap是产生了hash冲突，hashMap是如何解决的
         *                   在冲突的位置上将所有Hash冲突的内容转为链表保存。
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         * */

        Map<Integer, String> map = Map.of(1, "A", 2, "B");
        System.out.println(map);
        System.out.println("-------------------");

        /*测试hashMap*/
        Map<Integer, String> hashMap = new HashMap<>(20);
        hashMap.put(1, "A");
        /*返回A*/
        System.out.println(hashMap.put(1, "B"));
        hashMap.put(2, null);
        hashMap.put(2, "K");
        /*返回null*/
        System.out.println(hashMap.put(null, "A"));
        hashMap.put(null, "D");
        /*B*/
        System.out.println(hashMap.get(1));
        /*D*/
        System.out.println(hashMap.get(null));
        /*K*/
        System.out.println(hashMap.get(2));

        System.out.println("-------------------");

        /*LinkedHashMap*/
        Map<String, Integer> linkedHashMap1 = new LinkedHashMap<>();
        linkedHashMap1.put("1", 10);
        linkedHashMap1.put("1", 20);
        linkedHashMap1.put("2", 10);
        linkedHashMap1.put("3", 20);
        linkedHashMap1.put("4", 30);
        System.out.println(linkedHashMap1);
        System.out.println("-------------------");

        /*HashTable*/
        Map<String, Integer> hashTable1 = new Hashtable<>();
        hashTable1.put("1", 10);
        hashTable1.put("1", 20);
        hashTable1.put("2", 10);
        hashTable1.put("3", 20);
        hashTable1.put("4", 30);
        System.out.println(hashTable1);
        System.out.println("-------------------");

        /* 创建Map.entry对象 */
        Map.Entry<String, Integer> entry = Map.entry("one", 1);
        System.out.println("获取Key  " + entry.getKey() + "  获取value  " + entry.getValue());
        System.out.println("-------------------");

        /*获取Iterator*/
        Map<String, Integer> newMap = new HashMap<>();
        newMap.put("ONE", 1);
        newMap.put("TWO", 2);
        newMap.put("THREE", 1);
        /*转换为Set*/
        Set<Map.Entry<String, Integer>> set = newMap.entrySet();
        /*获取Iterator*/
        Iterator<Map.Entry<String, Integer>> ite = set.iterator();
        /*迭代输出*/
       /* while (iterator.hasNext()) {
            Map.Entry<String, Integer> da=iterator.next();
            System.out.println("KEY: " + da.getKey() + " Value: " +da.getValue());
        }  */
        for (Map.Entry<String, Integer> da : set) {
            System.out.println("KEY: " + da.getKey() + " Value: " + da.getValue());
        }
        System.out.println("-------------------");

    }
}
