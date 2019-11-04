/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidiofxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author jxw5883
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private Label label;
    @FXML private PasswordField passField;
    @FXML private TextField textField;
    private UserList userList;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        String userName = textField.getText();
        String pass = passField.getText();
        boolean result = false;
        //iterate through the userlist and look for the user
        for(User u: userList.getUserList()){
            if(u.getUsername().equals(userName)){
                result = u.authenticate(pass);
                break; //break when it finds the user
            }
        }
        
        if(result){
            label.setText("Login Success!");
            setupMenuUI();
        }
        label.setText("Login Failed!");
    }
    
    /*
     * Creates the new scene and stage for the menuUI.
     */
    private void setupMenuUI(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MenuUI.fxml"));
            Scene scene = new Scene(root);
            
            Stage stage = new Stage();
            stage.setTitle("MenuUI");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) { 
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userList = new UserList();
        userList.generateUserList();
        System.out.println("finished");
    }    
    
}
