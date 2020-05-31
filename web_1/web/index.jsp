<%--
  Created by IntelliJ IDEA.
  User: 11607
  Date: 2020/5/28
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>

<%--导包
    刷新缓冲区
    缓冲区大小 默认为8kb
    errorPage 表示页面出错后跳转的文件目录
    session 是否创建session
    --%>
<%@ page import="com.alibaba.druid"
         autoFlush="true"
         buffer="8kb"
         errorPage="/index.jsp"
         session="true"
%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>web_1</title>
</head>
<body>
<%--声明代码--%>
<%!
    private String name;
    private int age;
    private static Map<String, String> map;
%>
<%--静态代码块--%>
<%!
    static {
        map = new HashMap<>();
        map.put("1", "1-1");
        map.put("2", "2-1");
        map.put("3", "3-1");
    }

%>
<%--声明类方法--%>
<%!
    public void get() {
        System.out.println();
    }
%>
<%--表达式脚本--%>
<%=map%>


<%--代码脚本--%>
<%
    int x = 13;
    System.out.println(x);%>
</body>
</html>
