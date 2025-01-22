<%--
  Created by IntelliJ IDEA.
  User: nhnacademy
  Date: 25. 1. 19.
  Time: 오후 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sub.jsp title</title>
</head>
<body>
<p>
    THIS IS SUB PAGE. TYPE IS <%= request.getParameter("type") %>.
</p>

<p>
    SUB : ID IS  <%=request.getParameter("id")%>
</p>
</body>
</html>
