var myApp = angular.module("myApp", ["ngRoute", "ui.bootstrap"]);

myApp.run(function ($rootScope, $uibModal) {
    $rootScope.isUserLoggedIn = false;
    $rootScope.scholarships = [
        {name: "EU scholarship 1", deadline: "June 1, 2017", isRelevant: true, isWatched: true},
        {name: "EU scholarship 2", deadline: "June 18, 2017", isRelevant: false, isWatched: false},
        {name: "EU scholarship 3", deadline: "July 13, 2017", isRelevant: false, isWatched: false},
        {name: "EU scholarship 4", deadline: "August 23, 2017", isRelevant: true, isWatched: true},
        {name: "EU scholarship 5", deadline: "August 30, 2017", isRelevant: false, isWatched: true}
    ];
    $rootScope.programs = [
        {name: "EU program 1", deadline: "June 1, 2017", isRelevant: false, isWatched: false},
        {name: "EU program 2", deadline: "June 10, 2017", isRelevant: true, isWatched: false},
        {name: "EU program 3", deadline: "June 23, 2017", isRelevant: true, isWatched: false},
        {name: "EU program 4", deadline: "July 12, 2017", isRelevant: false, isWatched: true}
    ];

    $rootScope.calculateDaysLeft = function (dueDate) {
        var oneDay = 24*60*60*1000;	// hours*minutes*seconds*milliseconds

        var firstDate = new Date();
        var secondDate = new Date(dueDate);
        var diffDays = Math.round((secondDate - firstDate) / oneDay);

        return diffDays;
    };

    $rootScope.openSignup = function () {
        $rootScope.signupModal = $uibModal.open({
            templateUrl: "app/components/signup/signup.html",
            controller: "SignupController"
        });
    };
});

myApp.filter("isWatched", function () {
    return function (input, scope) {
        var searchForWatched = false;
        if(scope == undefined || scope == null) {
            searchForWatched = true;
        } else {
            searchForWatched = scope.onlyWatched;
        }

        if(searchForWatched) {
            var watchedArray = [];
            angular.forEach(input, function (item) {
                if(item.isWatched) {
                    watchedArray.push(item);
                }
            });

            return watchedArray;
        } else {
            return input;
        }
    }
});

myApp.filter("isRelevant", function () {
    return function (input, scope) {
        if(scope.onlyRelevant) {
            var relevantArray = [];
            angular.forEach(input, function (item) {
                if(item.isRelevant) {
                    relevantArray.push(item);
                }
            });

            return relevantArray;
        } else {
            return input;
        }
    }
});
