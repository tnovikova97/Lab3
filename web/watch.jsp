<%--
  Created by IntelliJ IDEA.
  User: Татьяна
  Date: 05.12.2019
  Time: 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
</head>
<body>
<%@include file="_header.jsp"%>


<table class="table">
   <thead>
   <tr>
       <th>Название</th>
       <th>Тип</th>
       <th>Пол</th>
       <th>Цена</th>
   </tr>
   </thead>
    <tbody>
        <tr>
            <td><%=rs.getString("title")%></td>


        </tr>
    </tbody>


</table>

</body>
</html>
