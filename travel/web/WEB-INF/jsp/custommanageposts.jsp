<%-- 
    Document   : custommanageposts
    Created on : Dec 11, 2016, 10:29:40 AM
    Author     : ducvu
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
        <!-- Custom Fonts -->
        <link href="client/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- Theme CSS -->
        <link rel="stylesheet" href="client/css/popup.css">
        <link href="client/css/grayscale.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="client/js/controller/deletepost.js"></script>

    </head>

    <body  data-spy="scroll" data-target=".navbar-fixed-top">

        <%@ include file = "customheader.jsp" %>


        <div class="container" style="padding-top:230px;padding-bottom:30px" >
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                <button type="button" data-toggle="modal" data-target="#myModal1" class="button-modal"><a href="writeposts.htm">Chia sẻ trải nghiệm</a></button>
            </div>
            <ul class="nav nav-tabs" id="profile"style="margin-bottom:20px;color:#6f6f6e">

                <li class="active"><a data-toggle="tab" href="#lposts" style="color:#1d508d">Bài viết đã đăng</a></li>

            </ul>


            <div class="tab-content">

                <div id="lposts" class="tab-pane fade in active">
                    <div id= "information-product"style="color:#898989; text-align:justify">
                        <c:forEach var="p" items="${listp}">
                            <div class="post" id="${p.id}">
                                <a href="customposts.htm?id=${p.id}">
                                    <img  src="${p.profile}" class="image"alt="tin tức" class="menu-picture">
                                    <span class="title">${p.title}</span>
                                    <span style="font-size:10px;color:#7d7d7d">
                                        <div class="content-post-hidden">${p.context}</div></span>
                                </a>
                                <div class="left"><p>${user}<img src="img/default/add.png" alt="time"> ${p.date}</p></div><br>
                                <div class="line-first">
                                    <div class="right" style=" padding-right: 1cm; padding-left: 1cm;">
                                        <a href="customeditposts.htm?id=${p.id}">
                                            <button class="button-modal" >Chỉnh sửa</button>
                                        </a>
                                    </div>

                                    <div class="right ">
                                        <div class="popup" id="pop">
                                            <span class="popuptext" id="loginrating">Đăng nhập để thực hiện chức năng này</span>
                                            <span class="popuptext" id="errorpage">lỗi trang, hãy reload lại trang web</span>
                                            <span class="popuptext" id="waitadmin">bài viết đang chờ admin phê duyệt</span>
                                        </div>
                                        <button id="bt_${p.id}" class="button-modal deletepost">Xoá</button>
                                    </div>


                                </div>
                            </div>
                        </c:forEach> 

                    </div>

                </div>
            </div>
        </div>

        <hr >
        <c:import url="http://localhost:8080/travel/customfooter.htm" />

        <!-- jQuery -->
        <script src="client/vendor/jquery/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="client/vendor/bootstrap/js/bootstrap.min.js"></script>

        <!-- Theme JavaScript -->
        <script src="client/js/grayscale.min.js"></script>
        <script src="client/js/bootbox.min.js"></script>
    </body>

</html>
