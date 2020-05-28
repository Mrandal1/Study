package com.randal;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal
 * @data 2020/5/28 15:03
 */
public class HelloServlet implements Servlet {
    public HelloServlet() {
        System.out.println("1 构造器初始化");
    }
    /*
     * servletConfig作用
     * 1 获取servlet程序别名       String getServletName();
     * 2 获取初始化参数init-param ServletContext getServletContext();
     * 3 获取servletContext对象  String getServletInfo();
     *
     *  servletContext对象 的作用
     *  1 获取配置文件中的上下文参数 context-param
     *  2 获取当前工程路径
     *  3 获取工程部署后在磁盘上的绝对路经
     *  4 存储数据
     * */

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 init执行");
        System.out.println("ServletName\t"+servletConfig.getServletName());
        System.out.println("init-param\t"+servletConfig.getInitParameter("myKey"));
        System.out.println("servletContext\t"+servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法用于处理请求与响应  （需要去web.xml配置servlet程序的访问地址）
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //获取context
        ServletContext context = getServletConfig().getServletContext();
        System.out.println(context.getInitParameter("username"));
        System.out.println(context.getContextPath());
        //获取真实路径
        System.out.println(context.getRealPath("/"));
        System.out.println("POST".equals(request.getMethod()) ? "3 POST service被访问了！" : "3 GET service被访问了！");
        //设置attr
        context.setAttribute("key", "value");
        System.out.println(context.getAttribute("key"));
    }
    //抽象出doGet或doPost方法


    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 destroy");

    }
}
