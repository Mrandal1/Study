package study.chapter05.thread02;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter05.thread02
 * @data 2020/4/27 16:51
 */
public class Main {
    public static void main(String[] args) {
        Resource res = new Resource();
        Runnable runnableA = new Producer(res);
        Runnable runnableB = new Consumer(res);
        new Thread(runnableA, "生产者A").start();
        new Thread(runnableB, "消费者B").start();
    }


}
