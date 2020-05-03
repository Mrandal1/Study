package study.chapter09.iodemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.iodemo
 * @data 2020/5/3 14:40
 */
public class RandomAccess {
    public static void main(String[] args) throws Exception {
        /*
        *
        *
        * RandomAccessFile 随机读取
        *       public class RandomAccessFile implements DataOutput, DataInput, Closeable
        *   1 构造方法  （mode 包括 "r""w" "d "）
        *       public RandomAccessFile(File file, String mode) throws FileNotFoundException
        *       public RandomAccessFile(String name, String mode) throws FileNotFoundException
        *
        *
        * */
        File file=new File("D:\\test.txt");
        RandomAccessFile rdf=new RandomAccessFile(file,"rw");
        String[] names=new String[]{
                "zhangsan","lisi    ","wangwu  "
        };
        int[] ages=new int[]{
                10,20,30
        };
        for (int x=0;x<names.length;x++){
            rdf.writeBytes(names[x]);
            rdf.writeInt(ages[x]);
        }

        /*通过跳读获取数据*/
        rdf.skipBytes(24);
        byte[] bytes=new byte[8];
        int len=rdf.read(bytes);
        System.out.println("姓名"+new String(bytes,0,len)+"年龄"+rdf.readInt());
        rdf.close();
    }
}
