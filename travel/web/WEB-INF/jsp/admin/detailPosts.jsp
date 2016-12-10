<%-- 
    Document   : adminDetailPost
    Created on : Nov 24, 2016, 12:32:31 AM
    Author     : GiangTHQ
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin | Thông tin bài viết</title>
        <meta charset="utf-8">
        <!-- Bootstrap -->
        <link href="../admin/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="../admin/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- Pagination -->
        <link href="../admin/vendors/pagination/dist/pagination.css" rel="stylesheet">

        <!-- Custom Theme Style -->
        <link href="../admin/css/custom.css" rel="stylesheet">
        <link href="../admin/css/css.css" rel="stylesheet">


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
                            <!--Flash Message-->
                            <c:if test="${not empty message}">
                                <div class="alert alert-success" style="margin-top: 50px;">
                                    <div id="warning_cnt">${message}</div>
                                </div>
                            </c:if>
                            <!--/Flash Message-->
                            <div class="title_left">
                                <h3>${p.title}</h3>
                            </div>

                            <div class="title-right">
                                <div class="col-md-1 col-sm-1 col-xs-12 form-group pull-right top_search">
                                    <div class="input-group">
                                        <button type="button" class="btn btn-round btn-warning" onclick="deletePost()"><i class="fa fa-trash-o" aria-hidden="true"></i>   Xóa</button>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="clearfix"></div>

                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Lượt yêu thích và đánh giá</h2>
                                        <div class="clearfix"></div>
                                    </div>

                                    <div class="x_content">
                                        <br/>
                                        <div class="group-content row">
                                            <div class="title-content col-md-3 col-xs-12 col-sm-3">
                                                <p>Lượt yêu thích</p>
                                            </div>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <p><i class="fa fa-heart-o" aria-hidden="true" style="color: red;"></i> ${p.usersFarvorite.size()}</p>
                                            </div>
                                        </div>
                                        <div class="group-content row">
                                            <div class="title-content col-md-3 col-xs-12 col-sm-3">
                                                <p>Đánh giá</p>
                                            </div>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <c:forEach begin="1" end="5" var="r">
                                                    <div class="row">
                                                        <div class="col-sm-4 col-md-4 col-xs-12">
                                                            <c:forEach begin="1" end="5" var="ri">
                                                                <c:choose>
                                                                    <c:when test="${ri <= r}">
                                                                        <i class="fa fa-star-o" aria-hidden="true" style="color: yellow; font-size: 20px;"></i>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <i class="fa fa-star-o" aria-hidden="true" style="font-size: 20px;"></i>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach>
                                                        </div>
                                                        <div class="col-sm-8 col-md-8 col-xs-12">
                                                            ${rank.get(r-1)} lượt
                                                        </div>
                                                    </div> 
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Nội dung bài viết</h2>
                                        <div class="clearfix"></div>
                                    </div>

                                    <div class="x_content">
                                        <div class="col-md-1 col-sm-1 col-xs-12"></div>
                                        <div class="col-md-10 col-sm-10 col-xs-12">
                                            <p> ${p.context}
                                            </p>
                                        </div>
                                        <div class="col-md-1 col-sm-1 col-xs-12"></div>
                                    </div>
                                </div>

                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Hình ảnh </h2>
                                        <div class="clearfix"></div>
                                    </div>

                                    <div class="x_content">
                                        <c:forEach items="${p.getImagedetailPostses()}" var="i">
                                            <img src="../img/posts/detail/${i.getIdImage()}.png" class="img_detail thumbnail zoom">
                                        </c:forEach>
                                    </div>
                                </div>

                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Bình luận </h2>
                                        <div class="clearfix"></div>
                                    </div>

                                    <div class="x_content">    
                                        <c:choose>
                                            <c:when test="${cmtAct.size() == 0}">
                                                <c:out value="Không có bình luận!" />
                                            </c:when>
                                            <c:otherwise>     
                                                <div id="cmt_content">
                                                    <c:forEach items="${cmtAct}" var="cmt">
                                                    </c:forEach>
                                                </div>
                                                <div id="pagination-container" class="col-sm-12 col-md-12" style="text-align: center; left: 500px;"></div>
                                            </c:otherwise>
                                        </c:choose>


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
        <!-- Pagination -->
        <script src="../admin/vendors/pagination/dist/pagination.js"></script>

        <!-- Custom Theme Scripts -->
        <script src="../admin/js/custom.min.js"></script>

        <script>
            function deleteComment(idCmt) {
                var comfirmBox = confirm("Bạn muốn xóa bình luận này?");
                if (comfirmBox == true) {
                    window.location.href = "/travel/admin/deleteComment.htm?idCmt=" + idCmt + "&idPost=${p.getIdPosts()}";
                }
            }

            function deletePost() {
                var comfirmBox = confirm("Bạn muốn xóa bài viết ${p.getTitle()}?");
                if (comfirmBox == true) {
                    window.location.href = "/travel/admin/deletePosts.htm?idPost=${p.getIdPosts()}";
                }
            }
        </script>
        <script>
            var cmts = ${cmtJson};
            $('#pagination-container').pagination({
                dataSource: cmts,
                pageSize: 3,
                callback: function (data, pagination) {
                    var html = listCmt(data);
                    $('#cmt_content').html(html);
                }
            });
            function listCmt(data) {
                var html = '';
                $.each(data, function (index, item) {
                    var url_img = "img/users/profile/" + item.profile + ".png";
                    html += "<div class='row'>"
                            + "<div class='col-sm-1 col-md-1 col-xs-12'></div>"
                            + "<div class='col-sm-1 col-md-1 col-xs-2'>"
                            + "<div class='thumbnail' style='height: auto'>"
                            + "<img class='user-photo' src='" + url_img + "' />"
                            + "</div>"
                            + "</div>"
                            + "<div class='col-md-9 col-sm-9 col-xs-12'>"
                            + "<div class='panel panel-default'>"
                            + "<div class='panel-heading'>"
                            + "<strong>" + item.username + "</strong>"
                            + "<span class='text-muted'>  " + item.dateWrite + "</span>"
                            + "<a href='#' style='float:right;' onclick='deleteComment(" + item.id + ");'><i class='fa fa-trash' aria-hidden='true'></i></a>"
                            + "</div>"
                            + "<div class='panel-body'>"
                            + item.context
                            + "</div>"
                            + "</div>"
                            + "</div>"
                            + "<div class='col-sm-1 col-md-1 col-xs-12'></div>"
                            + "</div>"
                })
                return html;
            }
        </script>
    </body>
</html>
