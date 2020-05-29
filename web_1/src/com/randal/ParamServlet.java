package com.randal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal
 * @data 2020/5/28 22:16
 */
public class ParamServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求参数设置 解决POST参数中文乱码
        request.setCharacterEncoding("UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        System.out.println("------ParamServlet------");
        System.out.println("1" + request.getParameter("username"));
        System.out.println("1" + request.getParameter("password"));
        System.out.println("1性别" + request.getParameter("Sex"));
        //设置参数传值
        request.setAttribute("key_name", "key_value");
        //设置转发目标路径
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/HelloServlet2");
        //转发
        requestDispatcher.forward(request, response);

        /**
         * 请求转发forward特点
         * 1 地址栏没有变化 （隐式）
         * 2 一次请求转发就是一次客户端请求
         * 3 共享request域中的数据         Attribute
         * 4 可以转发到WEB-INF目录下文件  （一般情况下无法直接访问）
         * 5 只能访问本工程下的资源
         *
         *
         * 请求重定向特点
         * 1    地址栏有变化
         * 2    流程分为两步请求
         * 3    不共享request域中的数据
         * 4    不可以转发到WEB-INF目录下文件
         * 5    可以访问本工程外的资源
         */


    }
}
