package study.chapter06;

import java.util.Random;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter06
 * @data 2020/4/28 16:25
 */
public class RandomDemo {
    public static void main(String[] args) {
        /*
         * Random类的功能是产生随机数
         *
         * 1 产生一个不大于边界的随机正整数
         * public int nextInt(int bound)
         *
         *
         *
         * */
        /*产生十个不大于100的随机数*/
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(100));
        }

    }
}
