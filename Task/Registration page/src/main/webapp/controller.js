var app = angular.module("app",  ['ngRoute']);

app.config(function($routeProvider) {
    $routeProvider
        .when('/view1', {
            templateUrl: 'register.jsp',
            controller: 'FirstController'
        })
        .when('/view2', {
            templateUrl: 'success.html',
            controller: 'SecondController'
        })
        .otherwise({
            redirectTo: '/view1'
        });
});

app.controller("registerController",function($scope, $http) {
					$scope.registerID = "";
					$scope.userDetail = {};
					$scope.UUID="";
					$scope.items = [];
					$scope.educationDetail = [];
					$scope.resultMessage="";
					$scope.result={};
					$scope.generateID = function() {
						var response = $http
								.get('/WebAPP/webservice/for/generateID');
						response.success(function(data) {
						
							$scope.registerID = data;
						})
						response.error(function(data, status, headers, config) {
							$scope.registerID = "";
						})
					};

					$scope.generateUUID = function() {
						var response = $http
								.get('/WebAPP/webservice/for/generateUUID');
						response.success(function(data) {
							$scope.userDetail.uniqueId=data.uuid;
							console.log(data);
						})
						response.error(function(data, status, headers, config) {
							alert("success");

						})

					};

					$scope.add = function() {
						$scope.items.push({
							course : "",
							college : "",
							yearOfPass : "",
							percentage : ""
						});
					};

					$scope.remove = function(index) {
						$scope.items.splice(index, 1);
					}
					$scope.reloadPage = function() {
						$scope.reloadPage = function() {
							window.location.reload();
						}
					}

					$scope.collectData = function() {
						if (angular
								.isUndefined($scope.userDetail.permanentAddress))
							$scope.userDetail.permanentAddress = $scope.userDetail.communicationAddress;

						$scope.userDetail.educationDetails = $scope.items;
						$scope.userDetail.registerID = $scope.registerID;

						console.log($scope.userDetail);
						var userData = JSON.stringify($scope.userDetail);
						console.log(userData);
						var res = $http.post(
								'/WebAPP/webservice/for/userDetail', userData);
						res.success(function(data, status, headers, config) {
							
							$scope.result=data;
							$scope.resultMessage="Your details are successfully inserted.<a href=\"/success.jsp\">"
								$scope.reloadPage = function() {
								window.location.reload();
							}
						});
						res.error(function(data, status, headers, config) {
		                    $window.location.href = '/failure.jsp';

						});
					}
				});
