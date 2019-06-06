<%@ page import="com.dingli.javaee.bean.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Hello
  Date: 2018/12/4
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息</title>
</head>
<body>
<table border="1">
<%
    // 这里是java代码
    List<Student> list = (List<Student>)request.getAttribute("list");
    for(Student s: list){
%>

    <tr>
        <td><%= s.getName()%></td>
        <td><%= s.getAge()%></td>
        <td><%= s.getSex()%></td>
        <td><%= s.getFavs()%></td>
        <td><%= s.getDesc()%></td>
        <td><a href="javascript:void(0);" onclick="fn(<%= s.getId() %>)"></a></td>
    </tr>

<%
    }
%>
<!-- 这里是HTML代码 -->
</table>

<script>
    function fn(id){
        var btn = confirm("确认删除?");
        if(btn == true){
            location.href = "/test6?id=" + id;
        }
    }
</script>
</body>
</html>
