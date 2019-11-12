<%--
  Created by IntelliJ IDEA.
  User: Татьяна
  Date: 12.11.2019
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers</title>
</head>
<body>
    <jsp:useBean id="customersBean" class="Beans.CustomersBean" scope="session"/>
    <jsp:setProperty name="customersBean" property="username" />
    <h1>Hello, <jsp:getProperty name="customersBean" property="username"/>!</h1>

</body>
</html>
