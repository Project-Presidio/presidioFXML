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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Austin
 */
public class UserDetailsViewController implements Initializable {

    private Civilian civilian;
    @FXML
    private Text output;

    public UserDetailsViewController() {

    }

    public UserDetailsViewController(Civilian civilian) {
        this.civilian = civilian;
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    private void readUser(ActionEvent event) {
        // System.out.println(civilian.generateReport());
        output.setText(civilian.generateReport());
    }

    @FXML
    private void updateUser(ActionEvent event) throws IOException {
        //old scene with civilian object passed
        Stage existingStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        System.out.println("reached here");
        Parent root = FXMLLoader.load(getClass().getResource("PersonalDetailsView.fxml"));
        System.out.println("made it here");
        Scene scene = new Scene(root);
        existingStage.setScene(scene);
        existingStage.show();
    }

    @FXML
    private void deleteUser(ActionEvent event) throws IOException {
        civilian = null;
        Stage existingStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        System.out.println("reached here");
        Parent root = FXMLLoader.load(getClass().getResource("PersonalDetailsView.fxml"));
        System.out.println("made it here");
        Scene scene = new Scene(root);
        existingStage.setScene(scene);
        existingStage.show();
        //old scene civilian object passed
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
