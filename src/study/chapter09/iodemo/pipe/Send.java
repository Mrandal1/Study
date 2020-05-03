package study.chapter09.iodemo.pipe;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.iodemo.pipe
 * @data 2020/5/3 14:12
 */
public class Send implements Runnable {
    private PipedOutputStream outputStream;

    public Send() {
        outputStream = new PipedOutputStream();
    }

    @Override
    public void run() {
        try {
            this.outputStream.write(( "1消息发送" + Thread.currentThread().getName()).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PipedOutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(PipedOutputStream outputStream) {
        this.outputStream = outputStream;
    }
}
