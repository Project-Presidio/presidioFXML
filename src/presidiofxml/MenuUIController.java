/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidiofxml;

import Model.Civilian;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This controller class controls a user interface for a menu.
 * This allows a user to select between multiple use cases. 
 * @author jxw5883
 */
public class MenuUIController implements Initializable {
    
    private static final MenuUIController INSTANCE = new MenuUIController();
    
    private Civilian civilian;
    
    /**
     * Implements the Singleton Pattern.
     * @return MenuUIController
     */
    public static MenuUIController getInstance(){
        return INSTANCE;
    }
    
    /**
     * Switch to the AlertView (not yet implemented).
     */
    @FXML
    private void goToAlertView(){
        System.out.println("Hit Alert Button.");
        
    }
    
    /**
     * Switch to the ArticleMenuView.
     * @param event
     * @throws IOException 
     */
    @FXML
    private void goToArticlesView(ActionEvent event) throws IOException{
        Stage existingStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ArticleMenuView.fxml"));
        Parent root = fxmlLoader.load();
        //UserDetailsViewController controller = fxmlLoader.<UserDetailsViewController>getController();
        //controller.setCivilian(civilian);
        Scene scene = new Scene(root);
        existingStage.setScene(scene);
        existingStage.show();
    }
    
    /**
     * Switch to the SurveyMultipleChoiceView.
     * @param event
     * @throws IOException 
     */
    @FXML
    private void goToSurveyView(ActionEvent event) throws IOException{
        Stage existingStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SurveyMultipleChoiceView.fxml"));
        Parent root = fxmlLoader.load();
        SurveyMultipleChoiceViewController controller = fxmlLoader.getController();
        controller.setup();
        Scene scene = new Scene(root);
        existingStage.setScene(scene);
        existingStage.show();
    }

    /**
     * Switch to the PersonalDetailsViewController
     * @param event
     * @throws IOException 
     */
    @FXML
    private void updateUser(ActionEvent event) throws IOException {
        //old scene with civilian object passed
        Stage existingStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PersonalDetailsView.fxml"));
        PersonalDetailsViewController controller = PersonalDetailsViewController.getInstance(); //singleton pattern
        controller.load();
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        existingStage.setScene(scene);
        existingStage.show();
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    /**
     * @param civilian the civilian to set
     */
    public void setCivilian(Civilian civilian) {
        this.civilian = civilian;
    }
    
}
