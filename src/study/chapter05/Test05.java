package study.chapter05;

import java.util.concurrent.FutureTask;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter05
 * @data 2020/4/25 17:51
 */
public class Test05 {
    public static boolean flag=true;
    public static void main(String[] args) throws Exception {
        /* 启动线程
         * 启动顺序不可控
         * 每一个线程类对象只允许启动一次，如果重复启动，会抛出异常  IllegalThreadStateException();
         *
         *  class Thread implements Runnable
         *  thread实现的就是Runnable的run()；
         *
         *
         *  public void run() {
         *      if (target != null) {
         *        target.run();
         *    }
         * }
         * 多线程设计中，使用了代理设计模式的结构，用户定义线程主体是核心功能的实现，而其他辅助功能就交由Thread去处理
         * 当Thread构造方法传入Runnable接口对象时，该对象由Thread 的target属性保存 ，
         * 在start方法执行时就会调用Thread中的run方法，run方法再调用target对象被覆写的run方法。
         *
         *
         * Thread线程提供有可以为线程命名的构造方法
         *      public Thread(ThreadGroup group, String name)
         * 1设置线程名称的方法
         *       public final synchronized void setName(String name)
         * 2取得线程名称的方法(若没有命名就会返回自动编号threadInitNumber)
         *        public final String getName()
         * 3取得当前线程
         *        public static native Thread currentThread()
         *
         * 在主方法直接调用线程run方法会返回“main”,说明主方法也是一个线程
         * 可以由某个线程（如main方法）创建子线程，形成主次关系
         * 一般可以有主线程执行整体流程，由子线程执行耗时操作。
         *
         *
         * Thread线程提供有线程休眠的方法
         * 1.传入毫秒级休眠时间
         * public static native void sleep(long millis) throws InterruptedException
         * 2.传入毫秒+纳秒级休眠时间
         * public static void sleep(long millis, int nanos) throws InterruptedException
         * 休眠操作可能会产生中断异常InterruptedException，且由于其实Exception的子类，所以必须处理
         *
         * Thread中线程中断相关方法
         * 1判断线程是否被中断
         * public boolean isInterrupted()
         * 2中断线程执行
         * public void interrupt()
         *
         * 线程的强制执行
         * public final void join() throws InterruptedException
         *
         * 线程的礼让
         * public static native void yield();
         *
         * 线程优先级相关
         * 1 设置线程优先级
         * public final void setPriority(int newPriority)
         * 2 取得优先级
         * public final int getPriority()
         * 3 线程最高优先级
         * public final static int MAX_PRIORITY = 10;
         * 4 线程最低优先级
         * public final static int MIN_PRIORITY = 1;
         * 5线程默认优先级（主线程优先级为5）
         * public final static int NORM_PRIORITY = 5;
         *
         * 线程的同步
         * 使用 synchronized 关键字 注明操作只能单个线程操作 实现安全同步
         * 1一般要进行同步对象处理可以通过当前对象 this 进行同步
         * 2利用同步方法解决，在方法定义上使用 synchronized 关键字
         * 同步会造成性能损失
         *
         * 线程死锁问题 若干线程面对统一资源互相等待且无法进行解决的情况
         * 过多的同步操作将导致死锁问题出现
         *
         * 解决生产者与消费者的问题可以通过等待与唤醒机制
         * 1 等待机制
         * 未设置等待时间即一直为等待状态
         * public final void wait() throws InterruptedException
         * 设置了等待时间
         * public final void wait(long timeout, int nanos) throws InterruptedException
         * 2 唤醒机制
         * 唤醒第一个等待线程
         * public final native void notify();
         * 唤醒全部等待线程
         * public final native void notifyAll();
         *
         * 守护线程方法
         * 设置为守护线程
         *  public final void setDaemon(boolean on)
         * 判断对象是否为守护线程
         *  public final boolean isDaemon()
         * 守护线程依赖用户线程，当程序执行完毕，守护线程就消失
         * JVM中最大的守护线程就是GC处理
         * 程序执行中 GC一直存在，程序执行完毕，GC结束
         *
         *
         * volatile主要用于修饰属性  表示直接操作
         * 一般变量处理的步骤
         * 1 获取变量原有的数值内容副本
         * 2 利用副本为变量进行数学计算
         * 3 取计算后的结果保存到原始变量内存空间中
         *
         * 被volatile修饰的变量的处理步骤
         * 直接拿变量进行操作，节约了拷贝读出与内存写入的消耗
         *
         * volatile 与 synchronized 的区别？
         * volatile 主要在属性上使用，而 synchronized 主要在代码块与方法上使用
         * volatile 无法描述同步处理，只是声明对属性内存的直接处理，而synchronized用于同步
         *
         *
         *
         * */


        new ThreadDemo("A").start();
        new ThreadDemo("B").start();
        new ThreadDemo("C").start();

        /*
         * 传入构造，再由Thread启动
         * */
        new Thread(new RunnableDemo()).start();
        /*
         * 简化形式 通过lambda实现接口并启动
         * */
        new Thread(() -> System.out.println("Runnable-lambda")).start();

        /*通过Callable接口实现call方法 ,实现有返回值的线程调用 通过get()返回结果
         *
         * public class FutureTask<V> implements RunnableFuture<V>
         * public interface RunnableFuture<V> extends Runnable, Future<V>
         * FutureTask类进行溯源分析可以得到对Runnable的继承
         *
         * */
        FutureTask<String> task = new FutureTask<>(new CallableDemo());
        new Thread(task).start();
        System.out.println(task.get());


        /*测试线程命名*/
        new Thread(() -> System.out.println("当前线程" + Thread.currentThread().getName()), "线程A").start();
        new Thread(() -> System.out.println("当前线程" + Thread.currentThread().getName())).start();
        new Thread(() -> System.out.println("当前线程" + Thread.currentThread().getName()), "线程C").start();

        /*测试线程休眠*/
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + i);
                try {
                    /*休眠1000毫秒*/
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "测试休眠线程").start();

        /*测试线程中断*/
        Thread interruptThread = new Thread(() -> {
            System.out.println("准备线程休眠");
            try {
                Thread.sleep(10000);
                System.out.println("休眠完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        interruptThread.start();
        Thread.sleep(1000);
        if (!interruptThread.isInterrupted()) {
            interruptThread.interrupt();
        }
        /*测试线程停止*/

        new Thread(()->{
            long num=0;
            while (flag){
                System.out.println(Thread.currentThread().getName()+"num="+num++);
            }
        },"执行线程").start();
        Thread.sleep(10);
        flag=false;

    }
}
