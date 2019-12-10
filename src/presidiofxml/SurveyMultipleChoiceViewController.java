/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidiofxml;

import Model.QuestionList;
import Model.Question;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

/**
 * FXML Controller class
 *
 * @author jxw5883
 */
public class SurveyMultipleChoiceViewController implements Initializable {
    
    @FXML
    private RadioButton option1;
    @FXML
    private RadioButton option2;
    @FXML
    private RadioButton option3;
    @FXML
    private RadioButton option4;
    @FXML
    private RadioButton option5;
    @FXML
    private RadioButton option6;
    private RadioButton[] radioButtons;
    @FXML
    private Label questionNumberLabel;
    @FXML
    private Label questionLabel;
    
    private QuestionList questionList;
    
    private Question currentQuestion;
    
    private int questionNumber = 1;
    
    private static final String QUESTION_FILE_LOCATION = "question.json";
    
    @FXML
    public void submit(){
        //move onto the next question
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.radioButtons = new RadioButton[6]; 
        radioButtons[0] = option1;
        radioButtons[1] = option2;
        radioButtons[2] = option3;
        radioButtons[3] = option4;
        radioButtons[4] = option5;
        radioButtons[5] = option6;
        readQuestionFile();
        updateView();
    }    
    
    /**
     * Disable other RadioButtons when one is selected.
     * @param event
     */
    @FXML
    public void selectItem(ActionEvent event){
        for (RadioButton radioButton : radioButtons) {
            radioButton.setSelected(false);
        }
        ((RadioButton) event.getSource()).setSelected(true);
    }
    
    @FXML
    private void moveOntoNextQuestion(){
        int selected;
        for(selected = 0; selected<radioButtons.length; selected++){
            if(radioButtons[selected].isSelected())
                break;
        }
        
        int nextQuestionNum = 0;
        switch(selected){
            case 0: nextQuestionNum = currentQuestion.getRedirect().get("a"); break;
            case 1: nextQuestionNum = currentQuestion.getRedirect().get("b"); break;
            case 2: nextQuestionNum = currentQuestion.getRedirect().get("c"); break;
            case 3: nextQuestionNum = currentQuestion.getRedirect().get("d"); break;
            case 4: nextQuestionNum = currentQuestion.getRedirect().get("e"); break;
            case 5: nextQuestionNum = currentQuestion.getRedirect().get("f"); break;
            default: System.err.println("An invalid question redirect was selected!");
        }
        System.out.println(nextQuestionNum);
        if(nextQuestionNum >= 0)
            currentQuestion = this.questionList.getQuestion(nextQuestionNum);
        else
            return;
        
        this.questionNumber++;
        updateView();
        
    }
    
    /**
     * Opens a Json file containing a serialized QuestionList and loads it into questionList.
     */
    private void readQuestionFile(){
        String file = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(QUESTION_FILE_LOCATION));
            String st;
            while((st = br.readLine()) != null){
                file += st;
            }
            
            this.questionList = QuestionList.importJSON(file);
            currentQuestion = (Question) this.questionList.getQuestionList().get("0");
        } catch (IOException ex) {
            Logger.getLogger(SurveyMultipleChoiceViewController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    /**
     * Sets up the view with proper content by updating the title, question number, and question responses.
     */
    private void updateView(){
        this.questionLabel.setText(currentQuestion.getTitle());
        this.questionNumberLabel.setText("Question " + questionNumber);
        switch(this.currentQuestion.getResponse().size()){
            case 2: 
                option1.setText(this.currentQuestion.getResponse().get("a"));
                option2.setText(this.currentQuestion.getResponse().get("b"));
                option3.setVisible(false); 
                option4.setVisible(false); 
                option5.setVisible(false); 
                option6.setVisible(false); 
                break;
            case 3: 
                option1.setText(this.currentQuestion.getResponse().get("1"));
                option2.setText(this.currentQuestion.getResponse().get("b"));
                option3.setText(this.currentQuestion.getResponse().get("c"));
                option4.setVisible(false); 
                option5.setVisible(false); 
                option6.setVisible(false); 
                break;
            case 4: 
                option1.setText(this.currentQuestion.getResponse().get("a"));
                option2.setText(this.currentQuestion.getResponse().get("b"));
                option3.setText(this.currentQuestion.getResponse().get("c"));
                option4.setText(this.currentQuestion.getResponse().get("d"));
                option5.setVisible(false); 
                option6.setVisible(false); 
                break;
            case 5: 
                option1.setText(this.currentQuestion.getResponse().get("a"));
                option2.setText(this.currentQuestion.getResponse().get("b"));
                option3.setText(this.currentQuestion.getResponse().get("c"));
                option4.setText(this.currentQuestion.getResponse().get("d"));
                option5.setText(this.currentQuestion.getResponse().get("e"));
                option6.setVisible(false); 
                break;
            case 6: 
                option1.setText(this.currentQuestion.getResponse().get("a"));
                option2.setText(this.currentQuestion.getResponse().get("b"));
                option3.setText(this.currentQuestion.getResponse().get("c"));
                option4.setText(this.currentQuestion.getResponse().get("d"));
                option5.setText(this.currentQuestion.getResponse().get("e"));
                option6.setText(this.currentQuestion.getResponse().get("f"));
                break;
            default: System.err.println("Invalid Question Response length!");
        }
        
    }
    
}
