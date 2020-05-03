package study.chapter10;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter10
 * @data 2020/5/3 20:29
 */
public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
         * 反射概念：根据实例化对象反推出其类型
         *
         *       获取Class对象信息：      public final native Class<?> getClass();
         *
         *
         *   反射的核心操作 通过Class类实现  可以通过三种方法实现实例化
         *       定义Class可以使用泛型来避免对象的向下转型
         *       public final class Class<T> implements java.io.Serializable, GenericDeclaration, Type,  AnnotatedElement
         *
         *               1 【Object类支持】Object类可以根据实例化对象获取Class对象 (缺点：1 需要获取对象实例才能进行方法调用 2 需要进行导包)
         *                    public final native Class<?> getClass();
         *               2 【JVM直接支持】 类.class  的形式实例化   此种方式需要进行导包
         *               3 【Class类支持】使用Class类的静态方法  可以使用字符串的形式定义要使用的类对象 不用导包
         *                      3.1 加载类 public static Class<?> forName(String className) throws ClassNotFoundException
         *                          （若找不到类会报错 ClassNotFoundException）
         *
         *
         *
         *
         * */
        Date date = new Date();
        System.out.println(date.getTime());

        /*根据实例化对象找到对象所属信息*/
        System.out.println(date.getClass());

        /*方式一 调用Object类方法获取*/
        Person p = new Person();
        Class<? extends Person> cls = p.getClass();
        System.out.println(cls.getName());
        /*方式二  类.class  的形式实例化*/
        Class<?> clsa = Person.class;
        System.out.println(clsa.getName());
        /*方式三  使用Class类的静态方法*/
        Class<?> clsb = Class.forName("study.chapter10.Person");
        System.out.println(clsb.getName());

    }
}
