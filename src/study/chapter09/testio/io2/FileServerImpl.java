package study.chapter09.testio.io2;

import study.chapter09.testio.InputUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.testio.io2
 * @data 2020/5/3 18:25
 */
public class FileServerImpl implements IFileServer {
    private String name;
    private String content;
    public FileServerImpl(){
        this.name= InputUtil.getString("请输入文件名称");
        this.content= InputUtil.getString("请输入文件内容");

    }
    @Override
    public boolean save() throws FileNotFoundException {
        File file=new File(IFileServer.FILE,this.name);
        PrintWriter printWriter=new PrintWriter(file);
        printWriter.print(this.content);
        printWriter.close();
        return true;
    }
}
