<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<%--
  Created by IntelliJ IDEA.
  User: Татьяна
  Date: 05.12.2019
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<script src="js/ajax.js"></script>
<html>
<head>
    <title>Show All Rings</title>
</head>
<body>
<%@include file="_header.jsp"%>
<%@include file="_menu.jsp"%>

<div class="container">
    <div style="display: flex;
                                      flex-direction: column;
                                      justify-items: center;
                                      justify-content: center;">

        <%request.getParameter("item");%>
        <div style="display: flex;
                    flex-direction: row;
                    justify-content: space-around;">
            <div>
                <p><a href="ringsServlet?action=insert"><span style="color: blue">Добавить новое кольцо</span> </a> </p>
            </div>
            <div>
                <p><a href="ringsServlet?action=listRings"><span style="color: blue">Посмотреть все кольца</span> </a> </p>
            </div>

        </div>
        <table border="1">

        <thead>
        <tr>
<%--            <th>ID</th>--%>
            <th>Название</th>
            <th>Бренд</th>
            <th>Металл</th>
            <th>Вставка</th>
            <th>Проба</th>
            <th>Размер</th>
            <th>Цена</th>
            <th colspan="2">Действия</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${rings}" var="ring">
            <tr>
<%--                <td><c:out value="${ring.id}"/></td>--%>
                <td><c:out value="${ring.title}"/></td>
                <td><c:out value="${ring.brand}"/></td>
                <td><c:out value="${ring.metal}"/></td>
                <td><c:out value="${ring.vstavka}"/></td>
                <td><c:out value="${ring.proba}"/></td>
                <td><c:out value="${ring.size}"/></td>
                <td><c:out value="${ring.prise}"/> руб.</td>
                <td><a href="ringsServlet?action=edit&id=<c:out value="${ring.id}"/>"><span style="color: blue">Обновить</span> </a> </td>
                <td><a href="ringsServlet?action=delete&id=<c:out value="${ring.id}"/>"><span style="color: blue">Удалить</span></a> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>

<%--указываем id секции в которую будем выводить список--%>
<div id="forajax">
<%--    указываем метод запроса формы --%>
    <form method="get" >

<%--создаем таблицу--%>
    <table>
<%-- создаем шапку таблицы   --%>
        <thead>
<%--        создаем строку таблицы --%>
        <tr>
<%--            создаем ячейки таблицы --%>
            <th>ID</th>
            <th>Название</th>
            <th>Бренд</th>
            <th>Металл</th>
            <th>Вставка</th>
            <th>Проба</th>
            <th>Размер</th>
            <th>Цена</th>
        </tr>
        </thead>
<%--    создаем тело таблицы: для хранения нескольких строк таблицы, присваем id--%>
        <tbody id="listR"> </tbody>
    </table>
<%--    создаем кнопку с типом button, устанавливаем функцию на событие - нажатие --%>
        <button id="button" type="button" onclick="getRings()">Список колец</button>
    </form>
</div>

</div>
</body>
</html>
