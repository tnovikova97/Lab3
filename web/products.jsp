<%--
  Created by IntelliJ IDEA.
  User: Татьяна
  Date: 13.11.2019
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Products</title>

</head>
<body>

        <div style="text-align: center; font-size: 20px; font-weight: 700; text-transform: uppercase; text-shadow: #1a1a1a"> Здравствуйте <%=request.getAttribute("login_temp") %> !</div>



        <%--<%@include file="_menu.jsp"%>--%>
        <center>
            <h1 style="font-size: 20px; font-weight: bold; text-transform: uppercase">Управление продукцией</h1>
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
                    <th colspan="2">Действия</th>

                    <c:forEach var="watch" items="${listWatch}">
                <tr>
                        <%--                    <td><c:out value="${watch.id}" /></td>--%>
                    <td><c:out value="${watch.title}"/></td>
                    <td><c:out value="${watch.type}"/></td>
                    <td><c:out value="${watch.gender}"/></td>
                    <td><c:out value="${watch.price}"/></td>



                        <%--                            <c:if test="${session == 'admin'}">--%>

                    <td>    <a href="watchController?action=edit&id=<c:out value='${watch.id}'/>">Редактировать</a></td>
                        <%--                                <a href="edit?id=<c:out value='${watch.id}'/>">Редактировать</a>&nbsp;&nbsp;--%>




                    <td> <a href="delete&id=<c:out value='${watch.id}' />">Удалить</a></td>
                    </td>
                </tr>
                </c:forEach>
                </tr>
            </table>
        </div>








<span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
        : request.getAttribute("errMessage")%></span>

</body>
</html>


</body>
</html>
