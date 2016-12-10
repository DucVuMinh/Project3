<%-- 
    Document   : customupdateinfuser
    Created on : 05-Dec-2016, 16:27:03
    Author     : DucVu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <script src="http://malsup.github.com/jquery.form.js"></script> 
    </head>

    <body id="#" data-spy="scroll" data-target=".navbar-fixed-top">
        <!-- Navigation -->
        <c:import url="http://localhost:8080/travel/customheader.htm" />
        <div class="container" style="padding-left:80px;padding-right:80px;padding-top:200px;padding-bottom:30px" >

            <ul class="nav nav-tabs" id="profile"style="margin-bottom:20px;color:#6f6f6e">
                <li class="active"><a data-toggle="tab" href="#home"  style="color:#1d508f">THÔNG TIN CÁ NHÂN</a></li>
            </ul>
            <div class="tab-content">
                <div id="home" class="tab-pane fade in active">
                    <div class="row">
                        <div class="col-lg-3">
                            <div class="username">Bilgate</div>
                            <div class="avatar">
                                <div class= "thumbnai" >

                                    <div class="avatar-border">
                                        <form method="POST" enctype="multipart/form-data" action="userupdateprofile" id="formprofile">
                                            <img src="img/default/bilgate.jpg" class="home-avatar" id="proimg">
                                            <div class="figure">
                                                <input id="upload" type="file" name="profile"/>
                                                <a href="#" id="upload_link"><div class="text" style="margin-top:223px"><i class="fa fa-camera-retro fa-lg"></i>  Thay avatar</div></a>
                                            </div> 
                                        </form>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="col-lg-9">
                            <div class="info-profile" ng-app="setuserinf" ng-controller="setuserinfctr">
                                <form  ng-submit="sendRequest()">
                                    <div class="form-group">
                                        <label>Full name: </label>
                                        <input type="text" class="form-control" id="fullname" placeholder="Enter full name" required="true" ng-model="fullname">
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
                                    <button type="submit" class="btn ">Đăng ký</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="menu1" class="tab-pane fade">

                    <center>

                    </center>

                </div>


            </div>
        </div>
    </div>

    <hr >

    <hr >
    <c:import url="http://localhost:8080/travel/customfooter.htm" />
    <!-- jQuery -->
    <!-- Bootstrap Core JavaScript -->
    <script src="client/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <!-- Google Maps API Key - Use your own API key to enable the map feature. More information on the Google Maps API can be found at https://developers.google.com/maps/ -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRngKslUGJTlibkQ3FkfTxj3Xss1UlZDA&sensor=false"></script>

    <!-- Theme JavaScript -->
    <script src="client/js/grayscale.min.js"></script>
    <script src="client/js/controller/CustomSetUserInf.js"></script>

</body>
<style>
    #upload_link{
        text-decoration:none;
    }
    #upload{
        display:none
    }

</style>
<script type="text/javascript">
                                                    $(function () {
                                                        $("#upload_link").on('click', function (e) {
                                                            e.preventDefault();
                                                            $("#upload:hidden").trigger('click');
                                                        });
                                                    });

</script>
<script>
    $(function () {
        $('#upload').change(function () {
            $('#formprofile').ajaxForm({
                success: function (msg) {
                    var pro=document.getElementById("proimg");
                    pro.setAttribute("src",msg);
                    alert(msg);
                }
            }).submit();
        });
    });
</script>
</html>
