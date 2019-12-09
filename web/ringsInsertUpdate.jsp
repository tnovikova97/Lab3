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
<%@include file="_header.jsp"%>
<%@include file="_menu.jsp"%>

<div class="container">

<center>
    <h1 style="text-transform: uppercase; font-weight: bold; size: 20px">Управление продукцией</h1>
</center>

    <div style="display: flex;
                    flex-direction: row;
                    justify-content: space-around;">
        <div>
            <p><a href="ringsServlet?action=insert"><span style="color: blue; text-transform: uppercase">Добавить новое кольцо</span> </a> </p>
        </div>
        <div>
            <p><a href="ringsServlet?action=listRings"><span style="color: blue; text-transform: uppercase">Посмотреть все кольца</span> </a> </p>
        </div>

    </div>

<div align="center">
    <c:if test="${rings != null}">
    <form action="ringsServlet?action=edit" method="post">
        </c:if>
        <c:if test="${rings == null}">
        <form action="ringsServlet?action=insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <c:if test="${rings != null}">
                    <input type="hidden" name="id" value="<c:out value='${rings.id}' />" />
                </c:if>
                <tr>
                    <th>Название: </th>
                    <td>
                        <input type="text" name="title" size="45"
                               value="<c:out value='${rings.title}' />" required
                        />
                    </td>
                </tr>
                <tr>
                    <th>Бренд: </th>
                    <td>
<%--                        <input type="text" name="type" size="45"--%>
<%--                               value="<c:out value='${rings.brand}' />" required--%>
<%--                        />--%>

                        <select name="brand" required>
                            <option>Bang&Olufsen</option>
                            <option>Sokolov</option>
                            <option>Nvidia</option>
                        </select>

                    </td>
                </tr>
                <tr>
                    <th>Металл: </th>
                    <td>

                        <select name="metal" required >
                            <option>Серебро</option>
                            <option>Платина</option>
                            <option>Золото</option>
                        </select>

<%--                        <input type="text" name="gender" size="15"--%>
<%--                               value="<c:out value='${rings.metal}' />"--%>
                    </td>
                </tr>

                <tr>
                    <th>Вставка: </th>
                    <td>

                        <select name="vstavka" required >
                            <option>Фионит</option>
                            <option>Агат</option>
                            <option>Бриллиант</option>
                            <option>Нет</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <th>Проба: </th>
                    <td>

                        <select name="proba" required >
                            <option>925</option>
                            <option>500</option>
                            <option>825</option>
                            <option>Нет</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <th>Размер: </th>
                    <td>

                        <select name="size" required >
                            <option>8.5</option>
                            <option>9</option>
                            <option>9.5</option>
                            <option>10</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <th>Цена: </th>
                    <td>
                        <input type="number" name="prise" size="15" required
                               value="<c:out value='${rings.prise}' />"
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
</div>

<%@include file="_footer.jsp"%>
</body>
</html>
