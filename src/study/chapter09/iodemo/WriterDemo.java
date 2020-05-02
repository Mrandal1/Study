package study.chapter09.iodemo;

import java.io.*;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.iodemo
 * @data 2020/5/2 19:10
 */
public class WriterDemo {
    public static void main(String[] args) throws IOException {
        /*
         * Writer类
         *            public abstract class Writer implements Appendable, Closeable, Flushable
         *
         *       1 输出字符数组
         *           public void write(char cbuf[]) throws IOException
         *       2 输出字符串
         *            public void write(String str) throws IOException
         *
         * */


        /*1 指定要操作的文件目录*/
        File file = new File("D:" + File.separator + "TEST.txt");

        /*文件不存在*/
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        Writer writer = new FileWriter(file, true);
        String str = "TEST";
        writer.write(str);
        writer.append("追加的内容");
        writer.close();

    }
}
