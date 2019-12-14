function identification() {

    var login = document.getElementById("loginID").value;
    // var password = document.getElementById("password").value;
    var message = "loginAjax=" + encodeURIComponent(login);
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("POST", "http://localhost:8080/Lab3/checkLoginAjax", true);
    xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlHttp.onreadystatechange = callback();
    xmlHttp.send(message);
    function callback() {
        if (xmlHttp.readyState == 4)
            if (xmlHttp.status == 200) {
                if (xmlHttp.responseText == "true") {
                    window.location.href = "http://localhost:8080/Lab3/listRings.jsp";
                } else {
                    document.getElementById("#login_response").innerHTML = "Введен неверной логин/пароль"
                }
            }
        }
    }


    function getListRings() {
        var xmlHttp = new XMLHttpRequest();
        // xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlHttp.onreadystatechange = callback();
        xmlHttp.open("GET", "http://localhost:8080/Lab3/listRings?listRings=all", true);
        xmlHttp.send(null);
        
        function callback() {
            if (xmlHttp.readyState == 4) {
                if (xmlHttp.status == 200) {
                    document.querySelector("listR").innerHTML = xmlHttp.responseText;
                }
            }
        }
    }

// window.onload = function () {
//     document.querySelector('#forajax').onclick = function () {
//         ajaxGet();
//     }
// }

function ajaxGet() {
    var request = new XMLHttpRequest();
    request.onreadystatechange = function () {
        if (request.readyState == 4 && request.status == 200) {
            document.querySelector('#listR').innerHTML = request.responseText;
        }
    }

    request.open("GET", "http://localhost:8080/Lab3/ajax", true);
    request.send();
}

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

    request.open("POST", "/checkLoginAjax", true);
    request.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    request.send(parameters);
}

$(document).ready(function(){
    $("#loginID").on('change', function(){
        var data = {
            "login": $("#loginID").val()
        }
        var url = "checkLoginAjax";

        $.ajax({
            url: url,
            method: "post",
            data: data,
            error: function(message) {
                console.log(message);
                //document.querySelector('#test').innerHTML = message;
            },
            success: function(data) {
                console.log(data);
                //document.querySelector('#info').innerHTML = request.responseText;
                // $("#result").val=data;
                if(data=="empty"){$("#btn-reg").prop('disabled', false);}
                else {$("#btn-reg").prop('disabled', true);}
            }
        });
    });
});