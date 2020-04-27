package study.chapter05;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter05
 * @data 2020/4/27 14:04
 */
public class Consumer implements Runnable{
    private Message msg;

    public Consumer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int x=0;x<100;x++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.msg.get());
        }
    }
}
