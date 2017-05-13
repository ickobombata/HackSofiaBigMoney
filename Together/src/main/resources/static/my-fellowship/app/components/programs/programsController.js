myApp.controller("ProgramsController", function ($scope, $http, $rootScope, $location) {

    $scope.programs = $rootScope.programs;
    $http.get("http://localhost:8080/programs/getPrograms")
        .then(function (response) {
            $scope.programs = response.data;
        });

    $scope.tableHeading = undefined;

    $scope.onlyIndividual = false;
    $scope.onlyLegalEntity = false;

    $scope.onlyRelevant = false;
    $scope.onlyWatched = false;

    $scope.toggleIndividualButton = function () {
        if($scope.onlyIndividual == undefined) {
            $scope.onlyIndividual = true;
        } else {
            $scope.onlyIndividual = !$scope.onlyIndividual;
        }

        if($scope.onlyIndividual) {
            $scope.onlyLegalEntity = false;
        }
        $scope.toggleTableHeading();
    };

    $scope.toggleLegalEntityButton = function () {
        if($scope.onlyLegalEntity == undefined) {
            $scope.onlyLegalEntity = true;
        } else {
            $scope.onlyLegalEntity = !$scope.onlyLegalEntity;
        }

        if($scope.onlyLegalEntity) {
            $scope.onlyIndividual = false;
        }
        $scope.toggleTableHeading();
    };

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

    $scope.toggleTableHeading = function () {
        if($scope.onlyIndividual) {
            $scope.tableHeading = "Individual programs";
        } else if ($scope.onlyLegalEntity) {
            $scope.tableHeading = "Legal Entity programs";
        } else {
            $scope.tableHeading = undefined;
        }
    };

    $scope.getProgramFilterType = function () {
        if($scope.onlyIndividual) {
            return "Individual";
        } else if ($scope.onlyLegalEntity) {
            return "Legal Entity";
        } else {
            return "";
        }
    };
    $scope.selectProgram = function(program){
        $rootScope.currentProgram = program;
        $location.url("/program");
    };
});