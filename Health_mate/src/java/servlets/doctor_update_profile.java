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
public class doctor_update_profile extends HttpServlet {

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
        Date date = new Date();
        String msg = "fail_profile";
        String path = "profile.jsp";

        try {
            String fname = request.getParameter("fname");
            String mname = request.getParameter("mname");
            String lname = request.getParameter("lname");
            String mobile = request.getParameter("mobile");
            String emailid = request.getParameter("emailid");

            fname = fname.substring(0, 1).toUpperCase() + fname.substring(1);
            mname = mname.substring(0, 1).toUpperCase() + mname.substring(1);
            lname = lname.substring(0, 1).toUpperCase() + lname.substring(1);

            //Session factory initialized and begins the transaction
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties());
            Session se = configuration.buildSessionFactory(builder.build()).openSession();
            Transaction tr = se.beginTransaction();

            //Creating modals object
            Logindetails ld = new Logindetails();
            Doctordetails dd = new Doctordetails();

            /*Session code + emailid get*/
            String session_emailid = hs.getAttribute("emailid").toString();

            //Storing new email id in logindetails data
            Criteria cr = se.createCriteria(Logindetails.class);
            cr.add(Restrictions.eq("emailid", session_emailid));
            ArrayList<Logindetails> al = (ArrayList<Logindetails>) cr.list();
            ld = al.get(0);
            ld.setDateTime(date);
            ld.setEmailid(emailid);
            se.save(ld);

            //Getting old doctor details data
            cr = se.createCriteria(Doctordetails.class);
            cr.add(Restrictions.eq("loginId", ld));
            ArrayList<Doctordetails> alu = (ArrayList<Doctordetails>) cr.list();
            dd = alu.get(0);

            //Storing updated doctor details here
            dd.setDateTime(date);
            dd.setFirstname(fname);
            dd.setMiddlename(mname);
            dd.setLastname(lname);
            dd.setMobile1(mobile);
            dd.setLoginId(ld);
            se.save(dd);

            tr.commit();
            path = "profile.jsp";
            hs.setAttribute("emailid", emailid);
            msg = "success_profile";

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
