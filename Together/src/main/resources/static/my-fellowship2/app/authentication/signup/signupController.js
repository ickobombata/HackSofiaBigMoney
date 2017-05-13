myApp.controller("SignupController", function ($scope, $http, $rootScope) {
    $scope.errorMessage = null;
    $scope.signup = function () {
        console.log($scope.mode);
        var serviceUrl = "http://localhost:8080/users/signup?data=";
        var ID_KEY = Math.floor(Math.random() * 10000) + 1;
        var userObject = {id: ID_KEY, username: $scope.signupUsername, password: $scope.signupPassword, type: $scope.mode};
        var userString = JSON.stringify(userObject);
        var requestUrl = serviceUrl + userString;

        $http.get(requestUrl)
            .then(function success(response) {
                $rootScope.currentUser = response.data;
                $rootScope.isUserLoggedIn = true;
                $rootScope.signupModal.close();
            }, function failure(response) {
                $rootScope.currentUser = null;
                $scope.errorMessage = "Invalid credentials!";
            });
    };
});