var app = angular.module("geektic", ['ngRoute']);

app.config(function($routeProvider) {
	$routeProvider.when('/', 
		{templateUrl: 'views/main.html',
		controller: 'MainControl'}).
		when('/register', 
		{templateUrl: 'views/register.html',
		controller: 'RegisterControl'});
});

app.controller('MainControl', function($scope, $http) {
    $http.get('/api/geeks').success(function(geeks) {
        $scope.geeks = geeks;
    });
});

app.controller('RegisterControl', function($scope, $http) {
   
});