package study.chapter05;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter05
 * @data 2020/4/26 16:09
 */
public class RunnableDemo implements Runnable {
    /*通过Runnable接口实现线程主体定义
    * 再由 Thread构造方法实现线程启动
    * */

    @Override
    public void run() {
        System.out.println("Runnable");
    }
}
