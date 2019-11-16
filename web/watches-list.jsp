<%--
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
<h1>Watches Management</h1>
<h2>
    <a href="new">Add new watches</a>
    &nbsp;&nbsp;&nbsp;
    <a href="list"> List all watches</a>
</h2>
</center>
<div align="center">
    <table border="1" cellpadding="6">
        <caption>
            <h2>List of Watches</h2>
        </caption>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Type</th>
                <th>Gender</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="watches" items="${listWatches}">
                <tr>
                    <td><c:out value="${watches.id}"/></td>
                    <td><c:out value="${watches.title}"/></td>
                    <td><c:out value="${watches.type}"/></td>
                    <td><c:out value="${watches.gender}"/></td>
                    <td><c:out value="${watches.price}"/></td>
                    <td>
                        <a href="edit?id=<c:out value='${watches.id}'/>">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${watches.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
    </table>
</div>


</body>
</html>
