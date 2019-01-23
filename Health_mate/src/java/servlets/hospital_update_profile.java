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
import modal.Hospitaldetails;
import modal.Locationdetails;
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
public class hospital_update_profile extends HttpServlet {

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
        String path = "hospitalprofile.jsp";

        try {
            /* TODO output your page here. You may use following sample code. */
            String hospitalname = request.getParameter("hospitalname");
            String hospitaladdress = request.getParameter("hospitaladdress");
            String hospitalarea = request.getParameter("hospitalarea");
            String hospitalcity = request.getParameter("hospitalcity");
            String hospitalstate = request.getParameter("hospitalstate");
            String hospitalpincode = request.getParameter("hospitalpincode");
            String mobile1 = request.getParameter("mobile1");
            String mobile2 = request.getParameter("mobile2");
            String country = request.getParameter("country");
            String emailid = request.getParameter("emailid");

            hospitalname = hospitalname.substring(0, 1).toUpperCase() + hospitalname.substring(1);
            hospitalarea = hospitalarea.substring(0, 1).toUpperCase() + hospitalarea.substring(1);
            hospitalcity = hospitalcity.substring(0, 1).toUpperCase() + hospitalcity.substring(1);

            //Session factory initialized and begins the transaction
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties());
            Session se = configuration.buildSessionFactory(builder.build()).openSession();
            Transaction tr = se.beginTransaction();

            //Creating modals object
            Hospitaldetails hd = new Hospitaldetails();

            //Getting old hospital details data
            Criteria cr = se.createCriteria(Hospitaldetails.class);
            cr.add(Restrictions.eq("emailid1", emailid));
            ArrayList<Hospitaldetails> al = (ArrayList<Hospitaldetails>) cr.list();
            hd = al.get(0);

            hd.setDateTime(date);
            hd.setHospitalname(hospitalname);
            hd.setEmailid1(emailid);
            hd.setMobile1(mobile1);
            hd.setMobile2(mobile2);
            se.save(hd);

            Locationdetails lod = hd.getLocationId();
            lod.setAddress(hospitaladdress);
            lod.setArea(hospitalarea);
            lod.setCity(hospitalcity);
            lod.setState(hospitalstate);
            lod.setCountry(country);
            lod.setDateTime(date);
            lod.setPincode(hospitalpincode);
            se.save(lod);

            tr.commit();
            path = "hospitalprofile.jsp";
            msg = "success_profile";

            hs.setAttribute("notifier", msg);
            response.sendRedirect(path);
        } catch (Exception e) {
            hs.setAttribute("notifier", msg);
            response.sendRedirect(path);
        }

    }// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

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
