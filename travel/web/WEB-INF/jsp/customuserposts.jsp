<%-- 
    Document   : customuserposts
    Created on : Dec 7, 2016, 3:29:07 PM
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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- Custom Fonts -->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
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

        <c:import url="http://localhost:8080/travel/customheader.htm" />

        <!-- Contact Section -->

        <div class="container" style="padding-top:200px;padding-bottom:30px" >
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                <button type="button" data-toggle="modal" data-target="#myModal1" class="button-modal"><a href="file:///C:/Users/Administrator/Desktop/demo/chiasetrainghiem.html">Chia sẻ trải nghiệm</a></button>
            </div>
            <ul class="nav nav-tabs" id="profile"style="margin-bottom:20px;color:#6f6f6e">

                <li class="active"><a data-toggle="tab" href="#home"style="color:#1d508d">QUẢN LÝ BÀI VIẾT</a></li>

            </ul>

            <div class="tab-content">
                <div id="home" class="tab-pane fade in active">
                    <div id= "information-product"style="color:#898989; text-align:justify">
                        <div class="post">
                            <img  src="img/default/hagiang.jpg" class="image"alt="tin tức" class="menu-picture">
                            <span class="title">Mùa tam giác mạch -Hà Giang</span>
                            <div class="line-first">
                                <div class="left"><p> Bilgate<img src="img/default/add.png" alt="time"> 01/05/2016</p></div>
                                <div class="right"><button class="button-modal">Xoá</button></div>
                                <div class="right"><button class="button-modal">Chỉnh sửa</button></div>
                            </div>
                            <span style="font-size:10px;color:#7d7d7d">
                                <div class="content-post-hidden">When you’re in DSLR territory, stylish design is not an emphasis. The all-black D500 looks like every other Nikon DSLR geared toward enthusiasts, including the red Nikon trademark on the grip and a faux-leather textured finish. It’s big and bulky, measuring 5.8 x 4.6 x 3.2 inches and weighing about 27 ounces for the body alone...</div></span>
                            <a href=""><div class="seemore"> Xem thêm -></a></div>
                    </div>


                    <div class="post">
                        <img  src="img/default/hagiang.jpg" class="image"alt="tin tức" class="menu-picture">
                        <span class="title">Mùa tam giác mạch -Hà Giang</span>
                        <div class="line-first">
                            <div class="left"><p> Bilgate<img src="img/default/add.png" alt="time"> 01/05/2016</p></div>
                            <div class="right"><button class="button-modal">Xoá</button></div>
                            <div class="right"><button class="button-modal">Chỉnh sửa</button></div>
                        </div>
                        <span style="font-size:10px;color:#7d7d7d">
                            <div class="content-post-hidden">When you’re in DSLR territory, stylish design is not an emphasis. The all-black D500 looks like every other Nikon DSLR geared toward enthusiasts, including the red Nikon trademark on the grip and a faux-leather textured finish. It’s big and bulky, measuring 5.8 x 4.6 x 3.2 inches and weighing about 27 ounces for the body alone...</div></span>
                        <a href=""><div class="seemore"> Xem thêm -></a></div>
                </div>
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