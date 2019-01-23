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
public class forgot_password extends HttpServlet {

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
        String msg = "fail_forgot";
        String path = "forgot.jsp";

        try {
            /* TODO output your page here. You may use following sample code. */
            String emailid = request.getParameter("emailid");

            //New session initialized and transaction is begin
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties());
            Session se = configuration.buildSessionFactory(builder.build()).openSession();
            Transaction tr = se.beginTransaction();

            //Getting password from logindetails
            Criteria cr = se.createCriteria(Logindetails.class);
            cr.add(Restrictions.eq("emailid", emailid));
            ArrayList<Logindetails> al = (ArrayList<Logindetails>) cr.list();
            String password = "";

            if (al.size() > 0) {
                Logindetails ld = new Logindetails();
                ld = al.get(0);
                password = ld.getPassword();

                //Sending email
                String subject = "Forgot Password - HealthMate";
                String content = "Your password -- " + password;
                String[] recipients = new String[]{emailid};
                MailUtil mu = new MailUtil();

                if (mu.sendMail(recipients, subject, content)) {
                    msg = "success_forgot";

                } else {
                    msg = "fail_forgot";
                }
            } else {
                msg = "fail_forgot";
            }
            path = "forgot.jsp";
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
