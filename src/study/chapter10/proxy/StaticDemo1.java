package study.chapter10.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter10.proxy
 * @data 2020/5/5 14:24
 */
public class StaticDemo1 {
    public static void main(String[] args) {
        /*静态代理*/
        IMessage message=new MessageProxy(new MessageImpl());
        message.send();


    }
}

interface IMessage {
    void send();
}

class MessageImpl implements IMessage {

    @Override
    public void send() {
        System.out.println("发送消息！");
    }
}

class MessageProxy implements IMessage {
    /**
     * 代理对象 业务接口实例
     */
    private IMessage message;

    public MessageProxy(IMessage message) {
        this.message = message;
    }

    public boolean connect() {
        System.out.println("网络连接");
        return true;
    }

    public boolean close() {
        System.out.println("网络连接关闭");
        return true;
    }

    @Override
    public void send() {
        if (this.connect()) {
            message.send();
            this.close();
        }

    }
}


