<%-- 
    Document   : register
    Created on : Jan 21, 2018, 7:04:34 PM
    Author     : sonav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Healthmate a Medical Helper</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <script type="applisalonion/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
        <!-- Custom Theme files -->
        <link rel="stylesheet" href="css/swipebox.css">
        <link href="css/style.css" rel='stylesheet' type='text/css' />	
        <link rel="stylesheet" href="css/slider.css">
        <script src="js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="js/move-top.js"></script>
        <script type="text/javascript" src="js/easing.js"></script>
        <!--/web-font-->
        <link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
        <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>

        <!-- My script -->	
        <script type="text/javascript" src="js/kepy.js"></script>
        <script type="text/javascript" src="js/notifIt.js"></script>
        <link rel="stylesheet" type="text/css" href="css/notifIt.css">
        <!-- My script -->

        <!--/script-->
        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 900);
                });
            });
        </script>
    </head>

    <!------Getting session attribute for notification -->
    <%
        String msg = "";
        HttpSession hs = request.getSession();
        if (hs.getAttribute("notifier") != null) {
            msg = hs.getAttribute("notifier").toString();
        }
    %>
    <body onload="CheckNotification()">
        <input type="hidden" id="msg" value=<%=msg%>>
        <%hs.removeAttribute("notifier");%>
        <!------Getting session attribute for notification -->

        <!--start-home-->
        <div class="main-header" id="house">
            <div class="header-strip">
                <div class="container">
                    <p class="location"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span> <a href="mailto:keyul.kepy@gmail.com">keyul.kepy@gmail.com</a></p>
                    <p class="phonenum"><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span> + 91 8866 258602</p>
                    <div class="social-icons">
                        <ul>					
                            <li><a href="https://www.facebook.com/Kepy97"><i class="facebook"> </i></a></li>
                            <li><a href="https://twitter.com/Keyul_kepy"><i class="twitter"> </i></a></li>
                            <li><a href="https://plus.google.com/u/0/116655621549532074666"><i class="google-plus"> </i></a></li>	
                            <li><a href="https://github.com/Kepy97"><i class="dribble"> </i></a></li>
                        </ul>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <!--header-top-->
            <div class="header-top" style="background-color:#F5F3EE;">
                <div class="container">
                    <nav class="navbar navbar-default">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <div class="logo">
                                <h1><a class="navbar-brand" href="index.html"><span>H</span>ealthMate  <img src="images/logo.png" alt=" " /></a></h1>
                            </div>
                        </div>

                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
                            <div class="top-menu">
                                <nav class="menu menu--francisco">
                                    <ul class="nav navbar-nav menu__list">
                                        <li class="menu__item"><a href="index.html" class="menu__link"><span class="menu__helper">Home</span></a></li>
                                        <li class="menu__item"><a href="login.jsp" class="menu__link"><span class="menu__helper">Login</span></a></li>
                                        <li class="menu__item menu__item--current"><a href="register.jsp" class="menu__link"><span class="menu__helper">Signup</span></a></li>
                                        <li class="menu__item"><a href="contact.html" class="menu__link"><span class="menu__helper">Contact Us</span></a></li>

                                    </ul>
                                </nav>
                            </div>
                        </div>
                        <!-- /.navbar-collapse -->
                    </nav>

                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
        <!--//header-top-->

        <!-- Form Start Here -->
        <br><br>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4 text-center">
                    <div class="search-box">
                        <div class="caption">
                            <h3 style="font-size: 250%;">Signup Here</h3>
                            <br><br>
                        </div>
                        <form action="registration" id="myform" class="loginForm">
                            <div class="input-group">
                                <input style="margin: 20px 2px;" name="fname" type="text" class="form-control" required pattern="[a-zA-Z]+" title="FirstName must be character only" placeholder="First Name">

                                <input style="margin: 20px 2px;" name="lname" type="text" class="form-control" required pattern="[a-zA-Z]+" title="LastName must be character only" placeholder="Last Name">

                                <input style="margin: 20px 2px;" name="mobile" type="text" class="form-control" pattern="[1-9]{1}[0-9]{9}" title="Number exactly 10 digits" required placeholder="Mobile Number">					

                                <input style="margin: 20px 2px;" id="emailid" name="emailid" type="text" class="form-control" pattern="\S+@\S+" title="EmailId" required placeholder="Email Id">

                                <input style="margin: 20px 2px;" id="password" name="password" required pattern="^.{8,15}$" type="password" class="form-control" title="Password Must be between 8 to 15 letters" placeholder="Password">

                                <input style="margin: 20px 2px;" id="confirmpass" name="confirmpass" required pattern="^.{8,15}$" type="password" class="form-control" title="Password Must be between 8 to 15 letters" placeholder="Confirm Password">					

                                <input type="hidden" name="role" value="user">

                                <input onclick="return ValidatePass()" style="background-color: #4CAF50;border: none;color: white;padding: 1px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;margin: 20px 2px;cursor: pointer;" type="submit" id="submit" class="form-control" value="Register">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>	
        <div style="text-align: center;">
            <h3 style="font-size: 125%;">For Clinics/Hospitals </h3>
            <a href="Doctor/doctorregister.jsp" style="color: #2afc46;"><button style="background-color: #4CAF50;border: none;color: white;padding: 8px 32px;text-decoration: none;display: inline-block;font-size: 16px;margin: 20px 2px;cursor: pointer;">Click Here</button></a>
        </div>
        <br><br><br>

        <!-- Form Complete Here -- >
            
        
        <!-- Kick off Filterizr -->
        <script type="text/javascript">
            $(function () {
                //Initialize filterizr with default options
                $('.filtr-container').filterizr();
            });
        </script>
        <!--//gallery-->

        <!--/start-footer-section-->
        <div class="footer-section">
            <div class="container">
                <div class="footer-grids wow bounceIn animated" data-wow-delay="0.4s">
                    <div class="col-md-3 footer-grid">
                        <h4>About <span>Healthmate</span></h4>
                        <div class="border2"></div>
                        <p>This project is intended to patient/user book doctor appointment using application as well as website. Using this application patient/user can check doctor is arrived at clinic/hospital or not. Furthermore, they can also see how many patient is waiting in queue and they will get estimated time through sms and email notification.</p>
                    </div>
                    <div class="col-md-3 footer-grid tags">
                        <h4>The <span>Tags</span></h4>
                        <div class="border2"></div>
                        <ul class="tag">
                            <li><a href="#">Book Appointment</a></li>
                            <li><a href="#">SMS</a></li>
                            <li><a href="#">Email</a></li>
                            <li><a href="#">Notification</a></li>
                            <li><a href="#">Medical Stores</a></li>
                            <li><a href="#">Medicine</a></li>
                            <li><a href="#">Labs</a></li>
                            <li><a href="#">Doctors</a></li>
                            <li><a href="#">Patients</a></li>
                            <li><a href="#">Receptionist</a></li>
                            <li><a href="#">Store Owners</a></li>
                        </ul>
                    </div>
                    <div class="col-md-3 footer-grid tweet">
                        <h4>Latest <span>Tweets</span></h4>
                        <div class="border2"></div>
                        <div class="icon-3-square">
                            <a href="#"><i class="square-3"></i></a>
                        </div>
                        <div class="icon-text">
                            <p>I like HealthMate sevices. The essential feature of HealthMate is patient can see how many patients appointments booked before them.</p>
                            <h5>2 days ago</h5>
                        </div>
                        <div class="clearfix"></div>
                        <div class="icon-3-square">
                            <a href="#"><i class="square-3"></i></a>
                        </div>
                        <div class="icon-text">
                            <p>HealthMate is very useful for any patients. It saves time for patients in critical situations. Thank You HealthMate</p>
                            <h5>5 days ago</h5>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="col-md-3 footer-grid flickr">
                        <h4>Contact <span>Us </span></h4>
                        <div class="border2"></div>
                        <div class="flickr-grids">
                            <p>If you have any query just contact us. we will get back to you as soon as possible. email id : keyul.kepy@gmail.com
                                Mobile Number : +91 88 66 258602 
                            </p>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
        <!--//footer-->
        <div class="footer-bottom">
            <div class="container">
                <p>© 2017 Healthmate. All rights reserved | Design by KePy</p>
            </div>
        </div>
        <!--start-smooth-scrolling-->
        <script type="text/javascript">
            $(document).ready(function () {

                $().UItoTop({easingType: 'easeOutQuart'});

            });
        </script>
        <!--//end-smooth-scrolling-->
        <a href="#house" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
        <script src="js/bootstrap.js"></script>

        <!-- Tooltip Script -->
        <script>
            // execute your scripts when the DOM is ready. this is a good habit
            // select all desired input fields and attach tooltips to them
            $("#myform :input").tooltip({

                // place tooltip on the right edge
                position: "center right",
                'trigger': 'focus',
                // a little tweaking of the position
                offset: [-2, 10],

                // use the built-in fadeIn/fadeOut effect
                effect: "fade",

                // custom opacity setting
                opacity: 0.7

            });
        </script>
        <!-- Tooltip Script -->

    </body>
</html>
