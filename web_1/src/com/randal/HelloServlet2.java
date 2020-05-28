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
        System.out.println(req.getRequestURI());
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
        System.out.println("3 GET service被访问了！");
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
