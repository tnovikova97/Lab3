let comments = [];
loadComments();

//событие на кнопку, при нажатии на которую запускается функция
document.getElementById('addcomment').onclick = function () {
    event.preventDefault();
//    функция вытаскивает комментарий из формы
//    получение элементов формы
    let commentName = document.getElementById('comment-name');
    let commentBody = document.getElementById('comment-body');

//    получаем значения

//    создание нового массива
    let comment = {
        name : commentName.value,
        body : commentBody.value,
        time : Math.floor(Date.now()/1000)
    }

    //clear form

    commentName.value = '';
    commentBody.value = '';
    comments.push(comment);

    //save v local storage
    saveComments();

    showComments();

    console.log(comment);
}

function saveComments() {
    localStorage.setItem('comments', JSON.stringify(comments));
}

function loadComments() {
    if (localStorage.setItem('comments')) comments = JSON.parse(localStorage.setItem('comments'));
    showComments();
}

function showComments() {
    let commentField = document.getElementById('comment-field');
    let out = '';
    comments.forEach(function (item) {
        out +=`<p class = "show_time">${timeConverter(item.time)}</p>`;
        out +=`<p class = "user-name">${item.name}</p>`;
        out +=`<p class = "right_panel">${item.body}</p>`;
    });
    commentField.innerHTML = out;
}

function timeConverter(UNIX_timestamp){
    var a = new Date(UNIX_timestamp * 1000);
    var months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
    var year = a.getFullYear();
    var month = months[a.getMonth()];
    var date = a.getDate();
    var hour = a.getHours();
    var min = a.getMinutes();
    var sec = a.getSeconds();
    var time = date + ' ' + month + ' ' + year + ' ' + hour + ':' + min + ':' + sec ;
    return time;
}
