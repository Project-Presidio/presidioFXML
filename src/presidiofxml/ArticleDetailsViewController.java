/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presidiofxml;

import Model.Article;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

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
    
    
}
