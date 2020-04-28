package study.chapter06;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter06
 * @data 2020/4/28 16:40
 */
public class BigNumberDemo {
    public static void main(String[] args) {
        /*
         * Java提供的大数操作类 BigDecimal BigInteger 其都是Number的子类 即可以进行装箱与拆箱
         *
         * public class BigDecimal extends Number implements Comparable<BigDecimal>
         *
         * public class BigInteger extends Number implements Comparable<BigInteger>
         *
         * 使用 BigDecimal 会产生进位的问题
         *
         *  public BigDecimal divide(BigDecimal divisor, RoundingMode roundingMode)
         *
         * Math类处理性能是优于以上两者的
         *
         * */

        /*用 BigInteger 进行四则运算*/
        BigInteger bigIntegerA = new BigInteger("111111111111111111111111111111111");
        BigInteger bigIntegerB = new BigInteger("1111111111111114545454511111111111111111");
        System.out.println("加法" + bigIntegerA.add(bigIntegerB));
        System.out.println("减法" + bigIntegerA.subtract(bigIntegerB));
        System.out.println("除法" + bigIntegerA.divide(bigIntegerB));
        System.out.println("乘法" + bigIntegerA.multiply(bigIntegerB));

        /*测试 BigDecimal */
        BigDecimal bigA = new BigDecimal("11111112121333333");
        BigDecimal bigB = new BigDecimal("1111111213421333333");

    }


}
