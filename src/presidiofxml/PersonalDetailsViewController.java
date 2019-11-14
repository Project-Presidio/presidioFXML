/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidiofxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author abp5300
 */
public class PersonalDetailsViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML private Label label;
    @FXML private PasswordField passField;
    @FXML private TextField textField;
    @FXML private TextArea disability;
    @FXML private DatePicker date;
    @FXML private RadioButton yes;
    @FXML private RadioButton no;
    //@FXML private Button continue;
    @FXML private RadioButton male;
    @FXML private RadioButton female;
    
    private void onButtonClicked() {
        
    }
    private void handleButtonAction(ActionEvent event) {
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
