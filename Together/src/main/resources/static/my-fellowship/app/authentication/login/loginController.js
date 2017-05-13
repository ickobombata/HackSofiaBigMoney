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
                var dataString = JSON.stringify({"username": $rootScope.currentUser.name});
                $http.get("http://localhost:8080/users/getUserInfo?data=" + dataString)
                    .then(function (response){
                        $rootScope.currentUser = response.data;
                        $rootScope.isUserLoggedIn = true;
                        $rootScope.loginModal.close();

                        $http.get("http://localhost:8080/watched/getschoolarships?data=" + $rootScope.currentUser.id)
                            .then(function success(response){
                                $rootScope.watchedUserScholarships = response.data;
                            }, function failure(response) {
                                $rootScope.watchedUserScholarships = [];
                            });

                        $http.get("http://localhost:8080/watched/getprograms?data=" + $rootScope.currentUser.id)
                            .then(function success(response){
                                $rootScope.userPrograms = response.data;
                            }, function failure(response) {
                                $rootScope.userPrograms = [];
                            });
                    })

            }, function failure(response) {
                $rootScope.currentUser = null;
                $rootScope.watchedUserScholarships = [];
                $rootScope.userPrograms = [];
                $scope.errorMessage = "Invalid credentials!";
            });
    };
});