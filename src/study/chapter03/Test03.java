package study.chapter03;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter03
 * @data 2020/4/24 14:53
 */
public class Test03 {
    public static void main(String[] args) {
        Outer outer=new Outer();
        outer.fun();
        //直接实例化内部类
        Outer.Inner inner=new Outer().new Inner();
        inner.print();
        //直接实例化静态内部类
        Outer.InnerA inner1=new Outer.InnerA();
        inner1.print();
        //使用匿名内部类
        IMessage message=new IMessage() {
            @Override
            public void message(String msg) {
                System.out.println(msg);
            }
        };
        message.message("匿名内部类实现了！");
        //通过lambda表达式实现匿名内部类
        //Lambda使用的要求：SAM即（single abstract method）只有一个抽象方法
        IMessage message1=(msg)-> System.out.println(msg);
        message1.message("匿名内部类lambda");
        //lambda的方法引用
        //引用静态方法 类名称::static方法名称
        //引用某个实例对象的方法 实例化对象::普通方法
        //引用特定类型的的方法 特定类::普通方法
        //引用构造方法 类名称::new
         IFunction<String> fun="实例化对象方法引用 asd"::toUpperCase;
        System.out.println(fun.upper());


        //内置函数式接口
        //1功能型函数接口
        //判断是否已指定字符串开头
        Function<String,Boolean> func="ABC"::startsWith;
        System.out.println(func.apply("A"));
        //2消费型接口 只能进行数据处理 无返回
        Consumer<String> con=System.out::println;
        con.accept("只接收数据");
        //3供给型接口 只返回结果
        Supplier<String> sup= "QWERT"::toLowerCase;
        System.out.println(sup.get());
        //4断言型函数接口
        //进行判断处理
        Predicate<String> pre="a"::equalsIgnoreCase;
        System.out.println(pre.test("A"));

    }
}
