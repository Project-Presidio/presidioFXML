/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidiofxml;

import Model.Civilian;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abp5300
 */
public class PersonalDetailsViewController implements Initializable {
    
    /**
     * Initializes the controller class.
     */
    @FXML
    private Label label;
    //  @FXML private PasswordField passField;
    @FXML
    private TextField textField;
    @FXML
    private TextArea disability;
    @FXML
    private DatePicker date;
    @FXML
    private RadioButton yes;
    @FXML
    private RadioButton no;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
    
    private Civilian civilian;
    
    public PersonalDetailsViewController(){
        
    }

    public PersonalDetailsViewController(Civilian c) {
         this.civilian=c;
    }
      
    @FXML
    private void onSubmit(ActionEvent event) throws IOException {
        String name = textField.getText();
        if (name == null) {
            System.out.println("No Name inputted");
        } else {
            LocalDate userDate = date.getValue();
            if (userDate == null) {
                System.out.println("No date was inputted");
            } else {
                if ((!male.isSelected()) && (!female.isSelected())) {
                    System.out.println("No gender was selected");
                } else if ((male.isSelected()) && (female.isSelected())) {
                    System.out.println("Please only select the 'male' or 'female' option");
                } else {
                    if ((!yes.isSelected()) && (!no.isSelected())) {
                        System.out.println("Please answer the disability prompt");
                    } else if ((yes.isSelected()) && (no.isSelected())) {
                        System.out.println("Please only select one disability option");
                    } else {
                        System.out.println("all prompts answered");
                        civilian = new Civilian(textField.getText(), date.getValue(), female.isSelected(), 0,0, disability.getText()); //female is 1 boolean
                        Stage existingStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserDetailsView.fxml"));
                        Parent root = fxmlLoader.load();
                        UserDetailsViewController controller = fxmlLoader.<UserDetailsViewController>getController();
                        System.out.println(controller);
                        controller.setCivilian(civilian);
                        Scene scene = new Scene(root);
                        existingStage.setScene(scene);
                        existingStage.show();
                    }
                }
            }
        }
    }
    @FXML
    private void onYes(ActionEvent event) {
        disability.setOpacity(1);
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        // TODO
    }

}
