package Model;

import java.util.ArrayList;

public class Survey {
    
    private String question;
    private String answer;
    private ArrayList answerList;
    
    
    public Survey(String questions, String answers)
    {
        
        question = questions;
        answer = answers;
        
    }
    
    public ArrayList answerList()
    {
        getAnswerList().add(getQuestion() + getAnswer());
        return getAnswerList();
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
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * @return the answerList
     */
    public ArrayList getAnswerList() {
        return answerList;
    }

    /**
     * @param answerList the answerList to set
     */
    public void setAnswerList(ArrayList answerList) {
        this.answerList = answerList;
    }
    
}
