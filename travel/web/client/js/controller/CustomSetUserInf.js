/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var app = angular.module('setuserinf', []);
app.controller('setuserinfctr', function ($scope, $http) {
    $scope.fullname;
    $scope.password;
    $scope.repassword;
    $scope.checkPasswordFormat = false;
    $scope.checkpassword = false;
    $scope.matchPass = false;
    $scope.initFullName=function(name){
        $scope.fullname=name;
    }
    $scope.checkpasswordfn = function () {
        var patt1 = /[0-9]+[A-Za-z]+/;
        var patt2 = /[A-Za-z]+[0-9]+/;
        var pass = $scope.password;
        $scope.checkpassword = !((patt1.test($scope.password) || patt2.test($scope.password)) && (('' + pass.length) > 7));

    };
    $scope.checkrepass = function () {
        if ($scope.password == $scope.repassword) {
            $scope.matchPass = false;
        } else {
            $scope.matchPass = true;
        }
    };
    $scope.checkUserInput = function () {
        $scope.checkPasswordFormat = /[-=+\s\\]/.test($scope.password);
    };
    $scope.sendRequest = function () {
        $scope.checkUserInput();
        $scope.checkrepass();
        $scope.checkpasswordfn();
        $scope.checkuser=false;
        $scope.checkemail=false;
        var strl=$scope.fullname+"|"+$scope.password;
       
        if (!($scope.checkPasswordFormat || $scope.checkpassword || $scope.matchPass)) {
            $http({
                method: 'POST',
                url: 'customupdateinf.htm',
                data: strl
            }).success(function (data, status, headers, config) {
                if(data!=null){
                    window.location=data;
                }
            }).error(function (data, status, headers, config) {
                alert("Network error");
            });
        }
    };
});