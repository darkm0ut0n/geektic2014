var app = angular.module("geektic", ['ngRoute']);

app.config(function($routeProvider) {
	$routeProvider.when('/', 
		{templateUrl: 'views/main.html',
		controller: 'MainControl'});
});

app.controller('MainControl', function($scope, $http) {
    $http.get('/api/geeks').success(function(geeks) {
        $scope.geeks = geeks;
    });
});



$http.post('/someUrl', data).success(successCallback);