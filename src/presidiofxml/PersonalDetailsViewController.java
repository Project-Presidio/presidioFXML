/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidiofxml;

import Model.Civilian;
import Model.CoordinateLocation;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
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
import javafx.scene.text.Text;
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
    private Text alert;
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
    private CoordinateLocation civilianLocation;
    
    private static final PersonalDetailsViewController INSTANCE = new PersonalDetailsViewController();
    
    public static PersonalDetailsViewController getInstance(){
        return INSTANCE;
    }

    /**
     * Loads a Civilian to be edited
     * @param civilian the civilian to set
     */
    public void load(Civilian civilian) {
        this.civilian = civilian;
        textField.setText(civilian.getFullname());
        date.setValue(civilian.getBirthday());
        if(civilian.isSex())
            female.fire();
        else
            male.fire();
        if(civilian.getPreexistingDisability().equals(""))
            no.fire();
        else {
            yes.fire();
            disability.setText(civilian.getPreexistingDisability());
        }
    }
      
    @FXML
    private void onSubmit(ActionEvent event) throws IOException {
        String name = textField.getText();
        if (name == null) {
            alert.setText("No Name inputted");
        } else {
            LocalDate userDate = date.getValue();
            if (userDate == null) {
                alert.setText("No date was inputted");
            } else {
                if ((!male.isSelected()) && (!female.isSelected())) {
                    alert.setText("No gender was selected");
                } else if ((male.isSelected()) && (female.isSelected())) {
                    alert.setText("Please only select the 'male' or 'female' option");
                } else {
                    if ((!yes.isSelected()) && (!no.isSelected())) {
                        alert.setText("Please answer the disability prompt");
                    } else if ((yes.isSelected()) && (no.isSelected())) {
                        alert.setText("Please only select one disability option");
                    } else {
                        System.out.println("all prompts answered");
                        
                        if(no.isSelected()){
                            disability.setText("");
                        }
                        
                        civilian = new Civilian(textField.getText(), date.getValue(), female.isSelected(), 0,0, disability.getText(), civilianLocation); //female is 1 boolean
                        Stage existingStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuUI.fxml"));
                        Parent root = fxmlLoader.load();
                        MenuUIController controller = fxmlLoader.<MenuUIController>getController();
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
        if(no.isSelected()){
            no.setSelected(false);
        }
    }
    @FXML
    private void onNo(ActionEvent event){
        if(yes.isSelected()){
            yes.setSelected(false);
            disability.setOpacity(0);
        }
    }
    
    @FXML
    private void onMale(ActionEvent event){
        if(female.isSelected()){
            female.setSelected(false);
        }
    }
    
    @FXML
    private void onFemale(ActionEvent event){
        if(male.isSelected()){
            male.setSelected(false);
        }
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        // TODO
    }

    /**
     * @param civilianLocation the civilianLocation to set
     */
    public void setCivilianLocation(CoordinateLocation civilianLocation) {
        this.civilianLocation = civilianLocation;
    }

    
    

}
