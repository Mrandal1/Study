package study.chapter06.clonedemo;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter06
 * @data 2020/4/28 15:47
 */
public class CloneDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        /*
         * 对象克隆指的是对象的复制
         * protected native Object clone() throws CloneNotSupportedException;
         *
         * 如果要进行克隆，克隆对象类需要实现一个接口 Cloneable
         * 该接口无任何方法
         *
         *
         *
         * */

        /*测试克隆*/
        Member member = new Member("张三", 15);
        Member memberA =(Member) member.clone();
        System.out.println(member);
        System.out.println(memberA);

    }
}
