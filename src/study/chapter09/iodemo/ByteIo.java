package study.chapter09.iodemo;

import java.io.*;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.iodemo
 * @data 2020/5/3 13:34
 */
public class ByteIo {
    public static void main(String[] args) throws IOException {
        /*
         *
         * java中的内存操作流
         *       1 字节内存操作流
         *           public class ByteArrayInputStream extends InputStream
         *           public class ByteArrayOutputStream extends OutputStream
         *       2 字符内存操作流
         *           public class CharArrayReader extends Reader
         *           public class CharArrayWriter extends Writer
         *
         *      其中 ByteArrayInputStream构造方法
         *               public ByteArrayInputStream(byte buf[])
         *               public ByteArrayInputStream(byte buf[], int offset, int length)
         *      其中 ByteArrayOutputStream构造方法
         *               public ByteArrayOutputStream()
         *               public ByteArrayOutputStream(int size)
         *
         *          ByteArrayOutputStream 中获取全部保存在内存的数据
         *                                  1  public synchronized byte[] toByteArray()
         *                                  2  public synchronized String toString()
         * */

        /*利用内存流操作实现大小写转换*/
        String str = "abcdefg";
        InputStream inputStream = new ByteArrayInputStream(str.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();
        int data=0;
        while ((data=inputStream.read())!=-1){
            outputStream.write(Character.toUpperCase(data));
        }
        System.out.println((outputStream.toString()));
        inputStream.close();
        outputStream.close();

    }
}
