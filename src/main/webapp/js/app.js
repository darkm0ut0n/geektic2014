var app = angular.module("geektic", ['ngRoute']);

app.config(function($routeProvider) {
	$routeProvider.when('/', 
		{templateUrl: 'views/main.html',
		controller: 'MainControl'});
});

app.controller('MainControl', function($scope, $http) {
	
    $scope.submitSearchForm = function() {
    	var serviceUrl = '/api/geeks/interest';
    	$http({
    		url: serviceUrl, 
    		method: "GET",
    		params: {sex:$scope.sex, interest:$scope.interest}
    	}).success(function(geeks) {
    		$scope.geeks = geeks;
    	});
    };
    
    $scope.likeProfil = function(geek) {
    	
    	 var serviceUrl = '/api/geeks/'+geek.id;
    	 
    	 $http.put(serviceUrl).success(function(newScore) {
    		 
    		 //predicat de filtre par id
    		 function elementHasId(element) {
    			  return element.id == geek.id;
    		 };
    		 
    		 $scope.geeks.filter(elementHasId).forEach(function(element) {
    			 element.consulted = newScore;
    		 });
    	 });
    };
});
