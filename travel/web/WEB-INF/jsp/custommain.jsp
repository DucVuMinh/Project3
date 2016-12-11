<%-- 
    Document   : main
    Created on : 19-Nov-2016, 11:26:23
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>

    <body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

        <!-- Navigation -->
        <%@ include file = "customheader.jsp" %>

        <!-- Intro Header -->
        <header class="intro">
            <div id="mycarousel" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#mycarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#mycarousel" data-slide-to="1"></li>
                    <li data-target="#mycarousel" data-slide-to="2"></li>
                    <li data-target="#mycarousel" data-slide-to="3"></li>
                    <li data-target="#mycarousel" data-slide-to="4"></li>
                </ol>
                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item">
                        <img src="img/default/2.jpg" data-color="lightblue" alt="First Image">
                        <div class="carousel-caption">
                            <h2>VỊNH HẠ LONG</h2>
                            <h3>- Được Unesco công nhận là di sản thiên nhiên thế giới, là điểm đến không thể quên khi đến thăm đất nước hình chữ S </h3>

                        </div>
                    </div>
                    <div class="item">
                        <img src="img/default/vietnam2.jpg" data-color="firebrick" alt="Second Image">
                        <div class="carousel-caption">
                            <h2>TÂY BẮC</h2>
                            <h3>Những thửa ruộng bậc thang như những dây đàn chạy vòng quanh những ngọn núi, là điểm đặc trưng của Tây Bắc Việt Nam</h3>
                        </div>
                    </div>
                    <div class="item">
                        <img src="img/default/danang.jpg" data-color="violet" alt="Third Image">
                        <div class="carousel-caption">
                            <h2>Đà Nẵng</h2>
                            <h3>Nơi được mệnh danh là thành phố đáng sống nhất Việt Nam,Đà Nẵng đang ngày càng khẳng định bản lĩnh trong công cuộc xây dựng đất nước</h3>
                        </div>
                    </div>
                    <div class="item">
                        <img src="img/default/mientay1.jpg" data-color="lightgreen" alt="Fourth Image">
                        <div class="carousel-caption">
                            <h3></h3>
                        </div>
                    </div>
                    <div class="item">
                        <img src="img/default/vietnam3.jpg" data-color="tomato" alt="Fifth Image">
                        <div class="carousel-caption">
                            <h3>Fifth Image</h3>
                        </div>
                    </div>
                </div>
                <!-- Controls -->
                <a class="left carousel-control" href="#mycarousel" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#mycarousel" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>


        </header>

        <!-- About Section -->
        <section id="about" class="container content-section text-center">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <h2>About S- travel</h2>
                    <p>Grayscale is a sharing travel website where help the tourist find out some information. Moreover, the tourist can share their experiences and provice the information about sightseeing what they know for other people. </a>. This website is set up by the HUST student team </p>
                    <p>With out the informations the user provice, we also show almost famous place in Vietnam for you.</a> Hope you love this.</p>
                    <p>Let 's join with us ;)</p>
                </div>
            </div>
        </section>

        <!-- Download Section -->
        <section id="sight" class="content-section ">
            <div class="download-section">
                <div class="container">

                    <h2>Tin nổi bật</h2>
                    <div class="main-content" id="top"> 
                        <p>Danh lam thắng cảnh</p>
                        <div class="row" id="topLandscape">
                            <c:forEach var="l" items="${topland}">
                                <div class="col-xs-12 col-lg-2 col-md-3 col-sm-4" id="${l.id}" >
                                    <div class="up-letter">
                                        <a href="${l.link}">
                                            <img src="${l.profile}" class="img1">
                                            <div class="title-letter ">${l.title}</div>
                                            <div class="hidden-letter">
                                                <p><h6>${l.desciption}</h6></p>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        
                        <p> Lễ hội</p>
                        <div class="row" id="topFestival">
                            <c:forEach var="fes" items="${topFes}">
                                <div class="col-xs-12 col-lg-2 col-md-3 col-sm-4" id="${fes.id}">
                                    <div class="up-letter">
                                        <a href="${fes.link}">
                                            <img src="${fes.profile}" class="img1">
                                            <div class="title-letter" >${fes.title}</div>
                                            <div class="hidden-letter">
                                                <p><h6>${fes.description} </h6></p>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>

                        <p> Bài viết</p>
                        <div class="row" id="topPosts">
                            <c:forEach var="post" items="${topPost}">
                                <div class="col-xs-12 col-lg-2 col-md-3 col-sm-4">
                                    <div class="up-letter">
                                        <a href="${post.link}">
                                            <img src="${post.profile}" class="img1">
                                            <div class="title-letter">${post.title}</div>
                                            <div class="hidden-letter">
                                                <p><h6>${post.context} </h6></p>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </c:forEach> 
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <hr>
        <!-- Contact Section -->
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
