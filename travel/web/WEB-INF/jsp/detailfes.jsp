<%-- 
    Document   : detailland
    Created on : Dec 18, 2016, 7:28:55 PM
    Author     : ducvu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css" rel="stylesheet" media="all">

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

    <body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

        <!-- Navigation -->
        <%@ include file = "customheader.jsp" %>


        <section id="sight" class="content-section ">
            <div class="download-section">
                <div class="container">

                    <h2 class="text-center"><img src="img/default/lehoi.png">Lễ Hội</h2>
                    <hr width="10px">
                    <div class="main-content" id="festival"> 
                        <c:forEach var="lland" items="${listFes}">
                            <div class="row" style="padding-bottom:40px">
                                <c:forEach var="land" items="${lland.listfes}">
                                    <div class="col-lg-6">
                                        <div class="row">
                                            <div class="col-lg-6">
                                                <img src="${land.profile}" class="img1">
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="title-letter"><a href="${land.link}">${land.title}</a></div>
                                                <div class="hidden-letter ">${land.description}</div>
                                            </div>
                                        </div>

                                    </div>
                                </c:forEach>
                            </div>
                        </c:forEach>
                        <hr>
                    </div>
                </div>
            </div>
        </section>


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

</html>
