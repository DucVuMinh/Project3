<%-- 
    Document   : writeposts
    Created on : 30-Nov-2016, 15:41:32
    Author     : DucVu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html ; charset=UTF-8"  pageEncoding="UTF-8"%>
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
        <script language="javascript" src="client/js/custom.js"></script>

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
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item">
                        <img src="img/default/hotay.jpg" data-color="lightblue" alt="First Image">
                        <div class="carousel-caption">
                            <h2>Hồ Tây</h2>
                            <h3>- Được Unesco công nhận là di sản thiên nhiên thế giới, là điểm đến không thể quên khi đến thăm đất nước hình chữ S </h3>

                        </div>
                    </div>

                </div>

                <!-- Controls -->

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

            <div class="slide-holder">
                <div class="slide-pager">
                    <div class="slide-control-prev">«</div>
                    <div class="slide-control-next">»</div>
                </div>
                <div class="slide-container">
                    <div class="slide-stage">
                        <div class="slide-image"><img src="img/hotay.jpg" class="img3"></div>
                        <div class="slide-image"><img src="img/hanoi.jpg" class="img3"></div>
                        <div class="slide-image"><img src="img/langbac.jpg" class="img3"></div>
                        <div class="slide-image"><img src="img/phoco.jpg" class="img3"></div>
                        <div class="slide-image"><img src="img/longbien.jpg" class="img3"></div>
                    </div>
                </div>
            </div>





        </section>
        <hr>

        <!-- Download Section -->
        <section id="download" class="content-section ">
            <div class="download-section" style="background:#fff">
                <div class="container" >

                    <h2 class="text-center">Bài đăng nổi bật</h2>
                    <div class="main-content"> 
                        <h3><img src="client/img/thangcanh.png">Danh lam thắng cảnh</h3>
                        <div class="row">
                            <div class="row" style="padding-bottom:40px">
                                <div class="col-lg-6">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <img src="client/img/hanoi23.jpg" class="img1">
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="title-letter"><a href="">hanoi morden and traditional</a></div>
                                            <div class="hidden-letter ">Hanoi- the capital of Vietnam, the traditional and morden city hanoi th ecpa tp hanons han noi hanno hand fhs </div>
                                        </div>
                                    </div>

                                </div>

                                <div class="col-lg-6">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <img src="client/img/thainguyen.jpg" class="img1">
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="title-letter"><a href="">hanoi morden and traditional</a></div>
                                            <div class="hidden-letter ">Hanoi- the capital of Vietnam, the traditional and morden city hanoi th ecpa tp hanons han noi hanno hand fhs </div>
                                        </div>
                                    </div>

                                </div>

                            </div>

                            <div class="row" style="padding-bottom:40px">

                                <div class="col-lg-6">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <img src="client/img/thaibinh.jpg" class="img1">
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="title-letter"><a href="">hanoi morden and traditional</a></div>
                                            <div class="hidden-letter ">Hanoi- the capital of Vietnam, the traditional and morden city hanoi th ecpa tp hanons han noi hanno hand fhs </div>
                                        </div>
                                    </div>

                                </div>

                                <div class="col-lg-6">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <img src="client/img/bacninh.jpg" class="img1">
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="title-letter"><a href="">hanoi morden and traditional</a></div>
                                            <div class="hidden-letter ">Hanoi- the capital of Vietnam, the traditional and morden city hanoi th ecpa tp hanons han noi hanno hand fhs </div>
                                        </div>
                                    </div>

                                </div>

                            </div>



                        </div>
                        <div class="right"> Xem thêm >> </div>
                        <hr>

                        <h3><img src="client/img/lehoi.png">Lễ hội</h3>
                        <div class="row">

                            <div class="row" style="padding-bottom:40px">

                                <div class="col-lg-6">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <img src="client/img/vietnam1.jpg" class="img1">
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="title-letter"><a href="">hanoi morden and traditional</a></div>
                                            <div class="hidden-letter ">Hanoi- the capital of Vietnam, the traditional and morden city hanoi th ecpa tp hanons han noi hanno hand fhs </div>
                                        </div>
                                    </div>

                                </div>

                                <div class="col-lg-6">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <img src="client/img/langbac.jpg" class="img1">
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="title-letter"><a href="">hanoi morden and traditional</a></div>
                                            <div class="hidden-letter ">Hanoi- the capital of Vietnam, the traditional and morden city hanoi th ecpa tp hanons han noi hanno hand fhs </div>
                                        </div>
                                    </div>

                                </div>

                            </div>

                            <div class="row" style="padding-bottom:40px">

                                <div class="col-lg-6">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <img src="client/img/phoco.jpg" class="img1">
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="title-letter"><a href="">hanoi morden and traditional</a></div>
                                            <div class="hidden-letter ">Hanoi- the capital of Vietnam, the traditional and morden city hanoi th ecpa tp hanons han noi hanno hand fhs </div>
                                        </div>
                                    </div>

                                </div>

                                <div class="col-lg-6">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <img src="client/img/hotay.jpg" class="img1">
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="title-letter"><a href="">hanoi morden and traditional</a></div>
                                            <div class="hidden-letter ">Hanoi- the capital of Vietnam, the traditional and morden city hanoi th ecpa tp hanons han noi hanno hand fhs </div>
                                        </div>
                                    </div>

                                </div>

                            </div>



                        </div>
                        <div class="right"> Xem thêm >> </div>
                        <hr>



                        <h3><img src="client/img/baiviet.png">Bài viết</h3>
                        <div class="row">

                            <div class="row" style="padding-bottom:40px">

                                <div class="col-lg-6">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <img src="client/img/vietnam3.jpg" class="img1">
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="title-letter"><a href="">hanoi morden and traditional</a></div>
                                            <div class="hidden-letter ">Hanoi- the capital of Vietnam, the traditional and morden city hanoi th ecpa tp hanons han noi hanno hand fhs </div>
                                        </div>
                                    </div>

                                </div>

                                <div class="col-lg-6">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <img src="client/img/halong1.jpg" class="img1">
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="title-letter"><a href="">hanoi morden and traditional</a></div>
                                            <div class="hidden-letter ">Hanoi- the capital of Vietnam, the traditional and morden city hanoi th ecpa tp hanons han noi hanno hand fhs </div>
                                        </div>
                                    </div>

                                </div>

                            </div>

                            <div class="row" style="padding-bottom:40px">

                                <div class="col-lg-6">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <img src="client/img/vietnam2.jpg" class="img1">
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="title-letter"><a href="">hanoi morden and traditional</a></div>
                                            <div class="hidden-letter ">Hanoi- the capital of Vietnam, the traditional and morden city hanoi th ecpa tp hanons han noi hanno hand fhs </div>
                                        </div>
                                    </div>

                                </div>

                                <div class="col-lg-6">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <img src="client/img/bentre.jpg" class="img1">
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="title-letter"><a href="">hanoi morden and traditional</a></div>
                                            <div class="hidden-letter ">Hanoi- the capital of Vietnam, the traditional and morden city hanoi th ecpa tp hanons han noi hanno hand fhs </div>
                                        </div>
                                    </div>

                                </div>

                            </div>



                        </div>
                        <div class="right"> Xem thêm >> </div>
                        <hr>
                    </div>
                </div>
            </div>
        </section>
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