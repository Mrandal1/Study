<%@ page import="com.randal.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: 11607
  Date: 2020/5/31
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>person</title>
</head>
<body>
<%
    List<String> cities = new ArrayList<String>();
    cities.add("北京");
    cities.add("上海");
    Map<String, Object> map = new HashMap<>();
    map.put("k1", "v1");
    map.put("k2", "v1");
    map.put("k3", "v1");
    Person person = new Person(
            "mike",
            new String[]{"12", "34", "56"},
            cities, map
    );
    pageContext.setAttribute("person1", person);


%>
<%--EL表达式获取数据调用的是getXXX方法--%>
输出： <br>
${person1.name}
${person1.city[0]}
${person1.map.k1}   或   ${person1.map['K1']}
</body>
</html>
