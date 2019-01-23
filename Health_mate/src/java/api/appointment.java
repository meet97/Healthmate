/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import modal.Appointmentdetails;
import modal.Doctordetails;
import modal.Hospitaldetails;
import modal.Logindetails;
import modal.Userdetails;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import servlets.MailUtil;

/**
 *
 * @author sonav
 */
@Path("appointment")
public class appointment {

    @Path("time")
    @GET
    public static String time(@QueryParam("date") String parameter_date, @QueryParam("doctorname") String doctorname) {

        //Session factory initialized and begins the transaction
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        Session se = configuration.buildSessionFactory(builder.build()).openSession();
        Transaction tr = se.beginTransaction();
        String jsonData = "";
        Boolean nine = Boolean.TRUE;
        Boolean ten = Boolean.TRUE;
        Boolean eleven = Boolean.TRUE;
        Boolean twelve = Boolean.TRUE;
        Boolean four = Boolean.TRUE;
        Boolean five = Boolean.TRUE;
        Boolean six = Boolean.TRUE;
        Boolean seven = Boolean.TRUE;
        
        try {

            SimpleDateFormat sdf_date = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf_date.parse(parameter_date);

            String appointment_date = new SimpleDateFormat("yyyy-MM-dd").format(date);

            //getting emailid and password related data from the logindetails class
            Criteria cr = se.createCriteria(Doctordetails.class);
            cr.add(Restrictions.eq("firstname", doctorname));
            ArrayList<Doctordetails> al = (ArrayList<Doctordetails>) cr.list();

            if (al.size() > 0) 
            {
                Doctordetails dd = al.get(0);

                String sql = "Select a.time from (SELECT time,COUNT(appointment_id) as n "
                        + "FROM appointmentdetails where date = '" + appointment_date + "' and doctor_id = " + dd.getDoctorId() + " GROUP BY time) as a"
                        + " where a.n < 4";

                Query query = se.createSQLQuery(sql);
                List list = query.list();
                
                Date system_date = new Date();
                //check format for datesssssssssssss
                if(system_date.getDate() == (date.getDate()))
                {
                    //check jdk version here
                    //Check time for 12 to 24
                    int hour = system_date.getHours();
                    if(hour>=19)
                    {
                        seven = Boolean.FALSE;
                    }
                    if(hour>=18)
                    {
                        six = Boolean.FALSE;
                    }
                    if(hour>=17)
                    {
                        five = Boolean.FALSE;
                    }
                    if(hour>=16)
                    {
                        four = Boolean.FALSE;
                    }
                    if(hour>=12)
                    {
                        twelve = Boolean.FALSE;
                    }
                    if(hour>=11)
                    {
                        eleven = Boolean.FALSE;
                    }
                    if(hour>=10)
                    {
                        ten = Boolean.FALSE;
                    }
                    if(hour>=9)
                    {
                        nine = Boolean.FALSE;
                    }
                }
                
                JSONObject jsonObject=new JSONObject();
                
                if(list.size()>0) 
                {    
                    for (int i = 0; i < list.size(); i++) 
                    {
                        if ("09:00:00".equals(list.get(i).toString())) 
                        {
                            nine = Boolean.FALSE;
                        }
                        else if ("10:00:00".equals(list.get(i).toString())) 
                        {
                            ten = Boolean.FALSE;
                        }
                        else if ("11:00:00".equals(list.get(i).toString())) 
                        {
                            eleven = Boolean.FALSE;
                        }
                        else if ("12:00:00".equals(list.get(i).toString())) 
                        {
                            twelve = Boolean.FALSE;
                        }
                        else if ("16:00:00".equals(list.get(i).toString())) 
                        {
                            four = Boolean.FALSE;
                        }
                        else if ("17:00:00".equals(list.get(i).toString())) 
                        {
                            five = Boolean.FALSE;
                        }
                        else if ("18:00:00".equals(list.get(i).toString())) 
                        {
                            six = Boolean.FALSE;
                        }
                        else if ("19:00:00".equals(list.get(i).toString())) 
                        {
                            seven = Boolean.FALSE;
                        }
                        else
                        {
                            String hdsahkjhs = "";
                        }
                    }
                }
                
                ArrayList jsonarray = new ArrayList();
                if (nine) 
                {
                    jsonarray.add("9:00 AM");
                }
                if (ten) 
                {
                    jsonarray.add("10:00 AM");
                }
                if (eleven) 
                {
                    jsonarray.add("11:00 AM");
                }
                if (twelve) 
                {
                    jsonarray.add("12:00 AM");
                }
                if (four) 
                {
                    jsonarray.add("4:00 AM");
                }
                if (five) 
                {
                    jsonarray.add("5:00 AM");
                }
                if (six) 
                {
                    jsonarray.add("6:00 AM");
                }
                if (seven) 
                {
                    jsonarray.add("7:00 AM");
                }
                
                jsonData = jsonObject.put("time", jsonarray).toString();

            }
            tr.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            jsonData = "[{\"result\":\"Failed\"}]";
        }

        return jsonData;
    }
    
    @Path("viewappointment")
    @GET
    public static String viewappointment(@QueryParam("emailid") String emailid) {

        //Session factory initialized and begins the transaction
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        Session se = configuration.buildSessionFactory(builder.build()).openSession();
        Transaction tr = se.beginTransaction();
        String jsonData = "";
        try {

            Criteria cr = se.createCriteria(Logindetails.class);
            cr.add(Restrictions.eq("emailid", emailid));
            ArrayList<Logindetails> al = (ArrayList<Logindetails>) cr.list();
            Logindetails ld = al.get(0);

            cr = se.createCriteria(Appointmentdetails.class);
            cr.add(Restrictions.eq("loginId", ld));
            Date d = new Date();
            cr.add(Restrictions.eq("date", d));
            cr.add(Restrictions.eq("flag", Boolean.TRUE));
            ArrayList<Appointmentdetails> all = (ArrayList<Appointmentdetails>) cr.list();

            if (all.size() > 0) {
                Appointmentdetails ad = all.get(0);
                cr = se.createCriteria(Appointmentdetails.class);
                cr.add(Restrictions.eq("date", d));
                cr.add(Restrictions.eq("hospitalId", ad.getHospitalId()));
                cr.add(Restrictions.eq("doctorId", ad.getDoctorId()));
                cr.add(Restrictions.eq("flag", Boolean.TRUE));
                cr.addOrder(Order.asc("time"));
                ArrayList<Appointmentdetails> all_appointment = (ArrayList<Appointmentdetails>) cr.list();

                Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                jsonData = gson.toJson(all_appointment);

                tr.commit();
            }
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            jsonData = "[{\"result\":\"Failed\"}]";
        }

        return jsonData;
    }

    @Path("bookappointment")
    @GET
    public static String bookappointment(@QueryParam("emailid") String emailid, @QueryParam("hospital") String hospital, @QueryParam("doctor") String doctor, @QueryParam("time") String a_time, @QueryParam("date") String a_date) {

        //Session factory initialized and begins the transaction
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        Session se = configuration.buildSessionFactory(builder.build()).openSession();
        Transaction tr = se.beginTransaction();
        String jsonData = "";
        try {

            SimpleDateFormat sdf_date = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdf_time = new SimpleDateFormat("hh:mm a");
            Date appointment_date = sdf_date.parse(a_date);
            Date appointment_time = sdf_time.parse(a_time);

            Appointmentdetails ad = new Appointmentdetails(); 
            
            //Login ID code
            Criteria cr = se.createCriteria(Logindetails.class);
            cr.add(Restrictions.eq("emailid", emailid));
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
            ad.setDateTime(new Date());
            //appointment date and time
            ad.setDate(appointment_date);
            ad.setTime(appointment_time);
            
            Criteria crt = se.createCriteria(Appointmentdetails.class);
            crt.add(Restrictions.eq("doctorId", dd));
            crt.add(Restrictions.eq("hospitalId", hd));
            crt.add(Restrictions.eq("loginId", ld));
            crt.add(Restrictions.eq("date", appointment_date));
            crt.add(Restrictions.eq("flag", true));
            ArrayList<Appointmentdetails> arra = (ArrayList<Appointmentdetails>) crt.list();
            
            if (arra.size()>0) {
                jsonData = "[{\"result\":\"Failed\"}]";
            } else {
                se.save(ad);
                tr.commit();
                
                try {
                    //Sending email
                    String subject = "HealthMate: Doctor Appointment Update";
                    String content = "You have successfully booked doctor appointments. This are the appointment details: DoctorName : "+doctor +" Hospital :" +hospital
                                        + " Date : "+ a_date + " Time : " +a_time;
                    String[] recipients = new String[]{emailid};
                    MailUtil mu = new MailUtil();
                    mu.sendMail(recipients, subject, content);
                } catch (Exception e) {
                    System.out.println("Error in send mail" + e.getMessage());
                }
                
                jsonData = "[{\"result\":\"Success\"}]";
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            jsonData = "[{\"result\":\"Failed\"}]";
        }

        return jsonData;
    }
    
    @Path("myappointment")
    @GET
    public static String myappointment(@QueryParam("emailid") String emailid) {

        //Session factory initialized and begins the transaction
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties());
        Session se = configuration.buildSessionFactory(builder.build()).openSession();
        Transaction tr = se.beginTransaction();
        String jsonData = "";
        try {

            Criteria cr = se.createCriteria(Logindetails.class);
            cr.add(Restrictions.eq("emailid", emailid));
            ArrayList<Logindetails> al = (ArrayList<Logindetails>)cr.list();
            Logindetails ld = al.get(0);
                
            cr = se.createCriteria(Appointmentdetails.class);
            cr.add(Restrictions.eq("loginId", ld));
            cr.addOrder(Order.asc("date"));
            cr.add(Restrictions.eq("flag", Boolean.TRUE));
            ArrayList<Appointmentdetails> all = (ArrayList<Appointmentdetails>)cr.list();
            
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
            jsonData = gson.toJson(all);
            
            tr.commit();
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            jsonData = "[{\"result\":\"Failed\"}]";
        }

        return jsonData;
    }
    
}
