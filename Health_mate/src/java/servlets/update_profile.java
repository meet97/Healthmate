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
import modal.Locationdetails;
import modal.Logindetails;
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
public class update_profile extends HttpServlet {

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
        String msg = "fail_profile";
        String path = "profile.jsp";

        try {
            //Getting data from request paramters
            String fname = request.getParameter("fname");
            String mname = request.getParameter("mname");
            String lname = request.getParameter("lname");
            String mobile = request.getParameter("mobile");
            String emailid = request.getParameter("emailid");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String country = request.getParameter("country");
            String pincode = request.getParameter("pincode");

            fname = fname.substring(0, 1).toUpperCase() + fname.substring(1);
            mname = mname.substring(0, 1).toUpperCase() + mname.substring(1);
            lname = lname.substring(0, 1).toUpperCase() + lname.substring(1);
            city = city.substring(0, 1).toUpperCase() + city.substring(1);
            country = country.substring(0, 1).toUpperCase() + country.substring(1);

            //Session factory initialized and begins the transaction
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties());
            Session se = configuration.buildSessionFactory(builder.build()).openSession();
            Transaction tr = se.beginTransaction();

            //Creating modals object
            Userdetails ud = new Userdetails();
            Logindetails ld = new Logindetails();
            Locationdetails lod = new Locationdetails();

            /*Session code + emailid get*/
            String session_emailid = hs.getAttribute("emailid").toString();

            //Storing logindetails data
            Criteria cr = se.createCriteria(Logindetails.class);
            cr.add(Restrictions.eq("emailid", session_emailid));
            ArrayList<Logindetails> al = (ArrayList<Logindetails>) cr.list();
            ld = al.get(0);
            ld.setDateTime(date);
            ld.setEmailid(emailid);
            se.save(ld);

            //Storing LocationDetails data
            cr = se.createCriteria(Userdetails.class);
            cr.add(Restrictions.eq("loginId", ld));
            ArrayList<Userdetails> alu = (ArrayList<Userdetails>) cr.list();
            ud = alu.get(0);

            if (ud.getLocationId() != null) {
                lod = ud.getLocationId();
            }
            lod.setAddress(address);
            lod.setCity(city);
            lod.setCountry(country);
            lod.setPincode(pincode);
            lod.setState(state);
            lod.setDateTime(date);
            lod.setFlag(Boolean.TRUE);
            se.save(lod);

            //Storing Userdetails data
            ud.setDateTime(date);
            ud.setFirstname(fname);
            ud.setLastname(lname);
            ud.setLoginId(ld);
            ud.setLocationId(lod);
            ud.setMiddlename(mname);
            ud.setMobile(mobile);
            ud.setFlag(Boolean.TRUE);
            se.save(ud);

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
