/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidiofxml;

import Model.Article;
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
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jxw5883
 */
public class ArticleDetailsViewController implements Initializable {
    
    @FXML 
    private WebView webView;
    @FXML
    private Label titleLabel;
    
    private Article article;
    private WebEngine webEngine;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * @param article the article to set
     */
    public void setArticle(Article article) {
        this.article = article;
        this.titleLabel.setText(article.getTitle());
        webEngine = webView.getEngine();
        webEngine.loadContent(article.getContent(), "text/html");
    }
    
    @FXML
    private void back(ActionEvent event) throws IOException{
        Stage existingStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ArticleMenuView.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        existingStage.setScene(scene);
        existingStage.show();
    }
}
