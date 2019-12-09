<%--
  Created by IntelliJ IDEA.
  User: Татьяна
  Date: 16.11.2019
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Products Management Application</title>
</head>
<body>
<%@ include file="_header.jsp"%>
<%@include file="_menu.jsp"%>

<center>
    <h1>Управление продукцией</h1>
    <h2>
        <a href="new">Добавить новые часы</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">Список всех часов</a>

    </h2>
</center>
<div align="center">
    <c:if test="${watch != null}">
    <form action="update" method="get">
        </c:if>
        <c:if test="${watch == null}">
        <form action="insert" method="get">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${watch != null}">
                            Редактировать часы
                        </c:if>
                        <c:if test="${watch == null}">
                           Добавить новые часы
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${watch != null}">
                    <input type="hidden" name="id" value="<c:out value='${watch.id}' />" />
                </c:if>
                <tr>
                    <th>Название часов: </th>
                    <td>
                        <input type="text" name="title" size="45"
                               value="<c:out value='${watch.title}' />" required
                        />
                    </td>
                </tr>
                <tr>
                    <th>Тип механизма: </th>
                    <td>
<%--                        <input type="text" name="type" size="45"--%>
<%--                               value="<c:out value='${watch.type}' />" required--%>
<%--                        />--%>

                        <select name="type" required>
                            <option>Кварцевый (электромеханический)</option>
                            <option>Электронный</option>
                            <option>Механический</option>
                        </select>

                    </td>
                </tr>
                <tr>
                    <th>Пол: </th>
                    <td>

                        <select name="gender" required >
                            <option>Женские</option>
                            <option>Мужские</option>
                            <option>Универсальные</option>
                        </select>

<%--                        <input type="text" name="gender" size="15"--%>
<%--                               value="<c:out value='${watch.gender}' />"--%>
                    </td>
                </tr>
                <tr>
                    <th>Цена: </th>
                    <td>
                        <input type="number" name="price" size="15" required
                               value="<c:out value='${watch.price}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>

</body>
</html>
