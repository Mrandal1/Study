package study.chapter10;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter10
 * @data 2020/5/5 13:13
 */
public class ClassLoaderDemo {
    public static void main(String[] args) throws Exception {
        /*
         * 获取类加载器  public ClassLoader getClassLoader()
         *
         *   由当前类加载器获得器父类类加载器    public final ClassLoader getParent()
         *              一级加载器：AppClassLoader    （应用程序加载器）
         *              二级加载器：PlatformClassLoader       （平台加载器 JDk1.8及以前为拓展类加载器ExtClassLoader）
         *              系统类加载器 Bootstrap
         *
         *   可以利用类加载器实现类的反射加载处理
         *
         *
         *
         *
         *
         * */

        Class<?> clazz = Message.class;
        /*获取当前Class类加载器*/
        System.out.println(clazz.getClassLoader());
        /*获取当前Class父类加载器d*/
        System.out.println(clazz.getClassLoader().getParent());
        /*使用自定义加载器*/
        ClassLoader my = new MyClassLoader();
        Class<?> clazz1 = my.loadClass("study.chapter10.Message");
        Object ob = clazz1.getDeclaredConstructor().newInstance();
        Method m = ob.getClass().getDeclaredMethod("send");
        m.invoke(ob);
    }
}

class Message {
    public Message() {
    }

    public void send() {
        System.out.println("消息发送");
    }
}

class MyClassLoader extends ClassLoader {
    /**
     * 定义文件路径
     */
    private static final String MESSAGE_PATH = "D:" + File.separator + "Message.class";

    /**
     * 进行指定类的加载
     *
     * @param classname 类的完整路径
     * @return 指定类的Class对象
     */
    public Class<?> loadData(String classname) throws Exception {
        byte[] data = this.loadClassData();
        if (data != null) {
            super.defineClass(classname, data, 0, data.length);
        }
        return null;
    }

    private byte[] loadClassData() throws Exception {

        /*记载至内存*/

        byte[] data = null;
        try (InputStream input = new FileInputStream(new File(MESSAGE_PATH)); ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            input.transferTo(output);
            data = output.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return data;
    }

}
