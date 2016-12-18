<%-- 
    Document   : detailFestival
    Created on : Dec 17, 2016, 1:09:04 AM
    Author     : vanduc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin | Thông tin lễ hội</title>
        <meta charset="utf-8">
        <!-- Bootstrap -->
        <link href="../admin/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="../admin/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- NProgress -->
        <link href="../admin/vendors/nprogress/nprogress.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="../admin/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
        <!-- bootstrap-progressbar -->
        <link href="../admin/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
        <!-- JQVMap -->
        <link href="../admin/vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
        <!-- bootstrap-daterangepicker -->
        <link href="../admin/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
        <!-- Dropzone.js -->
        <link href="../admin/vendors/dropzone/dist/min/dropzone.min.css" rel="stylesheet">


        <!-- Custom Theme Style -->
        <link href="../admin/css/custom.min.css" rel="stylesheet">
        <link href="../admin/css/css.css" rel="stylesheet">
        <link href="../admin/css/bootstrap-select.css" rel="stylesheet">

        <!-- Upload Image Banner -->
        <link rel="stylesheet" type="text/css" href="../admin/css/bootstrap-imageupload.css">

    </head>
    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <div class="col-md-3 left_col">
                    <div class="left_col scroll-view">
                        <div class="navbar nav_title" style="border: 0;">
                            <a href="index.htm" class="site_title">
                                <i class="fa fa-paw"></i>
                                <span>S - Travel</span>
                            </a>
                        </div>
                        <div class="clearfix"></div>

                        <!-- Menu Profile Info -->
                        <div class="profile">
                            <div class="profile_pic">
                                <img src="../admin/images/img.jpg" alt="..." class="img-circle profile_img">
                            </div>
                            <div class="profile_info">
                                <span>Welcome, </span>
                                <h2>Admin</h2>
                            </div>
                        </div>
                        <!-- /Menu Profile Info -->

                        <br/>

                        <!-- Sidebar Menu -->
                        <jsp:include page="sidebarMenu.jsp" />
                    </div>
                </div>
                <!-- Top navbar -->
                <div class="top_nav">
                    <div class="nav_menu">
                        <nav>
                            <div class="nav toggle">
                                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                            </div>

                            <ul class="nav navbar-nav navbar-right">
                                <li class="">
                                    <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                        <img src="../admin/images/img.jpg" alt="">Admin
                                        <span class="fa fa-angle-down"></span>
                                    </a>
                                    <ul class="dropdown-menu dropdown-usermenu pull-right">
                                        <li><a href="javascript:;">Thông tin cá nhân</a></li>
                                        <li><a href="logout.htm"><i class="fa fa-sign-out pull-right"></i>Đăng xuất</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
                <!-- /Top navbar -->
                <!-- Page Content -->
                <div class="right_col" role="main">
                    <div class="">
                        <!--Flash Message-->
                        <c:if test="${not empty param.success && param.success == 'true'}">
                            <div class="alert alert-success" style="margin-top: 50px;">
                                <div>Sửa lễ hội thành công!</div>
                            </div>
                        </c:if>
                        <!--/Flash Message-->
                        <div class="page-title">
                            <div class="title_left">
                                <h1 style="margin-left: 50px">${detailFes.getTitle()}</h1>
                            </div>

                            <div class="title-right">
                                <div class="col-md-1 col-sm-1 col-xs-12 form-group pull-right top_search">
                                    <div class="input-group">
                                        <button type="button" class="btn btn-round btn-warning"
                                                onclick="window.location = 'editFestival.htm?idFestival=${param.idFestival}';">
                                            <i class="fa fa-edit" aria-hidden="true"></i> Sửa
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="clearfix"></div>

                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Thông tin lễ hội</h2>
                                        <ul class="nav navbar-right panel_toolbox">
                                            <li><a href=""></a></li>
                                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                                            <li><a class="close-link"><i class="fa fa-close"></i></a></li>
                                        </ul>
                                        <div class="clearfix"></div>
                                    </div>

                                    <div class="x_content">
                                        <br/>
                                        <div class="group-content row">
                                            <div class="title-content col-md-3 col-xs-12 col-sm-3">
                                                <p>Địa điểm</p>
                                            </div>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <p style="font-size: 18px"><i class="fa fa-map-marker" aria-hidden="true"></i>
                                                    <a href="detailDestination.htm?idDestination=${detailFes.getDestination().getIdDestination()}">${detailFes.getDestination().getTitle()}</a>
                                                </p>
                                            </div>
                                        </div>
                                        <div class="group-content row">
                                            <div class="title-content col-md-3 col-xs-12 col-sm-3">
                                                <p>Giới thiệu</p>
                                            </div>
                                            <div class="col-md-8 col-sm-6 col-xs-12">
                                                <p>${detailFes.getDiscription()}</p>
                                            </div>
                                        </div>
                                        <br/>
                                        <div class="group-content row">
                                            <div class="title-content col-md-3 col-sm-3 col-xs-12">
                                                <p>Ảnh đại diện</p>
                                            </div>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <img class="banner" src="../img/festival/profile/${detailFes.getIdFestival()}.png"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Hình ảnh lễ hội</h2>
                                        <ul class="nav navbar-right panel_toolbox">
                                            <li><a href=""></a></li>
                                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                                            <li><a class="close-link"><i class="fa fa-close"></i></a></li>
                                        </ul>
                                        <div class="clearfix"></div>
                                    </div>

                                    <div class="x_content">
                                        <c:forEach items="${detailFes.getImagedetailFestivals()}" var="i">
                                            <image src="../img/festival/detail/${i.getIdImage()}.png" class="img_detail thumbnail zoom"/>
                                        </c:forEach>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Page Content -->

                <!-- Footer Content -->
                <footer>
                    <div class="pull-right">
                        S - Travel Admin Page
                    </div>
                    <div class="clearfix"></div>
                </footer>
                <!-- /Footer Content -->
            </div>
        </div>

        <!-- jQuery -->
        <script src="../admin/vendors/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="../admin/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- Dropzone.js -->
        <script src="../admin/vendors/dropzone/dist/min/dropzone.min.js"></script>

        <!-- Custom Theme Scripts -->
        <script src="../admin/js/custom.min.js"></script>
        <script type="text/javascript" src="../admin/js/bootstrap-select.js"></script>
    </body>
</html>