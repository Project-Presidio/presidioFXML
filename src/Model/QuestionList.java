/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;

/**
 *
 * @author jxw5883
 */
public class QuestionList {
    //Json Format
    /*
{
  "0": {
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
      "b": 1,
      "c": 1,
      "d": 1
    }
  },
  "1": {
    "id": 1,
    "title": "Is this a true false question?",
    "response": {
      "a": "Yes",
      "b": "No"
    },
    
    "redirect":{
      "a": -1,
      "b": -2
    }
  }
}
    */
    
    
    private final HashMap<String, Question_> questionList;

    public QuestionList(HashMap<String,Question_> questionList){
        this.questionList = questionList;
    }
    
    /**
     * @return the questionList
     */
    public HashMap<String, Question_> getQuestionList() {
        return questionList;
    }
    
    /**
     * De-serializes a QuestionList from Json. 
     * @param rawJson
     * @return QuestionList
     */
    public static QuestionList importJSON(String rawJson){
        JsonObject json = (JsonObject) JsonParser.parseString(rawJson);
        
        HashMap<String, Question_> questionList = new HashMap();
        
        json.keySet().forEach((key) -> {
            JsonObject individualQuestion = json.get(key).getAsJsonObject();
            Question_ question = Question_.importFromJSON(individualQuestion);
            questionList.put(key, question);
        });
        
        QuestionList result = new QuestionList(questionList);
        return result;
    }
    
    /**
     * Prints out the QuestionList in a Json format.
     * @return Json String 
     */
    @Override
    public String toString(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
    
}
