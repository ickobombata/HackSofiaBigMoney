myApp.controller("ScholarshipsController", function ($scope, $rootScope, $location) {
    $scope.scholarships = $rootScope.scholarships;

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