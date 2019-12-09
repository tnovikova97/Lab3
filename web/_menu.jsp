<%--
  Created by IntelliJ IDEA.
  User: Татьяна
  Date: 04.12.2019
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jewelry House</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>
    <!--            menu-->
    <nav class="main-navbar">
        <div class="container">
            <ul class="main-menu">
                <li><a href="#">Главная</a></li>
                <li><a href="#products">Украшения</a>
                    <ul class="sub-menu">
                        <li><a href="#">Серьги</a></li>
                        <li><a href="#">Подвески</a></li>
                        <li><a href="listRings.jsp">Кольца</a></li>
                        <li><a href="#">Браслеты</a></li>
                        <li><a href="watch-list.jsp">Часы</a></li>
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

<!--            Совет дня-->
<div class="overlay-totd js-overlay-totd" id="tipoftheday">
    <form action="" class="tip_of_the_day_form" id="totd_form">
        <div id="randomtip"></div>
    </form>
</div>


<!--        vendor scripts (скрипты от поставщика)-->
<script src="libs/jquery/jquery-3.4.1.min.js"></script>
<script src="libs/OwlCarousel2/owl.carousel.min.js"></script>


<!--    user scripts-->
<script src="js/main.js"></script>


</body>
</html>
