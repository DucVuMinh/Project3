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
                        <img src="${infdes.profile}" data-color="lightblue" alt="First Image">
                        <div class="carousel-caption">
                            <h2>${infdes.title}</h2>
                        </div>
                    </div>

                </div>

                <!-- Controls -->

            </div>

        </header>
        <body>
        <!-- About Section -->
        <section id="about" class="container content-section text-center">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <h2>About S- travel</h2>
                    <p>${infdes.desciption}</p>
                </div>
            </div>

            <div class="slide-holder">
                <div class="slide-pager">
                    <div class="slide-control-prev">«</div>
                    <div class="slide-control-next">»</div>
                </div>
                <div class="slide-container">
                    <div class="slide-stage">
                        <c:forEach var="img" items="${imgdes}">
                            <div class="slide-image"><img src="${img}" class="img1"></div>
                        </c:forEach>
                        
                    </div>
                </div>
            </div>


        </section>

        <!-- Download Section -->
        <section id="download" class="content-section ">
            <div class="download-section">
                <div class="container">

                    <h2>Thắng cảnh, lễ hội, bài viết</h2>
                    <div class="main-content"> 
                        <p>Danh lam thắng cảnh</p>
                        <c:forEach var="lland" items="${listLand}">
                            <div class="row">
                                <c:forEach var="land" items="${lland.listLand}">
                                    <div class="col-xs-6 col-lg-2 col-md-2 col-sm-4">
                                        <div class="up-letter">
                                            <a href="${land.link}">
                                                <img src="${land.profile}" class="img1">

                                                <div class="title-letter">${land.title}</div>
                                                <div class="hidden-letter">
                                                    <p><h6>${land.desciption}</h6></p>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>                            
                        </c:forEach>

                        <p> Lễ hội</p>
                        <c:forEach var="lfes" items="${listFes}">
                            <div class="row">
                                <c:forEach var="fes" items="${lfes.listfes}">
                                    <div class="col-xs-6 col-lg-2 col-md-2 col-sm-4">
                                        <div class="up-letter">
                                            <a href="${fes.link}">
                                                <img src="${fes.profile}" class="img1">

                                                <div class="title-letter">${fes.title}</div>
                                                <div class="hidden-letter">
                                                    <p><h6>${fes.description} </h6></p>
                                                </div>
                                            </a>
                                        </div>
                                    </div>  
                                </c:forEach>
                                
                            </div>
                        </c:forEach>
                        

                        <p> Bài viết</p>
                        <c:forEach var="lpost" items="${listPosts}"> 
                            <div class="row">
                                <c:forEach var="post" items="${lpost.listPost}">
                                    <div class="col-xs-6 col-lg-2 col-md-2 col-sm-4">
                                        <div class="up-letter">
                                            <a href="${post.link}">
                                                <img src="${post.profile}" class="img1">
                                                <div class="title-letter">${post.title}</div>
                                                <div class="hidden-letter">
                                                    <p><h6>${post.context}</h6></p>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </section>
        <c:import url="http://localhost:8080/travel/customfooter.htm" />
        </body>
        <!-- jQuery -->
        <script src="client/vendor/jquery/jquery.js"></script>
        

        <!-- Bootstrap Core JavaScript -->
        <script src="client/vendor/bootstrap/js/bootstrap.min.js"></script>

        <!-- Plugin JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
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
