/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author jxw5883
 */
public class Article {
    private int id;
    private final String title;
    private final String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
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
     * Returns the title of the Article
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
