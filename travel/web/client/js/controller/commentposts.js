/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var comment = angular.module('commentposts', []);
comment.controller('commentpostsctr', function ($scope, $http, $location) {
    $scope.content;
    $scope.sendComment = function () {
        var idposts = $location.absUrl().split('?')[1].split('=')[1];
        var strl = idposts + '|' + $scope.content;
        $http({
            method: 'POST',
            url: 'http://localhost:8080/travel/customhandlingcomment.htm',
            data: strl
        }).success(function (data, status, headers, config) {
            if (data === "login") {
                var popup = document.getElementById('logincomment');
                popup.classList.toggle('show');
                $scope.content = "";
            } else if (data === "waitadmin") {
                var popup = document.getElementById('waitadmincomment');
                popup.classList.toggle('show');
                $scope.content = "";
            } else {
                $scope.insertComment(data);
                $scope.content = "";
            }
        }).error(function (data, status, headers, config) {
            alert("Network error");
            $scope.content = "";
        });
    };
    $scope.insertComment = function (data) {
        var nodeComment = document.getElementById("comment-of-post");
        var arr = data.split("|");
        var noderow = document.createElement("div");
        noderow.setAttribute("class", "row");
        var nodecolumn1=document.createElement("div");
        nodecolumn1.setAttribute("class", "col-lg-1");
        var link=document.createElement("a");
        var profile=document.createElement("img");
        var linkprofile="http://localhost:8080/travel/img/users/profile/"+arr[2]+".png";
        profile.setAttribute("src", linkprofile);
        profile.setAttribute("class", "img2");
        link.appendChild(profile);
        nodecolumn1.appendChild(link);
        var nodecolumn = document.createElement("div");
        nodecolumn.setAttribute("class", "col-lg-11");
        var nodeusername = document.createElement("div");
        var username = document.createTextNode(arr[0]);
        nodeusername.appendChild(username);
        nodeusername.setAttribute("class", "username");
        var nodeContent = document.createElement("div");
        var content = document.createTextNode(arr[1]);
        nodeContent.appendChild(content);
        nodeContent.setAttribute("class", "content-comment");
        nodecolumn.appendChild(nodeusername);
        nodecolumn.appendChild(nodeContent);
        noderow.appendChild(nodecolumn1);
        noderow.appendChild(nodecolumn);
        nodeComment.appendChild(noderow);
    };
});

angular.element(document).ready(function () {
    angular.bootstrap(document.getElementById("writepost"), ['commentposts']);
});