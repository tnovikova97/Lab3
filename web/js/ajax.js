function identification() {

    var login = document.getElementById("login").value;
    var password = document.getElementById("password").value;
    var message = "loginAjax=" + encodeURIComponent(login) + "&passwordAjax=" + encodeURIComponent(password);
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("POST", "http://localhost:8080/Lab2", true);
    xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xmlHttp.onreadystatechange = callback();
    xmlHttp.send(message);
    function callback() {
        if (xmlHttp.readyState == 4)
            if (xmlHttp.status == 200) {
                if (xmlHttp.responseText == "true") {
                    window.location.href = "http://localhost:8080/Lab2/listRings.jsp";
                } else {
                    document.getElementById("error").innerHTML = "Введен неверной логин/пароль"
                }
            }
        }
    }


    function getListRings() {
        var xmlHttp = new XMLHttpRequest();
        // xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlHttp.onreadystatechange = callback();
        xmlHttp.open("GET", "http://localhost:8080/Lab2/listRings?listRings=all", true);
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


function getRings() {
    var request = new XMLHttpRequest();
    request.onreadystatechange = function () {
        if (request.readyState == 4 && request.status == 200) {
            document.querySelector('#listR').innerHTML = request.responseText;
        }
    }

    request.open("GET", "http://localhost:8080/Lab2/listRings?listRings=all", true);
    request.send();
}

function ajaxGet() {
    var request = new XMLHttpRequest();
    request.onreadystatechange = function () {
        if (request.readyState == 4 && request.status == 200) {
            document.querySelector('#listR').innerHTML = request.responseText;
        }
    }

    request.open("GET", "http://localhost:8080/Lab2/ajax", true);
    request.send();
}

window.onload = function () {
    document.querySelector('#forajax').onclick = function () {
        getRings();
    }
}
