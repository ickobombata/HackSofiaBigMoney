myApp.filter("isWatched", function () {
    return function (input, scope) {
        var searchForWatched = false;
        if(scope == undefined || scope == null) {
            searchForWatched = true;
        } else {
            searchForWatched = scope.onlyWatched;
        }

        if(searchForWatched) {
            var watchedArray = [];
            angular.forEach(input, function (item) {
                if(item.isWatched) {
                    watchedArray.push(item);
                }
            });

            return watchedArray;
        } else {
            return input;
        }
    }
});

myApp.filter("isRelevant", function () {
    return function (input, scope) {
        if(scope.onlyRelevant) {
            var relevantArray = [];
            angular.forEach(input, function (item) {
                if(item.isRelevant) {
                    relevantArray.push(item);
                }
            });

            return relevantArray;
        } else {
            return input;
        }
    }
});