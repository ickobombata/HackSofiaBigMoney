myApp.controller("HomeController", function ($scope, $rootScope) {
    $('.service-box').hide();
    $(window).scroll(function() {
        if ($(window).scrollTop() > 20) {
            $('.service-box').show(2000);
        }
    });
});