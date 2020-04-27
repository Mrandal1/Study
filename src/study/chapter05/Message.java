package study.chapter05;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter05
 * @data 2020/4/27 14:00
 */

public class Message {
    /*实现消费者与生产者资源的管理*/

    private String title;
    private String content;
    /**
     * flag=true ,允许生产，不允许消费
     * flag=false,允许消费，不允许生产
     */
    private boolean flag;

    public synchronized void set(String title, String content) {
        if (!this.flag) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.title = title;
        this.content = content;
        this.flag = false;
        super.notify();
    }

    public synchronized String get() {
        if (this.flag) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            return this.title + this.content;
        } finally {
            this.flag=true;
            super.notify();
        }
    }


}
