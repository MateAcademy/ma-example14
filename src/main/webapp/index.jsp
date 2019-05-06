<%@ page import="java.util.*" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head charset="utf-8">
  <title>Логин</title>
</head>
<body>
<center>
  Форма входа
  <br>
  <c:if test="${isRegistrated == true}">
  <p>Вы успешно зарегестрированы!</p>
  </c:if>

  <c:out value="${error}"/>



<form action="login" method="post">
  <br>
  Имя <input type="text" name="name"/>
  <br>
  Пароль <input type="text" name="password"/>
  <br>
  <input type="submit">
</form>
  <br>
  Еще не зарегестрированы?
  <br>
  <a href="registration.jsp">Регистрация</a>
</center>
</body>
</html>