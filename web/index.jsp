<%--
  Created by IntelliJ IDEA.
  User: Татьяна
  Date: 12.11.2019
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@include  file="index.html" %>--%>

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

  <section class="main-content-wrapper">

    <!--    first screen-->
    <section class="first-screen">
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

      <section class="home">
        <div class="home-content-wrapper block-content-wrapper">
          <div class="home-content">
            <h1 class="home-content-title">
              Jewelry House
            </h1>
            <a href="#products" class="home-content-button">
                                    <span class="home-content-button-text">
                                        Наши украшения
                                    </span>
            </a>
          </div>
        </div>
      </section>

      <!--        Преимущества-->
      <section class="features-section">
        <div class="features-section-wrapper">
          <div class="features-col p-0 feature">
            <div class="feature-inner">
              <div class="feature-icon">
                <img src="img/icons/1.png">
                <h2>БЕЗОПАСНЫЕ ПЛАТЕЖИ</h2>
              </div>
            </div>
          </div>
          <div class="features-col p-0 feature">
            <div class="feature-inner">
              <div class="feature-icon">
                <img src="img/icons/2.png">
                <h2>ПРЕМИУМ ПРОДУКТЫ</h2>
              </div>
            </div>
          </div>
          <div class="features-col p-0 feature">
            <div class="feature-inner">
              <div class="feature-icon">
                <img src="img/icons/3.png">
                <h2>БЫСТРАЯ ДОСТАВКА</h2>
              </div>
            </div>
          </div>
        </div>
      </section>
    </section>

    <!--        products-->
    <section class="products" id="products">
      <div class="container">
        <div class="products-title">
          <h2> - Наши украшения - </h2>
        </div>

        <div class="owl-carousel owl-theme" id="carousel1">
          <div class="products-item">
            <div class="products-pic">
              <img src="./img/products/1.jpg">
              <div class="product-links">
                <a href="#" class="view-button">
                  <span class="view-button-text">Кольца</span></a>
              </div>
            </div>

          </div>

          <div class="product-item">
            <div class="products-pic">
              <img src="./img/products/2.jpg">
              <div class="product-links">
                <a href="#" class="view-button">
                  <span class="view-button-text">Подвески</span></a>
              </div>
            </div>

          </div>

          <div class="product-item">
            <div class="products-pic">
              <img src="./img/products/4.jpg">

              <div class="product-links">
                <a href="#" class="view-button">
                  <span class="view-button-text">Серьги</span></a>
              </div>
            </div>

          </div>

          <div class="product-item">
            <div class="products-pic">
              <img src="./img/products/5.jpg">
              <div class="product-links">
                <a href="#" class="view-button">
                  <span class="view-button-text">Браслеты</span></a>
              </div>
            </div>

          </div>

          <div class="product-item">
            <div class="products-pic">
              <img src="./img/products/6.jpg">
              <div class="product-links">
                <a href="#" class="view-button">
                  <span class="view-button-text">Часы</span></a>
              </div>
            </div>

          </div>


        </div>
      </div>

    </section>

    <!--        photo-->
    <section class="photo" id="photo">

      <div class="container">
        <div class="photo-title">
          <h2> - Фотографии - </h2>
        </div>

        <!--        используем библиотеку js owlCarousel,
                    она использует jquery-->

        <div class="owl-carousel owl-theme" id="carousel2">
          <div><img src="img/photo/1.jpg" alt="Img"></div>
          <div><img src="img/photo/2.jpg" alt="Img"></div>
          <div><img src="img/photo/3.jpg" alt="Img"></div>
          <div><img src="img/photo/4.jpg" alt="Img"></div>
          <div><img src="img/photo/5.jpg" alt="Img"></div>
          <div><img src="img/photo/6.jpg" alt="Img"></div>
          <div><img src="img/photo/7.jpg" alt="Img"></div>
        </div>
      </div>


    </section>

    <!--        footer-->
    <section class="footer">
      <div class="container">
        <div class="footer-logo">
          <a href="index.html">
            <img src="img/logo.png">
          </a>
        </div>
        <div class="row">
          <div class="footer-content">
            <div class="footer-widget about-widget">
              <h2>О нас</h2>
              <p>
                Интернет-магазин компании Jewelry House. Мы работаем для Вас, и ради Вас!
              </p>
            </div>
          </div>
          <div class="footer-content">
            <div class="footer-widget about-widget">
              <h2>О компании</h2>
              <ul>
                <li><a href="#">О нас</a></li>
                <li><a href="index.html">Главная</a></li>
                <li><a href="#products">Украшения</a></li>
                <li><a href="#photo">Фотографии</a></li>
                <li><a href="#">Отзывы</a></li>
                <li><a href="#">Партнеры</a></li>
                <li><a href="#">Поддержка</a></li>
              </ul>
            </div>
          </div>
          <div class="footer-content">
            <div class="footer-widget contact-widget">
              <h2>Контактная информация</h2>
              <div class="contact-info">
                <span>Адрес:</span>
                <p>г. Новосибирск, ул. Немировича-Данченко</p>
              </div>
              <div class="contact-info">
                <span>Телефон:</span>
                <p>+79130671968</p>
              </div>
              <div class="contact-info">
                <span>Почта:</span>
                <p>product_jewerly@jewelry.com</p>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="social-links">
        <div class="container">
          <div class="social-links-warp">
            <a href="" class="instagram"><span>instagram</span></a>
            <a href="" class="google-plus"><span>g+plus</span></a>
            <a href="" class="facebook"><span>facebook</span></a>
            <a href="" class="twitter"><span>twitter</span></a>
            <a href="" class="youtube"><span>youtube</span></a>
          </div>
          <p class="text-footer">Copyright &copy;<script>document.write(new Date().getFullYear());</script>
            All rights reserved | Данный сайт создан не для коммерческой деятельности
          </p>
        </div>
      </div>
    </section>

  </section>

  <!--            Регистрация/Авторизация-->
  <div class="overlay-reg js-overlay-reg">
    <div class="popup-reg js-popup-reg">

      <div class="close-popup-reg js-close-reg"></div>
      <div class="user-form">

        <form method="" action="loginServlet" onsubmit="return validate_auth()" class="login-form"
              id="login"
              name="auth-form">
          <h2>Войти</h2>
          <div>
            <input type="text" placeholder="Логин" name="login_auth" class="input-reg" required>
            <div id="login_auth_error" class="validation_error"></div>
          </div>
          <div>
            <input type="password" placeholder="Пароль" name="password_auth" class="input-reg" required>
            <div id="password_auth_error" class="validation_error"></div>
          </div>
          <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
                  : request.getAttribute("errMessage")%></span>
          <input type="submit" value="Войти" name="reg" class="button_reg_auth">
          <p class="message"> Нет аккаунта? <a href="" id="reg-link"> Зарегистрироваться</a></p>
        </form>

        <form method="" action="registrationServlet" onsubmit="return validate_reg()" class="register-form"
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

          <%=(request.getAttribute("errMessage") == null) ? ""
                  : request.getAttribute("errMessage")%>

          <input type="submit" value="Создать аккаунт"  name="reg" class="input-reg button_reg_auth" required>
          <p class="message"> Уже есть аккаунт? <a href="" id="log-link">Войти</a></p>

        </form>

      </div>
    </div>
  </div>

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

