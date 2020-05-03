package study.chapter09.iodemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.iodemo
 * @data 2020/5/3 15:34
 */
public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        /*
        *
        * BufferedReader 缓冲输入流
        *   public class BufferedReader extends Reader
        *       构造方法
        *           public BufferedReader(Reader in, int sz)
        *           public BufferedReader(Reader in)
        *
        *
        *       读取一行数据 String readLine(boolean ignoreLF) throws IOException
        *
        *
        *
        *
        * */
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("开始输入");
        String msg=bufferedReader.readLine();
        System.out.println("输入内容为："+msg);
    }
}
