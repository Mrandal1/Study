package study.chapter07;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter07
 * @data 2020/4/30 10:46
 */
public class ResourceBundleDemo {
    public static void main(String[] args) {
        /*
         * java.util.ResourceBundle 主要用于资源的读取
         *  定义：
         *       public abstract class ResourceBundle
         *
         * 获取实例对象
         * 【baseName描述的是资源文件的名称，无后缀】
         * 1 public static final ResourceBundle getBundle(String baseName)
         *
         *  读取资源的顺序
         * 1 读取指定区域的资源 > 2 默认的本地区域资源 > 3 公共的资源（未设置区域）
         *
         *
         * 根据 key 读取资源内容
         *  public final String getString(String key)
         *
         * 常用方法
         * 格式化文本        public class MessageFormat extends Format
         * public static String format(String pattern, Object ... arguments)
         *
         *
         * */


        /*使用 ResourceBundle 类获取目标对象*/
        /*如果资源没有在包内，直接引用包名*/
        ResourceBundle resource = ResourceBundle.getBundle("study.chapter07.messagepro.ResourceTest");

        /*使用 key 读取资源*/
        String value = resource.getString("info");
        System.out.println(value);

        /*若 key 不存在将产生异常*/
/*
        Exception in thread "main" java.util.MissingResourceException:
        Can't find resource for bundle java.util.PropertyResourceBundle, key inf
*/

        /*利用 MessageFormat 对资源文件占位内容格式化*/
        ResourceBundle res = ResourceBundle.getBundle("study.chapter07.messagepro.Messages_en_US");
        String val = res.getString("info");
        System.out.println(MessageFormat.format(val, "用户1", new SimpleDateFormat("yyyy-MM-dd").format(new Date())));



    }
}
