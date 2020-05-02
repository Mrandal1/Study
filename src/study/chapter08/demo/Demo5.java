package study.chapter08.demo;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter08.demo
 * @data 2020/5/2 12:38
 */
public class Demo5 {
    public static void main(String[] args) {
        String ip="192.168.0.1";
        System.out.println(Validator.ipValidator(ip));
        String ip1="192.168.0.255";
        System.out.println(Validator.ipValidator(ip1));
    }

    static class Validator {
        public static boolean ipValidator(String str) {
            if (str == null || "".equals(str)) {
                return false;
            }
            String regex = "([12]?[0-9]?[0-9]\\.){3}([12]?[0-9]?[0-9])";
            if (str.matches(regex)) {
                String[] temp = str.split("\\.");
                for (int i = 0; i < temp.length; i++) {
                    int result = Integer.parseInt(temp[i]);
                    if (result >= 255) {
                        return false;
                    }
                }
            }else {
                return false;
            }
            return true;
        }

    }
}
