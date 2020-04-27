package study.chapter05;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter05
 * @data 2020/4/27 13:04
 */
public class Test0501 {
    public static void main(String[] args) {
        /*测试主线程优先级*/
        System.out.println("主线程优先级" + Thread.currentThread().getPriority());

        /*定义一个售票测试线程*/
        Runnable th = new Runnable() {
            /*定义有十张票*/
            private int ticket = 10;
            /*利用同步方法实现的形式*/
            /*public synchronized void sale(){
                if (this.ticket > 0) {
                    try {
                        *//*模拟网络延迟*//*
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖票" + this.ticket--);
                } else {
                    System.out.println("没有票了");
                    break;
                }
            }*/
            @Override
            public void run() {
                while (true) {
                    /*实现同步操作 每次只允许一个线程访问*/
                    synchronized (this) {
                        if (this.ticket > 0) {
                            try {
                                /*模拟网络延迟*/
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(Thread.currentThread().getName() + "卖票" + this.ticket--);
                        } else {
                            System.out.println("没有票了");
                            break;
                        }
                    }
                    /*this.sale();*/
                }
            }
        };
        /*测试线程同步*/
        new Thread(th, "售票处A").start();
        new Thread(th, "售票处B").start();
        new Thread(th, "售票处C").start();

        /*测试消费者与生产者模型*/
        Message msg=new Message();
        new Thread(new Producer(msg)).start();
        new Thread(new Consumer(msg)).start();




    }
}
