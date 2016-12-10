<%-- 
    Document   : adminDetailPostNeedApprove
    Created on : Nov 26, 2016, 4:49:41 PM
    Author     : GiangTHQ
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin | Duyệt bài viết</title>
        <meta charset="utf-8">
        <!-- Bootstrap -->
        <link href="../admin/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="../admin/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">

        <!-- Custom Theme Style -->
        <link href="../admin/css/custom.min.css" rel="stylesheet">
        <link href="../admin/css/css.css" rel="stylesheet">

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
                                <h2>GT</h2>
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
                        </nav>
                    </div>
                </div>
                <!-- /Top navbar -->
                <!-- Page Content -->
                <div class="right_col" role="main">
                    <div class="">
                        <div class="page-title">
                            <div class="title_left">
                                <h3>${p.getTitle()}</h3>
                            </div>
                        </div>

                        <div class="clearfix"></div>

                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Nội dung bài viết</h2>
                                        <ul class="nav navbar-right panel_toolbox">
                                            <li><a href=""></a></li>
                                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                                            <li><a class="close-link"><i class="fa fa-close"></i></a></li>
                                        </ul>
                                        <div class="clearfix"></div>
                                    </div>

                                    <div class="x_content">
                                        <div class="col-md-1 col-sm-1 col-xs-12"></div>
                                        <div class="col-md-10 col-sm-10 col-xs-12">
                                            <p>${p.getContext()}</p>
                                        </div>
                                        <div class="col-md-1 col-sm-1 col-xs-12"></div>		
                                    </div>
                                </div>

                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Hình ảnh bài viết</h2>
                                        <ul class="nav navbar-right panel_toolbox">
                                            <li><a href=""></a></li>
                                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                                            <li><a class="close-link"><i class="fa fa-close"></i></a></li>
                                        </ul>
                                        <div class="clearfix"></div>
                                    </div>

                                    <div class="x_content">
                                        <c:forEach items="${p.getImagedetailPostses()}" var="i">
                                            <image src="../img/posts/detail/${i.getIdImage()}.png" class="img_detail thumbnail zoom"/>
                                        </c:forEach>
                                    </div>
                                </div>

                                <div class="x_panel">
                                    <div class="col-md-1 col-sm-1 col-xs-12"></div>
                                    <div class="col-md-10 col-sm-10 col-xs-12">
                                        <button type="submit" class="btn btn-success" onclick="approvePost()">Chấp nhận</button>
                                        <button type="submit" class="btn btn-primary">Xóa</button>
                                    </div>
                                    <div class="col-md-1 col-sm-1 col-xs-12"></div>	
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

        <!-- Custom Theme Scripts -->
        <script src="../admin/js/custom.min.js"></script>
        <script type="text/javascript" src="../admin/js/bootstrap-select.js"></script>
        
        <script>
            function approvePost(){
                var comfirmBox = confirm("Bạn muốn chấp nhận bài viết này?");
                if(comfirmBox == true){
                    window.location.href = "/travel/admin/approvePosts.htm?idPost=${p.getIdPosts()}";
                }
            }
        </script>
    </body>
</html>
