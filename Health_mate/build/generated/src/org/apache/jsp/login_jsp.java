package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Healthmate a Medical Helper</title>\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("        <script type=\"applisalonion/x-javascript\"> addEventListener(\"load\", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>\r\n");
      out.write("        <link href=\"css/bootstrap.css\" rel='stylesheet' type='text/css' />\r\n");
      out.write("        <!-- Custom Theme files -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/swipebox.css\">\r\n");
      out.write("        <link href=\"css/style.css\" rel='stylesheet' type='text/css' />\t\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/slider.css\">\r\n");
      out.write("        <script src=\"js/jquery-1.11.1.min.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/move-top.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/easing.js\"></script>\r\n");
      out.write("        <!--/web-font-->\r\n");
      out.write("        <link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>\r\n");
      out.write("        <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>\r\n");
      out.write("\r\n");
      out.write("        <!-- My script -->\t\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/kepy.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/notifIt.js\"></script>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/notifIt.css\">\r\n");
      out.write("        <!-- My script -->\r\n");
      out.write("\r\n");
      out.write("        <!--/script-->\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            jQuery(document).ready(function ($) {\r\n");
      out.write("                $(\".scroll\").click(function (event) {\r\n");
      out.write("                    event.preventDefault();\r\n");
      out.write("                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 900);\r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <!------Getting session attribute for notification -->\r\n");
      out.write("    ");

            String msg = "";
            HttpSession hs = request.getSession();
            if(hs.getAttribute("notifier")!=null)
            {
                msg = hs.getAttribute("notifier").toString();
            }
    
      out.write("\r\n");
      out.write("    <body onload=\"CheckNotification()\">\r\n");
      out.write("        <input type=\"hidden\" id=\"msg\" value=");
      out.print(msg);
      out.write(">\r\n");
      out.write("        ");
hs.removeAttribute("notifier");
      out.write("\r\n");
      out.write("        <!------Getting session attribute for notification -->\r\n");
      out.write("\r\n");
      out.write("        <!--start-home-->\r\n");
      out.write("        <div class=\"main-header\" id=\"house\">\r\n");
      out.write("            <div class=\"header-strip\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <p class=\"location\"><span class=\"glyphicon glyphicon-envelope\" aria-hidden=\"true\"></span> <a href=\"mailto:keyul.kepy@gmail.com\">keyul.kepy@gmail.com</a></p>\r\n");
      out.write("                    <p class=\"phonenum\"><span class=\"glyphicon glyphicon-earphone\" aria-hidden=\"true\"></span> + 91 8866 258602</p>\r\n");
      out.write("                    <div class=\"social-icons\">\r\n");
      out.write("                        <ul>\t\t\t\t\t\r\n");
      out.write("                            <li><a href=\"https://www.facebook.com/Kepy97\"><i class=\"facebook\"> </i></a></li>\r\n");
      out.write("                            <li><a href=\"https://twitter.com/Keyul_kepy\"><i class=\"twitter\"> </i></a></li>\r\n");
      out.write("                            <li><a href=\"https://plus.google.com/u/0/116655621549532074666\"><i class=\"google-plus\"> </i></a></li>\t\r\n");
      out.write("                            <li><a href=\"https://github.com/Kepy97\"><i class=\"dribble\"> </i></a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"clearfix\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!--header-top-->\r\n");
      out.write("            <div class=\"header-top\" style=\"background-color:#F5F3EE;\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <nav class=\"navbar navbar-default\">\r\n");
      out.write("                        <!-- Brand and toggle get grouped for better mobile display -->\r\n");
      out.write("                        <div class=\"navbar-header\">\r\n");
      out.write("                            <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">\r\n");
      out.write("                                <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("                                <span class=\"icon-bar\"></span>\r\n");
      out.write("                                <span class=\"icon-bar\"></span>\r\n");
      out.write("                                <span class=\"icon-bar\"></span>\r\n");
      out.write("                            </button>\r\n");
      out.write("                            <div class=\"logo\">\r\n");
      out.write("                                <h1><a class=\"navbar-brand\" href=\"index.html\"><span>H</span>ealthMate  <img src=\"images/logo.png\" alt=\" \" /></a></h1>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <!-- Collect the nav links, forms, and other content for toggling -->\r\n");
      out.write("                        <div class=\"collapse navbar-collapse nav-wil\" id=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("                            <div class=\"top-menu\">\r\n");
      out.write("                                <nav class=\"menu menu--francisco\">\r\n");
      out.write("                                    <ul class=\"nav navbar-nav menu__list\">\r\n");
      out.write("                                        <li class=\"menu__item\"><a href=\"index.html\" class=\"menu__link\"><span class=\"menu__helper\">Home</span></a></li>\r\n");
      out.write("                                        <li class=\"menu__item menu__item--current\"><a href=\"login.jsp\" class=\"menu__link\"><span class=\"menu__helper\">Login</span></a></li>\r\n");
      out.write("                                        <li class=\"menu__item\"><a href=\"register.jsp\" class=\"menu__link\"><span class=\"menu__helper\">Signup</span></a></li>\r\n");
      out.write("                                        <li class=\"menu__item\"><a href=\"contact.html\" class=\"menu__link\"><span class=\"menu__helper\">Contact Us</span></a></li>\r\n");
      out.write("\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </nav>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- /.navbar-collapse -->\r\n");
      out.write("                    </nav>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"clearfix\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!--//header-top-->\r\n");
      out.write("\r\n");
      out.write("        <!-- Form Start Here -->\r\n");
      out.write("        <br><br>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-4 col-md-offset-4 text-center\">\r\n");
      out.write("                    <div class=\"search-box\">\r\n");
      out.write("                        <div class=\"caption\">\r\n");
      out.write("                            <h3 style=\"font-size: 250%;\">Login Here</h3>\r\n");
      out.write("                            <br><br>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <form action=\"login\" class=\"loginForm\">\r\n");
      out.write("                            <div class=\"input-group\">\r\n");
      out.write("                                <input style=\"margin: 20px 2px;\" name=\"emailid\" type=\"text\" class=\"form-control\" pattern=\"\\S+@\\S+\" title=\"EmailId\" required placeholder=\"Email Id\">\r\n");
      out.write("\r\n");
      out.write("                                <input style=\"margin: 20px 2px;\" name=\"password\" required pattern=\"^.{8,15}$\" type=\"password\" class=\"form-control\" title=\"Password Must be between 8 to 15 letters\" placeholder=\"Password\">\r\n");
      out.write("\r\n");
      out.write("                                <input style=\"background-color: #4CAF50;border: none;color: white;padding: 1px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;margin: 20px 2px;cursor: pointer;\" type=\"submit\" id=\"submit\" class=\"form-control\" value=\"Submit\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\t\r\n");
      out.write("        <div style=\"text-align: center;\">\r\n");
      out.write("            <h3 style=\"font-size: 125%;\">Forgot password? </h3>\r\n");
      out.write("            <a href=\"forgot.jsp\" style=\"color: #2afc46;\"><button style=\"background-color: #4CAF50;border: none;color: white;padding: 8px 32px;text-decoration: none;display: inline-block;font-size: 16px;margin: 20px 2px;cursor: pointer;\">Click Here</button></a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <br><br><br>\r\n");
      out.write("\r\n");
      out.write("        <!-- Form Complete Here -- >\r\n");
      out.write("        \r\n");
      out.write("        <!-- Kick off Filterizr -->\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            $(function () {\r\n");
      out.write("                //Initialize filterizr with default options\r\n");
      out.write("                $('.filtr-container').filterizr();\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("        <!--//gallery-->\r\n");
      out.write("\r\n");
      out.write("        <!--/start-footer-section-->\r\n");
      out.write("        <div class=\"footer-section\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"footer-grids wow bounceIn animated\" data-wow-delay=\"0.4s\">\r\n");
      out.write("                    <div class=\"col-md-3 footer-grid\">\r\n");
      out.write("                        <h4>About <span>Healthmate</span></h4>\r\n");
      out.write("                        <div class=\"border2\"></div>\r\n");
      out.write("                        <p>This project is intended to patient/user book doctor appointment using application as well as website. Using this application patient/user can check doctor is arrived at clinic/hospital or not. Furthermore, they can also see how many patient is waiting in queue and they will get estimated time through sms and email notification.</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-3 footer-grid tags\">\r\n");
      out.write("                        <h4>The <span>Tags</span></h4>\r\n");
      out.write("                        <div class=\"border2\"></div>\r\n");
      out.write("                        <ul class=\"tag\">\r\n");
      out.write("                            <li><a href=\"#\">Book Appointment</a></li>\r\n");
      out.write("                            <li><a href=\"#\">SMS</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Email</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Notification</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Medical Stores</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Medicine</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Labs</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Doctors</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Patients</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Receptionist</a></li>\r\n");
      out.write("                            <li><a href=\"#\">Store Owners</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-3 footer-grid tweet\">\r\n");
      out.write("                        <h4>Latest <span>Tweets</span></h4>\r\n");
      out.write("                        <div class=\"border2\"></div>\r\n");
      out.write("                        <div class=\"icon-3-square\">\r\n");
      out.write("                            <a href=\"#\"><i class=\"square-3\"></i></a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"icon-text\">\r\n");
      out.write("                            <p>I like HealthMate sevices. The essential feature of HealthMate is patient can see how many patients appointments booked before them.</p>\r\n");
      out.write("                            <h5>2 days ago</h5>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"clearfix\"></div>\r\n");
      out.write("                        <div class=\"icon-3-square\">\r\n");
      out.write("                            <a href=\"#\"><i class=\"square-3\"></i></a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"icon-text\">\r\n");
      out.write("                            <p>HealthMate is very useful for any patients. It saves time for patients in critical situations. Thank You HealthMate</p>\r\n");
      out.write("                            <h5>5 days ago</h5>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"clearfix\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-3 footer-grid flickr\">\r\n");
      out.write("                        <h4>Contact <span>Us </span></h4>\r\n");
      out.write("                        <div class=\"border2\"></div>\r\n");
      out.write("                        <div class=\"flickr-grids\">\r\n");
      out.write("                            <p>If you have any query just contact us. we will get back to you as soon as possible. email id : keyul.kepy@gmail.com\r\n");
      out.write("                                Mobile Number : +91 88 66 258602 \r\n");
      out.write("                            </p>\r\n");
      out.write("                            <div class=\"clearfix\"> </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"clearfix\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!--//footer-->\r\n");
      out.write("        <div class=\"footer-bottom\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <p>© 2017 Healthmate. All rights reserved | Design by KePy</p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!--start-smooth-scrolling-->\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            $(document).ready(function () {\r\n");
      out.write("\r\n");
      out.write("                $().UItoTop({easingType: 'easeOutQuart'});\r\n");
      out.write("\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("        <!--//end-smooth-scrolling-->\r\n");
      out.write("        <a href=\"#house\" id=\"toTop\" class=\"scroll\" style=\"display: block;\"> <span id=\"toTopHover\" style=\"opacity: 1;\"> </span></a>\r\n");
      out.write("        <script src=\"js/bootstrap.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
