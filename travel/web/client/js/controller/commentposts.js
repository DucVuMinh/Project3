/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var comment=angular.module('commentposts',[]);
comment.controller('commentpostsctr',function($scope, $http,$location){
    $scope.content;
    $scope.sendComment=function(){
        alert('begin');
        var idposts = $location.absUrl().split('?')[1].split('=')[1];
        var strl=idposts+'|'+$scope.content;
        alert(strl);
        $http({
            method: 'POST',
            url: 'http://localhost:8080/travel/customhandlingcomment.htm',
            data: strl
        }).success(function (data, status, headers, config) {
            alert(data);
            if (data === "login") {
                alert('login to comment');
            }else {
                $scope.insertComment(data);
                $scope.content="";
            }
        }).error(function (data, status, headers, config) {
            alert("Network error");
        });
    };
    $scope.insertComment=function(data){
        var nodeComment=document.getElementById("comment-of-post");
        var arr=data.split("|");
        var noderow = document.createElement("div");
        noderow.setAttribute("class","row");
        var nodecolumn = document.createElement("div");
        nodecolumn.setAttribute("class","col-lg-11");
        
        var nodeusername=document.createElement("div");
        var username = document.createTextNode(arr[0]);
        nodeusername.appendChild(username);
        nodeusername.setAttribute("class", "username");
        
        var nodeContent=document.createElement("div");
        var content = document.createTextNode(arr[1]);
        nodeContent.appendChild(content);
        nodeContent.setAttribute("class", "content-comment");
        nodecolumn.appendChild(nodeusername);
        nodecolumn.appendChild(nodeContent);
        noderow.appendChild(nodecolumn);
        nodeComment.appendChild(noderow);
    };
});