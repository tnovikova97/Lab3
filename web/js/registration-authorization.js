// Модальное окно регистрации

// открыть по кнопке
$('.js-button-reg').click(function () {
    $('.js-overlay-reg').fadeIn();
});

/* обращаемся к классу элемента кнопки и в метод click помещаем событие
 элементу body задаем свойство css блюр в 5px - эффект матового стекла
при открытие popup окна
следующее событие - обращение к элементу overlay и применение метода fadeIn,
который позволяет плавно показать окно */

// закрыть на крестик
$('.js-close-reg').click(function () {
    $('.js-overlay-reg').fadeOut();

});

// закрыть по клику вне окна
$(document).mouseup(function (e) {
    var popup = $('.js-popup-reg');
    if (e.target != popup[0] && popup.has(e.target).length === 0) {
        $('.js-overlay-reg').fadeOut();

    }
});

// $('.message a').click(function () {
//     $('.user-form').animate({height: "toggle", opacity: "toggle"}, "slow");
// });

// Реализация регистрации и авторизации в одном окне
$(function () {
    $('#reg-link').on('click', function (e) {
        $('.login-form').css('display', 'none');
        $('.register-form').css('display', 'inline');
        e.preventDefault()
    });
});

$(function () {
    $('#log-link').on('click', function (e) {
        $('.register-form').css('display', 'none');
        $('.login-form').css('display', 'inline');
        e.preventDefault()
    });
});