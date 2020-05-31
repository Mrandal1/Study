<%--
  Created by IntelliJ IDEA.
  User: 11607
  Date: 2020/5/31
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
通过pageContext获取九大对象
协议 ${pageContext.request.scheme} <br>
服务器IP ${pageContext.request.serverName} <br>
服务器端口 ${pageContext.request.serverPort} <br>
获取工程路径 ${pageContext.request.servletPath} <br>
客户端IP ${pageContext.request.remoteHost} <br>
获取会话的id编号 ${pageContext.request.session.id} <br>
<br>
其他隐含对象<br>
单个参数${param.username}<br>
多个参数${paramValues.username[0]}<br>
请求头所有信息${header}<br>
请求头某段信息${header['User-Agent']}<br>
获取cookie${cookie.JSESSIONID}<br>
获取initParam ${initParam.name} <br>

</body>
</html>
