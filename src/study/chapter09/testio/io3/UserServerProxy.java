package study.chapter09.testio.io3;

import study.chapter09.testio.InputUtil;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.testio.io3
 * @data 2020/5/3 19:31
 */
public class UserServerProxy implements ILoginServer {
    private ILoginServer loginServer;

    public UserServerProxy(ILoginServer loginServer) {
        this.loginServer = loginServer;

    }

    @Override
    public boolean isExit() {
        return this.loginServer.isExit();
    }

    @Override
    public boolean login(String name, String password) {
        while (!this.isExit()) {
            String inputdata = InputUtil.getString("请输入登录用户名：");
            if (inputdata.contains("/")) {
                String[] temp = inputdata.split("/");
                if (this.loginServer.login(temp[0], temp[1])) {
                    return true;
                } else {
                    System.out.println("登陆失败");
                }
            } else {
                String pwd = InputUtil.getString("请输入密码");
                if (this.loginServer.login(inputdata, pwd)) {
                    System.out.println("登录成功！");
                    return true;
                } else {
                    System.out.println("登陆失败");
                }


            }

        }
        return false;
    }
}
