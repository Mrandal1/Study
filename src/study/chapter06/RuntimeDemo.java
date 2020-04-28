package study.chapter06;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter06
 * @data 2020/4/28 13:41
 */
public class RuntimeDemo {
    public static void main(String[] args) {
        /*
         * Runtime 类描述的是系统运行时的状态
         * 在JVM中 Runtime 类是唯一一个与JVM运行状态有关的类，并且默认提供一个该类的实例化对象
         * 由于在每一个JVM进程中只允许有一个Runtime类的对象，因此此类采用单例设计模式，构造方法为私有
         *  private Runtime() {}
         *
         * 1 获取实例化对象
         *  public static Runtime getRuntime()
         * 2 获取可用进程数(CPU内核数)
         *  public static Runtime getRuntime()
         * 3 获取最大可用内存空间(默认为本机内存的1/4)
         *  public native long maxMemory();
         * 4 获取可用内存空间(默认为本机内存的1/64)
         *  public native long totalMemory();
         * 5 获取空闲内存空间
         *  public native long freeMemory();
         * 6 手工进行GC处理
         *  public native void gc();
         *
         *
         *
         *
         *
         *
         *
         *
         *
         * */

        /*测试Runtime方法*/
        Runtime runtime = Runtime.getRuntime();
        System.out.println("获取可用进程数 " + runtime.availableProcessors());
        System.out.println("1.MAX_MEMORY "+ runtime.maxMemory());
        System.out.println("2.TOTAL_MEMORY "+ runtime.totalMemory());
        System.out.println("3.FREE_MEMORY "+ runtime.freeMemory());
    }
}
