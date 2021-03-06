<%-- 
    Document   : customheader
    Created on : 01-Dec-2016, 00:06:02
    Author     : DucVu
--%>
<%@page import="travel.model.User"%>
<%@ page import="javax.servlet.http.HttpSession"%>

<!DOCTYPE html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="client/js/controller/ClientHeader.js"></script>
<!-- JS file -->
<script src="client/js/jquery.easy-autocomplete.js"></script> 

<!-- CSS file -->
<link rel="stylesheet" href="client/css/easy-autocomplete.min.css"> 

<!-- Additional CSS Themes file - not required-->
<link rel="stylesheet" href="client/css/easy-autocomplete.themes.min.css"> 
<script src="client/js/cussearch.js"></script>

<%
    String username = (String) session.getAttribute("username");
    String idimg = "0";
    String profile="img/users/profile/0.png";
    boolean login = true;
    boolean createAccount = true;
    boolean logout = false;
    try {
        String serverName = request.getServerName();
        if (username != null) {
            User u = User.getUserByUserName(username);
            login = false;
            createAccount = false;
            logout = true;
            if (u.getFacebookId() == null || u.getFacebookId().isEmpty()) {
                idimg = String.valueOf(u.getIdUser());
                profile="img/users/profile/"+u.getIdUser()+".png";
            } else {
                profile="http://graph.facebook.com/"+u.getFacebookId()+"/picture";
                        
            }
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
%>
<nav id="headerele" class="navbar navbar-custom navbar-fixed-top" role="navigation" style="background: #1d508d" >
    <div class="container" ng-app="headerapp" ng-controller="headerctr" ng-init="int(<%=login%>,<%=logout%>,<%=createAccount%>)">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                Menu <i class="fa fa-bars"></i>
            </button>
            <a class="navbar-brand page-scroll" href="custommain.htm">
                <img src="img/default/logo1.jpg" style > 
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->

        <div class="collapse navbar-collapse navbar-center navbar-main-collapse">
            <ul class="nav navbar-nav">
                <li class="hidden">
                    <a href="#page-top"></a>
                </li>
                <li>
                    <a href="custommain.htm">Trang chủ</a>
                </li>
                <li>
                    <a href="detailland.htm">Thắng cảnh</a>
                </li>
                <li>
                    <a href="detailfes.htm">Lễ hội</a>
                </li>
                <li>
                    <a href="detailpost.htm">Bài viết</a>
                </li>
                <li>
                    <div class="dropdown-user" >
                        <a href="#profile">
                            <img src="<%=profile%>" style="margin-top: 5px; margin-left: 15px;" class="img-circle" width="35" height="35">
                        </a>
                        <div class="dropdown-content">
                            <a href="customupdateinfuser.htm">Sửa thông tin cá nhân</a>
                            <a href="custommanagefavorite.htm">Mục yêu thích</a>
                            <a href="custommanageposts.htm">Quản lý bài viết</a>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
        <div class="collapse navbar-collapse navbar-right navbar-main-collapse" >
            <form class="navbar-form" role="search">
                <div class="input-group">
                    <input id="ajax-search" type="text" class="form-control" placeholder="Search" name="q" style="border-radius:8px;background:#fcfcfc" my-enter="search()" ng-model="datasearch" required>
                </div>
            </form>
        </div>

        <div class="form-login" >
            <a ng-show="loginapp" href="customlogin.htm"><button type="button" data-toggle="modal" data-target="#myModal1" class="button-modal" >Đăng nhập</button></a>
            <a ng-show="createaccountapp" href="customcreateaccount.htm"><button type="button" data-toggle="modal" data-target="#myModal2" class="button-modal" >Đăng ký</button></a>
            <button ng-show="logoutapp" ng-click="cusLogout()" type="button" data-toggle="modal" data-target="#myModal2" class="button-modal" >Đăng Xuất</button>

        </div>

        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

