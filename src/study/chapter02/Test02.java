package study.chapter02;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter02
 * @data 2020/4/24 12:51
 */

/**1在程序执行中才会产生异常，而一旦执行中产生了异常，将自动进行指定异常类的实例化对象
 * 2如果此时没有异常处理，则会采用JVM的默认处理机制：首先进行异常信息的打印，而后直接退出当前程序
 * 3如果有异常处理，当前异常将被try捕获
 * 4try捕获到异常后依次与catch的异常类型进行比较。如果与catch的内容对应，就用catch处理。若当前catch不匹配，继续比较以下的catch
 * 若没有匹配的catch就表示一场无法处理
 * 5 最终执行finally语句
 * 6执行完finally后进一步判断异常是否全部处理完毕。若执行完毕，向后执行其他代码，否则交由JVM进行默认处理。
 * */
/**throws和throw的区别？
 * 1.throw是在代码块中使用的，表示进行手工异常抛出
 * 2.throws是在方法定义上使用的，表示将此方法可能产生的异常报告给调用处，并由调用处处理。
* */
/**RuntimeException是Exception的子类
 * RuntimeException的子类异常允许不强制处理异常 而Exception异常需要强制处理
 *常见的RuntimeException：ArithmeticException  NullPointerException  NumberFormatException  ClassCastException
 * */
public class Test02 {

    public static void main(String[] args) {
        System.out.println("程序开始");
        //Exception in thread "main" java.lang.ArithmeticException: / by zero
        try {
            System.out.println("计算"+(10/0));
        }catch (ArithmeticException e){
            /*处理异常*/
            System.out.println(e);
            /*输出完整错误信息*/
            e.printStackTrace();
        }finally {
            System.out.println("不管错误与否都执行");
        }
        //抛出异常的方法必须要进行异常处理
        try {
            MyMath.div(10,2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //测试自定义异常
        MyMath.getNum(11);
        System.out.println("程序结束");
    }
}
