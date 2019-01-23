/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modal.Appointmentdetails;
import modal.Doctordetails;
import modal.Hospitaldetails;
import modal.Logindetails;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author admin
 */
public class book_appointment extends HttpServlet {

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
            String hospital = request.getParameter("hospital");
            String doctor = request.getParameter("doctor");
            String a_time = request.getParameter("time");
            String a_date = request.getParameter("date");

            SimpleDateFormat sdf_date = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdf_time = new SimpleDateFormat("hh:mm a");
            Date appointment_date = sdf_date.parse(a_date);
            Date appointment_time = sdf_time.parse(a_time);

            //Session factory initialized and begins the transaction
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            Session se = configuration.buildSessionFactory(builder.build()).openSession();
            Transaction tr = se.beginTransaction();

            Appointmentdetails ad = new Appointmentdetails(); 

            //Login ID code
            String session_emailid = hs.getAttribute("emailid").toString();
            Criteria cr = se.createCriteria(Logindetails.class);
            cr.add(Restrictions.eq("emailid", session_emailid));
            ArrayList<Logindetails> al = (ArrayList<Logindetails>) cr.list();
            Logindetails ld = al.get(0);

            //Hospital ID code
            cr = se.createCriteria(Hospitaldetails.class);
            cr.add(Restrictions.eq("hospitalname", hospital));
            ArrayList<Hospitaldetails> alh = (ArrayList<Hospitaldetails>) cr.list();
            Hospitaldetails hd = alh.get(0);

            //Doctor ID code
            cr = se.createCriteria(Doctordetails.class);
            cr.add(Restrictions.eq("firstname", doctor));
            ArrayList<Doctordetails> all = (ArrayList<Doctordetails>) cr.list();
            Doctordetails dd = all.get(0);

            ad.setLoginId(ld);
            ad.setHospitalId(hd);
            ad.setDoctorId(dd);
            ad.setFlag(Boolean.TRUE);
            ad.setDateTime(date);
            //appointment date and time
            ad.setDate(appointment_date);
            ad.setTime(appointment_time);
            //appointment date and time completed
            
            Criteria crt = se.createCriteria(Appointmentdetails.class);
            crt.add(Restrictions.eq("doctorId", dd));
            crt.add(Restrictions.eq("hospitalId", hd));
            crt.add(Restrictions.eq("loginId", ld));
            crt.add(Restrictions.eq("date", appointment_date));
            crt.add(Restrictions.eq("flag", true));
            ArrayList<Appointmentdetails> arra = (ArrayList<Appointmentdetails>) crt.list();
            
            if (arra.size()>0) {
                msg = "error_book_appointment";
            } else {
                se.save(ad);
                tr.commit();
                msg = "success_book_appointment";
                
                try {
                    //Sending email
                    String subject = "HealthMate: Doctor Appointment Update";
                    String content = "You have successfully booked doctor appointments. This are the appointment details: DoctorName : "+doctor +" Hospital :" +hospital
                                        + " Date : "+ a_date + " Time : " +a_time;
                    String[] recipients = new String[]{session_emailid};
                    MailUtil mu = new MailUtil();
                    mu.sendMail(recipients, subject, content);
                } catch (Exception e) {
                    out.println("Error in send mail" + e.getMessage());
                }
                
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
