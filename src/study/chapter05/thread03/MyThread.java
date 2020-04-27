package study.chapter05.thread03;

import java.util.concurrent.Callable;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter05.thread03
 * @data 2020/4/27 17:25
 */
public class MyThread implements Callable<String> {
    private boolean flag = false;

    @Override
    public String call() throws Exception {
        synchronized (this) {
            if (!this.flag) {
                this.flag = true;
                return Thread.currentThread().getName() + "抢答成功";

            } else {
                return Thread.currentThread().getName() + "抢答失败";
            }

        }
    }
}