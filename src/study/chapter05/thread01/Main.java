package study.chapter05.thread01;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter05.Thread01
 * @data 2020/4/27 16:05
 */
public class Main {
    public static void main(String[] args) {
        Resource re=new Resource();
        Runnable addrun=new AddThread(re);
        Runnable subrun=new SubThread(re);
        new Thread(addrun,"加法线程A").start();
        new Thread(addrun,"加法线程B").start();
        new Thread(subrun,"减法线程X").start();
        new Thread(subrun,"减法线程Y").start();
    }


}
