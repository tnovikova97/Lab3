// создание captcha

var captchaA = randomNumber(1,10); // генерируем число
var captchaB = randomNumber(1,10); // генерируем число
var captchaAB = captchaA + captchaB;  // вычисляем сумму
document.getElementById('captcha-span').innerHTML = captchaA + ' + ' + captchaB + ' = ';  // показываем пользователю выражение

// function ValidCaptcha() {
//     var code1 = sumAB;
//     var code2 = document.getElementById('txtInput').value;
//     if (code1 == code2) {
//         $('.captache-error').hide();
//         $('.formcontent').slideDown();
//     } else {
//         $('.captache-error').show();
//         $('.formcontent').hide();
//     }
// }

// функция для генерации случайных чисел в диапазоне от m до n
function randomNumber(m,n){
    m = parseInt(m);
    n = parseInt(n);
    return Math.floor( Math.random() * (n - m + 1) ) + m;
};


//Валидация формы регистрации

// получение всех входных текстовых объектов
// var username = document.forms["reg-form"]["username"];
// var surname = document.forms["reg-form"]["surname"];
// var email = document.forms["reg-form"]["email"];
// var login = document.forms["reg-form"]["login"];
var password = document.forms["reg-form"]["password"];
var password2 = document.forms["reg-form"]["password2"];
//
// //получение всех объектов отображения ошибок
// var username_error = document.getElementById("username_error");
// var surname_error = document.getElementById("surname_error");
// var email_error = document.getElementById("email_error");
// var login_error = document.getElementById("login_error");
var password_error = document.getElementById("password_error");
var password2_error = document.getElementById("password2_error");
//
// //установка обработчиков
// username.addEventListener("blur", usernameVerify, true);
// surname.addEventListener("blur", surnameVerify, true);
// email.addEventListener("blur", emailVerify, true);
// login.addEventListener("blur", loginVerify, true);
password.addEventListener("blur", passwordVerify, true);
password2.addEventListener("blur", password2Verify, true);

//Функция валидации регистрации
function validate_reg() {
    //username validation
    if (username.value == "") {
        username.style.border = "3px solid #FF1F1F";
        username_error.textContent = "Требуется имя пользователя";
        username.focus();
        return false;
    }
    //surname validation
    if (surname.value == "") {
        surname.style.border = "3px solid #FF1F1F";
        surname_error.textContent = "Требуется фамилия пользователя";
        surname.focus();
        return false;
    }
    //email validation
    if (email.value == "") {
        email.style.border = "3px solid #FF1F1F";
        email_error.textContent = "Требуется адрес Email-почты";
        email.focus();
        return false;
    }
    //login validation
    if (login.value == "") {
        login.style.border = "3px solid #FF1F1F";
        login_error.textContent = "Требуется логин";
        login.focus();
        return false;
    }
    //password validation
    if (password.value == "") {
        password.style.border = "3px solid #FF1F1F";
        password_error.textContent = "Придумайте пароль";
        password.focus();
        return false;
    }

//    Проверка 2-х введеных паролей
    if (password.value != password2.value) {
        password.style.border = "3px solid #FF1F1F";
        password2.style.border = "3px solid #FF1F1F";
        password_error.textContent = "Пароли не совпадают";
        password.focus();
        return false;
    }

//    проверка капчи
    var code1 = captchaAB;
    var code2 = document.getElementById('txtInput').value;
    if (code1 == code2) {
        $('.captcha-error').hide();
        $('.captcha-right').show();
    } else {
        $('.captcha-error').show();
        $('.captcha-right').hide();
        event.preventDefault()
    }
    return true
}

//функции-обработчики
// function usernameVerify() {
//     if (username.value != "") {
//         username.style.border = "1px solid #5E6E66";
//         username_error.innerHTML = "";
//         return true;
//     }
// }
//
// function surnameVerify() {
//     if (surname.value != "") {
//         surname.style.border = "1px solid #5E6E66";
//         surname_error.innerHTML = "";
//         return true;
//     }
// }
//
// function emailVerify() {
//     if (email.value != "") {
//         email.style.border = "1px solid #5E6E66";
//         email_error.innerHTML = "";
//         return true;
//     }
// }
//
// function loginVerify() {
//     if (login.value != "") {
//         login.style.border = "1px solid #5E6E66";
//         login_error.innerHTML = "";
//         return true;
//     }
// }

function passwordVerify() {
    if (password.value != "") {
        password.style.border = "1px solid #5E6E66";
        password_error.innerHTML = "";
        return true;
    }
}

function password2Verify() {
    if (password2.value != "") {
        password2.style.border = "1px solid #5E6E66";
        password2_error.innerHTML = "";
        return true;
    }
}

// // Валидация формы авторизации
// var login_auth = document.forms["auth-form"]["login_auth"];
// var password_auth = document.forms["auth-form"]["password_auth"];
//
// var login_auth_error = document.getElementById("login_auth_error");
// var password_auth_error = document.getElementById("password_auth_error");
//
// login_auth.addEventListener("blur", loginVerify, true);
// password_auth.addEventListener("blur", passwordVerify, true);
//
//
// function validate_auth() {
//     //login validation
//     if (login_auth.value == "") {
//         login_auth.style.border = "3px solid #FF1F1F";
//         login_auth_error.textContent = "Введите логин";
//         login_auth.focus();
//         return false;
//     }
//     //password validation
//     if (password_auth.value == "") {
//         password_auth.style.border = "3px solid #FF1F1F";
//         password_auth_error.textContent = "Введите пароль";
//         password_auth.focus();
//         return false;
//     }
//     return true;
// }
//
// function loginVerify() {
//     if (login_auth.value != "") {
//         login_auth.style.border = "1px solid #5E6E66";
//         login_auth_error.innerHTML = "";
//         return true;
//     }
// }
//
// function passwordVerify() {
//     if (password_auth.value != "") {
//         password_auth.style.border = "1px solid #5E6E66";
//         password_auth_error.innerHTML = "";
//         return true;
//     }
// }

