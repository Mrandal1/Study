package study.chapter07.threadlocaldemo;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter07.threadlocaldemo
 * @data 2020/4/30 14:07
 */
public class Channel {
    /*private  static Message message;*/

    private static final ThreadLocal<Message> THREADLOCAL=new ThreadLocal<>();

    public static void setMessage(Message msg) {
        /*向ThreadLocal中保存对象数据*/
        THREADLOCAL.set(msg);
    }

    public static void send() {
        /*从ThreadLocal中取得对象数据*/
        System.out.println(Thread.currentThread().getName() + "发送" +THREADLOCAL.get().getInfo());
    }

}
