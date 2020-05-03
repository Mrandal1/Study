package study.chapter09.testio.io3;

import study.chapter09.testio.Factory;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.testio.io3
 * @data 2020/5/3 19:09
 */
public class Test {
    public static void main(String[] args) {
        ILoginServer login= Factory.getLoginServerInstance();
        login.login(null,null);
    }
}
