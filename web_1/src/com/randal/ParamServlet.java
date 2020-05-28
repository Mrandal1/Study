package com.randal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Randal1
 * @version V1.0
 * @Package ${PACKAGE_NAME}
 * @data 2020/5/28 22:16
 */
public class ParamServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //获取请求参数
        System.out.println(""+request.getParameter("username"));
        System.out.println(""+request.getParameter("password"));
        System.out.println("性别"+request.getParameter("Sex"));
    }
}
