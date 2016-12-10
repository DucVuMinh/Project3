<%-- 
    Document   : customheader
    Created on : 01-Dec-2016, 00:06:02
    Author     : DucVu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <nav class="navbar navbar-custom navbar-fixed-top" role="navigation" style="background:#1d508d">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                        Menu <i class="fa fa-bars"></i>
                    </button>
                    <a class="navbar-brand page-scroll" href="#page-top">
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
                            <a href="#page-top">Trang chủ</a>
                        </li>
                        <li>
                            <a href="#contact">Địa Điểm</a>
                        </li>
                        <li>
                            <a href="#sight">Thắng cảnh</a>
                        </li>
                        <li>
                            <a href="#festival">Lễ hội</a>
                        </li>
                        <li>
                            <div class="dropdown-user" >
                                <a href="#profile">
                                    <img src="img/default/user.png" style="margin-top: 5px; margin-left: 15px;" class="img-circle" width="35" height="35">
                                </a>
                                <div class="dropdown-content">
                                    <a href="">Sửa thông tin cá nhân</a>
                                    <a href="">Mục yêu thích</a>
                                    <a href="">Quản lý bài viết</a>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="collapse navbar-collapse navbar-right navbar-main-collapse" >
                    <form class="navbar-form" role="search">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search" name="q" style="border-radius:8px;background:#fcfcfc">
                        </div>
                    </form>
                </div>

                <div class="form-login">
                    <button type="button" data-toggle="modal" data-target="#myModal1" class="button-modal">Đăng nhập</button>
                    <button type="button" data-toggle="modal" data-target="#myModal2" class="button-modal">Đăng ký</button>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>
</html>
