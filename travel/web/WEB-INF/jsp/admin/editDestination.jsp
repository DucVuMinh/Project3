<%-- 
    Document   : editDestination
    Created on : Dec 12, 2016, 12:52:13 AM
    Author     : vanduc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin | Sửa thông tin địa điểm</title>
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

                            <ul class="nav navbar-nav navbar-right">
                                <li class="">
                                    <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                        <img src="../admin/images/img.jpg" alt="">GT
                                        <span class="fa fa-angle-down"></span>
                                    </a>
                                    <ul class="dropdown-menu dropdown-usermenu pull-right">
                                        <li><a href="javascript:;">Thông tin các nhân</a></li>
                                        <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i>Đăng xuất</a></li>
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
                                <div>Tên địa điểm đã tồn tại!</div>
                            </div>
                        </c:if>
                        <!--/Flash Message-->
                        
                        <div class="page_title">
                            <div class="title_left">
                                <h3>Sửa thông tin địa điểm</h3>
                            </div>

                        </div>
                    </div>

                    <div class="clearfix"></div>

                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Form sửa thông tin địa điểm</h2>
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
                                          action="editDestination.htm?idDestination=${des.idDestination}" method="POST" enctype="multipart/form-data">
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name_destination">
                                                Tên địa điểm <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="text" name="name_destination" required class="form-control col-md-7 col-xs-12" value="${des.title}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name_domain">Tên miền <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <div class="btn-group" data-toggle="buttons">
                                                    <c:forTokens items="Miền Bắc,Miền Trung,Miền Nam" delims="," var="name">
                                                        <c:choose>
                                                            <c:when test="${des.nameArea eq name}">
                                                                <label class="btn btn-default active">
                                                                    <input type="radio" name="name_domain" checked="true" value="${name}">${name}
                                                                </label>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <label class="btn btn-default">
                                                                    <input type="radio" name="name_domain" value="${name}" required>${name}
                                                                </label>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:forTokens>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                                Giới thiệu <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <textarea class="resizable_textarea form-control" placeholder="Giới thiệu ngắn gọn về địa điểm.............." name="desciption"
                                                          required >${des.discription}</textarea>
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
                                                        <img src="../img/destination/profile/${des.idDestination}.png" alt="Image preview" class="thumbnail" style="max-width: 250px; max-height: 250px;">
                                                        <label class="btn btn-default btn-file" />
                                                        <span>Change</span>
                                                        <input type="file" name="image-file">
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
                                    <h2>Hình ảnh địa điểm</h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a href=""></a></li>
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                                        <li><a class="close-link"><i class="fa fa-close"></i></a></li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>

                                <div class="x_content">
                                    <c:forEach items="${des.imagedetailDestinations}" var="p">
                                        <figure class="show-image">
                                        <img src="../img/destination/detail/${p.idImage}.png" class="img_detail thumbnail zoom">
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