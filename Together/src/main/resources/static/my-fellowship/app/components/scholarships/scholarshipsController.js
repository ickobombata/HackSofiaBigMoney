myApp.controller("ScholarshipsController", function ($scope, $http, $rootScope, $location) {
    $scope.scholarships = $rootScope.scholarships;

    $http.get("http://localhost:8080/scholarships")
        .then(function (response) {
            $scope.scholarships = response.data;
            $scope.backupScholarships = response.data;
    });

    $scope.onlyRelevant = false;
    $scope.onlyWatched = false;

    $scope.toggleAll = function () {
        $scope.scholarships = $scope.backupScholarships;
        $scope.onlyRelevant = false;
        $scope.onlyWatched = false;
    };

    $scope.toggleRelevant = function () {
        var dataString = JSON.stringify({minBal: $rootScope.currentUser.person.grade, mentFor: $rootScope.currentUser.person.education});
        $scope.onlyRelevant = !$scope.onlyRelevant;
        $scope.onlyWatched = false;
        $http.get("http://localhost:8080/scholarships/getScholarshipsByBalAndProgram?data=" + dataString)
            .then(function(response){
                    $scope.scholarships = response.data;
            });
    };

    $scope.toggleWatched = function () {
        $scope.onlyRelevant = false;
        $scope.onlyWatched = !$scope.onlyWatched;

        var serviceUrl = "http://localhost:8080/watched/getschoolarships?data=";
        var userId = $rootScope.currentUser.id;
        var requestUrl = serviceUrl + userId;

        $http.get(requestUrl)
            .then(function success(response) {
                var watchedScholarships = [];
                angular.forEach(response.data, function(item){
                    var currentObj = $scope.backupScholarships.find(function(element){
                        console.log(element);
                        console.log(item);
                         return element.id == item;
                    });
                    if(currentObj){
                        watchedScholarships.push(currentObj);
                    }
                });
                $scope.scholarships = watchedScholarships;
                console.log($scope.scholarships);
            });
    };

    $scope.selectScholarship = function (scholarship) {
        $rootScope.currentScholarship = scholarship;
        $location.url("/scholarship");
    };
});