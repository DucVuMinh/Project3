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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- Custom Fonts -->
        <link href="client/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css" rel="stylesheet" media="all">

        <!-- Theme CSS -->
        <link href="client/css/grayscale.css" rel="stylesheet">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    </head>

    <body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

        <!-- Navigation -->
        <%@ include file = "customheader.jsp" %>

        <!-- Intro Header -->
        <header class="intro">



            <!--Chỗ này thêm nè-->
            <!-- Wrapper for slides -->
            <div id="bootstrap-touch-slider" class="carousel bs-slider fade  control-round indicators-line" data-ride="carousel" data-pause="hover" data-interval="5000" >

                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#bootstrap-touch-slider" data-slide-to="0" class="active"></li>
                    <li data-target="#bootstrap-touch-slider" data-slide-to="1"></li>
                    <li data-target="#bootstrap-touch-slider" data-slide-to="2"></li>
                    <li data-target="#bootstrap-touch-slider" data-slide-to="3"></li>
                    <li data-target="#bootstrap-touch-slider" data-slide-to="4"></li>
                </ol>

                <!-- Wrapper For Slides -->
                <div class="carousel-inner" role="listbox">

                    <!-- Third Slide -->
                    <div class="item active">

                        <!-- Slide Background -->
                        <img src="img/default/sen.jpg?w=940&h=650&auto=compress&cs=tinysrgb" alt="Bootstrap Touch Slider"  class="slide-image"/>
                        <div class="bs-slider-overlay"></div>

                        <div class="container">
                            <div class="row">
                                <!-- Slide Text Layer -->
                                <div class="slide-text slide_style_left">
                                    <h1 data-animation="animated zoomInRight">Việt Nam</h1>
                                    <p data-animation="animated fadeInLeft">Mảnh đất hình chữ S thân thương</p>

                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End of Slide -->
                    <!-- Second Slide -->
                    <div class="item">

                        <!-- Slide Background -->
                        <img src="img/default/halong1.jpg?w=940&h=650&auto=compress&cs=tinysrgb" alt="Bootstrap Touch Slider"  class="slide-image"/>
                        <div class="bs-slider-overlay"></div>
                        <!-- Slide Text Layer -->
                        <div class="slide-text slide_style_center">
                            <h1 data-animation="animated flipInX">Vịnh Hạ Long</h1>
                            <p data-animation="animated lightSpeedIn">Được Unessco công nhận là di sản thiên nhiên thế giới</p>

                        </div>
                    </div>
                    <!-- End of Slide -->

                    <!-- Second Slide -->
                    <div class="item">

                        <!-- Slide Background -->
                        <img src="img/default/aodai2.jpg?w=940&h=650&auto=compress&cs=tinysrgb" alt="Bootstrap Touch Slider"  class="slide-image"/>
                        <div class="bs-slider-overlay"></div>
                        <!-- Slide Text Layer -->
                        <div class="slide-text slide_style_center">
                            <h1 data-animation="animated flipInX">Hà Nội</h1>
                            <p data-animation="animated lightSpeedIn">Thủ đô ngàn năm văn hiến</p>

                        </div>
                    </div>
                    <!-- End of Slide -->

                    <!-- Third Slide -->
                    <div class="item">

                        <!-- Slide Background -->
                        <img src="img/default/danang.jpg?w=940&h=650&auto=compress&cs=tinysrgb" alt="Bootstrap Touch Slider"  class="slide-image"/>
                        <div class="bs-slider-overlay"></div>
                        <!-- Slide Text Layer -->
                        <div class="slide-text slide_style_right">
                            <h1 data-animation="animated zoomInLeft">Đà Nẵng</h1>
                            <p data-animation="animated fadeInRight">Nơi mệnh danh vùng đất đáng sống nhất Việt Nam, đang dần khẳng định bản lĩnh trong công cuộc xây dựng đất nước .</p>

                        </div>

                    </div>
                    <!-- End of Slide -->
                    <!-- 4 Slide -->
                    <div class="item">

                        <!-- Slide Background -->
                        <img src="img/default/hochiminh.jpg?w=940&h=650&auto=compress&cs=tinysrgb" alt="Bootstrap Touch Slider"  class="slide-image"/>
                        <div class="bs-slider-overlay"></div>
                        <!-- Slide Text Layer -->
                        <div class="slide-text slide_style_right">
                            <h1 data-animation="animated zoomInLeft">TP Hồ Chí Minh</h1>
                            <p data-animation="animated fadeInRight">Một Sài Gòn trù phú tấp nập</p>

                        </div>

                    </div>
                    <!-- End of Slide -->


                </div><!-- End of Wrapper For Slides -->

                <!-- Left Control -->
                <a class="left carousel-control" href="#bootstrap-touch-slider" role="button" data-slide="prev">
                    <span class="fa fa-angle-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>

                <!-- Right Control -->
                <a class="right carousel-control" href="#bootstrap-touch-slider" role="button" data-slide="next">
                    <span class="fa fa-angle-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>

            </div> <!-- End  bootstrap-touch-slider Slider -->

        </header>

        <!-- About Section -->
        <section id="about" class="container content-section text-center">
            <div class="row">
                <div class="col-lg-8">
                    <h2 style="margin-top:50px"> S- travel</h2>
                    <p>S- travel là tên một website, nơi để mọi người chia sẻ trải nghiệm du lịch của bản thân về đất nước hình chữ S thân yêu.Những thông tin về danh lam thắng cảnh và những lễ hội của các vùng miền trên đất nước Việt Nam . </p>
                    <p>Website được xây dựng bởi nhóm sinh viên trường đại học Bách Khoa Hà Nội, những sinh viên đến từ các vùng miền của đất nước, với mong ước mang vẻ đẹp Việt Nam đến mọi người trong cả nước. Nếu cớ thể mở rộng đó là với các du khách trên thế giới</p>
                    <p>Mong nhận được góp ý từ mọi người để có thể xây dựng cộng đồng du lịch trên website</p>
                    <p>Hãy cùng chúng tôi xây dựng một đất nước Việt Nam giàu mạnh!</p>
                </div>
                <div class="col-lg-4">
                    <img src="img/default/vn1.jpg">
                </div>
            </div>

            <div class="row"> 
                <div class="title">Chúng tôi đến từ</div>
                <div class="col-xs-5ths col-lg-5ths col-md-5ths col-sm-5ths">
                    <img class="img-circle" src="img/default/thaibinh.jpg" alt="Generic placeholder image" width="140" height="140">
                    <h3>Thái Bình</h3>
                    <p>Quê hương 5 tấn</p>
                </div>
                <div class="col-xs-5ths col-lg-5ths col-md-5ths col-sm-5ths">
                    <img class="img-circle" src="img/default/thanhhoa.jpg" alt="Generic placeholder image" width="140" height="140">
                    <h3>Thanh Hóa</h3>
                    <p>Đặc sản nem chua Thanh Hóa</p>
                </div>
                <div class="col-xs-5ths col-lg-5ths col-md-5ths col-sm-5ths">
                    <img class="img-circle" src="img/default/bacninh.jpg" alt="Generic placeholder image" width="140" height="140">
                    <h3>Bắc Ninh</h3>
                    <p>Quê hương của làn điệu dân ca Quan họ</p>
                </div>
                <div class="col-xs-5ths col-lg-5ths col-md-5ths col-sm-5ths">
                    <img class="img-circle" src="img/default/hanoi23.jpg" alt="Generic placeholder image" width="140" height="140">
                    <h3>Hà Nội</h3>
                    <p>Thủ đô ngàn năm văn hiến</p>                   
                </div>
                <div class="col-xs-5ths col-lg-5ths col-md-5ths col-sm-5ths">
                    <img class="img-circle" src="img/default/thainguyen.jpg" alt="Generic placeholder image" width="140" height="140">

                    <h3>Thái Nguyên</h3>
                    <p>Đặc sản chè Thái nguyên</p>               
                </div>
            </div>
        </section>
        <!-------------------------------------------->
        <hr>
        <!-- Download Section -->
        <section id="sight" class="content-section ">
            <div class="download-section">
                <div class="container">

                    <h2 class="text-center">Bài đăng nổi bật</h2>
                    <hr width="10px">
                    <div class="main-content" id="festival"> 
                        <h3><img src="img/default/thangcanh.png">Danh lam thắng cảnh</h3>
                        <div class="row">

                            <div class="row" style="padding-bottom:40px">
                                <c:forEach var="l" items="${topland1}">
                                    <div class="col-lg-6">
                                        <div class="row">
                                            <div class="col-lg-6">
                                                <img src="${l.profile}" class="img1">
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="title-letter"><a href="${l.link}">${l.title}</a></div>
                                                <div class="hidden-letter ">${l.desciption}</div>
                                            </div>
                                        </div>

                                    </div>
                                </c:forEach>
                            </div>

                            <div class="row" style="padding-bottom:40px">

                                <c:forEach var="l" items="${topland2}">
                                    <div class="col-lg-6">
                                        <div class="row">
                                            <div class="col-lg-6">
                                                <img src="${l.profile}" class="img1">
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="title-letter"><a href="${l.link}">${l.title}</a></div>
                                                <div class="hidden-letter ">${l.desciption}</div>
                                            </div>
                                        </div>

                                    </div>
                                </c:forEach>

                            </div>



                        </div>
                        <div class="right"> <a href="detailland.htm">Xem thêm >></a> </div>
                        <hr>

                        <h3><img src="img/default/lehoi.png">Lễ hội</h3>
                        <div class="row">

                            <div class="row" style="padding-bottom:40px">
                                
                                
                                <c:forEach var="f" items="${topFes1}">
                                    <div class="col-lg-6">
                                        <div class="row">
                                            <div class="col-lg-6">
                                                <img src="${f.profile}" class="img1">
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="title-letter"><a href="${f.link}">${f.title}</a></div>
                                                <div class="hidden-letter ">${f.description}</div>
                                            </div>
                                        </div>

                                    </div>
                                </c:forEach>

                            </div>

                            <div class="row" style="padding-bottom:40px">

                                <c:forEach var="f" items="${topFes2}">
                                    <div class="col-lg-6">
                                        <div class="row">
                                            <div class="col-lg-6">
                                                <img src="${f.profile}" class="img1">
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="title-letter"><a href="${f.link}">${f.title}</a></div>
                                                <div class="hidden-letter ">${f.description}</div>
                                            </div>
                                        </div>

                                    </div>
                                </c:forEach>

                            </div>



                        </div>
                        <div class="right"><a href="detailfes.htm">Xem thêm >></a>  </div>
                        <hr>

                        <h3><img src="img/default/baiviet.png">Bài viết</h3>
                        <div class="row">

                            <div class="row" style="padding-bottom:40px">

                                 <c:forEach var="f" items="${topPost1}">
                                    <div class="col-lg-6">
                                        <div class="row">
                                            <div class="col-lg-6">
                                                <img src="${f.profile}" class="img1">
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="title-letter"><a href="${f.link}">${f.title}</a></div>
                                                <div class="hidden-letter ">${f.context}</div>
                                            </div>
                                        </div>

                                    </div>
                                </c:forEach>


                            </div>

                            <div class="row" style="padding-bottom:40px">

                                <c:forEach var="f" items="${topPost2}">
                                    <div class="col-lg-6">
                                        <div class="row">
                                            <div class="col-lg-6">
                                                <img src="${f.profile}" class="img1">
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="title-letter"><a href="${f.link}">${f.title}</a></div>
                                                <div class="hidden-letter ">${f.context}</div>
                                            </div>
                                        </div>

                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="right"><a href="detailpost.htm">Xem thêm >> </a> </div>
                        <hr>
                    </div>
                </div>
            </div>
        </section>

        <c:import url="http://localhost:8080/travel/customfooter.htm" />

        <!-- jQuery -->
        <script src="client/vendor/jquery/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="client/vendor/bootstrap/js/bootstrap.min.js"></script>

        <!-- Plugin JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

        <!-- Google Maps API Key - Use your own API key to enable the map feature. More information on the Google Maps API can be found at https://developers.google.com/maps/ -->
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRngKslUGJTlibkQ3FkfTxj3Xss1UlZDA&sensor=false"></script>

        <!-- Theme JavaScript -->
        <script src="client/js/grayscale.min.js"></script>

    </body>
    <script type="text/javascript">
        var $item = $('.carousel .item');
        var $wHeight = $(window).height();
        $item.eq(0).addClass('active');
        $item.height($wHeight);
        $item.addClass('full-screen');

        $('.carousel img').each(function () {
            var $src = $(this).attr('src');
            var $color = $(this).attr('data-color');
            $(this).parent().css({
                'background-image': 'url(' + $src + ')',
                'background-color': $color
            });
            $(this).remove();
        });

        $(window).on('resize', function () {
            $wHeight = $(window).height();
            $item.height($wHeight);
        });

        $('.carousel').carousel({
            interval: 6000,
            pause: "false"
        });

        (function (a) {
            if (typeof define === "function" && define.amd && define.amd.jQuery) {
                define(["jquery"], a)
            } else {
                if (typeof module !== "undefined" && module.exports) {
                    a(require("jquery"))
                } else {
                    a(jQuery)
                }
            }
        }(function (f) {
            var y = "1.6.15", p = "left", o = "right", e = "up", x = "down", c = "in", A = "out", m = "none", s = "auto", l = "swipe", t = "pinch", B = "tap", j = "doubletap", b = "longtap", z = "hold", E = "horizontal", u = "vertical", i = "all", r = 10, g = "start", k = "move", h = "end", q = "cancel", a = "ontouchstart" in window, v = window.navigator.msPointerEnabled && !window.navigator.pointerEnabled && !a, d = (window.navigator.pointerEnabled || window.navigator.msPointerEnabled) && !a, C = "TouchSwipe";
            var n = {fingers: 1, threshold: 75, cancelThreshold: null, pinchThreshold: 20, maxTimeThreshold: null, fingerReleaseThreshold: 250, longTapThreshold: 500, doubleTapThreshold: 200, swipe: null, swipeLeft: null, swipeRight: null, swipeUp: null, swipeDown: null, swipeStatus: null, pinchIn: null, pinchOut: null, pinchStatus: null, click: null, tap: null, doubleTap: null, longTap: null, hold: null, triggerOnTouchEnd: true, triggerOnTouchLeave: false, allowPageScroll: "auto", fallbackToMouseEvents: true, excludedElements: "label, button, input, select, textarea, a, .noSwipe", preventDefaultEvents: true};
            f.fn.swipe = function (H) {
                var G = f(this), F = G.data(C);
                if (F && typeof H === "string") {
                    if (F[H]) {
                        return F[H].apply(this, Array.prototype.slice.call(arguments, 1))
                    } else {
                        f.error("Method " + H + " does not exist on jQuery.swipe")
                    }
                } else {
                    if (F && typeof H === "object") {
                        F.option.apply(this, arguments)
                    } else {
                        if (!F && (typeof H === "object" || !H)) {
                            return w.apply(this, arguments)
                        }
                    }
                }
                return G
            };
            f.fn.swipe.version = y;
            f.fn.swipe.defaults = n;
            f.fn.swipe.phases = {PHASE_START: g, PHASE_MOVE: k, PHASE_END: h, PHASE_CANCEL: q};
            f.fn.swipe.directions = {LEFT: p, RIGHT: o, UP: e, DOWN: x, IN: c, OUT: A};
            f.fn.swipe.pageScroll = {NONE: m, HORIZONTAL: E, VERTICAL: u, AUTO: s};
            f.fn.swipe.fingers = {ONE: 1, TWO: 2, THREE: 3, FOUR: 4, FIVE: 5, ALL: i};
            function w(F) {
                if (F && (F.allowPageScroll === undefined && (F.swipe !== undefined || F.swipeStatus !== undefined))) {
                    F.allowPageScroll = m
                }
                if (F.click !== undefined && F.tap === undefined) {
                    F.tap = F.click
                }
                if (!F) {
                    F = {}
                }
                F = f.extend({}, f.fn.swipe.defaults, F);
                return this.each(function () {
                    var H = f(this);
                    var G = H.data(C);
                    if (!G) {
                        G = new D(this, F);
                        H.data(C, G)
                    }
                })
            }
            function D(a5, au) {
                var au = f.extend({}, au);
                var az = (a || d || !au.fallbackToMouseEvents), K = az ? (d ? (v ? "MSPointerDown" : "pointerdown") : "touchstart") : "mousedown", ax = az ? (d ? (v ? "MSPointerMove" : "pointermove") : "touchmove") : "mousemove", V = az ? (d ? (v ? "MSPointerUp" : "pointerup") : "touchend") : "mouseup", T = az ? (d ? "mouseleave" : null) : "mouseleave", aD = (d ? (v ? "MSPointerCancel" : "pointercancel") : "touchcancel");
                var ag = 0, aP = null, a2 = null, ac = 0, a1 = 0, aZ = 0, H = 1, ap = 0, aJ = 0, N = null;
                var aR = f(a5);
                var aa = "start";
                var X = 0;
                var aQ = {};
                var U = 0, a3 = 0, a6 = 0, ay = 0, O = 0;
                var aW = null, af = null;
                try {
                    aR.bind(K, aN);
                    aR.bind(aD, ba)
                } catch (aj) {
                    f.error("events not supported " + K + "," + aD + " on jQuery.swipe")
                }
                this.enable = function () {
                    aR.bind(K, aN);
                    aR.bind(aD, ba);
                    return aR
                };
                this.disable = function () {
                    aK();
                    return aR
                };
                this.destroy = function () {
                    aK();
                    aR.data(C, null);
                    aR = null
                };
                this.option = function (bd, bc) {
                    if (typeof bd === "object") {
                        au = f.extend(au, bd)
                    } else {
                        if (au[bd] !== undefined) {
                            if (bc === undefined) {
                                return au[bd]
                            } else {
                                au[bd] = bc
                            }
                        } else {
                            if (!bd) {
                                return au
                            } else {
                                f.error("Option " + bd + " does not exist on jQuery.swipe.options")
                            }
                        }
                    }
                    return null
                };
                function aN(be) {
                    if (aB()) {
                        return
                    }
                    if (f(be.target).closest(au.excludedElements, aR).length > 0) {
                        return
                    }
                    var bf = be.originalEvent ? be.originalEvent : be;
                    var bd, bg = bf.touches, bc = bg ? bg[0] : bf;
                    aa = g;
                    if (bg) {
                        X = bg.length
                    } else {
                        if (au.preventDefaultEvents !== false) {
                            be.preventDefault()
                        }
                    }
                    ag = 0;
                    aP = null;
                    a2 = null;
                    aJ = null;
                    ac = 0;
                    a1 = 0;
                    aZ = 0;
                    H = 1;
                    ap = 0;
                    N = ab();
                    S();
                    ai(0, bc);
                    if (!bg || (X === au.fingers || au.fingers === i) || aX()) {
                        U = ar();
                        if (X == 2) {
                            ai(1, bg[1]);
                            a1 = aZ = at(aQ[0].start, aQ[1].start)
                        }
                        if (au.swipeStatus || au.pinchStatus) {
                            bd = P(bf, aa)
                        }
                    } else {
                        bd = false
                    }
                    if (bd === false) {
                        aa = q;
                        P(bf, aa);
                        return bd
                    } else {
                        if (au.hold) {
                            af = setTimeout(f.proxy(function () {
                                aR.trigger("hold", [bf.target]);
                                if (au.hold) {
                                    bd = au.hold.call(aR, bf, bf.target)
                                }
                            }, this), au.longTapThreshold)
                        }
                        an(true)
                    }
                    return null
                }
                function a4(bf) {
                    var bi = bf.originalEvent ? bf.originalEvent : bf;
                    if (aa === h || aa === q || al()) {
                        return
                    }
                    var be, bj = bi.touches, bd = bj ? bj[0] : bi;
                    var bg = aH(bd);
                    a3 = ar();
                    if (bj) {
                        X = bj.length
                    }
                    if (au.hold) {
                        clearTimeout(af)
                    }
                    aa = k;
                    if (X == 2) {
                        if (a1 == 0) {
                            ai(1, bj[1]);
                            a1 = aZ = at(aQ[0].start, aQ[1].start)
                        } else {
                            aH(bj[1]);
                            aZ = at(aQ[0].end, aQ[1].end);
                            aJ = aq(aQ[0].end, aQ[1].end)
                        }
                        H = a8(a1, aZ);
                        ap = Math.abs(a1 - aZ)
                    }
                    if ((X === au.fingers || au.fingers === i) || !bj || aX()) {
                        aP = aL(bg.start, bg.end);
                        a2 = aL(bg.last, bg.end);
                        ak(bf, a2);
                        ag = aS(bg.start, bg.end);
                        ac = aM();
                        aI(aP, ag);
                        be = P(bi, aa);
                        if (!au.triggerOnTouchEnd || au.triggerOnTouchLeave) {
                            var bc = true;
                            if (au.triggerOnTouchLeave) {
                                var bh = aY(this);
                                bc = F(bg.end, bh)
                            }
                            if (!au.triggerOnTouchEnd && bc) {
                                aa = aC(k)
                            } else {
                                if (au.triggerOnTouchLeave && !bc) {
                                    aa = aC(h)
                                }
                            }
                            if (aa == q || aa == h) {
                                P(bi, aa)
                            }
                        }
                    } else {
                        aa = q;
                        P(bi, aa)
                    }
                    if (be === false) {
                        aa = q;
                        P(bi, aa)
                    }
                }
                function M(bc) {
                    var bd = bc.originalEvent ? bc.originalEvent : bc, be = bd.touches;
                    if (be) {
                        if (be.length && !al()) {
                            G(bd);
                            return true
                        } else {
                            if (be.length && al()) {
                                return true
                            }
                        }
                    }
                    if (al()) {
                        X = ay
                    }
                    a3 = ar();
                    ac = aM();
                    if (bb() || !am()) {
                        aa = q;
                        P(bd, aa)
                    } else {
                        if (au.triggerOnTouchEnd || (au.triggerOnTouchEnd == false && aa === k)) {
                            if (au.preventDefaultEvents !== false) {
                                bc.preventDefault()
                            }
                            aa = h;
                            P(bd, aa)
                        } else {
                            if (!au.triggerOnTouchEnd && a7()) {
                                aa = h;
                                aF(bd, aa, B)
                            } else {
                                if (aa === k) {
                                    aa = q;
                                    P(bd, aa)
                                }
                            }
                        }
                    }
                    an(false);
                    return null
                }
                function ba() {
                    X = 0;
                    a3 = 0;
                    U = 0;
                    a1 = 0;
                    aZ = 0;
                    H = 1;
                    S();
                    an(false)
                }
                function L(bc) {
                    var bd = bc.originalEvent ? bc.originalEvent : bc;
                    if (au.triggerOnTouchLeave) {
                        aa = aC(h);
                        P(bd, aa)
                    }
                }
                function aK() {
                    aR.unbind(K, aN);
                    aR.unbind(aD, ba);
                    aR.unbind(ax, a4);
                    aR.unbind(V, M);
                    if (T) {
                        aR.unbind(T, L)
                    }
                    an(false)
                }
                function aC(bg) {
                    var bf = bg;
                    var be = aA();
                    var bd = am();
                    var bc = bb();
                    if (!be || bc) {
                        bf = q
                    } else {
                        if (bd && bg == k && (!au.triggerOnTouchEnd || au.triggerOnTouchLeave)) {
                            bf = h
                        } else {
                            if (!bd && bg == h && au.triggerOnTouchLeave) {
                                bf = q
                            }
                        }
                    }
                    return bf
                }
                function P(be, bc) {
                    var bd, bf = be.touches;
                    if (J() || W()) {
                        bd = aF(be, bc, l)
                    }
                    if ((Q() || aX()) && bd !== false) {
                        bd = aF(be, bc, t)
                    }
                    if (aG() && bd !== false) {
                        bd = aF(be, bc, j)
                    } else {
                        if (ao() && bd !== false) {
                            bd = aF(be, bc, b)
                        } else {
                            if (ah() && bd !== false) {
                                bd = aF(be, bc, B)
                            }
                        }
                    }
                    if (bc === q) {
                        if (W()) {
                            bd = aF(be, bc, l)
                        }
                        if (aX()) {
                            bd = aF(be, bc, t)
                        }
                        ba(be)
                    }
                    if (bc === h) {
                        if (bf) {
                            if (!bf.length) {
                                ba(be)
                            }
                        } else {
                            ba(be)
                        }
                    }
                    return bd
                }
                function aF(bf, bc, be) {
                    var bd;
                    if (be == l) {
                        aR.trigger("swipeStatus", [bc, aP || null, ag || 0, ac || 0, X, aQ, a2]);
                        if (au.swipeStatus) {
                            bd = au.swipeStatus.call(aR, bf, bc, aP || null, ag || 0, ac || 0, X, aQ, a2);
                            if (bd === false) {
                                return false
                            }
                        }
                        if (bc == h && aV()) {
                            clearTimeout(aW);
                            clearTimeout(af);
                            aR.trigger("swipe", [aP, ag, ac, X, aQ, a2]);
                            if (au.swipe) {
                                bd = au.swipe.call(aR, bf, aP, ag, ac, X, aQ, a2);
                                if (bd === false) {
                                    return false
                                }
                            }
                            switch (aP) {
                                case p:
                                    aR.trigger("swipeLeft", [aP, ag, ac, X, aQ, a2]);
                                    if (au.swipeLeft) {
                                        bd = au.swipeLeft.call(aR, bf, aP, ag, ac, X, aQ, a2)
                                    }
                                    break;
                                case o:
                                    aR.trigger("swipeRight", [aP, ag, ac, X, aQ, a2]);
                                    if (au.swipeRight) {
                                        bd = au.swipeRight.call(aR, bf, aP, ag, ac, X, aQ, a2)
                                    }
                                    break;
                                case e:
                                    aR.trigger("swipeUp", [aP, ag, ac, X, aQ, a2]);
                                    if (au.swipeUp) {
                                        bd = au.swipeUp.call(aR, bf, aP, ag, ac, X, aQ, a2)
                                    }
                                    break;
                                case x:
                                    aR.trigger("swipeDown", [aP, ag, ac, X, aQ, a2]);
                                    if (au.swipeDown) {
                                        bd = au.swipeDown.call(aR, bf, aP, ag, ac, X, aQ, a2)
                                    }
                                    break
                            }
                        }
                    }
                    if (be == t) {
                        aR.trigger("pinchStatus", [bc, aJ || null, ap || 0, ac || 0, X, H, aQ]);
                        if (au.pinchStatus) {
                            bd = au.pinchStatus.call(aR, bf, bc, aJ || null, ap || 0, ac || 0, X, H, aQ);
                            if (bd === false) {
                                return false
                            }
                        }
                        if (bc == h && a9()) {
                            switch (aJ) {
                                case c:
                                    aR.trigger("pinchIn", [aJ || null, ap || 0, ac || 0, X, H, aQ]);
                                    if (au.pinchIn) {
                                        bd = au.pinchIn.call(aR, bf, aJ || null, ap || 0, ac || 0, X, H, aQ)
                                    }
                                    break;
                                case A:
                                    aR.trigger("pinchOut", [aJ || null, ap || 0, ac || 0, X, H, aQ]);
                                    if (au.pinchOut) {
                                        bd = au.pinchOut.call(aR, bf, aJ || null, ap || 0, ac || 0, X, H, aQ)
                                    }
                                    break
                            }
                        }
                    }
                    if (be == B) {
                        if (bc === q || bc === h) {
                            clearTimeout(aW);
                            clearTimeout(af);
                            if (Z() && !I()) {
                                O = ar();
                                aW = setTimeout(f.proxy(function () {
                                    O = null;
                                    aR.trigger("tap", [bf.target]);
                                    if (au.tap) {
                                        bd = au.tap.call(aR, bf, bf.target)
                                    }
                                }, this), au.doubleTapThreshold)
                            } else {
                                O = null;
                                aR.trigger("tap", [bf.target]);
                                if (au.tap) {
                                    bd = au.tap.call(aR, bf, bf.target)
                                }
                            }
                        }
                    } else {
                        if (be == j) {
                            if (bc === q || bc === h) {
                                clearTimeout(aW);
                                clearTimeout(af);
                                O = null;
                                aR.trigger("doubletap", [bf.target]);
                                if (au.doubleTap) {
                                    bd = au.doubleTap.call(aR, bf, bf.target)
                                }
                            }
                        } else {
                            if (be == b) {
                                if (bc === q || bc === h) {
                                    clearTimeout(aW);
                                    O = null;
                                    aR.trigger("longtap", [bf.target]);
                                    if (au.longTap) {
                                        bd = au.longTap.call(aR, bf, bf.target)
                                    }
                                }
                            }
                        }
                    }
                    return bd
                }
                function am() {
                    var bc = true;
                    if (au.threshold !== null) {
                        bc = ag >= au.threshold
                    }
                    return bc
                }
                function bb() {
                    var bc = false;
                    if (au.cancelThreshold !== null && aP !== null) {
                        bc = (aT(aP) - ag) >= au.cancelThreshold
                    }
                    return bc
                }
                function ae() {
                    if (au.pinchThreshold !== null) {
                        return ap >= au.pinchThreshold
                    }
                    return true
                }
                function aA() {
                    var bc;
                    if (au.maxTimeThreshold) {
                        if (ac >= au.maxTimeThreshold) {
                            bc = false
                        } else {
                            bc = true
                        }
                    } else {
                        bc = true
                    }
                    return bc
                }
                function ak(bc, bd) {
                    if (au.preventDefaultEvents === false) {
                        return
                    }
                    if (au.allowPageScroll === m) {
                        bc.preventDefault()
                    } else {
                        var be = au.allowPageScroll === s;
                        switch (bd) {
                            case p:
                                if ((au.swipeLeft && be) || (!be && au.allowPageScroll != E)) {
                                    bc.preventDefault()
                                }
                                break;
                            case o:
                                if ((au.swipeRight && be) || (!be && au.allowPageScroll != E)) {
                                    bc.preventDefault()
                                }
                                break;
                            case e:
                                if ((au.swipeUp && be) || (!be && au.allowPageScroll != u)) {
                                    bc.preventDefault()
                                }
                                break;
                            case x:
                                if ((au.swipeDown && be) || (!be && au.allowPageScroll != u)) {
                                    bc.preventDefault()
                                }
                                break
                        }
                    }
                }
                function a9() {
                    var bd = aO();
                    var bc = Y();
                    var be = ae();
                    return bd && bc && be
                }
                function aX() {
                    return !!(au.pinchStatus || au.pinchIn || au.pinchOut)
                }
                function Q() {
                    return !!(a9() && aX())
                }
                function aV() {
                    var bf = aA();
                    var bh = am();
                    var be = aO();
                    var bc = Y();
                    var bd = bb();
                    var bg = !bd && bc && be && bh && bf;
                    return bg
                }
                function W() {
                    return !!(au.swipe || au.swipeStatus || au.swipeLeft || au.swipeRight || au.swipeUp || au.swipeDown)
                }
                function J() {
                    return !!(aV() && W())
                }
                function aO() {
                    return((X === au.fingers || au.fingers === i) || !a)
                }
                function Y() {
                    return aQ[0].end.x !== 0
                }
                function a7() {
                    return !!(au.tap)
                }
                function Z() {
                    return !!(au.doubleTap)
                }
                function aU() {
                    return !!(au.longTap)
                }
                function R() {
                    if (O == null) {
                        return false
                    }
                    var bc = ar();
                    return(Z() && ((bc - O) <= au.doubleTapThreshold))
                }
                function I() {
                    return R()
                }
                function aw() {
                    return((X === 1 || !a) && (isNaN(ag) || ag < au.threshold))
                }
                function a0() {
                    return((ac > au.longTapThreshold) && (ag < r))
                }
                function ah() {
                    return !!(aw() && a7())
                }
                function aG() {
                    return !!(R() && Z())
                }
                function ao() {
                    return !!(a0() && aU())
                }
                function G(bc) {
                    a6 = ar();
                    ay = bc.touches.length + 1
                }
                function S() {
                    a6 = 0;
                    ay = 0
                }
                function al() {
                    var bc = false;
                    if (a6) {
                        var bd = ar() - a6;
                        if (bd <= au.fingerReleaseThreshold) {
                            bc = true
                        }
                    }
                    return bc
                }
                function aB() {
                    return !!(aR.data(C + "_intouch") === true)
                }
                function an(bc) {
                    if (!aR) {
                        return
                    }
                    if (bc === true) {
                        aR.bind(ax, a4);
                        aR.bind(V, M);
                        if (T) {
                            aR.bind(T, L)
                        }
                    } else {
                        aR.unbind(ax, a4, false);
                        aR.unbind(V, M, false);
                        if (T) {
                            aR.unbind(T, L, false)
                        }
                    }
                    aR.data(C + "_intouch", bc === true)
                }
                function ai(be, bc) {
                    var bd = {start: {x: 0, y: 0}, last: {x: 0, y: 0}, end: {x: 0, y: 0}};
                    bd.start.x = bd.last.x = bd.end.x = bc.pageX || bc.clientX;
                    bd.start.y = bd.last.y = bd.end.y = bc.pageY || bc.clientY;
                    aQ[be] = bd;
                    return bd
                }
                function aH(bc) {
                    var be = bc.identifier !== undefined ? bc.identifier : 0;
                    var bd = ad(be);
                    if (bd === null) {
                        bd = ai(be, bc)
                    }
                    bd.last.x = bd.end.x;
                    bd.last.y = bd.end.y;
                    bd.end.x = bc.pageX || bc.clientX;
                    bd.end.y = bc.pageY || bc.clientY;
                    return bd
                }
                function ad(bc) {
                    return aQ[bc] || null
                }
                function aI(bc, bd) {
                    bd = Math.max(bd, aT(bc));
                    N[bc].distance = bd
                }
                function aT(bc) {
                    if (N[bc]) {
                        return N[bc].distance
                    }
                    return undefined
                }
                function ab() {
                    var bc = {};
                    bc[p] = av(p);
                    bc[o] = av(o);
                    bc[e] = av(e);
                    bc[x] = av(x);
                    return bc
                }
                function av(bc) {
                    return{direction: bc, distance: 0}
                }
                function aM() {
                    return a3 - U
                }
                function at(bf, be) {
                    var bd = Math.abs(bf.x - be.x);
                    var bc = Math.abs(bf.y - be.y);
                    return Math.round(Math.sqrt(bd * bd + bc * bc))
                }
                function a8(bc, bd) {
                    var be = (bd / bc) * 1;
                    return be.toFixed(2)
                }
                function aq() {
                    if (H < 1) {
                        return A
                    } else {
                        return c
                    }
                }
                function aS(bd, bc) {
                    return Math.round(Math.sqrt(Math.pow(bc.x - bd.x, 2) + Math.pow(bc.y - bd.y, 2)))
                }
                function aE(bf, bd) {
                    var bc = bf.x - bd.x;
                    var bh = bd.y - bf.y;
                    var be = Math.atan2(bh, bc);
                    var bg = Math.round(be * 180 / Math.PI);
                    if (bg < 0) {
                        bg = 360 - Math.abs(bg)
                    }
                    return bg
                }
                function aL(bd, bc) {
                    var be = aE(bd, bc);
                    if ((be <= 45) && (be >= 0)) {
                        return p
                    } else {
                        if ((be <= 360) && (be >= 315)) {
                            return p
                        } else {
                            if ((be >= 135) && (be <= 225)) {
                                return o
                            } else {
                                if ((be > 45) && (be < 135)) {
                                    return x
                                } else {
                                    return e
                                }
                            }
                        }
                    }
                }
                function ar() {
                    var bc = new Date();
                    return bc.getTime()
                }
                function aY(bc) {
                    bc = f(bc);
                    var be = bc.offset();
                    var bd = {left: be.left, right: be.left + bc.outerWidth(), top: be.top, bottom: be.top + bc.outerHeight()};
                    return bd
                }
                function F(bc, bd) {
                    return(bc.x > bd.left && bc.x < bd.right && bc.y > bd.top && bc.y < bd.bottom)
                }
            }
        }
        ));
        !function (n) {
            "use strict";
            n.fn.bsTouchSlider = function (i) {
                var a = n(".carousel");
                return this.each(function () {
                    function i(i) {
                        var a = "webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend";
                        i.each(function () {
                            var i = n(this), t = i.data("animation");
                            i.addClass(t).one(a, function () {
                                i.removeClass(t)
                            })
                        })
                    }
                    var t = a.find(".item:first").find("[data-animation ^= 'animated']");
                    a.carousel(), i(t), a.on("slide.bs.carousel", function (a) {
                        var t = n(a.relatedTarget).find("[data-animation ^= 'animated']");
                        i(t)
                    }), n(".carousel .carousel-inner").swipe({swipeLeft: function (n, i, a, t, e) {
                            this.parent().carousel("next")
                        }, swipeRight: function () {
                            this.parent().carousel("prev")
                        }, threshold: 0})
                })
            }
        }(jQuery);



        //Initialise Bootstrap Carousel Touch Slider
        // Curently there are no option available.

        $('#bootstrap-touch-slider').bsTouchSlider();

    </script>

</html>