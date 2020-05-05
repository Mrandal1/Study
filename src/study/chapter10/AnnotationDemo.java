package study.chapter10;


import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter10
 * @data 2020/5/5 16:16
 */
public class AnnotationDemo {
    public static void main(String[] args) throws NoSuchMethodException {
        /*
         *
         * AccessibleObject类     public class AccessibleObject implements AnnotatedElement
         *       1 获取全部Annotation         public Annotation[] getAnnotations()
         *       2 获取指定Annotation        public <T extends Annotation> T getAnnotation(Class<T> annotationClass)
         *
         *  不同注解有不同得存在范围
         *      如：@Documented
         *          @Retention(RetentionPolicy.RUNTIME)  （运行时生效）
         *          @Target(ElementType.TYPE)
         *          public @interface FunctionalInterface {}
         *
         *         @Retention(RetentionPolicy.SOURCE)  （源码编写时效）
         *          public @interface SuppressWarnings
         *
         *          另一种     CLASS,  表示类定义时生效
         *
         * */

        /*获接口上的注解信息*/
        Annotation[] a = IMessage.class.getAnnotations();
        System.out.println(Arrays.toString(a));
        System.out.println("-------------------");
        /*获取接口子类上注解     @SuppressWarnings无法在运行时获取*/
        Annotation[] a1 = NetMessage.class.getAnnotations();
        System.out.println(Arrays.toString(a1));
        System.out.println("-------------------");
        /*获取方法注解        @Override无法在运行时获取*/
        Method method = NetMessage.class.getDeclaredMethod("send", String.class);
        Annotation[] a2 = method.getAnnotations();
        System.out.println(Arrays.toString(a2));
        /*获取指定注解*/
        MyAnnotation annotation=NetMessage.class.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.info());
        System.out.println(annotation.title());

    }
}

@FunctionalInterface
@Deprecated(since = "666")
interface IMessage {
    void send(String msg);
}

@SuppressWarnings("serial")
@MyAnnotation(title="ssss",info = "infoA")
class NetMessage implements IMessage, Serializable {
    @Override
    public void send(String msg) {
        System.out.println("消息发送" + msg);

    }
}

/**
 * 自定义注解
 * @author Mrandal1
 */
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String title() ;
    String info() default "defaultInfo";



}