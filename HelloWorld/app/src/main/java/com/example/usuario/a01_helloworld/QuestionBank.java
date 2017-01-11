package com.example.usuario.a01_helloworld;

import android.content.Context;

import java.util.LinkedList;
import java.util.List;

public class QuestionBank {

    private List<Question> questions;
    private int index = 0;

    public QuestionBank(Context context) {

        //  Pedir memoria oara la lista (construirla)

        questions = new LinkedList<>();

        //  Rellenarla con algunos datos

        Question q1 = new Question();
        q1.setText(context.getString(R.string.q1text));
        q1.setAnswer(false);

        Question q2 = new Question();
        q2.setText(context.getString(R.string.q2text));
        q2.setAnswer(true);

        Question q3 = new Question(context.getString(R.string.q3text), true);

        Question q4 = new Question(context.getString(R.string.q4text), true);

        Question q5 = new Question(context.getString(R.string.q5text), true);

        //  Añadimos las preguntas a la lista

        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        questions.add(q4);
        questions.add(q5);
    }

    public Question nextQuestion(){
        Question q = this.questions.get(index);
        index = index + 1;
        if ( index == this.questions.size()){
            index = 0;
        }
        return q;
    }

    public int getIndex(Question currentQuestion){
        int indexOfQuestion = this.questions.indexOf(currentQuestion);
        return indexOfQuestion + 1;
    }

}
