package study.chapter06;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter06
 * @data 2020/4/27 18:27
 */
public class Test06 {
    public static void main(String[] args) {
        /*
         *
         * StringBuffer类常用方法
         *
         * 构造方法
         * public StringBuffer()
         * public StringBuffer(String str)
         *
         * 支持传入各种数据类型的参数
         * public synchronized StringBuffer append(String str)
         *
         * 一般字符串连接的 "+" 与 StringBuffer 的 append 是一样的形式
         * "+" 经过编译通过 append 实现拼接
         *
         * 灵活得增加数据
         *  public synchronized StringBuffer insert(int offset, String str)
         *
         * 删除指定范围数据
         *  public synchronized StringBuffer delete(int start, int end)
         *  public synchronized StringBuffer deleteCharAt(int index)
         *
         * 字符反转
         *  public synchronized StringBuffer reverse()
         *
         * 与 StringBuffer(JDK1.0)类 类似的工具类还有 StringBuilder(JDK1.5),所提供的方法与 StringBuffer 相同
         * 两者的不同点在于 StringBuffer 中的方法是线程安全的，有 synchronized 修饰
         *
         * 问：String 、StringBuffer 、 StringBuilder 类的区别？
         * 1、String类是字符串的首选类型，其最大的特点是内容不可修改。
         * 2、StringBuffer 、 StringBuilder类的内容允许修改。
         * 3. StringBuffer 是在 JDK1.0 时就提供的工具类，属于线程安全的操作类 、 而StringBuilder 是在J DK1.5 后提供的，属于线程不安全的操作。
         *
         *
         *
         * */
        /* String类的引用传递
         * String类匿名对象不可追加
         * */
        String str = "hello";
        change(str);
        System.out.println(str);

        /*测试append方法追加数据*/
        StringBuffer buffer = new StringBuffer();
        buffer.append(1).append('A').append(true).append("String");
        System.out.println(buffer);

        /*测试insert方式插入数据*/
        StringBuffer buffer1 = new StringBuffer();
        buffer1.append(".com").insert(0, "baidu").insert(0, "www.");
        System.out.println(buffer1);

        /*测试删除指定范围数据*/
        StringBuffer buffer2 = new StringBuffer("ABCDEFGHIJ");
        buffer2.delete(2, 7);
        System.out.println(buffer2);

        /*测试字符反转*/
        StringBuffer buffer3 = new StringBuffer("ABCDEFGHIJ");
        buffer3.reverse();
        System.out.println(buffer3);


    }

    public static void change(String temp) {
        temp += "World";
    }

}
