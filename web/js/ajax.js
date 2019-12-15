// function identification() {
//
//     var login = document.getElementById("loginID").value;
//     // var password = document.getElementById("password").value;
//     var message = "loginAjax=" + encodeURIComponent(login);
//     var xmlHttp = new XMLHttpRequest();
//     xmlHttp.open("POST", "http://localhost:8080/Lab3/checkLoginAjax", true);
//     xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
//     xmlHttp.onreadystatechange = callback();
//     xmlHttp.send(message);
//     function callback() {
//         if (xmlHttp.readyState == 4)
//             if (xmlHttp.status == 200) {
//                 if (xmlHttp.responseText == "true") {
//                     window.location.href = "http://localhost:8080/Lab3/listRings.jsp";
//                 } else {
//                     document.getElementById("#login_response").innerHTML = "Введен неверной логин/пароль"
//                 }
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

window.onload = function () {
    document.querySelector('input[name=login]').onchange = function () {
        var input_login = document.querySelector('input[name=login]').value;
        var parameters = 'login = ' + input_login;
        ajaxPost(parameters);
    }
}

function ajaxPost(parameters) {
    var request = new XMLHttpRequest();
    request.onreadystatechange = function () {
        if (request.readyState == 4 && request.status == 200) {
            document.querySelector('#result').innerHTML = request.responseText;
            }
        }
    request.open("POST", "http://localhost:8080/Lab3/checkLoginAjax", true);
    request.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    request.send(parameters);
}


function checkLogin(login) {
    var xmlHttp = new XMLHttpRequest(); // Создаём объект XMLHTTP
    xmlHttp.open('POST', '/checkLoginAjax', true); // Открываем асинхронное соединение
    xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); // Отправляем тип содержимого
    xmlHttp.send("login=" + encodeURIComponent(login)); // Отправляем POST-запрос
    xmlHttp.onreadystatechange = function() { // Ждём ответа от сервера
        if (xmlHttp.readyState == 4) { // Ответ пришёл
            if(xmlHttp.status == 200) { // Сервер вернул код 200 (что хорошо)
                document.getElementById("result").innerHTML = xmlHttp.responseText;
            }
        }
    };
}

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
