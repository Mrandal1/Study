package study.chapter07;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.*;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter07
 * @data 2020/4/28 18:42
 */
public class RegexDemo {
    public static void main(String[] args) throws ParseException {
        /*
         * java.util.regex 正则表达式开发包
         *
         *
         * 常用正则标记
         *【单匹配】
         * 1 单字符   匹配    任意单字符
         * 2 \\ 匹配 "\"
         * 3 \n   匹配 换行
         * 4 \t   匹配 制表符
         *
         *【单匹配】 字符集（确定范围）
         *
         * 1  [abc]  表示 a 或 b 或 c
         * 2  [^abc] 表示 除了 a b c 以外的任意字符
         * 3  [a-zA-Z] 表示 任意字母 且 不区分大小写
         * 4  [0-9] 表示任意一位 数字
         *
         * 【单匹配】 简化字符集
         * 1  .  表示  任意一个字符
         * 2  \d  表示 任意单数字   等价于[0-9]
         * 3  \D  表示 不是数字 的单字符  等价于  [^0-9]
         * 4  \s  表示 匹配任意一位  空格  ，包括 空格 换行 制表符
         * 5  \S  表示 匹配任意一位  非空格数据
         * 6  \w  表示 匹配任意 一个 字母  数字或  _   等价于  [a-zA-Z_0-9]
         * 7  \W  表示  匹配 除了  数字 字母 与 下划线  外的任意字符  等价于  [^\w]
         *
         * 【边界匹配】
         * 1 ^  匹配边界开始
         * 2 $  匹配边界结束
         *
         * 【数量表示】   默认情况下只有添加了数量单位才可以 匹配  多位字符
         * 1  表达式？    表示  该正则可以出现  0次 或 1次
         * 2  表达式*     表示  该正则可以出现  0次 1次 或 多次
         * 3  表达式+     表示  该正则可以出现  1次 或 多次
         * 4  表达式{n}   表示 表达式   出现  n 次
         * 4  表达式{n,}  表示 表达式   出现  至少  n 次
         * 4  表达式{n,m} 表示 表达式   出现  n ~ m 次
         *
         * 【数量表示】
         * 1  表达式*?   重复任意次，但尽可能少重复
         * 2  表达式+?   重复1次或更多次，但尽可能少重复
         * 3  表达式??   重复0次或1次，但尽可能少重复
         * 4  表达式{n,m}?    重复n到m次，但尽可能少重复
         * 5  表达式{n,}?   重复n次以上，但尽可能少重复
         *
         *
         * 【逻辑表达式】  可以连接多个正则
         * 1  表达式X表达式Y   表示  表达式X  后紧跟上  表达式Y
         * 2  表达式X|表达式Y   表示  有一个表达式满足即可
         * 3  (表达式)     表示  为表达式设置一个整体描述  ，可以为整体描述设置数量单位
         *
         *
         *
         * String 类中相关方法
         * 1  将指定字符串进行正则判断
         *  public boolean matches(String regex)
         *
         * 2 替换全部
         * public String replaceAll(String regex, String replacement)
         *
         * 3 替换首个
         *  public String replaceFirst(String regex, String replacement)
         *
         * 4 正则拆分
         *  public String[] split(String regex, int limit)
         *   public String[] split(String regex)
         *
         *
         * java.util.regex 下有两个类 Pattern(正则表达式编译) Matcher(匹配)
         *
         * 1 Pattern 类提供正则表达式的编译处理支持
         *   public static Pattern compile(String regex)
         *
         * 2 Pattern 类提供字符串的拆分支持
         *   public String[] split(CharSequence input)
         *
         * 3  Pattern 类提供的正则匹配
         *    Matcher()
         *
         * 4 Pattern 类提供的字符串替换
         *   public String replaceAll(String replacement)
         *
         *
         *  public Matcher matcher(CharSequence input)
         *
         *  matcher 类相较于 String 具备的最大优势是 支持对正则的分组
         *
         *
         *
         * */

        /*字符匹配*/

        /*true*/
        System.out.println("a".matches("a"));
        /*true*/
        System.out.println("b".matches("[abc]"));
        /*true*/
        System.out.println("d".matches("[^abc]"));
        /*false*/
        System.out.println("X".matches("[a-z]"));
        /*true*/
        System.out.println("X".matches("[a-zA-Z]"));
        /*true*/
        System.out.println("0".matches("[0-9]"));
        /*true*/
        System.out.println("=".matches("."));
        /*true*/
        System.out.println("9".matches("\\d"));
        /*false*/
        System.out.println("9".matches("\\D"));
        /*true*/
        System.out.println(" ".matches("\\s"));
        /*true*/
        System.out.println("a\n".matches("\\D\\s"));
        /*true*/
        System.out.println("a\t".matches("\\D\\s"));
        /*true*/
        System.out.println("aA".matches("\\D\\S"));
        /*true*/
        System.out.println("aAasasasfdsfd".matches("\\w+"));
        /*true*/
        System.out.println("aAasa".matches("\\w{5}"));
        /*true*/
        System.out.println("xy".matches("xy"));
        /*true*/
        System.out.println("xy".matches("xy"));
        /*false*/
        System.out.println("ab".matches("a.{2,5}?b"));
        /*true*/
        System.out.println("aaab".matches("a.{2,5}?b"));

        /*实现字符串替换 删除掉非字母数字内容*/
        System.out.println("sadwsd09d0efi><((**&&*((*Jikjijf".replaceAll("[^a-zA-Z0-9]+", ""));

        /*实现字符串拆分*/
        String[] result = "a1111b2222c3333d4444444e55".split("\\d*");
        for (String i : result) {
            System.out.print(i + "、");
        }

        /*判断一个数据是否为小数，如果是，将其变为double类型*/
        System.out.println("100.2".matches("\\d+(\\.\\d+)?"));

        /*判断字符串是否由日期组成*/
        String str = "2020-05-20";
        if (str.matches("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse(str));
        }

        /*判断电话号码是否为XXX-XXXXXXXXX或XXXXXXXXX或（XXX）-XXXXXXXXX格式*/
        System.out.println("010-123456789".matches("(\\d{3}-|\\(\\d{3}\\)-)?\\d{9}"));
        System.out.println("123456789".matches("(\\d{3}-|\\(\\d{3}\\)-)?\\d{9}"));
        System.out.println("(010)-123456789".matches("(\\d{3}-|\\(\\d{3}\\)-)?\\d{9}"));

        /*验证e-mail格式
         *
         * 用户名包含字母数字或下划线 不能由下划线开头
         *域名包含字母数字下划线或中划线
         * 后缀 .cn .com.cn .net .gov .com
         *
         * */
        /*true*/
        System.out.println("dfff@qq.com".matches("[a-zA-Z0-9]\\w+@\\w+\\.(cn|com|gov|net|com.cn)"));
        /*false*/
        System.out.println("-dfff@qq.com".matches("[a-zA-Z0-9]\\w+@\\w+\\.(cn|com|gov|net|com.cn)"));
        /*true*/
        System.out.println("d_fff@gmail.com.cn".matches("[a-zA-Z0-9]\\w+@\\w+\\.(cn|com|gov|net|com.cn)"));

        /*测试Pattern的编译支持与字符串拆分*/
        String stra = "2k3g4kj32434pol]l][kpw3r0-";
        String regex = "[^a-zA-Z+]";
        Pattern pat = Pattern.compile(regex);
        String[] re = pat.split(stra);
        for (String i : re) {
            System.out.print(i + "、");
        }

        /*测试 Matcher类的使用*/
        String strb = "1221213";
        String regexa = "\\d+";
        Pattern pata = Pattern.compile(regexa);
        Matcher matcher = pata.matcher(strb);
        System.out.println(matcher.matches());

        /*测试Matcher类的分组功能*/
        /*要求取出 #{  } 内所有内容*/
        String sql = "INSERT INTO DEPT(deptno,dname,loc) VALUES (#{deptno},#{dname},#{loc})";
        String regexb = "#\\{\\w+\\}";
        Pattern sqlpa = Pattern.compile(regexb);
        Matcher matchera = sqlpa.matcher(sql);
        while (matchera.find()) {
            System.out.println(matchera.group(0).replaceAll("#|\\{|\\}",""));
        }

    }
}
