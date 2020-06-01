package com.randal;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal
 * @data 2020/6/1 19:40
 */
public class DownLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取要下载的文件名
        String downLoadFileName = "1.jpg";
        //读取要下载的文件内容（ServletContext）
        ServletContext servletContext = getServletContext();
        //设置回传文件类型
        resp.setContentType(servletContext.getMimeType("/file/" + downLoadFileName));
        // 设置数据的回传形式(以附件的形式)
        //若要设置附加名为中文 使用URLEncoder.encode
        resp.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(downLoadFileName, "UTF-8"));
        // 获取下载的文件
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downLoadFileName);
        //获取输出流
        OutputStream outputStream = resp.getOutputStream();
        //使用工具类复制至outputStream
        IOUtils.copy(resourceAsStream, outputStream);

        //Base64
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String con = "一段内容";
        String encode = base64Encoder.encode(con.getBytes(StandardCharsets.UTF_8));
        //解码
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] bytes = base64Decoder.decodeBuffer(encode);
        String newCon = new String(bytes, StandardCharsets.UTF_8);
    }
}
