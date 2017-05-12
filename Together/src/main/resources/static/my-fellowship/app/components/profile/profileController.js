myApp.controller("ProfileController", function($scope, $rootScope){
    console.log("Profile");
    console.log($rootScope.currentUser);
    $scope.currentUser = $rootScope.currentUser;
});