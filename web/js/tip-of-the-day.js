//Совет дня (Tip of the Day)

// Определяем массив
var tipOfTheDay = [
    '<h1>Совет дня </h1> <br> Украшения - это то, что делает женщищу женщиной <br>(Коко Шанель)',
    '<h1>Совет дня </h1> <br> Ювелирные украшения - то дополнение, которое дает возможность почувствовать себя особенной <br>(Кэтрин Зета-Джонс)',
    '<h1>Совет дня </h1> <br> Бриллианты - всегда признак хорошего вкуса <br>(Вудди Аллен)',
    '<h1>Совет дня </h1> <br> Красота - как драгоценный камень: чем она проще, тем драгоценнее <br>(Фрэнсис Бэкон)',
];

function RandomTip() {
    var rnd = Math.floor((Math.random() * tipOfTheDay.length));
    document.getElementById('randomtip').innerHTML = tipOfTheDay[rnd];
}

// совет дня - открыть по кнопке
$('.js-btn-totd').click(function () {
    $('.js-overlay-totd').fadeIn();
});


// совет дня - закрыть по клику вне окна
$(document).mouseup(function (e) {
    var popup = $('.js-popup-totd');
    if (e.target != popup[0] && popup.has(e.target).length === 0) {
        $('.js-overlay-totd').fadeOut();

    }
});
