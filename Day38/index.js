angular.module("AppMod", ["ngRoute"])
	.controller("AppCtrl", ['$http', function($http) {
		var self = this;

		$http.get('http://localhost:8080/student')
			.then(function(resp){
				self.students = resp.data;
			},function(err) {

			});

	}])
	.config(['$routeProvider', function($routeProvider) {

		$routeProvider
		.when('/', {
			templateUrl: 'home.html'

		}).when('/student', {
			templateUrl: 'student.html',
			controller: 'AppCtrl',
			controllerAs: 'ctrl'

		}).when('/about', {
			templateUrl: 'about.html'

		})
		.otherwise({redirectTo: '/'});

	}]); // end config