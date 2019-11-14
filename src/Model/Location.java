/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.google.gson.Gson;
import java.util.Date;

/**
 *
 * @author jxw5883
 */
public abstract class Location implements Reportable{
    private Date lastUpdated;

    /**
     * @return the lastUpdated
     */
    public Date getLastUpdated() {
        return lastUpdated;
    }
    
    /**
     * Generates a JSON String containing all details of a Location.
     * @return JSON String 
     */
    @Override
    public String generateReport() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
    
    public abstract String getLocation();
}
