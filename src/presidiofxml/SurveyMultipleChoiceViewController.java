/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidiofxml;

import Model.Article;
import Model.ArticleList;
import Model.QuestionList;
import Model.Question;
import com.jfoenix.controls.JFXRadioButton;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jxw5883
 */
public class SurveyMultipleChoiceViewController implements Initializable {
    
    @FXML
    private JFXRadioButton option1;
    @FXML
    private JFXRadioButton option2;
    @FXML
    private JFXRadioButton option3;
    @FXML
    private JFXRadioButton option4;
    @FXML
    private JFXRadioButton option5;
    @FXML
    private JFXRadioButton option6;
    
    private JFXRadioButton[] radioButtons;
    @FXML
    private Label questionNumberLabel;
    @FXML
    private Label questionLabel;
    @FXML
    private Label alertLabel;
    
    private QuestionList questionList;
    
    private Question currentQuestion;
    
    private int questionNumber = 1;
    
    private static final String QUESTION_FILE_LOCATION = "question.json";
    
    /**
     * Generates the questionList and updates the View to reflect that.
     */
    public void setup(){
        readQuestionFile();
        updateView();
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.radioButtons = new JFXRadioButton[6]; 
        radioButtons[0] = option1;
        radioButtons[1] = option2;
        radioButtons[2] = option3;
        radioButtons[3] = option4;
        radioButtons[4] = option5;
        radioButtons[5] = option6;
        
        for(JFXRadioButton r: radioButtons){
            r.selectedColorProperty().set(Color.web("#ef5350"));
        }
        //readQuestionFile();
        //updateView();
    }    
    
    /**
     * Disable other RadioButtons when one is selected.
     * @param event
     */
    @FXML
    private void selectItem(ActionEvent event){
        for (RadioButton radioButton : radioButtons) {
            radioButton.setSelected(false);
        }
        ((RadioButton) event.getSource()).setSelected(true);
    }
    
    /**
     * Moves onto the next question by determining which answer was selected and switching to question it redirects to.
     * As specified in the JSON, if the answer redirect is a negative number, it an ArticleView.
     * @param event 
     */
    @FXML
    private void moveOntoNextQuestion(ActionEvent event) throws IOException, InterruptedException{
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
            case 6: this.alertLabel.setVisible(true); return;
            default: System.err.println("An invalid question redirect was selected! The question selected was: " + selected);
        }
        
        if(nextQuestionNum >= 0){
            setCurrentQuestion(this.questionList.getQuestion(nextQuestionNum));
            Stage existingStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SurveyMultipleChoiceView.fxml"));
            Parent root = fxmlLoader.load();
            SurveyMultipleChoiceViewController controller = fxmlLoader.getController();
            
            controller.setQuestionList(questionList);
            controller.setCurrentQuestion(currentQuestion);
            controller.setQuestionNumber(questionNumber+1);
            controller.updateView();
            
            Scene scene = new Scene(root);
            existingStage.setScene(scene);
            existingStage.show();
        }
        //Tries to find an article to use, returns if it can't find one. 
        else{
            //Optimization potential: figure out another way to load the article list and search for a specific article.
            ArticleList articleList = new ArticleList().loadArticles();
            Article result = null;
            for(Article a: articleList.getArticleList()){
                if(a.getId() == nextQuestionNum){
                    result = a;
                    break;
                }
            }
            if(result == null){
                System.err.println("Article doesn't exist!");
                return;
            }
            
            Stage existingStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ArticleDetailsView.fxml"));
            Parent root = fxmlLoader.load();
            ArticleDetailsViewController controller = fxmlLoader.getController();
            controller.setArticle(result);
            Scene scene = new Scene(root);
            existingStage.setScene(scene);
            existingStage.show();
            return;
        }
        
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
            
            this.setQuestionList(QuestionList.importJSON(file));
            setCurrentQuestion((Question) this.questionList.getQuestionList().get("0"));
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
                option1.setText(this.currentQuestion.getResponse().get("a"));
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

    /**
     * @param currentQuestion the currentQuestion to set
     */
    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    /**
     * @param questionNumber the questionNumber to set
     */
    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    /**
     * @param questionList the questionList to set
     */
    public void setQuestionList(QuestionList questionList) {
        this.questionList = questionList;
    }
}
