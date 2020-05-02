package study.chapter09.iodemo;

import java.io.*;
import java.util.Arrays;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.iodemo
 * @data 2020/5/2 18:01
 */
public class InputStreamDemo {
    public static void main(String[] args) throws IOException {
        /*
         * public abstract class InputStream implements Closeable
         *      方法
         *          1   读取单个字节数据  如果读到底了，返回 -1
         *              public abstract int read() throws IOException;
         *          2   读取字节数组    返回读取的个数，如果读到底了，返回 -1
         *               public int read(byte b[]) throws IOException
         *          3   读取部分字节数组内容
         *              public int read(byte b[], int off, int len) throws IOException
         *      针对文件的处理，java中已有类实现了InPutStream，直接使用即可
         *          构造方法
         *              1
         *                  public FileInputStream(String name) throws FileNotFoundException
         *              2
         *                   public FileInputStream(File file) throws FileNotFoundException
         *              3
         *                   public FileInputStream(FileDescriptor fdObj)
         *
         *
         *
         *
         * */
        /*1 指定要操作的文件目录*/
        File file = new File("D:" + File.separator + "TEST.txt");
        /*2 实例化子类*/
        InputStream inputStream = new FileInputStream(file);
        /*3 开辟缓冲区 用于存储数据*/
        byte[] bytes = new byte[1024];
        /*返回读取个数*/
        int len = inputStream.read(bytes);
        /*未填冲的数组内容不会显示*/
        System.out.println(new String(bytes, 0, len));
    }
}
