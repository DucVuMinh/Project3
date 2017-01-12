/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var clientLogin = angular.module("headerapp", []);
clientLogin.controller("headerctr", function ($scope, $http, $location) {
    $scope.loginapp = "";
    $scope.logoutapp = "";
    $scope.createaccountapp = "";
    $scope.datasearch="";
    $scope.cusLogout = function () {
        var strl = "logout";
        $http({
            method: 'POST',
            url: 'customhandlinglogout.htm',
            data: strl
        }).success(function (data, status, headers, config) {
            if (data ==1) {
                $scope.loginapp = true;
                $scope.logoutapp = false;
                $scope.createaccountapp = true;
            }
        }).error(function (data, status, headers, config) {
            alert("Network error");
        });
    };
    $scope.int = function (var1, var2, var3) {
        $scope.loginapp = var1;
        $scope.logoutapp = var2;
        $scope.createaccountapp = var3;
    };
    $scope.search =function(){
        var url="customresultsearch.htm?query="+$scope.datasearch;
        window.location=url;
    };
    
});
clientLogin.directive('myEnter', function () {
    return function (scope, element, attrs) {
        element.bind("keydown keypress", function (event) {
            if(event.which === 13) {
                scope.$apply(function (){
                    scope.$eval(attrs.myEnter);
                });

                event.preventDefault();
            }
        });
    };
});


