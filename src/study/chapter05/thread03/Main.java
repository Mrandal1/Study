package study.chapter05.thread03;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter05.thread03
 * @data 2020/4/27 17:32
 */
public class Main {
    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        FutureTask taskA=new FutureTask(myThread);
        FutureTask taskB=new FutureTask(myThread);
        FutureTask taskC=new FutureTask(myThread);
        new Thread(taskA,"抢答者A").start();
        new Thread(taskB,"抢答者B").start();
        new Thread(taskC,"抢答者C").start();
        try {
            System.out.println(taskA.get());
            System.out.println(taskB.get());
            System.out.println(taskC.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
