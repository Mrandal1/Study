package study.chapter08.demo;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter08.demo
 * @data 2020/5/2 10:52
 */
public class Demo1 {
    public static void main(String[] args) {
        /*创建一个StringBuffer对象，通过append方法向其中加入26个小写字母，每次只添加一个，然后以逆序方式输出 并且删除前面五个字符*/
        StringBuffer buf=new StringBuffer();
        char cha='a';
        char chz='z';
        for(int x=cha;x<=chz;x++){
            buf.append((char)x);
        }
        /*反转+删除*/
       StringBuffer subbuf=buf.reverse().delete(0,5);
        System.out.println(subbuf);
    }
}
