package study.chapter09.iodemo.pipe;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.iodemo.pipe
 * @data 2020/5/3 14:14
 */
public class Receive implements Runnable {
    private PipedInputStream inputStream;

    public Receive() {
        inputStream = new PipedInputStream();
    }

    public PipedInputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(PipedInputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        byte[] data = new byte[1024];
        try {
            inputStream.read(data);
            System.out.println(Thread.currentThread().getName() + "接收\t" + new String(data));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
