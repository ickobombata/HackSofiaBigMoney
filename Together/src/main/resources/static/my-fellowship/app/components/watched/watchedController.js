myApp.controller("WatchedController", function ($scope, $rootScope) {
    $scope.watchedItems = [];

    $rootScope.scholarships.forEach(function(element, index, array) {
        if(element.isWatched) {
            $scope.watchedItems.push(element);
        }
    });

    $rootScope.programs.forEach(function(element, index, array) {
        if(element.isWatched) {
            $scope.watchedItems.push(element);
        }
    });
});