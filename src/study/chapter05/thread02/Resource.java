package study.chapter05.thread02;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter05.thread02
 * @data 2020/4/27 16:41
 */
public class Resource {
    private Computer com;


    /**
     * 生产
     */
    public synchronized void make() throws Exception {
        if (this.com != null) {
            super.wait();
        }
        Thread.sleep(100);

        this.com = new Computer("XX牌电脑", 999.9);
        System.out.println("生产了电脑" +this.com.toString());
        super.notifyAll();

    }

    /**
     * 消费
     */
    public synchronized void get() throws Exception {
        if (this.com == null) {
            super.wait();
        }
        Thread.sleep(10);
        System.out.println("消费了电脑"+this.com.toString());
        this.com = null;
        super.notifyAll();

    }
}
