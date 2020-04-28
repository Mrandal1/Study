package study.chapter06;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter06
 * @data 2020/4/28 17:08
 */
public class DateDemo {
    public static void main(String[] args) throws ParseException {
        /*
         * Data 类中只是对 long 数据的包装，所以 Data 中有转化的方法
         *
         * 1 将 long 转为 Data
         *  public Date(long date)
         *
         * 2 将 Data 转为 long
         *  public long getTime()
         *
         *
         * 日期格式化处理类
         * public class SimpleDateFormat extends DateFormat
         *                          public abstract class DateFormat extends Format
         *
         * 【DateFormat】下的方法
         * 1 将日期格式化
         *   public final String format(Date date)
         * 2将字符串转为日期
         *    public Date parse(String source) throws ParseException
         *
         *
         *
         *
         * 【SimpleDateFormat】
         * 1 构造方法
         *  public SimpleDateFormat(String pattern)
         *          日期格式之一  年（yyyy）----月（MM）----日（dd）----时（HH）----分（mm）----秒（ss）----毫秒（SSS）
         *
         *
         *
         *
         *
         *
         * */
        Date date = new Date();
        System.out.println(date);

        /*测试转换*/
        long time = date.getTime();
        time += 86400 * 1000;
        System.out.println(new Date(time));


        /*格式化日期显示*/
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String str = simpleDateFormat.format(date);
        System.out.println(str);

        /*通过字符串获取Date格式数据

         * 数据超过将自动进位
         * */
        String ss = "2020-10-10 11:11:11.231 ";
        Date date1 = simpleDateFormat.parse(ss);
        System.out.println(date1);

        /*数字的格式化*/
        double money = 2333344444.5;
        String sss= NumberFormat.getInstance().format(money);
        System.out.println(sss);


    }
}
