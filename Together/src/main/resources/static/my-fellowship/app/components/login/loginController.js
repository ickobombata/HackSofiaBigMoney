myApp.controller("LoginController", function ($scope, $http, $rootScope) {
    $scope.errorMessage = null;
    $scope.login = function () {
        var serviceUrl = "http://localhost:8080/users/login?data=";
        var userObject = {username: $scope.loginName, password: $scope.loginPassword};
        var userString = JSON.stringify(userObject);
        var requestUrl = serviceUrl + userString;
        
        $http.get(requestUrl)
            .then(function success(response) {
                $rootScope.currentUser = response.data;
                $rootScope.loginModal.close();
            }, function failure(response) {
                $rootScope.currentUser = null;
                $scope.errorMessage = "Invalid credentials!";
            });
    };
});