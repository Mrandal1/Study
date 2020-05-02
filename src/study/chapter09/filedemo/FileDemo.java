package study.chapter09.filedemo;


import java.io.File;
import java.io.IOException;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.filedemo
 * @data 2020/5/2 14:31
 */
public class FileDemo {
    /*
    File 操作类是唯一一个与文件操作（创建、删除、重命名。。。）相关的类

                处理流程 File -> JVM -> 操作系统函数  -> 文件处理

                  访问路径的设置通过构造方法进行。
                  public File(String pathname)

                  设置父路径与子目录
                  public File(File parent, String child)

                  创建新文件
                  public boolean createNewFile() throws IOException

                 判断文件是否存在
                  public boolean exists()

                 删除文件
                 public boolean delete()

        不同系统中路径分割符是不同的
            WINDOWS下是"\".linux下是"/"

        此时为了解决这个问题，FilE类提供了一个常量  表示分割符
        但是 目前已经没必要区分了，系统会自动识别
         public static final String separator = "" + separatorChar;

        创建文件有一个前提： 文件的父路径必须存在
          1  获取父路径：
                        public String getParent()
                        public File getParentFile()
          2  创建目录
                        public boolean mkdir()
                        public boolean mkdirs()


            获取文件信息
                1 判断是否 可读可写可执行
                             public boolean canRead()
                             public boolean canWrite()
                             public boolean canExecute()
                2 获取文件长度
                     返回字节长度        public long length()
                3  最后一次修改文件时间
                              public long lastModified()
                4  判断是否是目录
                               public boolean isDirectory()
                5 判断是否是文件
                               public boolean isFile()
                6 列出目录下内容
                                public File[] listFiles()





    */

    public static void main(String[] args) throws IOException {
        /*注意转义*/
        /*File file=new File("D:\\JAVASTUDY.txt");*/
        File file = new File("D:" + File.separator + "JAVASTUDY.txt");
        System.out.println(file.createNewFile());

        /*创建多级目录下的文件*/
        File file1 = new File("D:" + File.separator + "ONE" + File.separator + "TWO" + File.separator + "JAVASTUDY.txt");
        if (!file1.getParentFile().exists()) {
            file1.getParentFile().mkdirs();
            file1.createNewFile();
        } else {
            file1.createNewFile();
        }

        System.out.println("是否可读" + file.canRead() + "是否可写" + file.canWrite() + "是否可执行" + file.canExecute());
        System.out.println("文件长度" + file.length());
        System.out.println("上次修改时间" + file.lastModified());
        System.out.println("是否是目录" + file.isDirectory());
        System.out.println("是否是文件" + file.isFile());
        fileDir(new File("E:" + File.separator));
    }


    /**
     * 输出目录下所有文件，包括子目录
     *
     * @param file
     */
    public static void fileDir(File file) {
        if (file.isDirectory()) {
            File[] temp = file.listFiles();
            if (temp != null) {
                for (int x = 0; x < temp.length; x++) {
                    fileDir(temp[x]);
                }
            }

        }
        System.out.println(file);

    }

    /**
     * 进行文件名的批量修改
     *
     * @param file
     */
    public static void fileRename(File file) {
        if (file.isDirectory()) {
            File[] temp = file.listFiles();
            if (temp != null) {
                for (int x = 0; x < temp.length; x++) {
                    fileRename(temp[x]);
                }
            }

        } else {
            if (file.isFile()) {
                String fileName;
                if (file.getName().contains(".")) {
                    fileName = file.getName().substring(0, file.getName().lastIndexOf(".")) + ".txt";

                } else {
                    fileName = file.getName() + ".txt";
                }
                File newFile = new File(file.getParentFile(), fileName);
                file.renameTo(newFile);
            }
        }


    }
}
