package study.chapter08.demo;

import java.util.regex.Pattern;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter08.demo
 * @data 2020/5/2 11:18
 */
public class Demo3 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("参数错误！");
            System.exit(1);
        }
        if (Validator.isEmail(args[0])) {
            System.out.println("验证成功");
        } else {
            System.out.println("验证失败");
            System.exit(1);
        }
    }

    /*自定义验证处理类*/
    static class Validator {
        static String regex = "\\w+@\\w+\\.\\w+";

        private Validator() {
        }

        public static boolean isEmail(String str) {
            if (str == null || "".equals(str)) {
                return false;
            }

            return str.matches(regex);
        }
    }
}
