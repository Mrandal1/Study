package study.chapter10;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter10
 * @data 2020/5/4 10:17
 */
public class ReflectionDemo1 {
    public static void main(String[] args) throws Exception {
        /*
        *
        * 反射实例化对象（代替了 new ）
        *       【JDK1.9以前的实例化】 public T newInstance() throws InstantiationException, IllegalAccessException
        *       【JDK1.9以后的实例化】 clazz.getDeclaredConstructor().newInstance();
        *             public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException
        *
        *       newInstance被替代的原因是其只能调用无参构造，有局限性。
        *
        * */

        /*获取Class实例对象*/
        Class<?> cls=Class.forName("study.chapter10.Person");
        /*使用【JDK1.9以前的实例化方式】*/
       Object obj= cls.newInstance();
        System.out.println(obj);
        /*使用【JDK1.9以后的实例化方式】*/
        Object obja= cls.getDeclaredConstructor().newInstance();
        System.out.println(obja);

    }
}
