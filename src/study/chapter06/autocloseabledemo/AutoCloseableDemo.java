package study.chapter06.autocloseabledemo;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter06
 * @data 2020/4/28 12:58
 */
public class AutoCloseableDemo {
    public static void main(String[] args) throws Exception {
        /*
         * AutoCloseable(JDK1.7) 接口主要用于资源开发的处理，实现资源的自动关闭（释放资源 ）。
         *
         * 方法
         * void close() throws Exception;
         *
         * 要想实现自动关闭的效果，除了使用 AutoCloseable 接口，还需要结合异常处理语句
         *
         *
         * */


        /*测试 AutoCloseable 的使用*/
        try (IMessage nm = new NetMessage("MSG MSG MSG")) {
            nm.send();
        } catch (Exception e) {

        }

    }
}