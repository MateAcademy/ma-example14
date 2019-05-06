<%@ page import="java.util.*" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<html>
<head charset="utf-8">
    <title>Регистрация</title>
</head>
<body>
<center>
    Форма регистрации
    <form action="registration" method="post">
        <br>
        Имя <input type="text" name="name"/>
        <br>
        Пароль <input type="text" name="password"/>
        <br>
        <input type="submit">
    </form>
</center>
</body>
</html>