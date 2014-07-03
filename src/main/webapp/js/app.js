var app = angular.module("geektic", ['ngRoute']);

app.controller('GeekCtrl', function($scope, $http) {
    $http.get('/geek/interets').success(function(interets) {
        $scope.interets = interets;
    });
        
    $scope.chercher = function() {
    	$http.get('/geek/'+$scope.sexe+'/'+$scope.interet.num)
    	.success(function(geeks) {
    		$scope.geeks = geeks;
    	});
    };
});

app.controller('DetailsCtrl', function($scope, $http, $routeParams) {
	$http.get('/geek/'+$routeParams.id).success(function(geek) {
		$scope.geek = geek;
	});
});

app.config(function($routeProvider){
	$routeProvider
	.when('/', {
		  templateUrl: 'index.html',
		  controller: 'GeekCtrl'
		})
	.when('/geek/:id', {
	  templateUrl: 'details.html',
	  controller: 'DetailsCtrl'
	})
});