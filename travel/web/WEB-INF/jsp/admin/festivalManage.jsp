<%-- 
    Document   : festivalManage
    Created on : Dec 10, 2016, 11:30:09 PM
    Author     : vanduc
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Quản lý lễ hội</title>
        <meta charset="utf-8">
        <!-- Bootstrap -->
        <link href="../admin/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="../admin/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- NProgress -->
        <link href="../admin/vendors/nprogress/nprogress.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="../admin/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
        <!-- Datatables -->
        <link href="../admin/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
        <link href="../admin/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
        <link href="../admin/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
        <link href="../admin/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
        <link href="../admin/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

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
                                        <li><a href="javascript:;">Thông tin cá nhân</a></li>
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
                        <c:if test="${not empty message}">
                            <div class="alert alert-success" style="margin-top: 50px;">
                                <div id="warning_cnt">${message}</div>
                            </div>
                        </c:if>
                        <div class="page-title">
                            <div class="title_left">
                                <h3>Quản lý lễ hội</h3>
                            </div>

                            <div class="title-right">
                                <div class="col-md-1 col-sm-1 col-xs-12 form-group pull-right top_search">
                                    <div class="input-group">
                                        <a href="addFestival.htm">
                                            <button type="button" name="addFestival" class="btn btn-round btn-warning">
                                                <i class="fa fa-plus" aria-hidden="true"></i>Thêm
                                            </button>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="clearfix"></div>

                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Danh sách lễ hội</h2>
                                        <ul class="nav navbar-right panel_toolbox">
                                            <li><a href=""></a></li>
                                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                                            <li><a class="close-link"><i class="fa fa-close"></i></a></li>
                                        </ul>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                                        <table id="datatable" class="table table-striped table-bordered">
                                            <thead>
                                                <tr>
                                                    <th style="width: 20px">STT</th>
                                                    <th>Tên lễ hội</th>
                                                    <th>Địa điểm</th>
                                                    <th>Ảnh</th>
                                                    <th>Mô tả</th>
                                                    <th>Chi tiết</th>
                                                    <th></th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% int i = 1;%>
                                                <c:forEach items = "${listFes}" var = "p">
                                                    <c:if test="${p.state == 1}">
                                                        <tr>
                                                            <td><c:out value="<%=i%>" /></td>
                                                            <td><c:out value="${p.title}" /></td>
                                                            <td><c:out value="${p.destination.title}" /></td>
                                                            <td>
                                                                <img style="width: 110px; height: 70px;" src="../img/festival/profile/<c:out value="${p.idFestival}"/>.png" />
                                                            </td>
                                                            <td>${fn:substring(p.discription, 0, 180)}........</td>         
                                                            <td><a class="btn btn-primary btn-xs" href="detailFestival.htm?idFestival=${p.idFestival}"><i class="fa fa-folder"></i>Xem</a></td>
                                                            <td><a class="btn btn-info btn-xs" href="#"><i class="fa fa-pencil"></i>Sửa</a></td>
                                                            <td><a class="btn btn-danger btn-xs" href="#" onclick="deleteFestival('${p.title}', ${p.idFestival})"><i class="fa fa-trash-o"></i>Xóa</a></td>
                                                        </tr>
                                                        <% i++;%>
                                                    </c:if>
                                                </c:forEach>
                                            </tbody>
                                        </table>
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
        <!-- Datatables -->
        <script src="../admin/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
        <script src="../admin/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
        <script src="../admin/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
        <script src="../admin/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
        <script src="../admin/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
        <script src="../admin/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
        <script src="../admin/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
        <script src="../admin/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
        <script src="../admin/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
        <script src="../admin/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
        <script src="../admin/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
        <script src="../admin/vendors/datatables.net-scroller/js/datatables.scroller.min.js"></script>
        <script src="../admin/vendors/jszip/dist/jszip.min.js"></script>
        <script src="../admin/vendors/pdfmake/build/pdfmake.min.js"></script>
        <script src="../admin/vendors/pdfmake/build/vfs_fonts.js"></script>

        <!-- Custom Theme Scripts -->
        <script src="../admin/js/custom.min.js"></script>


        <script>
                                                                function deleteFestival(title, id) {
                                                                    var comfirmBox = confirm("Bạn muốn xóa lễ hội  " + title + " ?");
                                                                    if (comfirmBox == true) {
                                                                        window.location.href = "/travel/admin/deleteFestival.htm?idFestival=" + id;
                                                                    }
                                                                }
        </script>

        <!-- Datatables -->
        <script>
            $(document).ready(function () {
                var handleDataTableButtons = function () {
                    if ($("#datatable-buttons").length) {
                        $("#datatable-buttons").DataTable({
                            dom: "Bfrtip",
                            buttons: [
                                {
                                    extend: "copy",
                                    className: "btn-sm"
                                },
                                {
                                    extend: "csv",
                                    className: "btn-sm"
                                },
                                {
                                    extend: "excel",
                                    className: "btn-sm"
                                },
                                {
                                    extend: "pdfHtml5",
                                    className: "btn-sm"
                                },
                                {
                                    extend: "print",
                                    className: "btn-sm"
                                },
                            ],
                            responsive: true
                        });
                    }
                };

                TableManageButtons = function () {
                    "use strict";
                    return {
                        init: function () {
                            handleDataTableButtons();
                        }
                    };
                }();

                $('#datatable').dataTable();

                $('#datatable-keytable').DataTable({
                    keys: true
                });

                $('#datatable-responsive').DataTable();

                $('#datatable-scroller').DataTable({
                    ajax: "js/datatables/json/scroller-demo.json",
                    deferRender: true,
                    scrollY: 380,
                    scrollCollapse: true,
                    scroller: true
                });

                $('#datatable-fixed-header').DataTable({
                    fixedHeader: true
                });

                var $datatable = $('#datatable-checkbox');

                $datatable.dataTable({
                    'order': [[1, 'asc']],
                    'columnDefs': [
                        {orderable: false, targets: [0]}
                    ]
                });
                $datatable.on('draw.dt', function () {
                    $('input').iCheck({
                        checkboxClass: 'icheckbox_flat-green'
                    });
                });

                TableManageButtons.init();
            });
        </script>
        <!-- /Datatables -->
    </body>
</html>