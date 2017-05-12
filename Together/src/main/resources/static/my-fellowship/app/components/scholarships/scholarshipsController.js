myApp.controller("ScholarshipsController", function ($scope, $http, $rootScope, $location) {
    $scope.scholarships = $rootScope.scholarships;

    $http.get("http://localhost:8080/scholarships")
        .then(function (response) {
            $scope.scholarships = response.data;
    });

    $scope.onlyRelevant = false;
    $scope.onlyWatched = false;

    $scope.toggleAll = function () {
        $scope.onlyRelevant = false;
        $scope.onlyWatched = false;
    };
    $scope.toggleRelevant = function () {
        $scope.onlyRelevant = !$scope.onlyRelevant;
        $scope.onlyWatched = false;
    };
    $scope.toggleWatched = function () {
       $scope.onlyWatched = !$scope.onlyWatched;
        $scope.onlyRelevant = false;
    };
    $scope.selectScholarship = function () {
        $location.url("/scholarship");
    };
});