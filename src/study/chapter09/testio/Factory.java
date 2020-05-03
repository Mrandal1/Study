package study.chapter09.testio;

import study.chapter09.testio.io1.INumberServer;
import study.chapter09.testio.io1.NumberServerImpl;
import study.chapter09.testio.io2.FileServerImpl;
import study.chapter09.testio.io2.IFileServer;
import study.chapter09.testio.io3.ILoginServer;
import study.chapter09.testio.io3.LoginServerImpl;
import study.chapter09.testio.io3.UserServerProxy;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.testio.io1
 * @data 2020/5/3 17:56
 */
public class Factory {
    private Factory() {
    }

    ;

    public static INumberServer getNumberServerInstance() {
        return new NumberServerImpl();
    }

    public static IFileServer getFileServerInstance() {
        return new FileServerImpl();
    }

    public static ILoginServer getLoginServerInstance() {
        return new UserServerProxy(new LoginServerImpl());
    }
}
