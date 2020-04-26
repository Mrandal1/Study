package study.chapter05;

import java.util.concurrent.Callable;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter05
 * @data 2020/4/26 17:17
 */
public class CallableDemo implements Callable<String> {

    @Override
    public String call() throws Exception {
        for (int i=0;i<5;i++){
            System.out.println("X:"+i);
        }
        return "执行完毕！";
    }
}
