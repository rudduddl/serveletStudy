<%--
  Created by IntelliJ IDEA.
  User: nhnacademy
  Date: 25. 1. 20.
  Time: 오전 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/plain;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<jsp:useBean id="htmlBeautifier" scope="request" class="com.nhnacademy.jsp.beans.HtmlBeautifier" />
<jsp:setProperty name="htmlBeautifier" property="html" param="html" />
<jsp:getProperty name="htmlBeautifier" property="html" />
