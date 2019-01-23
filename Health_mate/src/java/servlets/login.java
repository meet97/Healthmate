/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
public class login extends HttpServlet {

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
        String path = "login.jsp";
        String msg = "fail";

        try {
            /* TODO output your page here. You may use following sample code. */
            String emailid = request.getParameter("emailid");
            String password = request.getParameter("password");
            //Getting data from query parameter

            //New session initialized and transaction is begin
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties());
            Session se = configuration.buildSessionFactory(builder.build()).openSession();
            Transaction tr = se.beginTransaction();

            //getting emailid and password related data from the logindetails class
            Criteria cr = se.createCriteria(Logindetails.class);
            cr.add(Restrictions.eq("emailid", emailid));
            cr.add(Restrictions.eq("password", password));

            //Checking if data is more than 0 than login is successful else unsuccessful
            ArrayList<Logindetails> al = (ArrayList<Logindetails>) cr.list();
            if (al.size() > 0) {
                Logindetails lt = al.get(0);
                String role = lt.getRole();
                hs.setAttribute("login", lt);
                if (role.equals("admin") && lt.getFlag()) {
                    path = "Admin/userdetails.jsp";
                    msg = "success";
                } else if (role.equals("doctor") && lt.getFlag()) {
                    path = "Doctor/home.jsp";
                    msg = "success";
                } else if (role.equals("receptionist") && lt.getFlag()) {
                    path = "Receptionist/home.jsp";
                    msg = "success";
                } else if (role.equals("user") && lt.getFlag()) {
                    path = "User/home.jsp";
                    msg = "success";
                }

                //Setting user_id for one session
                hs.setAttribute("emailid", emailid);
            } else {
                msg = "fail";
                path = "login.jsp";
            }

            //transaction is commited and request dispacthed to another page
            tr.commit();
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
