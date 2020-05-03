package study.chapter09.filecopydemo;

import java.io.*;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.chapter09.filecopydemo
 * @data 2020/5/3 10:37
 */
public class FileUtil {
    /**
     * 源目标文件路径
     */
    private File srcFile;
    /**
     * 目标文件路径
     */
    private File desFile;

    public FileUtil(File srcFile, File desFile) {
        this.srcFile = srcFile;
        this.desFile = desFile;
    }

    public FileUtil(String srcFile, String desFile) {
        this(new File(srcFile), new File(desFile));
    }

    public boolean copy() throws IOException {
        if (!this.srcFile.exists()) {
            System.out.println("源文件不存在！");
            return false;
        }
        if (!this.desFile.getParentFile().exists()) {
            this.desFile.getParentFile().mkdirs();
        }
        byte[] data = new byte[1024];
        int len = 0;
        try (InputStream inputStream = new FileInputStream(this.srcFile); OutputStream outputStream = new FileOutputStream(this.desFile)) {
            /*利用 transferTo 方法直接转存*/
            inputStream.transferTo(outputStream);
           /* while ((len = inputStream.read(data)) != -1) {
                outputStream.write(data, 0, len);
            }*/
        }
        return true;
    }

    private boolean copyImpl(File src, File des) throws IOException {
        if (!src.exists()) {
            return false;
        }
        if (!des.getParentFile().exists()) {
            des.getParentFile().mkdirs();
        }
        try (InputStream inputStream = new FileInputStream(src); OutputStream outputStream = new FileOutputStream(des)) {
            inputStream.transferTo(outputStream);
        }
        return true;
    }

    public void copyDirImpl(File file) throws IOException {
        if (file.isDirectory()) {
            File[] result = file.listFiles();
            if (result != null) {
                for (File value : result) {
                    copyDirImpl(value);
                }
            }
        } else {
            String newFilePath = file.getPath().replace(this.srcFile.getPath() + File.separator, "");
            File newFile = new File(this.desFile, newFilePath);
            copyImpl(file, newFile);

        }


    }

    /**
     * 拷贝目录下文件
     */
    public boolean copyDir() throws IOException {
        try {
            this.copyDirImpl(this.srcFile);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}

