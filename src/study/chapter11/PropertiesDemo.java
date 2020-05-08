package study.chapter11;

import java.io.*;
import java.util.Properties;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter11
 * @data 2020/5/8 16:08
 */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        /*
         * Properties属性操作 只允许字符串   public class Properties extends Hashtable<Object,Object>
         *         1 设置属性     public synchronized Object setProperty(String key, String value)
         *         2 获取属性，不存在则返回null     public String getProperty(String key)
         *         3 获取属性，不存在则返回指定默认值     public String getProperty(String key, String defaultValue)
         *         4 输出属性内容           public void store(OutputStream out, String comments) throws IOException
         *         4 读取属性内容           public synchronized void load(InputStream inStream) throws IOException
         * */
        Properties properties = new Properties();
        properties.setProperty("A", "1");
        properties.setProperty("B", "2");
        properties.setProperty("C", "3");
        properties.setProperty("D", "4");
        properties.setProperty("E", "5");
        /*输出至指定文件*/
        properties.store(new FileOutputStream(new File("D://set.txt")), "t1");
        /*从文件读取*/
        InputStream inputStream = new FileInputStream(new File("D://set.txt"));
        Properties getProperties = new Properties();
        getProperties.load(inputStream);
        System.out.println(getProperties.getProperty("B"));

    }
}
