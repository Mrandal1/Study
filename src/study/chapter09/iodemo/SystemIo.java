package study.chapter09.iodemo;

import java.io.PrintWriter;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.iodemo
 * @data 2020/5/3 15:21
 */
public class SystemIo {
    public static void main(String[] args) {
        /*
        *
        * 打印流 输出
        *  字节打印流
        *       public class PrintStream extends FilterOutputStream implements Appendable, Closeable
        *  字符打印流
        *       public class PrintWriter extends Writer
        *
        * System类
        *   1 标准输出
        *         public static final PrintStream out = null;
        *   2 错误输出
        *         public static final PrintStream err = null;
        *   3 标准输入
        *         public static final InputStream in = null;
        *
        * */
System.out.println(Integer.parseInt("a"));
System.err.println(Integer.parseInt("a"));
    }
}
