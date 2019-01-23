/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modal.Doctordetails;
import modal.Hospitaldetails;
import modal.Locationdetails;
import modal.Logindetails;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author sonav
 */
public class registration_hospital extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession hs = request.getSession();
        String msg = "";
        String path = "doctorregister(2).html";

        try {
            /* TODO output your page here. You may use following sample code. */
            Date date = new Date();
            String hospitalname = request.getParameter("hospitalname");
            String hospitaladdress = request.getParameter("hospitaladdress");
            String hospitalarea = request.getParameter("hospitalarea");
            String hospitalcity = request.getParameter("hospitalcity");
            String hospitalstate = request.getParameter("hospitalstate");
            String hospitalpincode = request.getParameter("hospitalpincode");
            String mobile = request.getParameter("mobile");
            String emailid = request.getParameter("emailid");
            //Gets all the data by query parameter

            hospitalname = hospitalname.substring(0, 1).toUpperCase() + hospitalname.substring(1);
            hospitalarea = hospitalarea.substring(0, 1).toUpperCase() + hospitalarea.substring(1);
            hospitalcity = hospitalcity.substring(0, 1).toUpperCase() + hospitalcity.substring(1);

            String session_email = hs.getAttribute("emailid").toString();

            //Session factory initialized and begins the transaction
            Hospitaldetails hd = new Hospitaldetails();
            Locationdetails ld = new Locationdetails();
            Doctordetails dd = new Doctordetails();
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties());
            Session se = configuration.buildSessionFactory(builder.build()).openSession();
            Transaction tr = se.beginTransaction();

            ld.setAddress(hospitaladdress);
            ld.setArea(hospitalarea);
            ld.setCity(hospitalcity);
            ld.setCountry("India");
            ld.setDateTime(date);
            ld.setFlag(Boolean.TRUE);
            ld.setPincode(hospitalpincode);
            ld.setState(hospitalstate);
            se.save(ld);

            hd.setLocationId(ld);
            hd.setDateTime(date);
            hd.setEmailid1(emailid);
            hd.setFlag(Boolean.TRUE);
            hd.setHospitalname(hospitalname);
            hd.setMobile1(mobile);
            se.save(hd);

            //For storing hospital id in doctordetails
            Criteria cr = se.createCriteria(Logindetails.class);
            cr.add(Restrictions.eq("emailid", session_email));
            ArrayList<Logindetails> al = (ArrayList<Logindetails>) cr.list();
            if (al.size() > 0) {
                Logindetails login_details = al.get(0);
                Criteria crr = se.createCriteria(Doctordetails.class);
                crr.add(Restrictions.eq("loginId", login_details));
                ArrayList<Doctordetails> alu = (ArrayList<Doctordetails>) crr.list();
                dd = alu.get(0);

                dd.setHopitalId(hd);
                se.save(dd);
                msg = "success_register";
                path = "home.jsp";
                hs.setAttribute("notifier", msg);
                response.sendRedirect(path);
            } else {
                msg = "fail_register";
                hs.setAttribute("notifier", msg);
                response.sendRedirect(path);
            }
            tr.commit();

            try {
                //Sending email
                String subject = "Welcome to HealthMate";
                String content = "You are successfully signed in. Thank you for your registration";
                String[] recipients = new String[]{emailid};
                MailUtil mu = new MailUtil();
                mu.sendMail(recipients, subject, content);
            } catch (Exception e) {
                out.println("Error in send mail" + e.getMessage());
            }

        } catch (Exception e) {
            out.println(e.getMessage());
            msg = "fail_register";
            hs.setAttribute("notifier", msg);
            response.sendRedirect(path);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
