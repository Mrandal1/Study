package study.chapter10;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter10
 * @data 2020/5/4 18:27
 */
public class UnsafeDemo {
    public static void main(String[] args) throws Exception {
        /*
         * private Unsafe() {}
         * private static final Unsafe theUnsafe = new Unsafe();
         *  Unsafe类中本来没有提供静态方法，无法使用传统方法获得实例 只能通过反射机制获取 后来提供了getUnsafe()来处理。
         *
         *  利用Unsafe类可以绕过JVM的管理，可以在没有实例化对象的情况下获取实例类中处理内容
         *
         *
         *
         *
         *
         * */

        /*通过反射获取成员实现实例化*/
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        /*不用传入对象 但要设置为可访问接触封装*/
        field.setAccessible(true);
        Unsafe unsafe1 = (Unsafe) field.get(null);
        /*直接调用静态方法获取*/
        Unsafe unsafe2 = Unsafe.getUnsafe();
    }

}
