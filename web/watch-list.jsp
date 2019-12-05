<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Татьяна
  Date: 16.11.2019
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Products Management Application</title>
</head>
<body>

<center>
<h1>Управление продукцией</h1>
<h2>
    <a href="new">Добавить новые часы</a>
    &nbsp;&nbsp;&nbsp;
    <a href="list">Просмотр всех часов</a>
</h2>
</center>
<div align="center">

    <table border="1" cellpadding="6">
        <%request.getParameter("item");%>

        <caption>
            <h2>Список часов</h2>
        </caption>
            <tr>
<%--                <th>Id</th>--%>
                <th>Название</th>
                <th>Тип</th>
                <th>Пол</th>
                <th>Цена</th>
                <th>Действия</th>
            </tr>
            <c:forEach var="watch" items="${listWatch}">
                <tr>
<%--                    <td><c:out value="${watch.id}" /></td>--%>
                    <td><c:out value="${watch.title}"/></td>
                    <td><c:out value="${watch.type}"/></td>
                    <td><c:out value="${watch.gender}"/></td>
                    <td><c:out value="${watch.price}"/> руб.</td>
                    <td>

                  

                        <c:if test="${admin}">

                        </c:if>


                        <a href="edit?id=<c:out value='${watch.id}'/>">Редактировать</a>&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${watch.id}' />">Удалить</a>
                    </td>
                </tr>
            </c:forEach>
    </table>

</div>


</body>
</html>
