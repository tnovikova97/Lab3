<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Татьяна
  Date: 05.12.2019
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Add New Ring</title>
</head>
<body>

<form method="post" action="ringsServlet" name="formAddRings">
<%--    ID: <input type="text" name="id"--%>
<%--               value="<c:out value="${ring.id}"/>" readonly="readonly" required />--%>
    Name: <input type="text" name="title"
                 value="<c:out value="${ring.title}"/>" required/>
    Brand: <input type="text" name="brand"
                  value="<c:out value="${ring.brand}"/>" required/>
    Metal: <input type="text" name="metal"
                  value="<c:out value="${ring.metal}"/>" required />
    Vstavka: <input type="text" name="vstavka"
                    value="<c:out value="${ring.vstavka}"/>" required />
    Proba: <input type="number" name="proba"
                  value="<c:out value="${ring.proba}"/>" required />
    Size: <input type="number" name="size"
                 value="<c:out value="${ring.size}"/>" required />
    Price: <input type="number" name="prise"
                  value="<c:out value="${ring.prise}"/>" required />
    <input type="submit" value="Отправить" />
</form>


</body>
</html>
