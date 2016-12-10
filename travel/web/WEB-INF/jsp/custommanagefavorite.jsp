<%-- 
    Document   : custommanagefavorite
    Created on : Dec 10, 2016, 7:39:00 PM
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
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- Custom Fonts -->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">

        <!-- Theme CSS -->
        <link href="css/grayscale.css" rel="stylesheet">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    </head>

    <body id="#" data-spy="scroll" data-target=".navbar-fixed-top">

        <!-- Navigation -->
        <c:import url="http://localhost:8080/travel/customheader.htm" />



        <!-- Contact Section -->

        <div class="container" style="padding-top:200px;padding-bottom:30px" >
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                <button type="button" data-toggle="modal" data-target="#myModal1" class="button-modal"><a href="file:///C:/Users/Administrator/Desktop/demo/chiasetrainghiem.html">Chia sẻ trải nghiệm</a></button>
            </div>
            <ul class="nav nav-tabs" id="profile"style="margin-bottom:20px;color:#6f6f6e">

                <li class="active"><a data-toggle="tab" href="#land"style="color:#1d508d">Thắng cảnh yêu thích</a></li>
                <li class="active"><a data-toggle="tab" href="#fes"style="color:#1d508d">Lễ hội yêu thích</a></li>
                <li class="active"><a data-toggle="tab" href="#posts"style="color:#1d508d">Bài viết yêu thích</a></li>

            </ul>


            <div class="tab-content">
                <div id="land" class="tab-pane fade in active">

                    <div id= "information-product"style="color:#898989; text-align:justify">
                        <c:forEach var="land" items="listL">
                            <div class="post">
                                <img  src="${land.profile}" class="image"alt="tin tức" class="menu-picture">
                                <span class="title">${land.title}</span>
                                <div class="line-first">
                                    <div class="right"><button class="button-modal">Xoá</button></div>
                                </div>
                                <span style="font-size:10px;color:#7d7d7d">
                                    <div class="content-post-hidden">${land.desciption}</div></span>
                                <a href="${land.link}"><div class="seemore"> Xem thêm -></a></div>
                        </div>
                    </c:forEach>

                </div>

                </div>
                <div id="fes" class="tab-pane fade in active">
                <div id= "information-product"style="color:#898989; text-align:justify">
                   <c:forEach var="fes" items="listF">
                            <div class="post">
                                <img  src="${fes.profile}" class="image" alt="error" class="menu-picture">
                                <span class="title">${fes.title}</span>
                                <div class="line-first">
                                    <div class="right"><button class="button-modal">Xoá</button></div>
                                </div>
                                <span style="font-size:10px;color:#7d7d7d">
                                    <div class="content-post-hidden">${fes.desciption}</div></span>
                                <a href="${fes.link}"><div class="seemore"> Xem thêm -></a></div>
                        </div>
                    </c:forEach>

                </div>
                <div id="posts" class="tab-pane fade in active">
                <div id= "information-product"style="color:#898989; text-align:justify">
                    <c:forEach var="posts" items="listP">
                            <div class="post">
                                <img  src="${posts.profile}" class="image"alt="tin tức" class="menu-picture">
                                <span class="title">${land.title}</span>
                                <div class="line-first">
                                    <div class="right"><button class="button-modal">Xoá</button></div>
                                </div>
                                <span style="font-size:10px;color:#7d7d7d">
                                    <div class="content-post-hidden">${posts.context}</div></span>
                                <a href="${posts.link}"><div class="seemore"> Xem thêm -></a></div>
                        </div>
                    </c:forEach>

                </div>

        </div>


    </div>
</div>
<hr >

<c:import url="http://localhost:8080/travel/customfooter.htm" />

<!-- jQuery -->
<script src="vendor/jquery/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Plugin JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

<!-- Google Maps API Key - Use your own API key to enable the map feature. More information on the Google Maps API can be found at https://developers.google.com/maps/ -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRngKslUGJTlibkQ3FkfTxj3Xss1UlZDA&sensor=false"></script>

<!-- Theme JavaScript -->
<script src="js/grayscale.min.js"></script>
<script type="text/javascript">
    var $item = $('.carousel .item');
    var $wHeight = $(window).height();
    $item.eq(0).addClass('active');
    $item.height($wHeight);
    $item.addClass('full-screen');

    $('.carousel img').each(function () {
        var $src = $(this).attr('src');
        var $color = $(this).attr('data-color');
        $(this).parent().css({
            'background-image': 'url(' + $src + ')',
            'background-color': $color
        });
        $(this).remove();
    });

    $(window).on('resize', function () {
        $wHeight = $(window).height();
        $item.height($wHeight);
    });

    $('.carousel').carousel({
        interval: 6000,
        pause: "false"
    });
</script>
</body>


</html>