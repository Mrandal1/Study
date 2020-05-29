package com.randal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal
 * @data 2020/5/28 17:41
 */
public class HelloServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求资源路径
        req.getRequestURI();
        //获取请求的统一资源定位符
        req.getRequestURL();
        //获取客户端地址
        req.getRemoteHost();
        //获取请求头
        req.getHeader("User-Agent");
        //获取请求参数
        req.getParameter("");
        //设置域对象
        req.setAttribute("", "");
        //获取域对象
        req.getAttribute("");
        //获取请求转发对象
        req.getRequestDispatcher("");


        //获取转发自ParamServlet的请求参数
        System.out.println("------HelloServlet2------");
        System.out.println("2" + req.getParameter("username"));
        System.out.println("2" + req.getParameter("password"));
        System.out.println("2性别" + req.getParameter("Sex"));

        //查看转发的attr

        Object key = req.getAttribute("key_name");
        System.out.println("来自ParamServlet的attr" + key);
        //使用参数
        System.out.println("key_value" + key + "处理HelloServlet2的业务");

        //response 默认编码为 ISO-8859-1

//        //用于设置浏览器解析的响应头
//        resp.setHeader("Content-type", "text/html;charset=UTF-8");
//        //用于设置服务器响应的编码
//        resp.setCharacterEncoding("UTF-8");

        // 直接设置编码 服务器与客户端都使用UTF-8编码 （需要在取得输出流之前设置）
        resp.setContentType("text/html;charset=UTF-8");

        resp.getWriter().write("成功收到！\t" + req.getParameter("username"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("3 POST service被访问了！");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
