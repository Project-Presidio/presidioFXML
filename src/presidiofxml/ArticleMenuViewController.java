/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidiofxml;

import Model.Article;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author jxw5883
 */
public class ArticleMenuViewController implements Initializable {
    
    @FXML 
    private TextField searchField;
    
    @FXML
    private ListView<String> listView;
    
    @FXML 
    private Button selectButton;
    
    private final ArrayList<Article> articleList = new ArrayList();
    
    ObservableList<String> listItems = FXCollections.observableArrayList();
    

    public ArticleMenuViewController(){
        
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        articleList.add(new Article("Title","Content")); //should be replaced with a method to obtain articles
        
        
        articleList.forEach((a) -> {
            listItems.add(a.toString());
        });
        
        listView.setItems(listItems);
    }
    
    /**
     * Searches for articles based on the content in searchField.
     */
    @FXML
    public void search(){
        String searchWord = searchField.getText();
//        for(Article a: listItems){
//            if(a.getTitle().equals(searchWord)){
//                //limit the items in listItems
//            }
//        }
    }
    
    @FXML
    public void selectItem(ActionEvent event){
        
    }
    
}
