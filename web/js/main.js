function include(url) {
    var script = document.createElement('script');
    script.src = url;
    document.getElementsByTagName('head')[0].appendChild(script);
}

include("js/registration-authorization.js");
include("js/tip-of-the-day.js");
include("js/validation.js");
include("js/ajax.js");




// Карусель продуктов
$(document).ready(function () {
    $("#carousel1").owlCarousel({
        items: 1,
        loop: true
    });
});

// Карусель фотографий
$(document).ready(function () {
    $("#carousel2").owlCarousel({
        items: 1,
        loop: true
        // ,
        // nav: true
    });
});
















