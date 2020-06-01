<%@ page import="java.util.*" %>
<%@ page import="com.randal.Person" %>
<%@ page import="com.randal.Student" %><%--
  Created by IntelliJ IDEA.
  User: 11607
  Date: 2020/5/31
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入jstl--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--set标签往域中保存数据
var key
value value--%>
<c:set scope="request" var="abc" value="123"/>
输出数据:${requestScope.abc}<br>

<%--if判断
test --%>
<c:if test="${12==12}">
    12==12 <br>
</c:if>


<c:set scope="request" var="key" value="12"/>


<%--多路判断
test条件
when标签的父标签必须是choosn--%>
<c:choose>
    <c:when test="${requestScope.key>12}">
        value>12<br>
    </c:when>
    <c:when test="${requestScope.key<12}">
        value<12<br>
    </c:when>
    <c:when test="${requestScope.key==13}">
        value1212<br>
    </c:when>
    <c:otherwise>
        <c:choose>
            <c:when test="${requestScope.key==12}">
                其他情况 <br>
            </c:when>
        </c:choose>
    </c:otherwise>
</c:choose>

<%--普通遍历1-10输出
begin-开始索引
end-结束索引
var-循环变量--%>


<table style="border:1px solid black; border-collapse: collapse">
    <c:forEach begin="1" end="10" var="x">
        <tr style="border:1px solid black; ">
            <td>第${x}行</td>
        </tr>
    </c:forEach>
</table>


<%--遍历一个数组
item表示一个遍历的数据源(集合)
--%>
<%
    request.setAttribute("arr", new String[]{"ob1", "ob2", "ob3"});

%>
<c:forEach items="${requestScope.arr}" var="ob">
    ${ob} <br>
</c:forEach>


<%--遍历一个Map
item表示一个遍历的数据源(集合)
--%>
<% Map<String, Object> map = new HashMap<>();
    map.put("1", "v1");
    map.put("2", "v2");
    map.put("3", "v3");
    request.setAttribute("map", map);
    /*for (Map.Entry<String,Object> entry:map.entrySet()){
        entry.getKey();
        entry.getValue();
    }*/
%>
<c:forEach items="${requestScope.map}" var="entry">
    ${entry.key}+${entry.value} <br>
</c:forEach>


<%--遍历List集合--%>
<%

    List<Student> list = new ArrayList<>();
    list.add(new Student(1, "name", "pass", "123456"));
    list.add(new Student(2, "name1", "pass2", "1234567"));
    list.add(new Student(3, "name2", "pass1", "1234568"));
    request.setAttribute("list", list);
%>
<c:forEach items="${list}" var="temp">
    ${temp.id} &nbsp;&nbsp;&nbsp;
</c:forEach> <br>
<%--step表示步数 i+=2
    varstaus 表示当前数据状态

    --%>
<c:forEach begin="0" end="10" varStatus="st" step="2" var="temp">

    当前遍历到的数据 (等于 var temp) ${st.current} <br>
    &nbsp;&nbsp;   遍历的个数 ${st.count} <br>
    &nbsp;&nbsp;   当前索引 ${st.index} <br>
    &nbsp;&nbsp;   是否是第一条数据 ${st.first}
    &nbsp;&nbsp;   是否是最后数据 ${st.last}<br>
</c:forEach>

</body>
</html>
