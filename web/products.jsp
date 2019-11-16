<%--
  Created by IntelliJ IDEA.
  User: Татьяна
  Date: 13.11.2019
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css"/>
    <link rel="stylesheet" type="text/css" href="./css/feedback.css"/>
</head>
<body>

<section class="header-section">
    <!--    header-->
    <div class="header-top">
        <div class="container">
            <div class="row">
                <div class="logo">
                    <a href="./index.html" class="site-logo">
                        <img src="img/logo.png">
                    </a>
                </div>
                <div class="user-panel">
                    <div class="login">
                        <div class="button-reg "><a href="logoutServlet"><span>Выйти</span></a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--            menu-->
    <nav class="main-navbar">
        <div class="container">
            <ul class="main-menu">
                <li><a href="#">Главная</a></li>
                <li><a href="#products">Украшения</a>
                    <ul class="sub-menu">
                        <li><a href="#">Серьги</a></li>
                        <li><a href="#">Подвески</a></li>
                        <li><a href="#">Кольца</a></li>
                        <li><a href="#">Браслеты</a></li>
                        <li><a href="#">Часы</a></li>
                    </ul>
                </li>
                <li><a href="#photo">Фотографии</a></li>
                <li><a href="feedback-page.html">Отзывы</a></li>
                <li><a href="#">Полезная информация</a></li>
                <li><a href="#">О компании</a></li>
                <button onclick="RandomTip()" class="tip_of_the_day-button js-btn-totd"><span> Совет дня </span>
                </button>

            </ul>
        </div>
    </nav>
</section>

<div class="feedback-page">

    <div class="feedback-page">
        <div style="text-align: center; font-size: 20px; font-weight: 700; text-transform: uppercase; text-shadow: #1a1a1a"> Здравствуйте <%=request.getAttribute("login") %> !</div>

    </div>

</div>



<span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
        : request.getAttribute("errMessage")%></span>

</body>
</html>


</body>
</html>
