<%--
  Created by IntelliJ IDEA.
  User: 11607
  Date: 2020/5/31
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test1</title>
</head>
<body>
<table style=" width:650px; border-collapse: collapse">

    <% for (int i = 0; i <= 9; i++) {%>
    <tr>
            <% for (int j = 1; j <= i; j++) {%>
                <td>
            <%= j+ "*" + i + "=" + i * j %>
        </td>
    <% }%>
    </tr>
            <% }%>
</table>

</body>
</html>
