<%-- 
    Document   : customfooter
    Created on : 01-Dec-2016, 00:22:37
    Author     : DucVu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <section id="contact" class="container content-section text-center">

        <h2>S-travel</h2>
        <div class="row">
            <div class="col-lg-4" style="margin-right:0px">
                <center>MIỀN BẮC</center>
                <div class="north-vietnam">
                    <c:forEach var="rowbac" items="${mienbac}">
                        <div class="row">
                            <c:forEach var="itemdes" items="${rowbac.ldes}">
                                <div class="col-lg-4 col-md-6 col-sm-4 col-xs-6 ">
                                    <div class= "thumbnai" style="background:#F5F5F5">
                                        <a href="${itemdes.link}">
                                            <div class="img_format">
                                                <img src="${itemdes.profile}" class="img">

                                                <div class="figure">
                                                    <div class="text"> ${itemdes.title} </div>
                                                </div>
                                            </div>
                                        </a>
                                    </div>

                                </div>
                            </c:forEach>
                        </div>
                    </c:forEach>

                </div>
            </div> 
            <div class="col-lg-4" style="margin-right:0px">
                <div class="middle-vietnam">
                    <center> MIỀN TRUNG</center>
                    <c:forEach var="rowbac" items="${mientrung}">
                        <div class="row">
                            <c:forEach var="itemdes" items="${rowbac.ldes}">
                                <div class="col-lg-4 col-md-6 col-sm-4 col-xs-6 ">
                                    <div class= "thumbnai" style="background:#F5F5F5">
                                        <a href="${itemdes.link}">
                                            <div class="img_format">
                                                <img src="${itemdes.profile}" class="img">

                                                <div class="figure">
                                                    <div class="text"> ${itemdes.title} </div>
                                                </div>
                                            </div>
                                        </a>
                                    </div>

                                </div>
                            </c:forEach>
                        </div>
                    </c:forEach>
                </div> 
            </div>
            <div class="col-lg-4" style="margin-right:0px">
                <div class="sourth-vietnam">
                    <center>  MIỀN NAM</center>
                    <c:forEach var="rowbac" items="${miennam}">
                        <div class="row">
                            <c:forEach var="itemdes" items="${rowbac.ldes}">
                                <div class="col-lg-4 col-md-6 col-sm-4 col-xs-6 ">
                                    <div class= "thumbnai" style="background:#F5F5F5">
                                        <a href="${itemdes.link}">
                                            <div class="img_format">
                                                <img src="${itemdes.profile}" class="img">

                                                <div class="figure">
                                                    <div class="text"> ${itemdes.title} </div>
                                                </div>
                                            </div>
                                        </a>
                                    </div>

                                </div>
                            </c:forEach>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div> 
    </section>
    <footer>
        <div class="row" style=" background: #1d508d;color:#fff;margin-right:0px">
            <div class="contact">
                <div class="container">
                    <div class="contact-info">
                        <h6>S-Travel</h6>
                        <p>Địa chỉ: Đại học Bách Khoa Hà Nội</p>
                    </div>
                    <div class="contact-social">
                        <a href=""><i class="fa fa-twitter" aria-hidden="true"></i></a>
                        <a href=""><i class="fa fa-instagram" aria-hidden="true"></i></a>
                        <a href=""><i class="fa fa-google-plus" aria-hidden="true"></i></a>
                        <a href=""><i class="fa fa-facebook-square" aria-hidden="true"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </footer>
</html>
