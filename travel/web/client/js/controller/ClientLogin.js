/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var clientLogin = angular.module("clientLogin", []);
clientLogin.controller("clientLoginCtrl", function ($scope, $http, $location) {
    $scope.username = "";
    $scope.password = "";
    $scope.loingFalse = "";
    $scope.disFalse = false;
    $scope.checkUsername = false;
    $scope.checkPassword = false;
    $scope.cusLogin = function () {
        var data = $.param({
            fName: $scope.username,
            lName: $scope.password
        });
        var strl = $scope.username + "|" + $scope.password;
        $http({
            method: 'POST',
            url: 'customhandlinglogin.htm',
            data: strl
        }).success(function (data, status, headers, config) {
            if (data === "username") {
                $scope.disFalse = true;
                $scope.loginFalse = "Sai Username";
            } else if (data === "password") {
                $scope.disFalse = true;
                $scope.loginFalse = "Sai mật khẩu";
            } else if (data === "lock") {
                $scope.disFalse = true;
                $scope.loginFalse = "Tài khoản đã bị khóa";
                bootbox.confirm({
                    message: "Tài khoản của bạn đã bị khóa, bạn muốn xem chi tiết?",
                    callback: function (result) {
                        if (result)
                            window.location = "suppostlock.htm";
                    }
                });
            } else {
                window.location = data;
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


