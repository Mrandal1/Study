package study.chapter07.timertaskdemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter07.timertaskdemo
 * @data 2020/4/30 20:18
 */
public class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"、当前任务时间"+System.currentTimeMillis()+"\n"+new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date()));
    }
}
