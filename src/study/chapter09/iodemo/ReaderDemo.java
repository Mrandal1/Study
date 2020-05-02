package study.chapter09.iodemo;

import java.io.*;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.iodemo
 * @data 2020/5/2 19:22
 */
public class ReaderDemo {
    public static void main(String[] args) throws IOException {
        /*
         *
         * Reader类
         *           public abstract class Reader implements Readable, Closeable
         * Reader类并没有提供字符串类的读操作
         *
         *
         * */
        /*1 指定要操作的文件目录*/
        File file = new File("D:" + File.separator + "TEST.txt");
        Reader reader = new FileReader(file);
        char[] chars = new char[1024];
        int len = reader.read(chars);
        reader.close();
        System.out.println("开始\n" + new String(chars, 0, len) + "结束");

    }
}
