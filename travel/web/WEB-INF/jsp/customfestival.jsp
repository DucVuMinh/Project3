<%-- 
    Document   : customfestival
    Created on : 27-Nov-2016, 23:19:11
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
        <script language="javascript" src="client/js/custom.js"></script>
        <link rel="stylesheet" href="client/css/stylerating.css">
        <link rel="stylesheet" href="client/css/popup.css">
        <script src="https://code.angularjs.org/1.3.0-rc.2/angular.js"></script>
        <script src="client/js/controller/appratingfes.js"></script>
        <script src="client/js/controller/addfesfavor.js"></script>
    </head>

    <body id="#" data-spy="scroll" data-target=".navbar-fixed-top" >

        <%@ include file = "customheader.jsp" %>
        <!-- Intro Header -->

        <!-- About Section -->
        <section id="about" class="container content-section text-center"  style="padding-top:190px;padding-bottom:30px">
            <div class="content">
                <div class="line-first">

                    <div id="addfavorele" class="right popup">
                        <span class="popuptext" id="loginfavor">Đăng nhập để thực hiện chức năng này</span>
                        <span class="popuptext" id="errorpagefavor">lỗi trang, hãy reload lại trang web</span>
                        <span class="popuptext" id="waitadminfavor">bài viết đang chờ admin phê duyệt</span>
                        <span class="popuptext" id="addedfavor">bài viết đã có trong mục yêu thích</span>
                        <span class="popuptext" id="doneaddfavor">đã thêm bài viết vào mục yêu thích</span>
                        <button id="btaddfavor" class="button-modal" ng-click="addFavor()">Lưu bài viết</button>
                    </div>
                    <div class="title">${inffes.title}</div>
                    <div class="content-post">
                        ${inffes.description}
                        <div class="slide-holder">
                            <div class="slide-pager">
                                <div class="slide-control-prev">«</div>
                                <div class="slide-control-next">»</div>
                            </div>
                            <div class="slide-container">
                                <div class="slide-stage">
                                    <c:forEach var="img" items="${imgDetail}">
                                        <div class="slide-image"><img src="${img}" class="img1"></div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>

                        <div class="comment" style="weight:700px">
                            <ul class="nav nav-tabs" id="profile"style="margin-bottom:20px;color:#6f6f6e">
                                <li><a data-toggle="tab" href="#menu1" style="color:#1d508d">Đánh giá</a></li>
                            </ul>

                            <div class="tab-content">
                                <div id="menu1" class="tab-pane fade">
                                    <div id="rankingele" ng-app="starApp" ng-controller="StarCtrl" ng-init="setRate(${inffes.avgRank},${inffes.rankOfUser},${inffes.numberUserRank})"> 
                                        <div class=col-md-12>

                                            <div>
                                                <h2>{{ratings[0].current}} /
                                                    {{ratings[0].max}}</h2>
                                                <div star-rating rating-value="ratings[0].current" max="ratings[0].max" 
                                                     readonly= "ratings[0].readonly" on-rating-selected="getSelectedRating(ratings[0])"
                                                     is-click="ratings[0].isClick"></div>
                                                <h2>Đánh giá {{ratings[0].current}} từ {{numberUserRank}} thành viên</h2>
                                            </div>
                                            <div>
                                                <h2>{{ratings[1].current}} /
                                                    {{ratings[1].max}}</h2>
                                                <div star-rating rating-value="ratings[1].current" max="ratings[1].max" readonly= "ratings[1].readonly" 
                                                     on-rating-selected="getSelectedRating(ratings[1])" is-click="ratings[0].isClick"></div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Contact Section -->
        <c:import url="http://localhost:8080/travel/customfooter.htm" />
        <!-- Map Section -->
        <!-- Footer -->
        

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
        angular.element(document).ready(function () {
            angular.bootstrap(document.getElementById("rankingele"), ['starApp']);
            
        });
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

        var currentImage;
        var currentIndex = -1;
        var interval;
        function showImage(index) {
            if (index < $('#bigPic img').length) {
                var indexImage = $('#bigPic img')[index]
                if (currentImage) {
                    if (currentImage != indexImage) {
                        $(currentImage).css('z-index', 2);
                        clearTimeout(myTimer);
                        $(currentImage).fadeOut(250, function () {
                            myTimer = setTimeout("showNext()", 3000);
                            $(this).css({'display': 'none', 'z-index': 1})
                        });
                    }
                }
                $(indexImage).css({'display': 'block', 'opacity': 1});
                currentImage = indexImage;
                currentIndex = index;
                $('#thumbs li').removeClass('active');
                $($('#thumbs li')[index]).addClass('active');
            }
        };

        function showNext() {
            var len = $('#bigPic img').length;
            var next = currentIndex < (len - 1) ? currentIndex + 1 : 0;
            showImage(next);
        };

        var myTimer;

        $(document).ready(function () {
            myTimer = setTimeout("showNext()", 3000);
            showNext(); //loads first image
            $('#thumbs li').bind('click', function (e) {
                var count = $(this).attr('rel');
                showImage(parseInt(count) - 1);
            });
        });
    </script>

</html>

