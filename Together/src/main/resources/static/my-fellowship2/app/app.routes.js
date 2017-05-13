myApp.config(function ($routeProvider) {
    $routeProvider
        .when("/",
            {
                controller: "HomeController",
                templateUrl: "app/components/home/home.html"
            })
        .when("/indexSignup",
            {
                controller: "HomeSingupController",
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
        .when("/program",
            {
                controller: "ProgramController",
                templateUrl: "app/components/programs/program.html"
            })
        .when("/watched",
            {
                controller: "WatchedController",
                templateUrl: "app/components/watched/watched.html"
            })
        .when("/profile",
            {
                controller: "ProfileController",
                templateUrl: "app/components/profile/profile.html"
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