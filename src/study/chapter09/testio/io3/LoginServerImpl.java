package study.chapter09.testio.io3;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.testio.io3
 * @data 2020/5/3 19:09
 */
public class LoginServerImpl implements ILoginServer {
    /**
     * 登陆统计
     */
    private int count = 0;


    @Override
    public boolean login(String name, String password) {
        this.count++;
        return "root".equals(password)&&"root".equals(name);
    }

    @Override
    public boolean isExit() {
        return this.count >= 3;

    }
}
