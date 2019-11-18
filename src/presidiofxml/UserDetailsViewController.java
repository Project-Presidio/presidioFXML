/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidiofxml;

import Model.Civilian;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Austin
 */
public class UserDetailsViewController implements Initializable {
    
    private Civilian civilian;
    private Text userInfo;
    
    public UserDetailsViewController(Civilian civilian){
        this.civilian = civilian;
    }

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void readUser(ActionEvent event) {
        userInfo.setText(civilian.generateReport());
    }
    @FXML
    private void updateUser(ActionEvent event) {
        //old scene with civilian object passed
    }
    @FXML
    private void deleteUser(ActionEvent event) {
        civilian = null;
        //old scene civilian object passed
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
