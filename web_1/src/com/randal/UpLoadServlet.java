package com.randal;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal
 * @data 2020/5/31 22:02
 */
public class UpLoadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("上传文件中...");
//        //以流的形式接收客户端的数据
//        ServletInputStream inputStream = req.getInputStream();
//        byte[] bytes=new byte[1024];
//        int read;
//        while ( (read=inputStream.read(bytes))!=-1){
//            System.out.println(new String(bytes,0,read));
//        }
        /*
         * common-upload.jar中常用类   ServletFileUpload
         *   判断数据格式是否是多段格式
         *    ServletFileUpload.isMultipartContent(HttpServletRequest request)
         *   解析上传的数据
         *    public List<FileItem> parseRequest(HttpServletRequest request)
         *           FileItem 类 表示单个表单项
         *   判断表单项是否是普通表单项
         *   boolean isFormField();
         *   获取表单项 Name 属性值
         *   String getFieldName();
         *   获取当前表单项的值
         *   String getString(String var1)
         *   获取上传的文件名
         *   String getName();
         *   将表单数据写入file
         *   void write(File var1) throws Exception;
         * */

        //  1 判断多段数据
        if (ServletFileUpload.isMultipartContent(req)) {
            //  创建 FileItemFactory 工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            // 创建 servletFileUpload工具类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                //  开始解析
                List<FileItem> list = servletFileUpload.parseRequest(req);
                // 判断是否是普通表单项
                for (FileItem temp : list) {
                    if (temp.isFormField()) {
                        // true 普通表单项
                        System.out.println("普通表单项的name值为：\t" + temp.getFieldName());
                        System.out.println("普通表单项的value值为" + temp.getString("UTF-8"));
                    } else {
                        System.out.println("上传内容项的name值为：\t" + temp.getFieldName());
                        System.out.println("上传内容项的文件为：\t" + temp.getName());
                        if (new File("D:" + File.separator + "test").createNewFile()) {
                            temp.write(new File("D:" + File.separator + temp.getName()));
                            System.out.println("写入磁盘成功！");
                        } else {
                            System.out.println("写入磁盘失败！");
                        }
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
