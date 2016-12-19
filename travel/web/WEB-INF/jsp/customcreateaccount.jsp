<%-- 
    Document   : customcreateaccount
    Created on : 21-Nov-2016, 15:54:54
    Author     : DucVu
--%>

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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    </head>
    <body>
        <div class="modal-dialog" id="signup-dialog">
            <!-- Modal --> <!-- Modal content-->
            <div class="modal-content" id="signup_content">
                <div class="modal-header" id="signup_header">
                    <!--<button type="button" class="close" data-dismiss="modal">&times;</button>-->
                    <h4 class="modal-title" style="margin-top: 20px;"><center>Đăng ký</center></h4>
                    <div class="modal-body" ng-app="creataccout" ng-controller="creatctr">
                        <form  ng-submit="sendRequest()">
                            <div class="form-group">
                                <label>Full name: </label>
                                <input type="text" class="form-control" id="fullname" placeholder="Enter full name" required="true" ng-model="fullname">
                            </div>
                            <div class="form-group">
                                <label>Username:</label>
                                <input type="text" class="form-control" id="username" placeholder="Enter username" ng-change="checkUserInput()" required="true" ng-model="username">
                                <font color="red">
                                <span ng-show="checkuser" color="red">Username đã có người dùng</span>
                                <span ng-show="checkUsernameLocal" >username không chứa các kí tự:|,\,",',-,=,+</span>
                                </font>
                            </div>
                            <div class="form-group">
                                <label for="pwd">Password:</label>
                                <input type="password" class="form-control" id="pwd" placeholder="Enter password" ng-keypress="checkUserInput()" ng-change="checkpasswordfn()" required="true" ng-model="password">
                                <font color="red">
                                <span ng-show="checkpassword">Ít nhất 8 kí tự, gồm chữ cái và số</span>
                                <span ng-show="checkPasswordFormat">password không được chứa các kí tự:|,\,",',-,=,+</span>
                                </font>

                            </div>
                            <div class="form-group">
                                <label for="pwd">Nhập lại Password:</label>
                                <input type="password" class="form-control" id="repwd" placeholder="Enter password" required="true" ng-model="repassword" ng-change="checkrepass()" >
                                <font color="red">
                                <span ng-show="matchPass">không khớp mật khẩu</span>
                                </font>

                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" class="form-control" id="email" placeholder="Enter Email" required="true" ng-model="email">
                                <font color="red">
                                <span ng-show="checkemail" color="red">email đã có người dùng</span>
                                </font>

                            </div>
                            <center style="margin-top: 25px;"><button type="submit" class="btn btn-info" style="width: 100px;">Đăng ký</button></center>
                                <p class="login-signup">Bạn đã có tài khoản?   <a href="customlogin.htm">Đăng nhập</a></p>
                        </form>
                    </div>
                </div>

            </div>
        </div>
        <script src="client/js/controller/createaccount.js"></script>
    </body>

</html>