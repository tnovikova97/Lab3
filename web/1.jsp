<%--
  Created by IntelliJ IDEA.
  User: Татьяна
  Date: 14.11.2019
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<center>
    <h1>Watch Management</h1>
    <h2>
        <a href="new">Add New Watch</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">List All Watchs</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Watchs</h2></caption>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Type</th>
            <th>gender</th>
            <th>price</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="watchsBean" items="${listWatch}">
            <tr>
                <td><c:out value="${watchsBean.id}" /></td>
                <td><c:out value="${watchsBean.title}" /></td>
                <td><c:out value="${watchsBean.type}" /></td>
                <td><c:out value="${watchsBean.gender}" /></td>
                <td><c:out value="${watchsBean.price}" /></td>
                <td>
                    <a href="edit?id=<c:out value='${watchsBean.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${watchsBean.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
