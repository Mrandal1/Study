package study.chapter08.demo;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter08.demo
 * @data 2020/5/2 11:05
 */
public class Demo2 {
    public static void main(String[] args) {
        /*利用Random类产生1-30（包括1和30）之间的随机数字*/
            int[] arr=RandomNumber(30);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] RandomNumber(int len) {
        Random random = new Random();
        int[] arr = new int[len];
        int foot = 0;
        while (foot < arr.length) {
            int num = random.nextInt(len);
            if (num != 0) {
                arr[foot++] = num;
            }
        }
        return arr;
    }
}
