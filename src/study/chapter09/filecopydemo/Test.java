package study.chapter09.filecopydemo;

import java.io.IOException;
import java.io.Reader;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.filecopydemo
 * @data 2020/5/3 10:41
 */
public class Test {
    public static void main(String[] args) throws IOException {
        /*
        * JDK1.9后追加的方法
        *       InputStream类中
        *       public long transferTo(OutputStream out) throws IOException
        *       Reader类中
        *        public long transferTo(Writer out) throws IOException
        *
        *       使用以上方式转存效率更高 且更简便
        * */

        if (args.length != 2) {
            System.out.println("请输入输入正确的参数");
            System.exit(1);
        }
      /*  long start = System.currentTimeMillis();
        FileUtil fileUtil = new FileUtil(args[0], args[1]);
        long end = System.currentTimeMillis();
        System.out.println(fileUtil.copy() ? "拷贝成功！" + "\t共花费：" + (end - start) : "拷贝失败！");
*/
        long start = System.currentTimeMillis();
        FileUtil fileUtil = new FileUtil(args[0], args[1]);
        long end = System.currentTimeMillis();
        System.out.println(fileUtil.copyDir()? "拷贝目录成功！" + "\t共花费：" + (end - start) : "拷贝失败！");

    }

}
