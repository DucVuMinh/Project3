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
    $scope.cusLogout = function () {
        var data = $.param({
            fName: $scope.username,
            lName: $scope.password
        });
        var strl = $scope.username + "|" + $scope.password;
        $http({
            method: 'POST',
            url: 'http://localhost:8080/travel/customhandlinglogout.htm',
            data: strl
        }).success(function (data, status, headers, config) {
            if (data === "username") {
                $scope.loginapp = true;
                $scope.logoutapp = true;
                $scope.createaccountapp = false;
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
});


