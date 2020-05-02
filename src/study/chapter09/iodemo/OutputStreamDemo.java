package study.chapter09.iodemo;

import java.io.*;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.iodemo
 * @data 2020/5/2 17:01
 */
public class OutputStreamDemo {
    public static void main(String[] args) throws IOException {
        /*
         * 字节操作是以byte类型为主实现的。
         * 1   OutputStream类的定义
         *       public abstract class OutputStream implements Closeable, Flushable
         *
         * 2 其中的输出方法
         *           2.1   输出单个字节数据
         *                  public abstract void write(int b) throws IOException;
         *           2.2   输出一组字节数据
         *                  public void write(byte b[]) throws IOException
         *           2.3    输出部分字节数据
         *                  public void write(byte b[], int off, int len) throws IOException
         *
         *  3   针对文件的处理，java中已有类实现了OutPutStream，直接使用即可
         *                  public class FileOutputStream extends OutputStream
         *             构造方法
         *           3.1    覆盖
         *                   public FileOutputStream(String name) throws FileNotFoundException
         *           3.2     追加
         *                   public FileOutputStream(String name, boolean append) throws FileNotFoundException
         *
         *
         *
         *
         *
         * */
        /*1 指定要操作的文件目录*/
        File file = new File("D:" + File.separator + "TEST.txt");

        /*文件不存在*/
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }


        /*2子类实例化*/
        /*覆盖*/
        /* OutputStream fileout = new FileOutputStream(file);*/
        /*追加*/
        OutputStream fileout = new FileOutputStream(file, true);
        /*3定义输出数据*/
        String str = "输入测试！\r\n";
        try {
            /*4将String对象转为字节数组并写出*/
            fileout.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /*5关闭资源*/
            fileout.close();


       /*     实现自动关闭资源的形式
        try( OutputStream fileout = new FileOutputStream(file)){
            String str = "输入测试！";
             fileout.write(str.getBytes());
             }catch (IOException e) {
                e.printStackTrace();
            }
                                    */

        }
    }
}
