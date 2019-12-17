/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * This model class contains the structure of an Article.
 * @author jxw5883
 */
public class Article {
    private final int id;
    private final String title;
    private final String content;

    /**
     * Initializes an Article with an id and its content, and runs extractTitle() to obtain a title.
     * @param id
     * @param content 
     */
    public Article(int id, String content) {
        this.id = id;
        this.content = content;
        this.title = extractTitle();
    }
    
    /**
     * Extract the title of the article by parsing the HTML for h1 tags.
     * @return 
     */
    private String extractTitle(){
        Document doc = Jsoup.parse(content);
        Elements h1 = doc.select("h1");
        return h1.text();
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }
    
    /**
     * Returns the title of the Article.
     * @return the title
     */
    @Override
    public String toString(){
        return this.getTitle();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
}
