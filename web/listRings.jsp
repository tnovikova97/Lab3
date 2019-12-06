<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<%--
  Created by IntelliJ IDEA.
  User: Татьяна
  Date: 05.12.2019
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show All Rings</title>
</head>
<body>

<table border="1">
    <%request.getParameter("item");%>
    <thead>
    <tr>
        <th>ID</th>
        <th>title</th>
        <th>brand</th>
        <th>metal</th>
        <th>vstavka</th>
        <th>proba</th>
        <th>size</th>
        <th>price</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${rings}" var="ring">
        <tr>
            <td><c:out value="${ring.id}"/></td>
            <td><c:out value="${ring.title}"/></td>
            <td><c:out value="${ring.brand}"/></td>
            <td><c:out value="${ring.metal}"/></td>
            <td><c:out value="${ring.vstavka}"/></td>
            <td><c:out value="${ring.proba}"/></td>
            <td><c:out value="${ring.size}"/></td>
            <td><c:out value="${ring.prise}"/></td>
            <td><a href="ringsServlet?action=edit&id=<c:out value="${ring.id}"/>">Update</a> </td>
            <td><a href="ringsServlet?action=delete&id=<c:out value="${ring.id}"/>">Delete</a> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<p><a href="ringsServlet?action=insert">Add Ring</a> </p>

</body>
</html>
