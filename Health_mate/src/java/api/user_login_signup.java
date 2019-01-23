/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Date;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
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
@Path("user")
public class user_login_signup {
    @Path("login")
    @GET
    public static String login(@QueryParam("emailid") String emailid, @QueryParam("password") String password){
        
        //Session factory initialized and begins the transaction
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
        applySettings(configuration.getProperties());
        Session se = configuration.buildSessionFactory(builder.build()).openSession();
        Transaction tr = se.beginTransaction();
        String jsonData = "[{\"result\":\"Failed\"}]";
        try {
            
            Criteria cr = se.createCriteria(Logindetails.class);
            cr.add(Restrictions.eq("emailid", emailid));
            cr.add(Restrictions.eq("password", password));
            cr.add(Restrictions.eq("role", "user"));
            ArrayList<Logindetails> al = (ArrayList<Logindetails>) cr.list();
            tr.commit();
            
            if (al.size()>0) {
                jsonData = "[{\"result\":\"Success\"}]";
            }
            else {
                jsonData = "[{\"result\":\"Failed\"}]";
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            jsonData = "[{\"result\":\"Failed\"}]";
        }
        
        return jsonData;
    }
    
    @Path("signup")
    @GET
    public static String signup(@QueryParam("emailid") String emailid, @QueryParam("password") String password, @QueryParam("fname") String fname, @QueryParam("lname") String lname, @QueryParam("mobile") String mobile){
        
        //Session factory initialized and begins the transaction
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
        applySettings(configuration.getProperties());
        Session se = configuration.buildSessionFactory(builder.build()).openSession();
        Transaction tr = se.beginTransaction();
        String jsonData = "[{\"result\":\"Failed\"}]";
        try {
            Date date = new Date();
            fname = fname.substring(0, 1).toUpperCase() + fname.substring(1);
            lname = lname.substring(0, 1).toUpperCase() + lname.substring(1);
            
            Userdetails ud = new Userdetails();
            Logindetails ld = new Logindetails();
            
            //getting emailid and password related data from the logindetails class
            Criteria cr = se.createCriteria(Logindetails.class);
            cr.add(Restrictions.eq("emailid", emailid));
            
            //Checking if data is more than 0 than login is successful else unsuccessful
            ArrayList<Logindetails> al = (ArrayList<Logindetails>) cr.list();

            if (al.size() > 0) 
            {
                jsonData = "[{\"result\":\"Emailid already exists\"}]";
            } 
            else 
            {
                //All loginDetails table data are stored
                ld.setEmailid(emailid);
                ld.setPassword(password);
                ld.setDateTime(date);
                ld.setFlag(Boolean.TRUE);
                ld.setRole("user");
                se.save(ld);

                //All userDetails table data are stored
                ud.setDateTime(date);
                ud.setFirstname(fname);
                ud.setFlag(Boolean.TRUE);
                ud.setLastname(lname);
                ud.setLoginId(ld);
                ud.setMobile(mobile);
                se.save(ud);
                tr.commit();
                
                
                jsonData = "[{\"result\":\"Success\"}]";
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            jsonData = "[{\"result\":\"Failed\"}]";
        }
        
        return jsonData;
    }
    
    
}
