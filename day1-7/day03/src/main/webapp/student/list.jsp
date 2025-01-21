<%--
  Created by IntelliJ IDEA.
  User: nhnacademy
  Date: 25. 1. 20.
  Time: 오후 3:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
  <title>student - list</title>
  <link rel="stylesheet" href="/style.css" />
</head>

<body>
<h1>학생 리스트</h1>
<p><a href="/student/register.do">학생(등록)</a></p>
<table border="1">
  <thead>
  <tr>
    <th>아이디</th>
    <th>이름</th>
    <th>성별</th>
    <th>나이</th>
    <th>cmd</th>
  </tr>
  </thead>
  <tbody>
  <!-- 학생 리스트를 반복하며 테이블에 데이터 채우기 -->
  <c:forEach var="student" items="${studentList}">
    <tr>
      <td>${student.id}</td>
      <td>${student.name}</td>
      <td>${student.gender}</td>
      <td>${student.age}</td>
      <td>
        <a href="/student/view.do?id=${student.id}">보기</a> |
        <form method="post" action="/student/delete.do">
          <input type="hidden" name="id" value="${student.id}"/>
          <button onclick="return confirm('삭제하시겠습니까?');">삭제</button>
        </form>

      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
