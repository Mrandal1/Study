package study.chapter07;

import java.util.UUID;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter07
 * @data 2020/4/30 12:35
 */
public class UuidDemo {
    public static void main(String[] args) {
        /*
        * UUID类的主要功能是通过时间戳实现一个自动的无重复字符串
        *
        * 可用于对文件的自动命名
        *
        * */

        /*生成随机序列*/
        System.out.println(UUID.randomUUID());


    }
}
