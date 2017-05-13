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
        var min_bal = 4.50;
        var mfor = "ака";
        var data = JSON.stringify({minBal: min_bal, mentFor: mfor});
        $http.get("http://localhost:8080/getScholarshipsByBalAndProgram?data=" + data)
            .then(function(response){
                $scope.scholarships = response.data;
            });
        $scope.onlyRelevant = !$scope.onlyRelevant;
        $scope.onlyWatched = false;
    };
    $scope.toggleWatched = function () {
       $scope.onlyWatched = !$scope.onlyWatched;
        $scope.onlyRelevant = false;
    };
    $scope.selectScholarship = function (scholarship) {
        $rootScope.currentScholarship = scholarship;
        $location.url("/scholarship");
    };
});