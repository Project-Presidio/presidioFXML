/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidiofxml;

import Model.CoordinateLocation;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jxw5883
 */
public class LocationInputViewController implements Initializable {
    
    @FXML 
    private TextField searchField;
    
    @FXML
    private WebView mapView;
    
    @FXML
    private Label alertLabel;

    private CoordinateLocation resultingLocation;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //generateWebView("16802");
        
        String locationQuery = "16802";
        if(locationQuery.length() > 0){
            resultingLocation = connectToLocationAPI(locationQuery);
            System.out.println(resultingLocation.getLocation());
            generateWebView(locationQuery);
        }
    }
    
    /**
     * Runs the API coordinate getter and updates the mapView
     */
    @FXML
    private void search(){
        String locationQuery = searchField.getText();
        if(locationQuery != null){
            if (locationQuery.length() > 0) {
                resultingLocation = connectToLocationAPI(locationQuery);
                System.out.println(resultingLocation.getLocation());
                generateWebView(locationQuery);
            } 
            else{
                alertLabel.setText("Please enter a valid location!");
                alertLabel.setVisible(true);
            }
        }
    }
    
    /**
     * Creates the web view using a Google Maps embed.
     * @param query 
     */
    private void generateWebView(String query){
        try {
            //https://www.google.com/maps/embed?origin=mfe&pb=location
            //String host = "https://www.google.com/maps/embed?origin=mfe&pb=";
            String charset = "UTF-8";
            WebEngine webEngine = mapView.getEngine();
            String request = String.format("<div class=\"mapouter\"><div class=\"gmap_canvas\"><iframe width=\"305\" height=\"400\" id=\"gmap_canvas\" src=\"https://maps.google.com/maps?q=%25s&t=&z=13&ie=UTF8&iwloc=&output=embed\" frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\"></iframe><a href=\"https://www.whatismyip-address.com\"></a></div><style>.mapouter{position:relative;text-align:right;height:400px;width:305px;}.gmap_canvas {overflow:hidden;background:none!important;height:400px;width:305px;}</style></div>",
                    URLEncoder.encode(query, charset));
            
            webEngine.loadContent(request, "text/html");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(LocationInputViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Uses the nominatim API open geocoding service to generate a Location
     * @param locationQuery 
     */
    private CoordinateLocation connectToLocationAPI(String locationQuery){
        //https://nominatim.openstreetmap.org/search.php?q=Penn+State+University&format=json
        String host = "https://nominatim.openstreetmap.org/search.php?";
        String charset = "UTF-8";
        String ending = "&format=json";
        
        StringBuilder coords = new StringBuilder();
        try {
            String query = String.format("q=%s", URLEncoder.encode(locationQuery, charset));
            URL url = new URL(host + query + ending);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            
            int status = con.getResponseCode();
            
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    coords.append(inputLine);
                }
            }
            con.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(LocationInputViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Grab the nested Json elements
        JsonParser parser = new JsonParser();
        JsonElement response = parser.parse(coords.toString());
        System.out.println("API Response: " + response);
        String lat = null;
        String lon = null;
        try{
            lat = response.getAsJsonArray().get(0).getAsJsonObject().get("lat").getAsString();
            lon = response.getAsJsonArray().get(0).getAsJsonObject().get("lon").getAsString();
        }
        catch(IndexOutOfBoundsException e){
            alertLabel.setText("Location not found!");
            alertLabel.setVisible(true);
            return this.resultingLocation;
        }
        CoordinateLocation result = new CoordinateLocation();
        result.updateLocation(lat, lon);
        
        return result;
    }
    
    /**
     * Creates a PersonalDetailsView and passes it the resulting location.
     * @param event
     * @throws IOException 
     */
    @FXML
    private void submit(ActionEvent event) throws IOException{
        Stage existingStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PersonalDetailsView.fxml"));
        PersonalDetailsViewController controller = PersonalDetailsViewController.getInstance();
        controller.setCivilianLocation(resultingLocation);
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        existingStage.setScene(scene);
        existingStage.show();
    }
    
}
