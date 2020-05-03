package study.chapter09.serializabledemo;

import java.io.*;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.demo
 * @data 2020/5/3 16:11
 */
public class SerializableDemo {
    private static final File SAVE_FILE = new File("D:\\save.person");

    public static void main(String[] args) throws Exception {
        /*
         * 对象序列化 实现对以二进制形式对象的保存
         *   并不是所有对象都可以序列化 只有实现 Serializable 才可以
         *
         *       序列化     public class ObjectOutputStream extends OutputStream implements ObjectOutput, ObjectStreamConstants
         *           构造方法        public ObjectOutputStream(OutputStream out) throws IOException
         *
         *               常用方法：1  public final void writeObject(Object obj) throws IOException
         *
         *
         *       反序列化   public class ObjectInputStream extends InputStream implements ObjectInput, ObjectStreamConstants
         *            构造方法        public ObjectInputStream(InputStream in) throws IOException
         *
         *               常用方法：1   public final Object readObject() throws IOException, ClassNotFoundException
         *
         *
         *
         *
         * */

        Person person1 = new Person("张三", 5);
        Person person2 = new Person("李四", 12);
        Person person3 = new Person("王五", 14);
        saveObject(person1);
        System.out.println(readObject());

    }

    public static void saveObject(Object obj) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(SAVE_FILE));
        out.writeObject(obj);
        out.close();
    }

    public static Object readObject() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(SAVE_FILE));
        Object o = in.readObject();
        in.close();
        return o;
    }
}
