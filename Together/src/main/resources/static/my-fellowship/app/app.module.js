var myApp = angular.module("myApp", ["ngRoute", "ui.bootstrap"]);

myApp.run(function ($rootScope, $uibModal) {
    $rootScope.isUserLoggedIn = false;
    $rootScope.currentUser = null;

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

        return (diffDays >= 0) ? diffDays : "PASSED";
    };
    $rootScope.isFollowed = function (currentScholarshipId){
        return $rootScope.watchedUserScholarships.some(function(scholarshipId){
            return scholarshipId == currentScholarshipId;
        });
    };
    $rootScope.openSignup = function () {
        $rootScope.signupModal = $uibModal.open({
            templateUrl: "app/authentication/signup/signup.html",

            controller: "SignupController"
        });
    };
    $rootScope.openLogin = function () {
        $rootScope.loginModal = $uibModal.open({
            templateUrl: "app/authentication/login/login.html",
            controller: "LoginController"
        });
    };
    $rootScope.signout = function () {
        $rootScope.isUserLoggedIn = false;
        $rootScope.currentUser = null;
    };
});


