package study.chapter07.threadlocaldemo;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter07
 * @data 2020/4/30 14:05
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        /*启动三线程
         * 由于对Message方法的不同步 将导致 数据覆盖
         *
         * 在保持Channel核心结构保持不变的时候，需要考虑到每个线程的独立操作问题
         * 因此Channel类在保留要发送的消息之外，还应该存放有一个每一个线程的标记（当前线程），这个时候就可以利用 ThreadLocal 类 来存放数据
         * 此时ThreadLocal 相当于一个对象容器
         * public class ThreadLocal<T>
         *
         * 构造方法
         * 1 创建新对象
         * public ThreadLocal()
         *
         * 2 设置数据
         *  public void set(T value)
         *
         * 3 取出数据
         *  public T get()
         *
         * 4 删除数据
         * public void remove()
         *
         *
         * 通过ThreadLocal类的使用，将传入对象与线程进行绑定，使得线程运作时，不会产生混乱。
         *
         *
         *
         *
         *
         *
         *
         * */


        new Thread(() -> {
            Message msg = new Message();
            msg.setInfo("第一个线程");
            Channel.setMessage(msg);
            Channel.send();
        }, "消息发送者A").start();
        new Thread(() -> {
            Message msg = new Message();
            msg.setInfo("第二个线程");
            Channel.setMessage(msg);
            Channel.send();
        }, "消息发送者B").start();
        new Thread(() -> {
            Message msg = new Message();
            msg.setInfo("第三个线程");
            Channel.setMessage(msg);
            Channel.send();
        }, "消息发送者C").start();
    }

}
