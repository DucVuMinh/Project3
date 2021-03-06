<%-- 
    Document   : customresultsearch
    Created on : 27-Nov-2016, 00:03:47
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

    </head>

    <body id="#" data-spy="scroll" data-target=".navbar-fixed-top">

        <!-- Navigation -->
        <%@ include file = "customheader.jsp" %>


        <div class="container" style="padding-top:230px;padding-bottom:30px" >
            <div class="result-search">
                <div class="title"> Các kết quả tìm kiếm <i class="fa fa-search fa" aria-hidden="true"></i> cho:
                    <span style="color:#337ab7">${query}</span> </div> 

            </div>
            <div id= "information-product"style="color:#898989; text-align:justify;border-top:1px solid #1d508d">
                <div class="sight-search" id="landscape">
                    <div class="format-title"> Thắng cảnh</div>
                    <c:forEach var="land" items="${land}">
                        <div class="post">
                            <div class="left">
                                <img  src="${land.profile}" class="img"alt="tin tức" class="menu-picture">
                            </div>
                            <span class="title">${land.title}</span>
                            <div class="line-first">
                                <div class= "left"><i class="fa fa-star" aria-hidden="true"></i></div>
                            </div>
                            <span style="font-size:10px;color:#7d7d7d">
                                <div class="content-post-hidden">${land.desciption}</div></span>
                            <a href="${land.link}"><div class="seemore"> Xem thêm -></a></div>
                    </div>
                </c:forEach>
                <hr>
            </div>
            <div class="festival-search" id="festival">
                <div class="format-title">Lễ hội</div>
                <c:forEach var="fes" items="${fes}">
                    <div class="post">
                        <div class="left">
                            <img  src="${fes.profile}" class="img"alt="tin tức" class="menu-picture">
                        </div>
                        <span class="title">${fes.title}</span>
                        <div class="line-first">
                            <div class= "left"><i class="fa fa-star" aria-hidden="true"></i></div>
                        </div>
                        <span style="font-size:10px;color:#7d7d7d">
                            <div class="content-post-hidden">${fes.description}</div></span>
                        <a href="${fes.link}"><div class="seemore"> Xem thêm -></a></div>
                </div>
            </c:forEach>
            <hr>
        </div>
        <div class="post-search" id="post">
            <div class="format-title">Bài viết</div>
            <c:forEach var="pos" items="${posts}">
                <div class="post">
                    <div class="left">
                        <img  src="${pos.profile}" class="img"alt="tin tức" class="menu-picture">
                    </div>
                    <span class="title">${pos.title}</span>
                    <div class="line-first">
                        <div class= "left"><i class="fa fa-star" aria-hidden="true"></i></div>
                    </div>
                    <span style="font-size:10px;color:#7d7d7d">
                        <div class="content-post-hidden">${pos.context}</div></span>
                    <a href="${pos.link}"><div class="seemore"> Xem thêm -></a></div>
            </div>
        </c:forEach>
    </div>
</div>
</div>


<hr >
<c:import url="http://localhost:8080/travel/customfooter.htm" />

<!-- jQuery -->
<script src="client/vendor/jquery/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="client/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Plugin JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

<!-- Google Maps API Key - Use your own API key to enable the map feature. More information on the Google Maps API can be found at https://developers.google.com/maps/ -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRngKslUGJTlibkQ3FkfTxj3Xss1UlZDA&sensor=false"></script>

<!-- Theme JavaScript -->
<script src="client/js/grayscale.min.js"></script>

</body>
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

</html>

