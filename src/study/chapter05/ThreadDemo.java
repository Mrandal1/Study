package study.chapter05;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter05
 * @data 2020/4/26 15:38
 */

public class ThreadDemo extends Thread {
    /*继承thread类实现线程主体定义
    * class Thread implements Runnable
    * thread实现的就是Runnable的run()；
    * */

    private String title;

    public ThreadDemo(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        /*执行主体的操作*/
       for (int x=0;x<10;x++){
           System.out.println(this.title+"x:"+x);
       }
    }
}
