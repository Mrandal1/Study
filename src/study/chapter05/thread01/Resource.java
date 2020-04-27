package study.chapter05.thread01;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter05.Thread01
 * @data 2020/4/27 15:55
 */
public class Resource {
    private int num = 0;
    /**
     * flag=true ,可以进行加操作
     * flag=false,可以进行减操作
     */
    private boolean flag = true;

    public synchronized void add() throws Exception {
        if (!this.flag) {
            super.wait();
        }
        Thread.sleep(100);
        this.num++;
        System.out.println("加运算" + Thread.currentThread().getName() + "num=" + num);
        this.flag = false;
        super.notifyAll();
    }

    public synchronized void sub() throws Exception {
        if (this.flag) {
            super.wait();
        }
        Thread.sleep(100);
        this.num--;
        System.out.println("减运算" + Thread.currentThread().getName() + "num=" + num);
        this.flag = true;
        super.notifyAll();
    }
}
