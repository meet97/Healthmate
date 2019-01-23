/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import modal.Locationdetails;
import modal.Logindetails;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author sonav
 */
@Path("location")
public class location {
    @Path("city")
    @GET
    public static String city(@QueryParam("state") String state){
        
        //Session factory initialized and begins the transaction
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
        applySettings(configuration.getProperties());
        Session se = configuration.buildSessionFactory(builder.build()).openSession();
        Transaction tr = se.beginTransaction();
        String jsonData = "[{\"result\":\"Failed\"}]";
        try {
            
            Criteria cr = se.createCriteria(Locationdetails.class);
            cr.add(Restrictions.eq("state", state));
            //cr.setProjection(Projections.distinct(Projections.property("city")));
            ArrayList<Locationdetails> al = (ArrayList<Locationdetails>) cr.list();
            
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
            jsonData = gson.toJson(al);
            tr.commit();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            jsonData = "[{\"result\":\"Failed\"}]";
        }
        
        return jsonData;
    }
    
    @Path("area")
    @GET
    public static String area(@QueryParam("city") String city){
        
        //Session factory initialized and begins the transaction
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
        applySettings(configuration.getProperties());
        Session se = configuration.buildSessionFactory(builder.build()).openSession();
        Transaction tr = se.beginTransaction();
        String jsonData = "[{\"result\":\"Failed\"}]";
        try {
            
            Criteria cr = se.createCriteria(Locationdetails.class);
            cr.add(Restrictions.eq("city", city));
            //cr.setProjection(Projections.distinct(Projections.property("city")));
            ArrayList<Locationdetails> al = (ArrayList<Locationdetails>) cr.list();
            
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
            jsonData = gson.toJson(al);
            tr.commit();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            jsonData = "[{\"result\":\"Failed\"}]";
        }
        
        return jsonData;
    }
    
}
