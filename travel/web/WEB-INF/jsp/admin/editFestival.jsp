<%-- 
    Document   : editFestival
    Created on : Dec 17, 2016, 10:30:12 AM
    Author     : vanduc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin | Sửa thông tin lễ hội</title>
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
                        <c:if test="${not empty param.success && param.success == 'false'}">
                            <div class="alert alert-danger" style="margin-top: 50px;">
                                <div>Tên lễ hội đã tồn tại!</div>
                            </div>
                        </c:if>
                        <!--/Flash Message-->
                        <div class="page_title">
                            <div class="title_left">
                                <h3>Sửa thông tin lễ hội</h3>
                            </div>

                        </div>
                    </div>

                    <div class="clearfix"></div>

                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Form sửa thông tin lễ hội</h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a href=""></a></li>
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                                        <li><a class="close-link"><i class="fa fa-close"></i></a></li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>

                                <div class="x_content">
                                    <br/>
                                    <form id="form-addlocation" data-parsley-validate class="form-horizontal form-label-left"
                                          action="editFestival.htm?idFestival=${fes.idFestival}" method="POST" enctype="multipart/form-data">
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name_festival">
                                                Tên lễ hội <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="text" name="name_festival" required class="form-control col-md-7 col-xs-12" value="${fes.title}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name_destination">Tên địa điểm <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <select id="name_destination" name="name_destination" class="selectpicker" data-live-search="true" title="Chọn địa điểm...">
                                                    <c:forEach items = "${listDes}" var = "p">
                                                        <option value="${p.title}" <c:if test="${fes.destination.title eq p.title}"> selected</c:if> >
                                                            <c:out value="${p.title}" />
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                                Giới thiệu <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <textarea class="resizable_textarea form-control" placeholder="Giới thiệu ngắn gọn lễ hội.............." name="desciption"
                                                          required >${fes.discription}</textarea>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                                Ảnh đại diện <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <div class="imageupload panel panel-default">
                                                    <div class="panel-heading clearfix">
                                                        <h3 class="panel-title pull-left">Upload Image</h3>
                                                    </div>
                                                    <div class="file-tab panel-body">
                                                        <img src="../img/festival/profile/${fes.idFestival}.png" alt="Image preview" class="thumbnail">
                                                        <label class="btn btn-default btn-file" />
                                                        <span>Change</span>
                                                        <input type="file" name="profile"/>
                                                        </label>
                                                        <button type="button" class="btn btn-default">Remove</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="ln_solid"></div>
                                        
                                        <div class="form-group">
                                            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                                <input type="reset" class="btn btn-primary" value="Hủy"/>
                                                <input type="submit" class="btn btn-success" value="Lưu"/>
                                            </div>
                                        </div>
                                    </form>
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
                                    <c:forEach items="${fes.imagedetailFestivals}" var="p">
                                        <figure class="show-image">
                                            <img src="../img/festival/detail/${p.idImage}.png" class="img_detail thumbnail zoom">
                                            <figcaption class="figure-caption">
                                                <a href="" class="delete-image"><i class="fa fa-trash" aria-hidden="true"></i></a>
                                            </figcaption>
                                        </figure>
                                    </c:forEach>
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
        <!-- Autosize -->
        <script src="../admin/vendors/autosize/dist/autosize.min.js"></script>
        <!-- Dropzone.js -->
        <script src="../admin/vendors/dropzone/dist/min/dropzone.min.js"></script>

        <!-- Custom Theme Scripts -->
        <script src="../admin/js/custom.min.js"></script>
        <script type="text/javascript" src="../admin/js/bootstrap-select.js"></script>
        <!-- Upload Image Banner -->
        <script type="text/javascript" src="../admin/js/bootstrap-imageedit.js"></script>

        <script type="text/javascript">
            var $imageupload = $('.imageupload');

            $imageupload.imageupload();

            $imageupload.imageupload({
                allowedFormats: ["jpg", "jpeg", "png", "gif"],
                previewWidth: 350,
                previewHeight: 350,
                maxFileSizeKb: 4048
            });
        </script>
        <!-- /Upload Image Banner -->
        <!-- Autosize -->
        <script>
            $(document).ready(function () {
                autosize($('.resizable_textarea'));
            });
        </script>
        <!-- /Autosize -->
    </body>
</html>
