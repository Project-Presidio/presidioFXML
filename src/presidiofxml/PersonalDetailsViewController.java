/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidiofxml;

import Model.Civilian;
import Model.CoordinateLocation;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.paint.Color;
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
    private Text coordinateText;
    @FXML
    private Text alert;
    @FXML
    private JFXTextField textField;
    @FXML
    private JFXTextArea disability;
    @FXML
    private DatePicker date;
    @FXML
    private JFXRadioButton yes;
    @FXML
    private JFXRadioButton no;
    @FXML
    private JFXRadioButton male;
    @FXML
    private JFXRadioButton female;
    
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
    public void load() {
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
    
    /**
     * Runs a series of checks on the input to verify the user has inputted all requested values and moves onto the next page if they have.
     * @param event
     * @throws IOException 
     */
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
                        
                        if(no.isSelected()){
                            disability.setText("");
                        }
                        
                        civilian = new Civilian(textField.getText(), date.getValue(), female.isSelected(), 0,0, disability.getText(), civilianLocation); //female is 1 boolean
                        Stage existingStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuUI.fxml"));
                        
                        MenuUIController controller = MenuUIController.getInstance();
                        controller.setCivilian(civilian); //pass the civilian
                        fxmlLoader.setController(controller);
                        
                        Parent root = fxmlLoader.load();
                        Scene scene = new Scene(root);
                        existingStage.setScene(scene);
                        existingStage.show();
                    }
                }
            }
        }
    }
    /**
     * Disables the other corresponding RadioButton and enables the disability prompt. 
     * @param event 
     */
    @FXML
    private void onYes(ActionEvent event) {
        disability.setVisible(true);
        if(no.isSelected()){
            no.setSelected(false);
        }
    }
    /**
     * Disables the other corresponding RadioButton and disables the disability prompt.
     * @param event 
     */
    @FXML
    private void onNo(ActionEvent event){
        if(yes.isSelected()){
            yes.setSelected(false);
            disability.setVisible(false);
        }
    }
    
    /**
     * Disable the other corresponding RadioButton.
     * @param event 
     */
    @FXML
    private void onMale(ActionEvent event){
        if(female.isSelected()){
            female.setSelected(false);
        }
    }
    
    /**
     * Disable the other corresponding RadioButton.
     * @param event 
     */
    @FXML
    private void onFemale(ActionEvent event){
        if(male.isSelected()){
            male.setSelected(false);
        }
    }
   
    /**
     * Set the coordinate Text object, and update the selectedColorProperty() of the radioButtons.
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(civilian != null)
            load();
        this.coordinateText.setText(this.civilianLocation.getCoordinatesAsDMS());
        
        this.no.selectedColorProperty().set(Color.web("#ef5350")); //Red color
        this.yes.selectedColorProperty().set(Color.web("#ef5350"));
        this.male.selectedColorProperty().set(Color.web("#ef5350"));
        this.female.selectedColorProperty().set(Color.web("#ef5350"));
    }

    /**
     * @param civilianLocation the civilianLocation to set
     */
    public void setCivilianLocation(CoordinateLocation civilianLocation) {
        this.civilianLocation = civilianLocation;
    }

    /**
     * Resets all details by setting civilian to null and loading the LocationInputView.
     * @param event
     * @throws IOException 
     */
    @FXML
    private void reset(ActionEvent event) throws IOException{
        this.civilian = null;
        Stage existingStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LocationInputView.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        existingStage.setScene(scene);
        existingStage.show();
    }
    
    

}
