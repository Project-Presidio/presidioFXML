/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidiofxml;

import Model.Civilian;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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

    // private void onButtonClicked() {
    //}
    @FXML
    private void onSubmit(ActionEvent event) {
        String name = textField.getText();
        if (name == null) {
            System.out.println("No Name inputted");
        } else {
            //Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            //Date date = Date.from(instant);
            //System.out.println(localDate + "\n" + instant + "\n" + date);
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
                        civilian = new Civilian(textField.getText(), new Date(date.getValue().toEpochDay()), female.isSelected(), 0,0, disability.getText());
                        
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