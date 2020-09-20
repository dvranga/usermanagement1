<%--
  Created by IntelliJ IDEA.
  User: ARUN
  Date: 20-08-2020
  Time: 12:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>
<%
    session.invalidate();
    response.sendRedirect("login");
%>
</body>
</html>
