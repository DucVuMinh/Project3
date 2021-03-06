<%-- 
    Document   : addDestination
    Created on : Dec 10, 2016, 12:28:37 AM
    Author     : vanduc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin | Thêm địa điểm</title>
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

        <!-- Upload Image Banner -->
        <link rel="stylesheet" type="text/css" href="../admin/css/bootstrap-imageupload.css">

        <style>
            input[type="file"] {
                display: none;
            }
            .custom-file-upload {
                border: 1px solid #ccc;
                display: table;
                padding: 6px 12px;
                cursor: pointer;
            }
            .imageThumb {
                max-height: 130px;
                border: 2px solid;
                padding: 1px;
                cursor: pointer;
            }
            .pip {
                display: inline-block;
                margin: 10px 10px 0 0;
            }
            .remove {
                display: block;
                /*background: #444;*/
                /*border: 1px solid black;*/
                font-size: 14px;
                color: #3e3232;
                text-align: center;
                cursor: pointer;
            }
            .remove:hover {
                background: white;
                color: black;
            }
        </style>

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
                                        <li><a href="javascript:;">Thông tin các nhân</a></li>
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
                        <c:if test="${not empty error}">
                            <div class="alert alert-danger" style="margin-top: 50px;">
                                <div id="warning_cnt"><c:out value="${error}" /></div>
                            </div>
                        </c:if>
                        <!--/Flash Message-->
                        <div class="page_title">
                            <div class="title_left">
                                <h3>Thêm địa điểm</h3>
                            </div>

                        </div>
                    </div>

                    <div class="clearfix"></div>

                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Form thêm địa điểm</h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a href=""></a></li>
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                                        <li><a class="close-link"><i class="fa fa-close"></i></a></li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <br/>
                                    <form id="form-addlocation" data-parsley-validate class="form-horizontal form-label-left "
                                          action="addDestination.htm" method="POST" onsubmit="return validateForm()" enctype="multipart/form-data">
                                        <!--Ten dia diem-->
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name_destination">
                                                Tên địa điểm <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <c:choose>
                                                    <c:when test="${param.name_destination == null}">
                                                        <input type="text" name="name_destination"
                                                               required="required" class="form-control col-md-7 col-xs-12"/>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="text" name="name_destination"
                                                               required="required" class="form-control col-md-7 col-xs-12" value="<c:out value="${param.name_destination}" />">
                                                    </c:otherwise>
                                                </c:choose>
                                            </div>
                                        </div>

                                        <!--Ten mien-->
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name_domain">Tên miền <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <div class="btn-group" data-toggle="buttons">
                                                    <c:forTokens items="Miền Bắc,Miền Trung,Miền Nam" delims="," var="name">
                                                        <c:choose>
                                                            <c:when test="${param.name_domain eq name}">
                                                                <label class="btn btn-default active">
                                                                    <input type="radio" name="name_domain" checked="true" value="${name}">${name}
                                                                </label>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <label class="btn btn-default">
                                                                    <input type="radio" name="name_domain" required value="${name}" >${name}
                                                                </label>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:forTokens>

                                                </div>
                                            </div>
                                        </div>

                                        <!--Gioi thieu-->
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                                Giới thiệu <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <textarea class="resizable_textarea form-control" placeholder="Giới thiệu ngắn gọn về địa điểm.............." name="desciption" 
                                                          required><% if (request.getParameterMap().containsKey("desciption")) {%><%=request.getParameter("desciption")%> <% }%></textarea>
                                            </div>
                                        </div>

                                        <!--Anh dai dien-->
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                                Ảnh đại diện <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12 ">
                                                <div class="imageupload panel panel-primary">
                                                    <div class="panel-heading clearfix">
                                                        <h3 class="panel-title pull-left">Upload image</h3>
                                                    </div>
                                                    <div class="file-tab panel-body">
                                                        <label class="btn btn-default btn-file">
                                                            <span>Browse</span>
                                                            <input type="file" name="profile" required/>
                                                        </label>
                                                        <button type="button" class="btn btn-default">Remove</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <!--Anh chi tiet-->
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                                Ảnh chi tiết <span class="required">*</span>
                                            </label>
                                            <label  for="img_detail" class="custom-file-upload">
                                                <i class="fa fa-cloud-upload"></i> Choose Image

                                            </label>
                                            <input type="file" id="img_detail" name="img_detail" multiple required/>
                                            <div class="col-md-8 col-sm-6 col-xs-12 col-md-offset-3 " id="bound_img"></div>

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
        <!-- Upload Image Banner -->
        <script type="text/javascript" src="../admin/js/bootstrap-imageupload.js"></script>

        <!--Validate form  -->
        <script>
                                              function validateForm() {
                                                  return true;
                                              }
        </script>

        <!-- Upload Image Banner -->
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


        <!-- Autosize -->
        <script>
            $(document).ready(function () {
                autosize($('.resizable_textarea'));
            });
        </script>
        
        <script>
            $(document).ready(function () {
                if (window.File && window.FileList && window.FileReader) {
                    $("#img_detail").on("change", function (e) {
                        var files = e.target.files,
                                filesLength = files.length;
                        for (var i = 0; i < filesLength; i++) {
                            var f = files[i]
                            var fileReader = new FileReader();
                            fileReader.onload = (function (e) {
                                var file = e.target;
                                $("#bound_img").append($("<span class=\"pip\">" +
                                        "<img class=\"imageThumb\" src=\"" + e.target.result + "\" title=\"" + file.name + "\"/>" +
                                        "<br/><span class=\"remove\"><i class=\"fa fa-2x fa-trash-o\"></i></span>" +
                                        "</span>"))
                                $(".remove").click(function () {
                                    $(this).parent(".pip").remove();
                                });

                            });
                            fileReader.readAsDataURL(f);
                        }
                    });
                } else {
                    alert("Your browser doesn't support to File API")
                }
            });
        </script>
    </body>
</html>
