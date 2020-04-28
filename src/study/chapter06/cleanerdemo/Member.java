package study.chapter06.cleanerdemo;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter06.cleanerdemo
 * @data 2020/4/28 15:06
 */
public class Member implements Runnable{
    public Member() {
        System.out.println("构造方法");
    }


    @Override
    public void run() {
        /*执行清理操作*/
        System.out.println("回收");
    }
}
