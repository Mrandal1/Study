package study.chapter06.autocloseabledemo;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter06.autocloseabledemo
 * @data 2020/4/28 13:05
 */
public class NetMessage implements IMessage {
    private String msg;

    public NetMessage(String msg) {
        this.msg = msg;
    }

    public boolean open() {
        System.out.println("OPEN获取消息发送连接资源");
        return true;
    }

    @Override
    public void send() {
        if (this.open()) {
            System.out.println("SEND发送消息" + this.msg);
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("CLOSE关闭消息发送通道");
    }

}
