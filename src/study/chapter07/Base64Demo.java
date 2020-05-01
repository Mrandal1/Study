package study.chapter07;

import java.util.Base64;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter07
 * @data 2020/5/1 10:00
 */
public class Base64Demo {
    public static void main(String[] args) {
        /*
         * Base64加密处理类
         *   Base64.Encoder 进行加密处理
         *                      public byte[] encode(byte[] src)
         *
         *   Base64.Decoder 进行解密处理
         *                      public byte[] decode(byte[] src)
         *
         *  使用Base64直接加密是不安全的
         *          因此要采用安全操作 比如多次加密
         *
         *
         *
         * */

        /*实现加密与解密操作*/
        String msg = "HELLo WORLD";
        String encmsg = new String(Base64.getEncoder().encode(msg.getBytes()));
        System.out.println(encmsg);
        String decmsg = new String(Base64.getDecoder().decode(encmsg.getBytes()));
        System.out.println(decmsg);

        /*实现相对安全的加密与解密*/
        String mesgA = "ABCdEFgHijK";
        String encmsgA = Base64Demo.encode(mesgA);
        System.out.println(encmsgA);
        String decmagA=Base64Demo.decode(encmsgA);
        System.out.println(decmagA);
    }

    public static String encode(String str) {
        String temp = str + "{+" + "salt" + "+}";
        byte[] data = temp.getBytes();
        for (int i = 0; i < 5; i++) {
            data = Base64.getEncoder().encode(data);
        }
        return new String(data);
    }

    public static String decode(String str) {
        byte[] temp = str.getBytes();
        for (int i = 0; i < 5; i++) {
            temp = Base64.getDecoder().decode(temp);
        }
        return new String(temp).replaceAll("\\{\\+salt\\+\\}", "");
    }
}