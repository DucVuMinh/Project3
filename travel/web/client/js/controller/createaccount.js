/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var app = angular.module('creataccout', []);
app.controller('creatctr', function ($scope, $http) {
    $scope.fullname;
    $scope.username;
    $scope.password;
    $scope.repassword;
    $scope.email;
    $scope.checkuser = false;
    $scope.checkemail = false;
    $scope.checkUsernameLocal = false;
    $scope.checkPasswordFormat = false;
    $scope.checkpassword = false;
    $scope.matchPass = false;
    $scope.checkpasswordfn = function () {
        var patt1 = /\d\w/;
        var patt2 = /\w\d/;
        var pass = $scope.password;
        $scope.checkpassword = !((patt1.test($scope.password) || patt2.test($scope.password)) && (('' + pass.length) > 8));

    };
    $scope.checkrepass = function () {
        if ($scope.password == $scope.repassword) {
            $scope.matchPass = false;
        } else {
            $scope.matchPass = true;
        }
    };
    $scope.checkUserInput = function () {
        $scope.checkUsernameLocal = /[-=+\s\\]/.test($scope.username);
        $scope.checkPasswordFormat = /[-=+\s\\]/.test($scope.password);
    };
    $scope.sendRequest = function () {
        $scope.checkUserInput();
        $scope.checkrepass();
        $scope.checkpasswordfn();
        $scope.checkuser=false;
        $scope.checkemail=false;
        var strl=$scope.fullname+"|"+$scope.username+"|"+$scope.password+"|"+$scope.email;
       
        if (!($scope.checkUsernameLocal || $scope.checkPasswordFormat || $scope.checkpassword || $scope.matchPass)) {
            
            $http({
                method: 'POST',
                url: 'http://localhost:8080/travel/customhandlingcreateaccount.htm',
                data: strl
            }).success(function (data, status, headers, config) {
                if (data === "username") {
                    $scope.checkuser = true;
                } else if (data === "email") {
                    $scope.checkemail = true;
                } else {
                    window.location = data;
                }
                
            }).error(function (data, status, headers, config) {
                alert("Network error");
            });
        }
    };
});