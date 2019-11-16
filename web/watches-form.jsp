<%--
  Created by IntelliJ IDEA.
  User: Татьяна
  Date: 16.11.2019
  Time: 19:38
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
        <a href="new">Add New Watches</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">List All Watches</a>

    </h2>
</center>
<div align="center">
    <c:if test="${watches != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${watches == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${watches != null}">
                            Edit watches
                        </c:if>
                        <c:if test="${watches == null}">
                            Add New watches
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${watches != null}">
                    <input type="hidden" name="id" value="<c:out value='${watches.id}' />" />
                </c:if>
                <tr>
                    <th>watches title: </th>
                    <td>
                        <input type="text" name="title" size="45"
                               value="<c:out value='${watches.title}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>watches type: </th>
                    <td>
                        <input type="text" name="type" size="45"
                               value="<c:out value='${watches.type}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>watches gender: </th>
                    <td>
                        <input type="text" name="gender" size="15"
                               value="<c:out value='${watches.gender}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>watches price: </th>
                    <td>
                        <input type="text" name="price" size="15"
                               value="<c:out value='${watches.price}' />"
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
