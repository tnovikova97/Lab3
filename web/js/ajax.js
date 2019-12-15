function identification() {

    var loginID = document.querySelector('#loginID').value;
    // var password = document.getElementById("password").value;
    var message = 'loginID=' + encodeURIComponent(loginID);
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open('POST', 'checkLoginAjax', true);
    xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlHttp.onreadystatechange = callback();
    xmlHttp.send(message);
    function callback() {
        if (xmlHttp.readyState == 4)
            if (xmlHttp.status == 200) {
                 document.getElementById("#result").innerHTML = xmlHttp.responseText;
            }
        }
    }


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

// вывод списка колец
window.onload = function () {
    document.querySelector('#forajax').onclick = function () {
        getRings();
    }
}

function getRings() {
    var request = new XMLHttpRequest();
    request.onreadystatechange = function () {
        if (request.readyState == 4 && request.status == 200) {
            document.querySelector('#listR').innerHTML = request.responseText;
        }
    }

    request.open("GET", "http://localhost:8080/Lab3/listRings?listRings=all", true);
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
//     xmlHttp.send(encodeURIComponent(loginID));
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
$(document).ready(function () {
    $('#loginID').change(function () {
        var loginID = $('#loginID').val();

        $.ajax(
            {
                type: 'POST',
                data: {loginID: loginID},
                url: 'checkLoginAjax',
                success: function (result) {
                    $('#result').html(result);
                }
            }
        )
    })
})
