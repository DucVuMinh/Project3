/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var clientLogin = angular.module("deletefavorite", []);
clientLogin.controller("deletefavoritectr", function ($scope, $http, $location) {
    $scope.delfavorLand = function (idfavor) {
        alert("delete favor "+String(idfavor));
        var str="land_"+idfavor;
        $http({
            method: 'POST',
            url: 'deletefavor.htm',
            data: str
        }).success(function (data, status, headers, config) {
           
            if (data == "ok") {
                 alert(data);
                var favor = document.getElementById(str);
                favor.style.visibility = "hidden";
            }
        }).error(function (data, status, headers, config) {
            alert("Network error");
        });
    };
    $scope.delfavorFes  = function (idfavor) {
        alert("delete favor "+String(idfavor));
        var str="fes_"+idfavor;
        $http({
            method: 'POST',
            url: 'deletefavor.htm',
            data: str 
        }).success(function (data, status, headers, config) {
            alert(data);
            if (data == "ok") {
                
                var favor = document.getElementById(str);
                favor.style.visibility = "hidden";
            }
        }).error(function (data, status, headers, config) {
            alert("Network error");
        });
    };
    $scope.delfavorPost  = function (idfavor) {
        alert("delete favor "+String(idfavor));
        var str="posts_"+idfavor;
        $http({
            method: 'POST',
            url: 'deletefavor.htm',
            data: str 
        }).success(function (data, status, headers, config) {
            alert(data);
            if (data == "ok") {
                
                var favor = document.getElementById(str);
                favor.style.visibility = "hidden";
            }
        }).error(function (data, status, headers, config) {
            alert("Network error");
        });
    };
    $scope.checkUserInput = function () {
        $scope.checkUsername = /[-=+\s\\]/.test($scope.username);
        $scope.checkPassword = /[=+\s\\]/.test($scope.password);

    };
});
