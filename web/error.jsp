<%--
  Created by IntelliJ IDEA.
  User: Татьяна
  Date: 13.11.2019
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>

<h1>Ошибка! Вы не были зарегистрированы!</h1>

<span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
        : request.getAttribute("errMessage")%></span>

<b>Вернуться на <a href="index.html">Главную страницу</a> для повторной регистрации.</b>

</body>
</html>
