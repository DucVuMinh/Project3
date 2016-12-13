<%-- 
    Document   : login
    Created on : 19-Nov-2016, 10:38:56
    Author     : DucVu
--%>

<%@page import="travel.controller.APIWrapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>S-travel</title>

        <!-- Bootstrap Core CSS -->
        <link href="client/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- Custom Fonts -->
        <link href="client/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">

        <!-- Theme CSS -->
        <link href="client/css/grayscale.css" rel="stylesheet">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    </head>
    <body>
        <!-- Modal --> <!-- Modal content-->

        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header1">

                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title"><center>Đăng nhập</center></h4>

                    <div class="modal-body"  ng-app="clientLogin" ng-controller="clientLoginCtrl">
                        <form ng-submit="cusLogin()">

                            <div class="form-group">
                                <label for="email">Username:</label>
                                <input class="form-control" id="username" placeholder="Enter username"
                                       ng-model="username" required="true" ng-keypress="checkUserInput()" >
                                <span ng-show="checkUsername">username not contain characters:|,\,-,=,+</span>
                            </div>
                            <div class="form-group">
                                <label for="pwd">Password:</label>
                                <input type="password" class="form-control" id="password" placeholder="Enter password"
                                       ng-model="password"  ng-keypress="checkUserInput()" required="true">
                                <span ng-show="checkPassword">password not contain characters:|,\,,-,=,+</span>
                            </div>
                            <div class="checkbox">
                                <label><input type="checkbox"> Remember me</label>
                            </div>
                            <button type="submit" class="btn btn-default" >Đăng nhập</button>
                            <span ng-show="disFalse">{{loginFalse}}</span>
                            <button type="button" class="btn btn-primary" style="width: 49%;" onclick="loginFB()">
                                <i class="fa fa-facebook-official" aria-hidden="true" style="margin-right: 5px;"></i>
                                Đăng nhập với Facebook
                            </button>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </body>
    <script src="client/js/controller/ClientLogin.js"></script>
    <script>
        function loginFB() {
            window.location.href = "<%= APIWrapper.getDialogLink()%>";
        }
    </script>
</html>