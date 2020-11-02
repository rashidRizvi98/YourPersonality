package com.example.quizfrag;

public class Question {
    private int ID;
    private String QUESTION;


    public Question()
    {
        ID=0;
        QUESTION="";
    }


    public Question(String QUESTION) {

        this.QUESTION = QUESTION;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getQUESTION() {
        return QUESTION;
    }

    public void setQUESTION(String QUESTION) {
        this.QUESTION = QUESTION;
    }



}
