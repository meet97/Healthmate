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
public class registration_doctor extends HttpServlet {

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
        String msg = "fail_register";
        String path = "doctorregister.jsp";

        try {
            /* TODO output your page here. You may use following sample code. */
            Date date = new Date();
            String password = request.getParameter("password");
            String emailid = request.getParameter("emailid");
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String mobile = request.getParameter("mobile");
            String role = request.getParameter("role");
            //Gets all the data by query parameter

            fname = fname.substring(0, 1).toUpperCase() + fname.substring(1);
            lname = lname.substring(0, 1).toUpperCase() + lname.substring(1);

            //Session factory initialized and begins the transaction
            Doctordetails dd = new Doctordetails();
            Logindetails ld = new Logindetails();
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties());
            Session se = configuration.buildSessionFactory(builder.build()).openSession();
            Transaction tr = se.beginTransaction();

            //getting emailid and password related data from the logindetails class
            Criteria cr = se.createCriteria(Logindetails.class);
            cr.add(Restrictions.eq("emailid", emailid));

            //Checking if data is more than 0 than login is successful else unsuccessful
            ArrayList<Logindetails> al = (ArrayList<Logindetails>) cr.list();

            if (al.size() > 0) {
                msg = "fail_register";
                hs.setAttribute("notifier", msg);
                response.sendRedirect(path);
            } else {
                //All loginDetails table data are stored
                ld.setEmailid(emailid);
                ld.setPassword(password);
                ld.setDateTime(date);
                ld.setFlag(Boolean.TRUE);
                ld.setRole(role);

                se.save(ld);

                try {

                    //All DoctorDetails table data are stored
                    dd.setDateTime(date);
                    dd.setFirstname(fname);
                    dd.setFlag(Boolean.TRUE);
                    dd.setLastname(lname);
                    dd.setLoginId(ld);
                    dd.setMobile1(mobile);

                    se.save(dd);

                    //Setting attribute for one session
                    hs.setAttribute("emailid", emailid);
                } catch (Exception e) {
                    out.println(e.getMessage());
                }

                path = "doctorregister(2).html";
                //Transaction commited and request dispactched to other page
                tr.commit();
                response.sendRedirect(path);
            }

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
