// function identification() {
//
//     var loginID = document.querySelector('#loginID').value;
//     // var password = document.getElementById("password").value;
//     var message = 'loginID=' + encodeURIComponent(loginID);
//     var xmlHttp = new XMLHttpRequest();
//     xmlHttp.open('POST', 'checkLoginAjax', true);
//     xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
//     xmlHttp.onreadystatechange = callback();
//     xmlHttp.send(message);
//     function callback() {
//         if (xmlHttp.readyState == 4)
//             if (xmlHttp.status == 200) {
//                  document.getElementById("#result").innerHTML = xmlHttp.responseText;
//             }
//         }
//     }


// function getListRings() {
    //     var xmlHttp = new XMLHttpRequest();
    //     // xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    //     xmlHttp.onreadystatechange = callback();
    //     xmlHttp.open("GET", "http://localhost:8080/Lab3/listRings?listRings=all", true);
    //     xmlHttp.send(null);
    //
    //     function callback() {
    //         if (xmlHttp.readyState == 4) {
    //             if (xmlHttp.status == 200) {
    //                 document.querySelector("listR").innerHTML = xmlHttp.responseText;
    //             }
    //         }
    //     }
    // }

// window.onload = function () {
//     document.querySelector('#forajax').onclick = function () {
//         ajaxGet();
//     }
// }

// function ajaxGet() {
//     var request = new XMLHttpRequest();
//     request.onreadystatechange = function () {
//         if (request.readyState == 4 && request.status == 200) {
//             document.querySelector('#listR').innerHTML = request.responseText;
//         }
//     }
//
//     request.open("GET", "http://localhost:8080/Lab3/ajax", true);
//     request.send();
// }

//                                      вывод списка колец

// используется для старта веб-приложения
// window.onload - выполняется когда простроен dom и загружены все нужные ресурсы
window.onload = function () {
    // метод document.querySelector() возвращает первый элемент в документе,
    // соответствующий указанному селектору, или группе селекторов
    // при нажатии на который реализуется функция getRings();
    document.querySelector('#forajax').onclick = function () {
        getRings();
    }
}

function getRings() {
    // создаем переменную request, которой присваиваем значение
    // созданного объекта XMLHttpRequest, который даёт возможность из JavaScript
    // делать HTTP-запросы к серверу без перезагрузки страницы
    var request = new XMLHttpRequest();

    // содержит обработчик события, вызываемый когда происходит событие readystatechange,
    // всякий раз когда свойство readyState запроса XMLHttpRequest изменяется
    request.onreadystatechange = function () {
        // Свойство .readyState возвращает текущее состояние объекта XMLHttpRequest.
        // условие: если текущее состояние объекта - данные загружены (операция полностью завершена) и
        // код HTTP-статуса = 200 - «OK» (успешный запрос)
        if (request.readyState == 4 && request.status == 200) {
            // в выбрвнный селектор вставляем текст ответа на запрос
            document.querySelector('#listR').innerHTML = request.responseText;
        }
    }

    // С помощью метода open() объекта XMLHttpRequest определяем параметры для запроса -
    // указываем, что HTTP запрос будет осуществлен методом "GET",
    // а в качестве URL адреса на который будет отправлен запрос задаем сервлет
    // параметр async определяет, происходит ли работа в асинхронном режиме.
    request.open("GET", "http://localhost:8080/Lab3/listRings?listRings=all", true);
    // С помощью метода send() объекта XMLHttpRequest отправляем запрос на сервер.
    request.send();
}

// проверка логина

// window.onload = function () {
//     document.querySelector('#loginID').onchange = function () {
//         var login = document.querySelector('#loginID').value;
//         loginID = login;
//         ajaxPost(loginID);
//     }
// }
//
// function ajaxPost(loginID) {
//     var request = new XMLHttpRequest();
//     request.onreadystatechange = function () {
//         if (request.readyState == 4 && request.status == 200) {
//             document.querySelector('#result').innerHTML = request.responseText;
//             }
//         }
//     request.open("POST", "http://localhost:8080/Lab3/checkLoginAjax", true);
//     request.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
//     request.send(loginID);
// }

//
// function checkLogin(loginID) {
//     // Создаём объект XMLHTTP
//     var xmlHttp = new XMLHttpRequest();
//     // Открываем асинхронное соединение
//     xmlHttp.open('POST', 'checkLoginAjax', true);
//     // Отправляем тип содержимого
//     xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
//     // Отправляем POST-запрос
//     xmlHttp.send(loginID);
//     // Ждём ответа от сервера
//     xmlHttp.onreadystatechange = function() {
//         // Ответ пришёл
//         if (xmlHttp.readyState == 4) {
//             // Сервер вернул код 200 (что хорошо)
//             if(xmlHttp.status == 200) {
//                 document.getElementById("result").innerHTML = xmlHttp.responseText;
//             }
//         }
//     };
// }

// рабочая функция


// Знак доллара - это просто псевдоним для JQuery.
// jQuery(document).ready(function(){}); ИЛИ. $(document).ready(function(){});
$(document).ready(function () {
    // при изменении поля с идентификатором loginID происходит функция
    $('#loginID').change(function () {
        // записывающая в перемннную loginID значения из текстового поля
        var loginID = $('#loginID').val();

        // jQuery функция $.ajax() позволяет выполнить асинхронный AJAX запрос
        $.ajax(
            {
                // метод HTTP, используемый для запросв
                type: 'POST',
                // данные, которые будут отправлены на сервер
                data: {loginID: loginID},
                // строка, содержащая фдрес, на который отправляется запрос
                url: 'checkLoginAjax',
                // режим
                async: true,
                statusCode: {
                    404: function () {
                        alert("Страница не найдена")
                    },
                    200: function () {
                        alert("Все ОК!")
                    }
                },
                // тип возвращаемых данных
                processData: true,
                // тип содержимого, которое указывается в запросе при передаче данных на сервер
                contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                // Функция обратного вызова, которая вызывается если AJAX запрос выполнится успешно.
                // Функции передаются три аргумента: data - данные возвращенные с сервера.
                // textStatus - строка описывающая статус запроса.
                // jqXHR - объект jqXHR (до версии jQuery 1.4.x объект XMLHttpRequest).
                success: function (result, textStatus) {
                    // вставляем в элемент result данные, полученные от сервера
                    $('#result').html(result);
                    $('#login_error').text(textStatus);
                }
            }
        )
    })
})
