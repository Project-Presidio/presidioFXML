/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidiofxml;

import Model.Article;
import Model.ArticleList;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jxw5883
 */
public class ArticleMenuViewController implements Initializable {
    
   // @FXML 
    //private TextField searchField;
    
    @FXML
    private ListView<String> listView;
    
    @FXML 
    private Button selectButton;
    
    @FXML
    private Label alertLabel;
    
    private final ArrayList<Article> articleList = new ArticleList().loadArticles().getArticleList();
    
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
        //articleList.add(new Article(-1, "Content")); //should be replaced with a method to obtain articles
        this.alertLabel.setVisible(false);
        
        articleList.forEach((a) -> {
            listItems.add(a.toString());
        });
        
        listView.setItems(listItems);
    }
    
    /**
     * Searches for articles based on the content in searchField.
     */
    /*
    @FXML
    private void search(){
        String searchWord = searchField.getText();
        for(String title: listItems){
            if(title.equals(searchWord)){
                //limit the items in listItems
            }
        }
    }
    */
    /**
     * Returns to the MenuUI, the previous window.
     * @param event
     * @throws IOException 
     */
    @FXML
    private void back(ActionEvent event) throws IOException{
        Stage existingStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuUI.fxml"));
        //Retrieve the existing controller using the singleton pattern.
        MenuUIController controller = MenuUIController.getInstance();
        fxmlLoader.setController(controller);
        
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        existingStage.setScene(scene);
        existingStage.show();
    }
    
    /**
     * Obtains the selected item in the ItemList, creates an ArticleDetailsView, passes an article to it, and switches to it.
     * @param event 
     * @throws java.io.IOException 
     */
    @FXML
    private void selectItem(ActionEvent event) throws IOException, InterruptedException{
        String selectedItem = this.listView.getSelectionModel().getSelectedItem();
        Article article = null;
        for(Article a: this.articleList){
            if(a.getTitle().equals(selectedItem)){
                article = a;
            }
        }
        if(article == null) {
            System.err.println("Please select an article!");
            this.alertLabel.setVisible(true);
            return;
        }
        Stage existingStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ArticleDetailsView.fxml"));
        Parent root = fxmlLoader.load();
        
        ArticleDetailsViewController controller = fxmlLoader.<ArticleDetailsViewController>getController();
        controller.setArticle(article);
        
        Scene scene = new Scene(root);
        existingStage.setScene(scene);
        existingStage.show();
    }
    
}
