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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="client/js/jquery-1.10.2.min.js"></script>   
    </head>

    <body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

        <!-- Navigation -->
        <%@ include file = "customheader.jsp" %>

        <div class="container" style="padding-top:200px;padding-bottom:30px" >
            <div class= "container-border">
                <div class="title"> Chia sẻ những trải nghiệm của bạn</div>
            </div>
            <div >
                <form  method="POST" enctype="multipart/form-data" action="savewritepost">
                    <div class="form-group">
                        <div class="col-md-6 title"> 
                            Select image
                            <input type="file" id="files" name="files" multiple="multiple"/><br>
                            Bài viết nói về địa điểm du lịch:
                            <select class="form-control" id="seldes" name="seldes">
                                <c:forEach var="des" items="${lisDes}">
                                    <option id="${des.idDestination}">${des.title}</option>
                                </c:forEach>
                            </select><br/>
                            Title:
                            <input type="title" class="form-control" name="title" id="title" placeholder="Enter title" required >
                        </div><br/>
                        <div class="col-md-10 title">Viết chia sẻ:
                            <textarea class="form-control" rows="7" cols="105" name="context" id="context" placeholder="Enter your shares..." required></textarea>
                            <br/>

                            <p style="text-align: right; margin-top: 20px;">
                            </p><br/>
                            <button type="submit" class="btn btn-default" style="background:#1d508d">Submit</button>
                        </div>
                    </div>
                </form>
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
        <link rel="stylesheet" type="text/css" href="http://www.shieldui.com/shared/components/latest/css/light-bootstrap/all.min.css" />
        <script type="text/javascript" src="http://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>

    </body>
    <script>
        jQuery(function ($) {
            $("#files").shieldUpload();
        });
    </script>
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

