package study.chapter09.iodemo;

import java.io.*;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.iodemo
 * @data 2020/5/2 16:46
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        /*
         * 字节处理流：OutputStream(输出字节流)、InputStream(输入字节流)
         * 字符处理流：Writer(输出字符流)、Reader（输入字符流）
         *
         *       流操作的基本流程：
         *           1 若进行的是文件的读写，首先要通过File类找到文件
         *           2 通过字节流或字符流的子类为父类实例化对象
         *           3 利用字节流或字符流中的方法实行数据的输入与输出
         *           4 关闭流操作
         *
         *
         *       字节流与字符流的区别
         *   1   OutputStream和Writer都使用了close()关闭通道
         *       但是 Writer 不用close 关闭通道  将无法进行写操作
         *       而 OutputStream 不关闭仍可以操作       主要原因是 Writer 的操作使用到了缓冲区 而使用 close 会强制刷新缓冲区输出
         *       在不关闭通道的情况下  Writer 可以使用flush方法强制刷新 进行输出
         *
         *   2   字节流在进行处理的时候并不会用到缓冲区，而字符流会用到缓冲区。同时对中文数据的操作更适用于字符流
         *
         *
         *
         *
         *   转换流：指的是实现字节流与字符流操作的转换
         *       java中相关类；
         *                public class InputStreamReader extends Reader
         *                public class OutputStreamWriter extends Writer
         *
         *               OutputStreamWriter中的构造方法：
         *                            public OutputStreamWriter(OutputStream out)
         *                            public OutputStreamWriter(OutputStream out, String charsetName) throws UnsupportedEncodingException
         *               InputStreamReader中的构造方法：
         *                            public InputStreamReader(InputStream in)
         *                             public InputStreamReader(InputStream in, String charsetName) throws UnsupportedEncodingException
         *
         *           观察 类的继承关系与构造方法的参数可以发现 所谓的转换流就是 将接受到的字节流对象 通过向上转型为字符流对象。
         *
         *
         *            实际上 可以通过 观察 FileWriter 和 FileReader 发现 其与转换流的关系
         *                          public class FileWriter extends OutputStreamWriter
         *                          public class FileReader extends InputStreamReader
         *
         *
         *
         *
         * */

        File file = new File("D:" + File.separator + "TEST.txt");


        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        OutputStream fileout = new FileOutputStream(file, true);
        /*转换流*/
        Writer writer=new OutputStreamWriter(fileout);
        writer.write("输出内容");
        writer.close();


    }
}
