package study.chapter03;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter03
 * @data 2020/4/24 14:55
 */
public class Outer {
    /**
     * 使用内部类 可以直接访问外部类私有属性
     * */
    private String msg="msg";
    public static final String MSG="MSG";
    public void fun(){
        //实例化内部类对象
    Inner inner=new Inner();
        //调用内部类方法
    inner.print();
    }
    /**
     * 可以使用 private 防止外部直接调用内部类
     * */
     class Inner{
        public  void print(){
            //内部类调用外部类私有属性
            System.out.println(Outer.this.msg);
        }
    }
    /**
     * 静态内部类可以直接调用
     * */
    static class InnerA{
        public void print(){
            System.out.println(Outer.MSG);
        }
    }
}
