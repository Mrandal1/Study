package study.chapter07.timertaskdemo;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter07
 * @data 2020/4/30 20:11
 */
public class TimerTaskDemo {
    public static void main(String[] args) {
        /*
         * 通过TimerTask实现简单定时调度
         * public abstract class TimerTask implements Runnable
         *
         *
         *
         * 通过Timer类进行任务的启动
         *  public class Timer
         *  启动方法
         *  1 延迟启动
         *   public void schedule(TimerTask task, long delay)
         *
         *  2 间隔触发
         *   public void scheduleAtFixedRate(TimerTask task, long delay, long period)
         *
         * */

        /*Timer timer = new Timer();
        timer.schedule(new MyTask(), 1000);*/

        /*定义周期任务  延迟0.1秒运行 间隔时间1秒*/
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new MyTask(),100,1000);

    }
}
