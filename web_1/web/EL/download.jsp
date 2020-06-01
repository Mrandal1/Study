<%--
  Created by IntelliJ IDEA.
  User: 11607
  Date: 2020/5/31
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--            文件的上传
    1、要有一个 form 标签，method=post 请求
    2、form 标签的 encType 属性值必须为 multipart/form-data 值
    3、在 form 标签中使用 input type=file 添加上传的文件
    4、编写服务器代码（Servlet 程序）接收，处理上传的数据。--%>
<form method="post" action="${pageContext.request.contextPath}/upLoadServlet" enctype="multipart/form-data">


    用户名 <input type="text" name="uname"><br>
    头像<input type="file" name="photo"> <br>
    <input type="submit" value="上传">



</form>
</body>
</html>
