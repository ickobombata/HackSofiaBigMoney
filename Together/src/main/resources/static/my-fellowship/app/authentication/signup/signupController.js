myApp.controller("SignupController", function ($scope, $http, $rootScope) {
    $scope.errorMessage = null;
    $scope.signup = function () {
        var serviceUrl = "http://localhost:8080/users/signup?data=";
        var ID_KEY = 10000;
        var userObject = {id: ID_KEY, name: $scope.signupUsername, password: $scope.signupPassword};
        var userString = JSON.stringify(userObject);
        var requestUrl = serviceUrl + userString;

        $http.get(requestUrl)
            .then(function success(response) {
                $rootScope.currentUser = response.data;
                $rootScope.signupModal.close();
            }, function failure(response) {
                $rootScope.currentUser = null;
                $scope.errorMessage = "Invalid credentials!";
            });
    };
});