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
 * FXML Controller class
 *
 * @author jxw5883
 */
public class MenuUIController implements Initializable {
    
    private Civilian civilian;
    
    @FXML
    private void goToAlertView(){
        System.out.println("Hit Alert Button.");
    }
    
    @FXML
    private void goToArticlesView(){
        System.out.println("Hit Articles View Button.");
    }
    
    @FXML
    private void goToSurveyView(){
        System.out.println("Hit Surview View Button.");
    }
    
    @FXML
    private void goToUserDetailsView(ActionEvent event) throws IOException{
        System.out.println("Hit User Details View Button.");
        Stage existingStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserDetailsView.fxml"));
        Parent root = fxmlLoader.load();
        UserDetailsViewController controller = fxmlLoader.<UserDetailsViewController>getController();
        controller.setCivilian(civilian);
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
        // TODO
    }    

    /**
     * @param civilian the civilian to set
     */
    public void setCivilian(Civilian civilian) {
        this.civilian = civilian;
    }
    
}
