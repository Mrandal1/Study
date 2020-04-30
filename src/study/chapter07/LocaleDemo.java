package study.chapter07;

import java.text.MessageFormat;
import java.util.Locale;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter07
 * @data 2020/4/30 10:22
 */
public class LocaleDemo {
    public static void main(String[] args) {
        /*
         * java.util.Locale 用于描述区域与语言编码
         *
         *  构造方法
         * 1  public Locale(String language)
         * 2  public Locale(String language, String country)
         *
         * 读取本地默认环境
         * public static Locale getDefault()
         *
         * Locale 提供了国家代码 常量
         *
         *   中文代码  zh_CN
         *   美国英语代码 en_US
         *
         * 利用 MessageFormat 进行文本格式化输出
         * public class MessageFormat extends Format
         *
         *
         *
         * */


        /*实例化locale对象*/
        /*zh_CN*/
        Locale loc = new Locale("zh", "CN");
        System.out.println(loc);

        /*获得当前系统参数*/
        /*zh_CN*/
        Locale locA = Locale.getDefault();
        System.out.println(locA);

        /*使用代码常量*/
        /*en_US*/
        Locale locB = Locale.US;
        System.out.println(locB);

    }


}
