<%-- 
    Document   : index
    Created on : Dec 6, 2016, 8:34:22 PM
    Author     : vanduc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin</title>
        <meta charset="utf-8">
        <!-- Bootstrap -->
        <!--<link href="../../../admin/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>-->
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

        <!-- Custom Theme Style -->
        <link href="../admin/css/custom.min.css" rel="stylesheet">
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

                    <div class="row top_tiles">
                        <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                            <div class="tile-stats">
                                <div class="icon"><i class="fa fa-users green"></i></div>
                                <div class="count ">${totalUser}</div>
                                <h3>Người dùng</h3>
                            </div>
                        </div>
                        <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                            <div class="tile-stats">
                                <div class="icon"><i class="fa fa-car green"></i></div>
                                <div class="count ">${totalFes}</div>
                                <h3 >Lễ hội</h3>
                            </div>
                        </div>
                        <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                            <div class="tile-stats">
                                <div class="icon"><i class="fa fa-car green"></i></div>
                                <div class="count ">${totalLand}</div>
                                <h3 >Thắng cảnh</h3>
                            </div>
                        </div>
                        <div class="animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
                            <div class="tile-stats">
                                <div class="icon"><i class="fa fa-newspaper-o green"></i></div>
                                <div class="count ">${totalPosts}</div>
                                <h3 >Bài viết</h3>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-md-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Transaction Summary</h2>
                                    <div class="filter">
                                        <div id="reportrange" class="pull-right" style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc">
                                            <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                                            <span>December 30, 2014 - January 28, 2015</span> <b class="caret"></b>
                                        </div>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">

                                    <div class="col-md-3 col-sm-12 col-xs-12">
                                        <div>
                                            <div class="x_title">
                                                <h2>Top User</h2>
                                                <ul class="nav navbar-right panel_toolbox" style="min-width: 0px">
                                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                                    </li>
                                                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                                                    </li>
                                                </ul>
                                                <div class="clearfix"></div>
                                            </div>
                                            <ul class="list-unstyled top_profiles scroll-view">
                                                <li class="media event">
                                                    <a class="pull-left border-aero profile_thumb">
                                                        <i class="fa fa-user aero"></i>
                                                    </a>
                                                    <div class="media-body">
                                                        <a class="title" href="#">Nguyễn Văn Đức</a>
                                                        <p><strong>ducnv</strong></p>
                                                        <p> <small>ducbac230895@gmail.com</small>
                                                        </p>
                                                    </div>
                                                </li>
                                                <li class="media event">
                                                    <a class="pull-left border-aero profile_thumb">
                                                        <i class="fa fa-user aero"></i>
                                                    </a>
                                                    <div class="media-body">
                                                        <a class="title" href="#">Vũ Minh Đức</a>
                                                        <p><strong>Duc Vu</strong></p>
                                                        <p> <small>ducvu@gmail.com</small>
                                                        </p>
                                                    </div>
                                                </li>
                                                <li class="media event">
                                                    <a class="pull-left border-aero profile_thumb">
                                                        <i class="fa fa-user aero"></i>
                                                    </a>
                                                    <div class="media-body">
                                                        <a class="title" href="#">Hoàng Thế Hà</a>
                                                        <p><strong>The Ha</strong></p>
                                                        <p> <small>hoangha95@gmail.com</small>
                                                        </p>
                                                    </div>
                                                </li>
<!--                                                <li class="media event">
                                                    <img class="pull-left" height="60px" src="../img/users/profile/2.png"/>
                                                    <div class="media-body">
                                                        <p class="text-center text-uppercase"><strong>Đền Bạch Mã</strong></p>
                                                    </div>
                                                </li>
                                                <li class="media event">
                                                    <img class="pull-left" height="60px" src="../img/users/profile/3.png"/>
                                                    <div class="media-body">
                                                        <p class="text-center text-uppercase"><strong>Đền Bạch Mã</strong></p>
                                                    </div>
                                                </li>-->
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="col-md-3 col-sm-12 col-xs-12">
                                        <div>
                                            <div class="x_title">
                                                <h2>Top Lễ hội</h2>
                                                <ul class="nav navbar-right panel_toolbox" style="min-width: 0px">
                                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                                    </li>
                                                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                                                    </li>
                                                </ul>
                                                <div class="clearfix"></div>
                                            </div>
                                            <ul class="list-unstyled top_profiles scroll-view">
                                                <li class="media event">
                                                    <img class="pull-left" height="60px" src="../img/festival/profile/1.png"/>
                                                    <div class="media-body">
                                                        <p class="text-center text-uppercase"><strong>Lễ hội đình và đền Kim Liên</strong></p>
                                                    </div>
                                                </li>
                                                <li class="media event">
                                                    <img class="pull-left" height="60px" src="../img/festival/profile/2.png"/>
                                                    <div class="media-body">
                                                        <p class="text-center text-uppercase"><strong>Đêm hội Giã La</strong></p>
                                                    </div>
                                                </li>
                                                <li class="media event">
                                                    <img class="pull-left" height="60px" src="../img/festival/profile/3.png"/>
                                                    <div class="media-body">
                                                        <p class="text-center text-uppercase"><strong>Hội đền Hát Môn</strong></p>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="col-md-3 col-sm-12 col-xs-12">
                                        <div>
                                            <div class="x_title">
                                                <h2>Top thắng cảnh</h2>
                                                <ul class="nav navbar-right panel_toolbox" style="min-width: 0px">
                                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                                    </li>
                                                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                                                    </li>
                                                </ul>
                                                <div class="clearfix"></div>
                                            </div>
                                            <ul class="list-unstyled top_profiles scroll-view">
                                                <li class="media event">
                                                    <img class="pull-left" height="60px" src="../img/landscape/profile/1.png"/>
                                                    <div class="media-body">
                                                        <p class="text-center text-uppercase"><strong>Đền Bạch Mã</strong></p>
                                                    </div>
                                                </li>
                                                <li class="media event">
                                                    <img class="pull-left" height="60px" src="../img/landscape/profile/4.png"/>
                                                    <div class="media-body">
                                                        <p class="text-center text-uppercase"><strong>NHÀ SÀN BÁC HỒ</strong></p>
                                                    </div>
                                                </li>
                                                <li class="media event">
                                                    <img class="pull-left" height="60px" src="../img/landscape/profile/3.png"/>
                                                    <div class="media-body">
                                                        <p class="text-center text-uppercase"><strong>LĂNG CHỦ TỊCH HỒ CHÍ MINH</strong></p>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="col-md-3 col-sm-12 col-xs-12">
                                        <div>
                                            <div class="x_title">
                                                <h2>Top bài viết</h2>
                                                <ul class="nav navbar-right panel_toolbox" style="min-width: 0px">
                                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                                    </li>
                                                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                                                    </li>
                                                </ul>
                                                <div class="clearfix"></div>
                                            </div>
                                            <ul class="list-unstyled top_profiles scroll-view">
                                                <li class="media event">
                                                    <img class="pull-left" height="60px" src="../img/posts/detail/1.png"/>
                                                    <div class="media-body">
                                                        <p class="text-center text-uppercase"><strong>Hà Nội Một Biển Trời Yêu Thương</strong></p>
                                                    </div>
                                                </li>
                                                <li class="media event">
                                                    <img class="pull-left" height="60px" src="../img/posts/detail/2.png"/>
                                                    <div class="media-body">
                                                        <p class="text-center text-uppercase"><strong>Huế Một Kỳ Nghỉ Hạnh Phúc</strong></p>
                                                    </div>
                                                </li>
                                                <li class="media event">
                                                    <img class="pull-left" height="60px" src="../img/posts/detail/3.png"/>
                                                    <div class="media-body">
                                                        <p class="text-center text-uppercase"><strong>Sài Gòn sống lại và Sài Gòn Hối Hả</strong></p>
                                                    </div>
                                                </li>
                                                
                                            </ul>
                                        </div>
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
        <!-- Custom Theme Scripts -->
        <script src="../admin/js/custom.min.js"></script>
    </body>
</html>
