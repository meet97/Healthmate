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
public class temporary extends HttpServlet {

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
        HttpSession hs = request.getSession();
        PrintWriter out = response.getWriter();
        try {
            Configuration configuration = new Configuration().configure();
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
                Session se = configuration.buildSessionFactory(builder.build()).openSession();
                Transaction tr = se.beginTransaction();
            
                
                String emailid = hs.getAttribute("emailid").toString();
                
                Criteria cr = se.createCriteria(Logindetails.class);
                cr.add(Restrictions.eq("emailid", emailid));
                ArrayList<Logindetails> al = (ArrayList<Logindetails>)cr.list();
                Logindetails ld = al.get(0);
                
                cr = se.createCriteria(Appointmentdetails.class);
                cr.add(Restrictions.eq("loginId", ld));
                ArrayList<Appointmentdetails> all = (ArrayList<Appointmentdetails>)cr.list();
                
                for (int i = 0; i < all.size(); i++)
                {
                    Appointmentdetails ad = all.get(i);
                    Doctordetails dd = ad.getDoctorId();
                    Hospitaldetails hd = ad.getHospitalId();
                    
                    Date d = ad.getDate();
                    
                    out.print("");
                    if(ad.getFlag())
                    {
                        out.println("<tr>");
                        out.println("<td>"+hd.getHospitalname()+"</td>");
                        out.println("<td>"+dd.getFirstname()+" "+dd.getLastname()+"</td>");
                        out.println("<td>"+ad.getDate()+"</td>");
                        out.println("<td>"+ad.getTime()+"</td>");
                        out.println("<td><a href='cancel_appointment?appointmentId="+ad.getAppointmentId()+"' class='kepybutton'>Cancel Appointment</a></td>");
                        out.println("</tr>");
                    }
                }
        }
        catch(Exception e){
            
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
