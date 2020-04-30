package study.chapter07.optionaldemo;

import java.util.Optional;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter07
 * @data 2020/4/30 12:42
 */
public class OptionalDemo {
    public static void main(String[] args) {
        /*
         * Optional 类的主要功能是进行 null 的相关处理
         *           public final class Optional<T>
         *
         * 常用方法
         * 1返回空数据
         *  public static<T> Optional<T> empty()
         *
         * 2获取数据
         *  public T get()
         *
         * 3保存数据，但不允许空  （若保存数据为空，抛出空指针异常）
         *  public static <T> Optional<T> of(T value)
         *
         * 4保存数据，允许为空
         *   public static <T> Optional<T> ofNullable(T value)
         *
         * 5获取数据 空时返回其他数据
         *    public T orElse(T other)
         *
         *
         *
         * */

        /*of方法（不允许空）封装后再通过get()获取对象*/
        IMessage msgA = MessageUtil.getMessageA().get();

        /*ofNullable方法（允许空）封装     若返回空对象 再由get()获取对象会  抛出异常
         * Exception in thread "main" java.util.NoSuchElementException: No value present
         *
         * 此时 可以使用 orElse 判断  若空则可以返回指定对象
         * */
        //IMessage msgB = MessageUtil.getMessageB().get();
        IMessage msgB = MessageUtil.getMessageB().orElse(new MessageImpl());

        MessageUtil.useMessage(msgA);
        MessageUtil.useMessage(msgB);

    }
}
