myApp.filter("isWatched", function () {
    return function (input, scope) {
        if(scope.onlyWatched) {
            var filteredArray = [];
            angular.forEach(input, function (item) {
                if(item.isWatched) {
                    filteredArray.push(item);
                }
            });

            return filteredArray;
        } else {
            return input;
        }
    }
});

myApp.filter("isRelevant", function () {
    return function(input, scope) {
        if(scope.onlyRelevant) {
            var filteredArray = [];
            angular.forEach(input, function (item) {
                if(item.isRelevant) {
                    filteredArray.push(item);
                }
            });

            return filteredArray;
        } else {
            return input;
        }
    }
});

myApp.filter("programType", function () {
    return function(input, type) {
        var filteredArray = [];
        angular.forEach(input, function (item) {
            if(item.type == type)  {
                filteredArray.push(item);
            }
        });

        return filteredArray;
    }
});