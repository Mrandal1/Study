<%--
  Created by IntelliJ IDEA.
  User: 11607
  Date: 2020/5/31
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--使用jsp表达式--%>
<% request.setAttribute("key", "123");%><br>
<%=request.getAttribute("key")%><br>
<%--使用EL--%>
${key}
</body>
</html>
