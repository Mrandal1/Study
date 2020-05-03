package study.chapter09.iodemo.pipe;

import java.io.*;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.iodemo
 * @data 2020/5/3 14:04
 */
public class PipeIo {
    public static void main(String[] args) throws IOException {
        /*
        *
        * 管道流用于连接两个线程的传输
        *      字节管道流
        *               public class PipedOutputStream extends OutputStream
        *               public class PipedInputStream extends InputStream
        *                       连接处理：  public synchronized void connect(PipedInputStream snk) throws IOException
         *      字符管道流
        *   public class PipedWriter extends Writer
        *   public class PipedReader extends Reader
        *                       连接处理：  public synchronized void connect(PipedReader snk) throws IOException
        *
        *
        * */
        Send send=new Send();
        Receive receive=new Receive();
        send.getOutputStream().connect(receive.getInputStream());
        new Thread(send).start();
        new Thread(receive).start();
    }
}
