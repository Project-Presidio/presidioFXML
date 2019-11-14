package Model;

import java.util.ArrayList;

public class Question {
    
    private String questionType;
    private String question;
    private ArrayList promptList;
    
    public Question(String questionTypes, String questions)
    {
        questionType = questionTypes;
        question = questions;
    }
    
    public ArrayList promptList()
    {
        getPromptList().add(getQuestionType() + getQuestion());
        return getPromptList();
    }

    /**
     * @return the questionType
     */
    public String getQuestionType() {
        return questionType;
    }

    /**
     * @param questionType the questionType to set
     */
    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return the promptList
     */
    public ArrayList getPromptList() {
        return promptList;
    }

    /**
     * @param promptList the promptList to set
     */
    public void setPromptList(ArrayList promptList) {
        this.promptList = promptList;
    }
    
}
