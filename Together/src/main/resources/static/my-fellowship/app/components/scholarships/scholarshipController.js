myApp.controller("ScholarshipController", function ($scope, $rootScope, $http) {
    $scope.scholarship = $rootScope.currentScholarship;
    var deadline = $scope.scholarship.endDate;

    $scope.watch = function () {
        var serviceUrl = "http://localhost:8080/watched/addwatch?data=";
        var userId = $rootScope.currentUser.id;
        var programId = null;
        var scholarshipId = $scope.scholarship.id;
        var watchedId = Math.floor(Math.random() * 20000) + 1;
        var watchedObject = {user_id: userId, program_id: programId, schoolarship_id: scholarshipId, id: watchedId};
        var watchedString = JSON.stringify(watchedObject);
        var requestUrl = serviceUrl + watchedString;

         $http.get(requestUrl)
             .then(function success(response) {
                 $rootScope.watchedUserScholarships.push(scholarshipId);
                 console.log("Successful watch");
             }, function failure(response) {
                 console.log("Failed watch");
             })
    };

    function time_remaining(endtime) {
        var t = Date.parse(endtime) - Date.parse(new Date());
        var seconds = Math.floor((t / 1000) % 60);
        var minutes = Math.floor((t / 1000 / 60) % 60);
        var hours = Math.floor((t / (1000 * 60 * 60)) % 24);
        var days = Math.floor(t / (1000 * 60 * 60 * 24));
        return { 'total': t, 'days': days, 'hours': hours, 'minutes': minutes, 'seconds': seconds };
    }
    function run_clock(id, endtime) {
        var clock = document.getElementById(id);

        // get spans where our clock numbers are held
        var days_span = clock.querySelector('.days');
        var hours_span = clock.querySelector('.hours');
        var minutes_span = clock.querySelector('.minutes');
        var seconds_span = clock.querySelector('.seconds');

        function update_clock() {
            var t = time_remaining(endtime);

            // update the numbers in each part of the clock
            days_span.innerHTML = t.days;
            hours_span.innerHTML = ('0' + t.hours).slice(-2);
            minutes_span.innerHTML = ('0' + t.minutes).slice(-2);
            seconds_span.innerHTML = ('0' + t.seconds).slice(-2);

            if (t.total <= 0) {
                clearInterval(timeinterval);
                days_span.innerHTML = '0';
                hours_span.innerHTML = '0';
                minutes_span.innerHTML = '0';
                seconds_span.innerHTML = '0';
            }
        }
        update_clock();
        var timeinterval = setInterval(update_clock, 1000);
    }
    run_clock('clockdiv', deadline);
});