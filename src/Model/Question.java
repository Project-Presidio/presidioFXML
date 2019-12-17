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
 * This model class contains the definition of a Question based off a JSON format.
 * The following is the JSON format this class is based on.
 * {
 * "question": {
 *   "id": 0,
 *   "title": "What best describes your current situation?",
 *   "response": {
 *     "a": "Seismic",
 *     "b": "Flood",
 *     "c": "Inclement Weather",
 *     "d": "Emergency"
 *   },
 *   
 *   "redirect":{
 *     "a": 1,
 *     "b": 2,
 *     "c": 3,
 *     "d": 4
 *   }
 *  }
 *}
 * @author jxw5883
 */
public class Question {
    
    private int id;
    private String title;
    
    //Gson de-serializes Json Objects to Mappings.
    private HashMap<String, String> response;
    private HashMap<String, Integer> redirect;
    
    /**
     * De-serializes a Question object from a Json String.
     * @param json: String
     * @return Question 
     */
    public static Question importFromJSON(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Question.class);
    }

    /**
     * De-serializes a Question object from a JsonObject.
     * @param json: JsonObject
     * @return Question
     */
    public static Question importFromJSON(JsonObject json){
        Gson gson = new Gson();
        return gson.fromJson(json, Question.class);
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
