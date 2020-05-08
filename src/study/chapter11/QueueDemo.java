package study.chapter11;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter11
 * @data 2020/5/8 15:51
 */
public class QueueDemo {
    public static void main(String[] args) {
        /*
         * java队列定义 public interface Queue<E> extends Collection<E>
         *           向队列增加数据      boolean offer(E e);  也可以使用子接口的add
         *           从队列取出数据并删除数据     E poll();
         *
         *
         *      优先级队列 public class PriorityQueue<E> extends AbstractQueue<E> implements java.io.Serializable(排序功能)
         *
         *
         * */
        Queue<String> queue = new LinkedList<>();
        queue.add("one");
        queue.offer("two");
        queue.offer("THREE");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        /*null*/
        System.out.println(queue.poll());

        System.out.println("------------------");
        Queue<Integer> pq=new PriorityQueue<>();
        pq.add(4);
        pq.offer(3);
        pq.offer(1);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());


    }
}
