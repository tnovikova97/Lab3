<%--
  Created by IntelliJ IDEA.
  User: Татьяна
  Date: 05.12.2019
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
<%@ include file="_header.jsp"%>
<%@include file="_menu.jsp"%>

<%--<jsp:forward page="/ringsServlet?action=listRings"></jsp:forward>--%>

<%--Поиск продукции--%>

<div class="container" style="height: 80vh;">

    <h2 align="center" style="size: 20px; text-transform: uppercase; font-weight: bold">Поиск колец по названию</h2>
    <form action="<c:url value="/searchServlet"/>">
        <input type="text" name="title" placeholder="Введите название">
        <input type="submit" value="Найти">
    </form>

</div>

<%@include file="_footer.jsp"%>

</body>
</html>
