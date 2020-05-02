package study.chapter08.demo;

import java.util.Random;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter08.demo
 * @data 2020/5/2 12:18
 */
public class Demo4 {
    public static void main(String[] args) {
            /*测试1000次*/
        Coin coin=new Coin();
        coin.throwCoin(1000);
        System.out.println("正面次数"+coin.getFront()+"反面次数"+coin.getBack());
    }

    /*模拟抛硬币*/
    static class Coin {
        /*正面次数*/
        private int front;
        /*背面次数*/
        private int back;

        public void throwCoin(int thrownum) {

            for (int x = 0; x < thrownum; x++) {
                /*   0<=random<2*/
                int random = new Random().nextInt(2);
                if (random == 0) {
                    this.front++;
                }else {
                    this.back++;}

            }
        }

        public int getBack() {
            return this.back;
        }

        public int getFront() {
            return this.front;
        }
    }
}
