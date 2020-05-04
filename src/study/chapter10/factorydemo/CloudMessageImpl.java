package study.chapter10.factorydemo;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter10.factorydemo
 * @data 2020/5/4 10:58
 */
public class CloudMessageImpl implements  IMessage{
    @Override
    public void sendMessage() {
        System.out.println("cloud消息发送！");
    }
}
