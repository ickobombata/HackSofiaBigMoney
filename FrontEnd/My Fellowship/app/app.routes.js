myApp.config(function ($routeProvider) {
    $routeProvider
        .when("/index",
            {
                templateUrl: "app/components/home/home.html"
            })
        .when("/scholarships",
            {
                controller: "ScholarshipsController",
                templateUrl: "app/components/scholarships/scholarships.html"
            })
        .when("/scholarship",
            {
                controller: "ScholarshipController",
                templateUrl: "app/components/scholarships/scholarship.html"
            })
        .when("/programs",
            {
                controller: "ProgramsController",
                templateUrl: "app/components/programs/programs.html"
            })
        .when("/watched",
            {
                controller: "WatchedController",
                templateUrl: "app/components/watched/watched.html"
            })
        .when("/about",
            {
                templateUrl: "app/components/about/about.html"
            })
        .when("/error",
            {
                templateUrl: "app/components/error/error.html"
            }
        )
        .otherwise({ redirectTo: "/error"});
});