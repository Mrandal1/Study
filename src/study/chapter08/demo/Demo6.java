package study.chapter08.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter08.demo
 * @data 2020/5/2 13:27
 */
public class Demo6 {
    public static void main(String[] args) {
        /*拆分<font face="Arial,Serif" size="+2" color="red">*/
        String str = "<font face=\"Arial,Serif\" size=\"+2\" color=\"red\">";
        String regex = "\\w+=\"[\\w,+]+\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String temp = matcher.group(0);
            System.out.println(temp);
        }
    }
}
