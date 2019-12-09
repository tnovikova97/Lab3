<%--
  Created by IntelliJ IDEA.
  User: Татьяна
  Date: 05.12.2019
  Time: 8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jewelry House</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css"/>

    <!--Подключаем стили CSS OwlCarousel-->
    <link rel="stylesheet" href="libs/OwlCarousel2/assets/owl.carousel.min.css">
    <link rel="stylesheet" href="libs/OwlCarousel2/assets/owl.theme.default.css">
</head>
<body>
<section class="header-section">
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
                        <div class="button-reg js-button-reg"><span>Войти</span></div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--            Регистрация/Авторизация-->
    <div class="overlay-reg js-overlay-reg">
        <div class="popup-reg js-popup-reg">

            <div class="close-popup-reg js-close-reg"></div>
            <div class="user-form">

                <form method="get" action="loginServlet" onsubmit="return validate_auth()" class="login-form"
                      id="login"
                      name="auth-form">
                    <h2>Войти</h2>
                    <div>
                        <input type="text" placeholder="Логин" name="login" class="input-reg" required>
                        <div id="login_auth_error" class="validation_error"></div>
                    </div>
                    <div>
                        <input type="password" placeholder="Пароль" name="password" class="input-reg" required>
                        <div id="password_auth_error" class="validation_error"></div>
                    </div>
                    <input type="submit" value="Войти" name="reg" class="button_reg_auth">
                    <p class="message"> Нет аккаунта? <a href="" id="reg-link"> Зарегистрироваться</a></p>
                </form>

                <form method="post" action="registrationServlet" onsubmit="return validate_reg()" class="register-form"
                      id="reg"
                      name="reg-form">
                    <h2>Регистрация</h2>
                    <div>
                        <input type="text" placeholder="Имя" name="username" class="input-reg" required>
                        <div id="username_error" class="validation_error"></div>
                    </div>
                    <div>
                        <input type="text" placeholder="Фамилия" name="surname" class="input-reg" required>
                        <div id="surname_error" class="validation_error"></div>
                    </div>
                    <div>
                        <input type="email" placeholder="Почта" name="email" class="input-reg" required>
                        <div id="email_error" class="validation_error"></div>
                    </div>
                    <div>
                        <input type="text" placeholder="Логин" name="login" class="input-reg" required>
                        <div id="login_error" class="validation_error"></div>
                    </div>
                    <div>
                        <input type="password" placeholder="Пароль" name="password" class="input-reg" required>
                        <div id="password_error" class="validation_error"></div>
                    </div>
                    <div>
                        <input type="password" placeholder="Подтвердите пароль" name="password2" class="input-reg" required>
                        <div id="password2_error" class="validation_error"></div>
                    </div>

                    <!--                капча-->

                    <div class="captcha">

                        <p>Введите сумму: </p>

                        <span id="captcha-span"></span>

                        <input type="text" id="txtInput"/>

                        <div class="captcha-right" style="display:none;">
                            <p>Правильно!</p>
                        </div>
                        <div class="captcha-error" style="display:none;">
                            <p>Неверно!</p>
                        </div>

                    </div>

                    <input type="submit" value="Создать аккаунт"  name="reg" class="input-reg button_reg_auth" required>
                    <p class="message"> Уже есть аккаунт? <a href="" id="log-link">Войти</a></p>

                </form>

            </div>
        </div>
    </div>

</body>
</html>
