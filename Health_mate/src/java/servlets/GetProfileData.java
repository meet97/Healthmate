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
import modal.Doctordetails;
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
public class GetProfileData extends HttpServlet {

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
        try {
            /* TODO output your page here. You may use following sample code. */
 /*Session code + emailid get*/
            String emailid = hs.getAttribute("emailid").toString();

            //Session factory initialized and begins the transaction
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties());
            Session se = configuration.buildSessionFactory(builder.build()).openSession();
            Transaction tr = se.beginTransaction();

            //getting emailid and password related data from the logindetails class
            Criteria cr = se.createCriteria(Logindetails.class);
            cr.add(Restrictions.eq("emailid", emailid));

            //Checking if data is more than 0 than login is successful else unsuccessful
            ArrayList<Logindetails> all = (ArrayList<Logindetails>) cr.list();
            Logindetails ld = all.get(0);

            String role = ld.getRole();
            if (role.equals("doctor")) {
                //Getting UserDetails using loginid
                //Important use only modal related name and give whole object to get the data
                Criteria crr = se.createCriteria(Doctordetails.class);
                crr.add(Restrictions.eq("loginId", ld));
                ArrayList<Doctordetails> alu = (ArrayList<Doctordetails>) crr.list();
                Doctordetails dd = alu.get(0);

                String mname = dd.getMiddlename();
                if (mname == null) {
                    mname = "";
                }
                //For response
                out.println(dd.getFirstname() + "," + mname + "," + dd.getLastname() + "," + dd.getMobile1() + "," + ld.getEmailid());
            } else if (role.equals("user")) {
                //Getting UserDetails using loginid
                //Important use only modal related name and give whole object to get the data
                Criteria crr = se.createCriteria(Userdetails.class);
                crr.add(Restrictions.eq("loginId", ld));
                ArrayList<Userdetails> alu = (ArrayList<Userdetails>) crr.list();
                Userdetails ud = alu.get(0);
                Locationdetails lod = ud.getLocationId();

                String mname = ud.getMiddlename();
                if (mname == null) {
                    mname = "";
                }
                //For response
                out.println(ud.getFirstname() + "," + mname + "," + ud.getLastname() + "," + ud.getMobile() + "," + ld.getEmailid());
                if (lod == null) {
                    out.println("," + "" + "," + "" + "," + "" + "," + "" + "," + "");
                } else {
                    out.print("," + lod.getAddress() + "," + lod.getCity() + "," + lod.getState() + "," + lod.getCountry() + "," + lod.getPincode());
                }
            }
        } catch (Exception e) {
            out.println(e.getMessage());
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
