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
 *
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

    public ArticleList(ArrayList<Article> articleList) {
        this.articleList = articleList;
    }
    
    public ArticleList(){
        this.articleList = new ArrayList();
    }
    
    public ArticleList loadArticles(){
        //load articles and insert them into articleList.
        File folder = new File("articles/");
        File[] files = folder.listFiles();
        for(File file : files){
            if(file.isFile()){
                try {
                    this.articleList.add(new Article(Integer.parseInt(file.getName().substring(0,file.getName().indexOf(".html")))
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
