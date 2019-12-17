/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidiofxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main class. This is the starting point of the app.
 * The github repo for this project can be found at: https://github.com/Project-Presidio/presidioFXML
 * @author jxw5883
 */
public class PresidioFXML extends Application {
    
    /**
     * Creates an instance of the LocationInputView and passes control to it.
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("PersonalDetailsView.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("LocationInputView.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("SurveyMultipleChoiceView.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
