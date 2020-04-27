package study.chapter05;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter05
 * @data 2020/4/27 14:03
 */
public class Producer implements Runnable {
    private Message msg;

    public Producer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int x = 0; x < 100; x++) {
            if (x % 2 == 0) {
                this.msg.set("提供A","contentA");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                this.msg.set("提供B","contentB");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
