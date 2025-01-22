<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
  <title>학생-등록</title>
  <link rel="stylesheet" href="/style.css" />
  <meta charset="UTF-8" />
</head>

<body>
<!-- action 주소 설정
    등록: /student/register
    수정: /student/update
-->
<c:choose>
  <c:when test="${empty student}">
    <c:set var="action" value="/student/register.do" />
  </c:when>
  <c:otherwise>
    <c:set var="action" value="/student/update.do" />
  </c:otherwise>
</c:choose>
<form method="post" action="${action}">
  <table>
    <tbody>
    <tr>
      <th>ID</th>
      <td>
        <input type="text" name="id" value="${student.id}"
               <c:if test="${not empty student}">readonly</c:if> required />
      </td>
    </tr>
    <tr>
      <th>이름</th>
      <td>
        <input type="text" name="name" value="${student.name}" required />
      </td>
    </tr>
    <tr>
      <th>성별</th>
      <td>
        <select name="gender" required>
          <option value="M" <c:if test="${student.gender == 'M'}">selected</c:if>>남성</option>
          <option value="F" <c:if test="${student.gender == 'F'}">selected</c:if>>여성</option>
        </select>
      </td>
    </tr>
    <tr>
      <th>나이</th>
      <td>
        <input type="number" name="age" value="${student.age}" min="1" required />
      </td>
    </tr>
    </tbody>
  </table>
  <p>
    <button type="submit">
      <c:choose>
        <c:when test="${empty student}">
          등록
        </c:when>
        <c:otherwise>
          수정
        </c:otherwise>
      </c:choose>
    </button>
  </p>
</form>
</body>
</html>
