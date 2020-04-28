package study.chapter06;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter06
 * @data 2020/4/28 12:38
 */
public class CharSequenceDemo {
    public static void main(String[] args) {


        /* CharSequenceDemo 是一个描述字符串结构的接口，在接口里有几个常用子类
         * 1 String 类
         *  public final class String
         *                       implements java.io.Serializable, Comparable<String>, CharSequence
         *
         * 2 StringBuffer 类
         * public final class StringBuffer extends AbstractStringBuilder
         *                       implements java.io.Serializable, CharSequence
         *
         * 3 StringBuilder 类
         * public final class StringBuilder extends AbstractStringBuilder
         *                       implements java.io.Serializable, CharSequence
         *
         * CharSequenceDemo 内的方法
         *
         * 1 获取指定索引字符
         * char charAt(int index);
         * 2 获取字符串长度
         * int length();
         * 3 截取部分字符串
         * CharSequence subSequence(int start, int end);
         *
         *
         *
         *
         * */

        /*测试子类对象向父接口转型*/

        CharSequence sequence = "sequence";

        /*测试字符串截取*/

        CharSequence sub = sequence.subSequence(0, 2);
        System.out.println(sub);

    }
}
