package study.chapter06;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter06
 * @data 2020/4/28 16:03
 */
public class MathDemo {
    public static void main(String[] args) {
        /*
         * Math 类的主要功能是进行数学计算，提供基础的公式函数，这个类的构造方法是私有的，提供静态方法
         *
         *
         *
         *
         * */
        System.out.println("求绝对值" + Math.abs(-10.1));
        System.out.println("求最大值" + Math.max(-10.1, 12));
        System.out.println("求对数" + Math.log(12.0));
        System.out.println("取整" + Math.round(-12.5));
        System.out.println("自定义位数取整" + MathDemo.round(12.5097,3));
    }

    /**
     * 实现自定义位数的四舍五入
     *
     * @param num   指定数字
     * @param scale 保留小数位数
     * @return 返回四舍五入结果
     */
    public static double round(double num, int scale) {
        return Math.round(num * Math.pow(10, scale)) / Math.pow(10, scale);
    }
}
