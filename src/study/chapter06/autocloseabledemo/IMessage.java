package study.chapter06.autocloseabledemo;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter06.autocloseabledemo
 * @data 2020/4/28 13:04
 */
public interface IMessage extends AutoCloseable {
    /**
     * 消息发送
     */
    void send();
}
