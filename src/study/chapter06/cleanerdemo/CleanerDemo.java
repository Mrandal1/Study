package study.chapter06.cleanerdemo;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter06
 * @data 2020/4/28 14:25
 */
public class CleanerDemo {
    public static void main(String[] args) throws Exception {
        /*
         * Cleaner (JDk1.9 ) 实现对象清理操作 其主要功能是进行 finalize() 的替代
         *
         * JDK1.9后不建议使用finalize 而是通过 AutoCloseable 或 Cleaner 来操作
         *
         * Object中的 finalize 抛出了 Throwable 的异常，而 Throwable有Error与Exception子类，说明其可能抛出错误
         * protected void finalize() throws Throwable
         *
         *
         *
         *
         *
         *
         * */

        /*测试 Cleaner 使用*/
        try (MemberCleaning mc = new MemberCleaning()) {
            /*执行相关代码*/
        } catch (Exception e) {

        }
    }
}