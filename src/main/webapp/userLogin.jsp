<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 05.05.2019
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Приветствие юзера!</title>
</head>
<body>
Приветствую тебя <c:out value="${name}"/>!
</body>
</html>
