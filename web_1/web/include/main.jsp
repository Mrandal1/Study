<%--
  Created by IntelliJ IDEA.
  User: 11607
  Date: 2020/5/31
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
头部 <br>
内容区 <br>
<%--静态包含--%>
 <%@include file="/include/footer.jsp"%>

<%--动态包含 单独编译include 并且可以传递参数--%>
<jsp:include page="/include/footer.jsp">
    <jsp:param name="name" value="root"/>
</jsp:include>
</body>
</html>
