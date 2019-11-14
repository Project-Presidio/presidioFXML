package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Guide {

    private int typeOfGuide;
    private String content;

    /**
     * @return the typeOfGuide
     */
    public int getTypeOfGuide() {
        return typeOfGuide;
    }

    /**
     * @param typeOfGuide the typeOfGuide to set
     */
    public void setTypeOfGuide(int typeOfGuide) {
        this.typeOfGuide = typeOfGuide;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    public Guide(int typeOfGuide, String content) {
        this.typeOfGuide = typeOfGuide;
        this.content = content;
    }

    public void findGuides() {
        File folder = new File("/Users/malavikakamathur/Desktop/");
        File[] listOfFiles = folder.listFiles();

        for (File listOfFile : listOfFiles) {
            if (listOfFile.toString().substring(listOfFile.toString().length() - 4).equals(".txt")) {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(listOfFile));
                    String st;
                    try {
                        while ((st = br.readLine()) != null) {
                            content += st;

                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Guide.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }catch (FileNotFoundException ex) {
                    Logger.getLogger(Guide.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        }

    }

}
