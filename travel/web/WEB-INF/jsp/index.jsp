<%-- 
    Document   : writeposts
    Created on : 30-Nov-2016, 15:41:32
    Author     : DucVu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html ; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>S-travel</title>

        <!-- Bootstrap Core CSS -->
        <link href="client/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom Fonts -->
        <link href="client/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">

        <!-- Theme CSS -->
        <link href="client/css/grayscale.css" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="admin/css/bootstrap-imageupload.css">
        <script src="admin/js/custom.min.js"></script>
        <script type="text/javascript" src="admin/js/bootstrap-imageupload.js"></script>
        <script type="text/javascript" src="client/js/jquery-1.10.2.min.js"></script>
        <script src="admin/vendors/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="admin/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- Autosize -->
        <script src="admin/vendors/autosize/dist/autosize.min.js"></script>
        <!-- Dropzone.js -->
        <script src="admin/vendors/dropzone/dist/min/dropzone.min.js"></script>
    </head>

    <body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

        <!-- Navigation -->
        <%@ include file = "customheader.jsp" %>

        <div class="container" style="padding-top:200px;padding-bottom:30px" >

            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <div class= "container-border">
                                <div class="title"> Chia sẻ những trải nghiệm của bạn</div>
                            </div>
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
                                  action="addposts.htm" method="POST" onsubmit="return validateForm()" enctype="multipart/form-data">
                                <!--Ten dia diem-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name_destination">
                                        Tên địa điểm <span class="required">*</span>
                                    </label>

                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" name="title"
                                               required="required" class="form-control col-md-7 col-xs-12"/>
                                    </div>
                                </div>
                                <div class="row">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name_destination">
                                        Địa điểm du lịch:     <span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <select class="form-control" id="seldes" name="seldes">
                                            <c:forEach var="des" items="${lisDes}">
                                                <option id="${des.idDestination}">${des.title}</option>
                                            </c:forEach>
                                        </select><br/>
                                    </div>
                                </div>
                                <!--Ten mien-->


                                <!--Gioi thieu-->
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">
                                        Giới thiệu <span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <textarea class="resizable_textarea form-control"  placeholder="Giới thiệu ngắn gọn về địa điểm.............." name="content" 
                                                  required></textarea>
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
                                    <input type="file" id="img_detail" name="img_detail" multiple="multiple" required/>
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

        <hr >
        <c:import url="http://localhost:8080/travel/customfooter.htm" />

        <!-- jQuery -->
        <script src="client/vendor/jquery/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="client/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!-- Theme JavaScript -->
        <script src="client/js/grayscale.min.js"></script>

    </body>
    <script>
                                      var $imageupload = $('.imageupload');

                                      $imageupload.imageupload();

                                      $imageupload.imageupload({
                                          allowedFormats: ["jpg", "jpeg", "png", "gif"],
                                          previewWidth: 350,
                                          previewHeight: 350,
                                          maxFileSizeKb: 4048
                                      });
    </script>
    <script type="text/javascript">
        function validateForm() {
            return true;
        }
        $(document).ready(function () {
            autosize($('.resizable_textarea'));
        });

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
//                                        "<br/><span class=\"remove\">Remove</span>" +
                                    "<br/><span class=\"remove\"><i class=\"fa fa-trash-o\"></i>Delete</span>" +
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
            color: red;
            text-align: center;
            cursor: pointer;
        }
        .remove:hover {
            background: white;
            color: black;
        }
    </style>
</html>

