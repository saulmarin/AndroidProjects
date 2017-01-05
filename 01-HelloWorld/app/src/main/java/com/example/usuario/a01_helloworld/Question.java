package com.example.usuario.a01_helloworld;

/**
 * Created by usuario on 03/01/2017.
 */

public class Question {

    private String text;
    private boolean answer;

    public Question(String text, boolean answer) {
        this.text = text;
        this.answer = answer;
    }

    public Question() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrectAnswer() {
        return answer;
    }

    public void setAnswer(boolean correctAnswer) {
        this.answer = correctAnswer;
    }
}
