/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.Appointmentdetails;
import modal.Doctordetails;
import modal.Locationdetails;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author sonav
 */
public class GetTime extends HttpServlet {

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
        try {
            String doctor_name = request.getParameter("doctorname");
            String parameter_date = request.getParameter("date");
            
            SimpleDateFormat sdf_date = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf_date.parse(parameter_date);
            
            String appointment_date = new SimpleDateFormat("yyyy-MM-dd").format(date);
            
            //Session factory initialized and begins the transaction
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties());
            Session se = configuration.buildSessionFactory(builder.build()).openSession();
            Transaction tr = se.beginTransaction();

            //getting emailid and password related data from the logindetails class
            Criteria cr = se.createCriteria(Doctordetails.class);
            cr.add(Restrictions.eq("firstname", doctor_name));
            ArrayList<Doctordetails> al = (ArrayList<Doctordetails>) cr.list();
            
            out.print("<option>Select</option>");
            if (al.size()>0) 
            {
                Doctordetails dd = al.get(0);
                
                String sql = "Select a.time from (SELECT time,COUNT(appointment_id) as n "+
                    "FROM appointmentdetails where date = '"+appointment_date+"' and doctor_id = "+dd.getDoctorId()+" GROUP BY time) as a"+
                    " where a.n = 4";
                
                Query query = se.createSQLQuery(sql);
                List list = query.list();
                
                String nine="";
                String ten="";
                String eleven="";
                String twelve="";
                String four="";
                String five="";
                String six="";
                String seven="";
                
                Date system_date = new Date();
                //check format for datesssssssssssss
                if(system_date.getDate() == (date.getDate()))
                {
                    //check jdk version here
                    //Check time for 12 to 24
                    int hour = system_date.getHours();
                    if(hour>=19)
                    {
                        seven = " disabled";
                    }
                    if(hour>=18)
                    {
                        six = " disabled";
                    }
                    if(hour>=17)
                    {
                        five = " disabled";
                    }
                    if(hour>=16)
                    {
                        four = " disabled";
                    }
                    if(hour>=12)
                    {
                        twelve = " disabled";
                    }
                    if(hour>=11)
                    {
                        eleven = " disabled";
                    }
                    if(hour>=10)
                    {
                        ten = " disabled";
                    }
                    if(hour>=9)
                    {
                        nine = " disabled";
                    }
                }
                
                
                if(list.size()>0) 
                {    
                    for (int i = 0; i < list.size(); i++) 
                    {
                        if ("09:00:00".equals(list.get(i).toString())) 
                        {
                            nine = " disabled";
                        }
                        else if ("10:00:00".equals(list.get(i).toString())) 
                        {
                            ten = " disabled";
                        }
                        else if ("11:00:00".equals(list.get(i).toString())) 
                        {
                            eleven = " disabled";
                        }
                        else if ("12:00:00".equals(list.get(i).toString())) 
                        {
                            twelve = " disabled";
                        }
                        else if ("16:00:00".equals(list.get(i).toString())) 
                        {
                            four = " disabled";
                        }
                        else if ("17:00:00".equals(list.get(i).toString())) 
                        {
                            five = " disabled";
                        }
                        else if ("18:00:00".equals(list.get(i).toString())) 
                        {
                            six = " disabled";
                        }
                        else if ("19:00:00".equals(list.get(i).toString())) 
                        {
                            seven = " disabled";
                        }
                        else
                        {
                            
                        }
                    }
                    
                }
                out.print("<option"+nine+">9:00 AM</option>");
                out.print("<option"+ten+">10:00 AM</option>");
                out.print("<option"+eleven+">11:00 AM</option>");
                out.print("<option"+twelve+">12:00 AM</option>");
                out.print("<option"+four+">4:00 PM</option>");
                out.print("<option"+five+">5:00 PM</option>");
                out.print("<option"+six+">6:00 PM</option>");
                out.print("<option"+seven+">7:00 PM</option>");
                
            }
            
            

            tr.commit();
        } catch (Exception e) {
            out.print("<option>Select</option>");
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
