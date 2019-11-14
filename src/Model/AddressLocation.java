/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.google.gson.Gson;

/**
 *
 * @author jxw5883
 */
public class AddressLocation extends Location{
    private String address;
    private String city;
    private String state;
    private String zipcode;
    
    public String getAddress(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    @Override
    public String getLocation() {
        return getAddress();
    }
}
