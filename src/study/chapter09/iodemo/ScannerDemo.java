package study.chapter09.iodemo;

import java.util.Scanner;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.iodemo
 * @data 2020/5/3 15:49
 */
public class ScannerDemo {
    public static void main(String[] args) {
        /*
         *
         * scanner是BufferedRead的替代   并且可以直接 通过正则验证输入数据
         *           public final class Scanner implements Iterator<String>, Closeable
         *
         *   构造方法    public Scanner(InputStream source)
         *
         *       判断是否有数据   public boolean hasNext()
         *       取出数据   public String next()
         *       设置读取分割符   public Scanner useDelimiter(Pattern pattern)
         *
         *
         *
         * */
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个整数");
        if (scanner.hasNextInt()) {
            int age = scanner.nextInt();
            System.out.println("输入的是" + age);
        } else {
            System.out.println("不是整数");
        }
        System.out.println("输入信息");
        if (scanner.hasNext()) {
           String msg=scanner.next();
            System.out.println("输入的是" + msg);
        } else {
            System.out.println("没有内容");
        }
        scanner.close();
    }
}
