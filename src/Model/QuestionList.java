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
 * This model class contains the definition of a QuestionList based off a JSON format.
 * The following is the JSON format this class is based on.
 * {
 *  "0": {
 *    "id": 0,
 *    "title": "What best describes your current situation?",
 *    "response": {
 *      "a": "Seismic",
 *      "b": "Flood",
 *      "c": "Inclement Weather",
 *     "d": "Emergency"
 *    },
 *    
 *    "redirect":{
 *      "a": 1,
 *      "b": 1,
 *      "c": 1,
 *      "d": 1
 *    }
 *  },
 *  "1": {
 *    "id": 1,
 *    "title": "Is this a true false question?",
 *    "response": {
 *      "a": "Yes",
 *      "b": "No"
 *    },
 *   
 *    "redirect":{
 *      "a": -1,
 *      "b": -2
 *    }
 *  }
 *}
 * @author jxw5883
 */
public class QuestionList {
    
    private final HashMap<String, Question> questionList;

    /**
     * Initializes a QuestionList with an existing one.
     * @param questionList 
     */
    public QuestionList(HashMap<String,Question> questionList){
        this.questionList = questionList;
    }
    
    /**
     * @return the questionList
     */
    public HashMap<String, Question> getQuestionList() {
        return questionList;
    }
    
    /**
     * De-serializes a QuestionList from Json. 
     * This function manually extracts Questions objects from the JSON.
     * @param rawJson
     * @return QuestionList
     */
    public static QuestionList importJSON(String rawJson){
        JsonObject json = (JsonObject) JsonParser.parseString(rawJson);
        
        HashMap<String, Question> questionList = new HashMap();
        
        json.keySet().forEach((key) -> {
            JsonObject individualQuestion = json.get(key).getAsJsonObject();
            Question question = Question.importFromJSON(individualQuestion);
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
    
    /**
     * Returns a question from the questionList based on the Question number.
     * @param questionId
     * @return 
     */
    public Question getQuestion(int questionId){
        return this.questionList.get(Integer.toString(questionId));
    }
}
