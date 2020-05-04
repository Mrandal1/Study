package study.chapter10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter10
 * @data 2020/5/4 13:06
 */
public class ReflectionDemo2 {
    public static void main(String[] args) throws Exception {
        /*
         *  1 利用反射获取类的基本信息  （类所在的报的名称  父类的定义 父接口的定义）
         *
         *      1.1 获取包名称      public Package getPackage()
         *      2.2 获取继承父类         public native Class<? super T> getSuperclass();
         *      3.3 获取实现父接口        public Class<?>[] getInterfaces()
         *
         *
         *  2 利用反射获取类的构造方法
         *
         *                  2.1获取所有构造方法 (包括私有构造)     public Constructor<?>[] getDeclaredConstructors() throws SecurityException
         *                  2.2获取指定构造方法      public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
         *                                                                      throws NoSuchMethodException, SecurityException
         *
         *                  2.3获取所有构造方法      public Constructor<?>[] getConstructors() throws SecurityException
         *                  2.4获取指定构造方法      public Constructor<T> getConstructor(Class<?>... parameterTypes)
         *                                                                      throws NoSuchMethodException, SecurityException
         *
         *                  利用构造方法实例化  public T newInstance(Object ... initargs)throws InstantiationException, IllegalAccessException,
         *                                                                                    IllegalArgumentException, InvocationTargetException
         *
         *
         *  3 利用反射获取类的普通方法 (首先要有实例化对象)
         *                   3.1 获取全部方法(包括父类继承的 不包括私有方法)         public Method[] getMethods() throws SecurityException
         *                   3.2 获取指定方法         public Method getMethod(String name, Class<?>... parameterTypes)
         *                                                                  throws NoSuchMethodException, SecurityException
         *
         *
         *                   3.3 获取全部方法(不包括父类继承的,可以有私有属性修饰的方法)         public Method[] getDeclaredMethods() throws SecurityException
         *                   3.4 获取指定方法         public Method getDeclaredMethod(String name, Class<?>... parameterTypes)
         *                                                                   throws NoSuchMethodException, SecurityException
         *
         *                  反射调用类中的方法    public Object invoke(Object obj, Object... args)
         *                                                       throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
         *
         *  4  利用反射获取类的成员
         *                    4.1 获取本类全部成员   public Field[] getDeclaredFields() throws SecurityException
         *                    4.2 获取本类指定成员    public Field getDeclaredField(String name)  throws NoSuchFieldException, SecurityException
         *
         *                    4.3 获取全部成员(包括父类继承的，不包括私有成员)    public Field[] getFields() throws SecurityException
         *                    4.4 获取指定成员(包括父类继承的)   public Field getField(String name) throws NoSuchFieldException, SecurityException
         *
         *                  反射设置成员属性     public void set(Object obj, Object value)  throws IllegalArgumentException, IllegalAccessException
         *
         *                  反射获取成员属性   public Object get(Object obj) throws IllegalArgumentException, IllegalAccessException
         *
         *                  (不要使用)解除成员、构造方法、方法的封装      public void setAccessible(boolean flag)
         *                  （常用）获取成员属性  public Class<?> getType()
         *
         *
         *
         *
         * */

        /*获取Person类对象信息*/

        Class<?> clazz = Person.class;

        /*获取Class对象所在包*/
        Package pac = clazz.getPackage();
        System.out.println(pac.getName());

        /*获取继承父类*/
        Class<?> clazza = clazz.getSuperclass();
        System.out.println(clazza.getName());
        System.out.println(clazza.getSuperclass().getName());

        /*获取实现接口（多个）*/
        Class<?>[] classes = clazz.getInterfaces();
        System.out.println(classes[0].getName() + "\t" + classes[1].getName());

        System.out.println("获取全部构造方法-----------------------------------------");

        /*获取全部构造方法*/
        Constructor<?>[] cons = clazz.getDeclaredConstructors();
        for (Constructor<?> i : cons) {
            System.out.println(i);
        }
        /*获取指定参数的构造  并实例化*/
        Constructor<?> con = clazz.getDeclaredConstructor(String.class, int.class);
        Object obj = con.newInstance("张三", 10);
        System.out.println(obj);

        System.out.println("获取全部方法(包括父类继承的)-----------------------------------------");

        /*获取全部方法(包括父类继承的)*/
        Method[] methods = clazz.getMethods();
        for (Method i : methods) {
            System.out.println(i);
        }
        System.out.println("获取全部方法(不包括父类继承的)-----------------------------------------");
        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method i : methods1) {
            System.out.println(i);
        }
        System.out.println("反射调用类中方法-----------------------------------------");
        /*要操作的属性*/
        String attribute = "name";
        /*为属性设置的内容*/
        String value = "张三";
        /*获取实例化(调用无参构造)*/
        Object o = clazz.getDeclaredConstructor().newInstance();
        /*指定方法名并设置参数*/
        Method setmethod = clazz.getDeclaredMethod("setName", String.class);
        Method getmethod = clazz.getDeclaredMethod("getName");
        /*调用方法*/
        setmethod.invoke(o, value);
        System.out.println(getmethod.invoke(o));
        System.out.println("反射调用类中成员-----------------------------------------");
        /*获取本类与父类中的公共成员*/
        Field[] fields = clazz.getFields();
        for (Field d : fields) {
            System.out.println(d);
        }
        System.out.println("------------------------------------------------------");
        /*获取本类所有成员*/
        Field[] fieldsa = clazz.getDeclaredFields();
        for (Field d : fieldsa) {
            System.out.println(d);
        }
        System.out.println("反射调用并设置类中成员-----------------------------------------");
        /*获取指定成员*/
        Field nameField = clazz.getDeclaredField("name");
        /*设置指定成员(此处无法直接set 需要设置解除封装)*/
        /*nameField.set(o,"李四");*/
        nameField.setAccessible(true);
        nameField.set(o, "李四");

        /*此处属性为私有，无法直接get 需要设置解除封装*/
        /* System.out.println(nameField.getName());*/
        System.out.println(nameField.get(o));
        nameField.setAccessible(false);
        System.out.println("反射获取类中成员的属性-----------------------------------------");
        System.out.println(nameField.getType().getName());
        System.out.println(nameField.getType().getSimpleName());



    }
}
