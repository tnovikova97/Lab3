<%--
  Created by IntelliJ IDEA.
  User: Татьяна
  Date: 05.12.2019
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
<%@ include file="_header.jsp"%>
<%@include file="_menu.jsp"%>

<div class="container">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script type="text/javascript">

    window.onload = function(){
        document.querySelector('#btn').onclick = function(){
            ajaxGet();
        }
    }
    function ajaxGet() {
        var http = new XMLHttpRequest();
        var url = 'http://localhost:8080/Lab3/checkLoginAjax';
        var gt = document.getElementById("login").value;
        var params = 'login='+gt;
        http.open('POST', url, true);
        //Send the proper header information along with the request
        http.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

        http.onreadystatechange = function () {//Call a function when the state changes.
            if (http.readyState == 4 && http.status == 200) {
                alert(http.responseText);
            }
        }
        http.send(params);
    }
</script>
<input type="text" name="name" id="login">

<h1>
    using script;
</h1>
<button id="btn">click</button>
<div id="test"></div>



</div>
<%@include file="_footer.jsp"%>
</body>

</html>
