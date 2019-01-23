/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import jdk.nashorn.internal.parser.JSONParser;
import modal.Doctordetails;
import modal.Hospitaldetails;
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
@Path("hospital")
public class hospital {
    
    @Path("name")
    @GET
    public static String hospitalname(@QueryParam("area") String area){
        
        //Session factory initialized and begins the transaction
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
        applySettings(configuration.getProperties());
        Session se = configuration.buildSessionFactory(builder.build()).openSession();
        Transaction tr = se.beginTransaction();
        String jsonData = "";
        
        
        JsonObject jo = new JsonObject();
        
        try {
            
            //getting locationID data from the LocationDetails class
            Criteria cr = se.createCriteria(Locationdetails.class);
            cr.add(Restrictions.eq("area", area));
            ArrayList<Locationdetails> al = (ArrayList<Locationdetails>) cr.list();
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
            ArrayList<Hospitaldetails> hostpital=new   ArrayList<>();
            for (int j = 0; j < al.size(); j++) 
            {
                Locationdetails loc = al.get(j);
                Criteria crr = se.createCriteria(Hospitaldetails.class);
                crr.add(Restrictions.eq("locationId", loc));
                ArrayList<Hospitaldetails> all = (ArrayList<Hospitaldetails>) crr.list();
                hostpital.addAll(all);
            }
             if (hostpital.size()>=0) {
                    jsonData = jsonData + gson.toJson(hostpital);        
                }
            
            tr.commit();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            jsonData = "[{\"result\":\"Failed\"}]";
        }
        
        return jsonData;
    }
    
    @Path("doctor")
    @GET
    public static String doctor(@QueryParam("hospital") String hospital){
        
        //Session factory initialized and begins the transaction
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
        applySettings(configuration.getProperties());
        Session se = configuration.buildSessionFactory(builder.build()).openSession();
        Transaction tr = se.beginTransaction();
        String jsonData = "";
        try {
            
            //getting locationID data from the LocationDetails class
            Criteria cr = se.createCriteria(Hospitaldetails.class);
            cr.add(Restrictions.eq("hospitalname", hospital));
            ArrayList<Hospitaldetails> al = (ArrayList<Hospitaldetails>) cr.list();
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
            
            for (int j = 0; j < al.size(); j++) 
            {
                Hospitaldetails hd = al.get(j);

                //Creating hospital details object
                Criteria crr = se.createCriteria(Doctordetails.class);
                crr.add(Restrictions.eq("hopitalId", hd));
                ArrayList<Doctordetails> all = (ArrayList<Doctordetails>) crr.list();
                
                if (all.size()>=0) {
                    jsonData = jsonData + gson.toJson(all);
                }
            }
            
            tr.commit();
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            jsonData = "[{\"result\":\"Failed\"}]";
        }
        
        return jsonData;
    }
    
}
