/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.HashMap;

/**
 *
 * @author jxw5883
 */
public class Question_ {
    
//JSON Format
/*
{
  "question": {
    "id": 0,
    "title": "What best describes your current situation?",
    "response": {
      "a": "Seismic",
      "b": "Flood",
      "c": "Inclement Weather",
      "d": "Emergency"
    },
    
    "redirect":{
      "a": 1,
      "b": 2,
      "c": 3,
      "d": 4
    }
  }
}
*/
    private int id;
    private String title;
    private HashMap<String, String> response;
    private HashMap<String, Integer> redirect;
    
    public static Question_ importFromJSON(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Question_.class);
    }

    /**
     *
     * @param json
     * @return
     */
    public static Question_ importFromJSON(JsonObject json){
        Gson gson = new Gson();
        return gson.fromJson(json, Question_.class);
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the response
     */
    public HashMap<String, String> getResponse() {
        return response;
    }

    /**
     * @return the redirect
     */
    public HashMap<String, Integer> getRedirect() {
        return redirect;
    }
    
    @Override
    public String toString(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
    
}
