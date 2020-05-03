package study.chapter09.testio.io2;

import java.io.File;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.testio.io2
 * @data 2020/5/3 18:24
 */
public interface IFileServer {
    String FILE= "D:"+ File.separator+"test";
    /**
     * 文件的保存
     * @return 成功返回true
     */
        boolean save()throws Exception;
}
