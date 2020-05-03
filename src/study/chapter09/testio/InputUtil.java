package study.chapter09.testio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.testio
 * @data 2020/5/3 16:50
 */
public class InputUtil {
    public InputUtil() {
    }

    public static int getInt(String prompt) {
        int num = 0;
        boolean flag = true;
        while (flag) {
            Scanner in = new Scanner(System.in);
            System.out.println(prompt);
            if (in.hasNext("\\d+")) {
                flag = false;
                num = Integer.parseInt(in.next("\\d+"));
            } else {
                System.out.println("输入的内容不是数字！");

            }
        }
        return num;
    }

    public static String getString(String prompt) {
        String str = null;
        boolean flag = true;
        while (flag) {
            Scanner in = new Scanner(System.in);
            System.out.println(prompt);
            if (in.hasNext()) {
                str = in.next().trim();
                if (!"".equals(str)) {
                    flag = false;
                } else {
                    System.out.println("内容为空！");
                }
            } else {
                System.out.println("内容为空！");
            }
        }
        return str;
    }

}
