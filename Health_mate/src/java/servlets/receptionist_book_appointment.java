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
import modal.Appointmentdetails;
import modal.Logindetails;
import modal.Receptionistdetails;
import modal.Userdetails;
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
public class receptionist_book_appointment extends HttpServlet {

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
        Date date = new Date();
        HttpSession hs = request.getSession();
        String msg = "fail_book_appointment";
        String path = "bookappointment.jsp";
        try {
            /* TODO output your page here. You may use following sample code. */
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String mobile = request.getParameter("mobile");
            String email = request.getParameter("email");
            
            String session_mail = hs.getAttribute("emailid").toString();
            
            //Session factory initialized and begins the transaction
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            Session se = configuration.buildSessionFactory(builder.build()).openSession();
            Transaction tr = se.beginTransaction();
            
            Criteria cr = se.createCriteria(Logindetails.class);
            cr.add(Restrictions.eq("emailid", session_mail));
            ArrayList<Logindetails> al = (ArrayList<Logindetails>) cr.list();
            Logindetails ldd = al.get(0);
            
            Criteria crr = se.createCriteria(Receptionistdetails.class);
            cr.add(Restrictions.eq("loginId", ldd));
            ArrayList<Receptionistdetails> all = (ArrayList<Receptionistdetails>) crr.list();
            Receptionistdetails rd = all.get(0);
            
            Logindetails ld = new Logindetails();
            ld.setDateTime(date);
            ld.setFlag(Boolean.TRUE);
            ld.setRole("user");
            ld.setEmailid(email);
            ld.setPassword("123456789");
            se.save(ld);
            
            Userdetails ud = new Userdetails();
            ud.setDateTime(date);
            ud.setFlag(Boolean.TRUE);
            ud.setFirstname(fname);
            ud.setLastname(lname);
            ud.setMobile(mobile);
            ud.setLoginId(ld);
            se.save(ud);
            
            Appointmentdetails ad = new Appointmentdetails();
            ad.setDate(date);
            ad.setTime(date);
            ad.setDateTime(date);
            ad.setDoctorId(rd.getDoctorId());
            ad.setFlag(Boolean.TRUE);
            ad.setHospitalId(rd.getHospitalId());
            ad.setLoginId(ld);
            se.save(ad);
            
            
            tr.commit();
            msg = "success_book_appointment";
            try {
                    //Sending email
                    String subject = "HealthMate: Doctor Appointment Update";
                    String content = "You have successfully booked doctor appointments.";
                    String[] recipients = new String[]{email};
                    MailUtil mu = new MailUtil();
                    mu.sendMail(recipients, subject, content);
                } catch (Exception e) {
                    out.println("Error in send mail" + e.getMessage());
                }
            
            hs.setAttribute("notifier", msg);
            response.sendRedirect(path);
            
        } catch (Exception e) {
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
