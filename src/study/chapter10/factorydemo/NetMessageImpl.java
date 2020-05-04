package study.chapter10.factorydemo;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter10.factorydemo
 * @data 2020/5/4 10:49
 */
public class NetMessageImpl implements IMessage{
    @Override
    public void sendMessage() {
        System.out.println("Net消息发送了！");
    }
}
