package study.chapter10.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter10.proxy
 * @data 2020/5/5 15:15
 */
public class DynamicDemo {
    public static void main(String[] args) {
        /*动态代理
         * 用于代理方法调用的接口
         *
         * public interface InvocationHandler
         *               public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
         *
         * 创建代理对象   public class Proxy implements java.io.Serializable
         *                   public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,  InvocationHandler h)
         *   ClassLoader loader：获取当前真实主体类的ClassLoader
         *  Class<?>[] interfaces:获取当前真实主体类接口
         *
         *
         * */

        IInfo info=(IInfo)new MyDynamicProxy().bind(new INfoImpl());
        info.send();
    }
}

/**
 * 动态代理执行接口
 */
class MyDynamicProxy implements InvocationHandler {
    /**
     * 保存真实业务对象
     */
    private Object target;

    /**
     * 进行真实业务对象与代理业务对象的绑定
     * @param target 真实业务对象
     * @return Proxy生成的代理业务对象
     */
    public Object bind(Object target){
        this.target=target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);

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
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行"+method);
        Object returnData=null;
        if (this.connect()){
            returnData=method.invoke(target, args);
            this.close();
        }
        return null;
    }
}
interface IInfo {
    void send();
}

class INfoImpl implements IInfo {

    @Override
    public void send() {
        System.out.println("发送消息！");
    }
}

