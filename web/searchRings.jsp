<%--
  Created by IntelliJ IDEA.
  User: Татьяна
  Date: 09.12.2019
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%--Подключение библиотеки JSTL core--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Find product</title>
</head>
<body>

<%--Подключаем страницы--%>
<%@ include file="_header.jsp"%>
<%@ include file="_menu.jsp"%>

<div class="container" style="height: 80vh;
                              display: flex;
                              flex-direction: column;
                              justify-content: center;
                              align-items: center">
    <div style="padding: 20px;">


        <%--Поиск продукта по названию--%>

        <h2 align="center" style="size: 20px; text-transform: uppercase; font-weight: bold">Поиск колец по названию</h2>


        <form action="<c:url value="/searchServlet"/>">
            <%-- Передаем параметры сервлету--%>

            <input type="text" name="title" placeholder="Введите название">
            <input type="submit" value="Найти">
        </form>
    </div>

    <div>
        <%--    Вывод продукта--%>
        <table border="1" >
<%--            <%request.getParameter("item");%>--%>
            <thead>
            <tr>
                <th>Название</th>
                <th>Бренд</th>
                <th>Металл</th>
                <th>Вставка</th>
                <th>Проба</th>
                <th>Размер</th>
                <th>Цена</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${rings}" var="ring">
                <tr>
                    <td><c:out value="${ring.title}"/></td>
                    <td><c:out value="${ring.brand}"/></td>
                    <td><c:out value="${ring.metal}"/></td>
                    <td><c:out value="${ring.vstavka}"/></td>
                    <td><c:out value="${ring.proba}"/></td>
                    <td><c:out value="${ring.size}"/></td>
                    <td><c:out value="${ring.prise}"/> руб.</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>



<%@include file="_footer.jsp"%>
</body>
</html>

