/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author jxw5883
 */
public class Coordinate {
    private double longitude;
    private double latitude;

    public Coordinate(double lattitude, double longitude) {
        this.latitude = lattitude;
        this.longitude = longitude;
    }

    /**
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
    /**
     * Returns longitude in the format of Degrees, Minutes, and Seconds
     * @return String of format "DDD° MM' SS.S""
     */
    public String getLognitudeAsDMS(){
        String result = "";
        
        double decimalValue = this.longitude;
        boolean isWest = false;
        if(this.longitude < 0){
            isWest = true;
            decimalValue *= -1;
        }
        result += (int) decimalValue;
        result += "° ";
        
        decimalValue = (decimalValue - (int) decimalValue);        
        
        decimalValue *= 60;
        result += (int) decimalValue;
        result += "\' ";
        
        decimalValue -= (int) decimalValue;
        decimalValue *= 60;
        BigDecimal dV = new BigDecimal(decimalValue);
        dV = dV.setScale(3, RoundingMode.HALF_UP);
        result += dV.doubleValue();
        result += "\"";
        
        if(isWest)
            result += " W";
        else
            result += " E";
        
        return result;
        
    }
    
    /**
     * Returns latitude in the format of Degrees, Minutes, and Seconds
     * @return String of format "DDD° MM' SS.S""
     */
    public String getLatitudeAsDMS(){
        String result = "";
        
        double decimalValue = this.latitude;
        boolean isSouth = false;
        if(this.latitude < 0){
            isSouth = true;
            decimalValue *= -1;
        }
        result += (int) decimalValue;
        result += "° ";
        decimalValue = (decimalValue - (int) decimalValue);
        
        decimalValue *= 60;
        result += (int) decimalValue;
        result += "\' ";
        
        decimalValue -= (int) decimalValue;
        decimalValue *= 60;
        BigDecimal dV = new BigDecimal(decimalValue);
        dV = dV.setScale(3, RoundingMode.HALF_UP);
        result += dV.doubleValue();
        result += "\"";
        if(isSouth)
            result += " S";
        else
            result += " N";
        return result;
        
    }
}
