package study.chapter09.testio.io2;

import java.io.File;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.testio.io2
 * @data 2020/5/3 18:31
 */
public class Test {

    static {
        File file=new File(IFileServer.FILE);
        if (!file.exists()){
            file.mkdirs();
        }

    }
    public static void main(String[] args) throws Exception {
        IFileServer fileserver=new FileServerImpl();
        fileserver.save();
    }
}
