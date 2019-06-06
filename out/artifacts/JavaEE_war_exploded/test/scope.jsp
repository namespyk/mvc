<%--
  Created by IntelliJ IDEA.
  User: Hello
  Date: 2018/12/5
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作用域对象</title>
</head>
<body>
<%
    ServletContext context = request.getServletContext();
%>

<h1>context:<%=context.getAttribute("context")%></h1>
<h1>application:<%=application.getAttribute("context")%></h1>
<h1>ression:<%=session.getAttribute("session")%></h1>
<h1>request:<%=request.getAttribute("request")%></h1>

<!--
application是jsp的内置对象，在servlet中表示为Servlet
-->
</body>
</html>
