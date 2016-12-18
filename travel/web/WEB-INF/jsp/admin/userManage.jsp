<%-- 
    Document   : userManage
    Created on : Dec 17, 2016, 11:26:42 PM
    Author     : vanduc
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Quản lý người dùng</title>
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
                        <div class="page-title">
                            <div class="title_left">
                                <h3>Quản lý người sử dụng</h3>
                            </div>
                        </div>

                        <div class="clearfix"></div>

                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Danh sách người dùng</h2>
                                        <ul class="nav navbar-right panel_toolbox">
                                            <li><a href=""></a></li>
                                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                                            <li><a class="close-link"><i class="fa fa-close"></i></a></li>
                                        </ul>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                                        <table id="datatable" class="table table-striped table-bordered" >
                                            <thead>
                                                <tr>
                                                    <th style="width: 20px">STT</th>
                                                    <th>Họ tên</th>
                                                    <th>Username</th>
                                                    <th>Ảnh đại diện </th>
                                                    <th>Email</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% int i = 1;%>
                                                <c:forEach items = "${listUser}" var = "p">
                                                    <c:if test="${p.state == 1 && p.facebookId == null}">
                                                        <tr>
                                                            <td><c:out value="<%=i%>" /></td>
                                                            <td><c:out value="${p.fullname}" /></td>
                                                            <td><c:out value="${p.username}" /></td>
                                                            <td>
                                                                <img style="width: 100px; height: 60px;" src="../img/users/profile/<c:out value="${p.idUser}"/>.png" />
                                                            </td>
                                                            <td><c:out value="${p.email}" /></td>         
                                                            <td><a class="btn btn-danger btn-xs" data-toggle="modal" data-target="#${p.username}" ><i class="fa fa-lock"></i> Khóa</a></td>

                                                        </tr>

                                                    <div class="modal fade" id="${p.username}" role="dialog">
                                                        <div class="modal-dialog modal-sm">

                                                            <!-- Modal content-->
                                                            <div class="modal-content">
                                                                <div class="modal-body">
                                                                    <h4 class="text-center">Bạn muốn khóa người dùng ${p.username}?</h4>
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                                    <button type="button" class="btn btn-default" onclick="lockUser('${p.idUser}')">OK</button>
                                                                </div>
                                                            </div>

                                                        </div>
                                                    </div>
                                                    <% i++;%>
                                                </c:if>

                                            </c:forEach>  
                                            </tbody>

                                        </table>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2 style="color: red">Danh sách người dùng bị khóa </h2>
                                        <ul class="nav navbar-right panel_toolbox">
                                            <li><a href=""></a></li>
                                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                                            <li><a class="close-link"><i class="fa fa-close"></i></a></li>
                                        </ul>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                                        <table id="datatable-checkbox" class="table table-striped table-bordered">
                                            <thead>
                                                <tr>
                                                    <th style="width: 20px">STT</th>
                                                    <th>Họ tên</th>
                                                    <th>Username</th>
                                                    <th>Ảnh đại diện </th>
                                                    <th>Email</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <% int j = 1;%>
                                                <c:forEach items = "${listUser}" var = "p">
                                                    <c:if test="${p.state == -1}">
                                                        <tr>
                                                            <td><c:out value="<%=j%>" /></td>
                                                            <td><c:out value="${p.fullname}" /></td>
                                                            <td><c:out value="${p.username}" /></td>
                                                            <td>
                                                                <img style="width: 100px; height: 60px;" src="../img/users/profile/<c:out value="${p.idUser}"/>.png" />
                                                            </td>
                                                            <td><c:out value="${p.email}" /></td>         
                                                            <td><a class="btn btn-success btn-xs" data-toggle="modal" data-target="#${p.username}" ><i class="fa fa-unlock"></i> Mở khóa</a></td>
                                                        </tr>
                                                        
                                                    <div class="modal fade" id="${p.username}" role="dialog">
                                                        <div class="modal-dialog modal-sm">

                                                            <!-- Modal content-->
                                                            <div class="modal-content">
                                                                <div class="modal-body">
                                                                    <h4 class="text-center">Bạn muốn mở khóa người dùng ${p.username}?</h4>
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                                    <button type="button" class="btn btn-default" onclick="unlockUser('${p.idUser}')">OK</button>
                                                                </div>
                                                            </div>

                                                        </div>
                                                    </div>
                                                    <% j++;%>
                                                </c:if>

                                            </c:forEach>  
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>                    
                        </div>

                        <!--<div class="ln_solid"></div>-->



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
    <script src="../admin/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
    <script src="../admin/vendors/jszip/dist/jszip.min.js"></script>
    <script src="../admin/vendors/pdfmake/build/pdfmake.min.js"></script>
    <script src="../admin/vendors/pdfmake/build/vfs_fonts.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="../admin/js/custom.min.js"></script>


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
    <script>
        function lockUser(idUser) {
            window.location.href = "/travel/admin/lockUser.htm?idUser=" + idUser;
        }

        function unlockUser(idUser) {
            window.location.href = "/travel/admin/unlockUser.htm?idUser=" + idUser;
        }
    </script>

</body>
</html>