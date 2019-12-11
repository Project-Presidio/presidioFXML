/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

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
    
    public ArticleList generateArticles(){
        //generate articles and insert them into articleList.
        return this;
    }
}
