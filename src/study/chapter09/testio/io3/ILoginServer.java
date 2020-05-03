package study.chapter09.testio.io3;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.testio.io3
 * @data 2020/5/3 19:09
 */
public interface ILoginServer {
    /**
     * 判断用户是否存在
     * @return true-登陆次数超过3
     */
    boolean isExit();

    /**
     * 进行用户登录
     * @param name  账号
     * @param password 密码
     * @return true-登陆成功
     */
    boolean login(String name,String password);
}
