/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This model class encapsulates a list of Articles. 
 * @author jxw5883
 */
public class ArticleList {
    private final ArrayList<Article> articleList;

    /**
     * @return the articleList
     */
    public ArrayList<Article> getArticleList() {
        return articleList;
    }

    /**
     * Initializes an ArticleList with a premade article.
     * @param articleList 
     */
    public ArticleList(ArrayList<Article> articleList) {
        this.articleList = articleList;
    }
    
    public ArticleList(){
        this.articleList = new ArrayList();
    }
    
    /**
     * Loads articles from HTML files located in the articles folder on the root directory. 
     * The id of the article is determined by its corresponding filename. 
     * @return ArticleList
     */
    public ArticleList loadArticles(){
        //load articles and insert them into articleList.
        File folder = new File("articles/");
        File[] files = folder.listFiles();
        //Iterate over all files in the directory. 
        for(File file : files){
            if(file.isFile()){
                try {
                    this.articleList.add(new Article(Integer.parseInt(file.getName().substring(0,file.getName().indexOf(".html"))) //sets the id to name of the file without its extension
                            , new String(Files.readAllBytes(Paths.get(file.getPath())))));
                } catch (IOException ex) {
                    Logger.getLogger(ArticleList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //this.articleList.add(new Article(-1, "Title1", "<body>Content1</body>"));
        return this;
    }
}
