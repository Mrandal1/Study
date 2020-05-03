package study.chapter09.testio.io1;

import study.chapter09.testio.Factory;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.testio.io1
 * @data 2020/5/3 17:59
 */
public class Test {
    public static void main(String[] args) {
        INumberServer num= Factory.getNumberServerInstance();
        int[] res=num.stat(3);
        System.out.println("最小值为"+res[0]+"\t最大值为"+res[1]);
    }
}
