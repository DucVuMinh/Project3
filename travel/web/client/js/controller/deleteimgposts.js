/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var clientLogin = angular.module("deleteimgposts", []);
clientLogin.controller("deleteimgpostsctr", function ($scope, $http, $location) {
    $scope.deleteimg = function (idimg) {
        $http({
            method: 'POST',
            url: 'deleteimgposts.htm',
            data: idimg
        }).success(function (data, status, headers, config) {
            var imgdelete = document.getElementById(idimg);
            imgdelete.style.visibility="hidden";

        }).error(function (data, status, headers, config) {
            alert("Network error");
        });
    };
    $scope.checkUserInput = function () {
        $scope.checkUsername = /[-=+\s\\]/.test($scope.username);
        $scope.checkPassword = /[=+\s\\]/.test($scope.password);

    };
});
