package com.example.usuario.a01_helloworld;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int corrects;
    int errors;
    TextView textViewCorrects;
    TextView textViewErrors;

    //Se declaran los botones de clase Button
    Button yesButton;
    Button noButton;

    //Se declaran los textview que vamos a modificar
    TextView questionNumber;
    TextView titleTextView;
    TextView questionTextView;
    ImageView imageView;

    QuestionBank questionBank;
    Question currentQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Para asignar el valor a los botones desde los ids del xml
        //Se utiliza R.id.(id del elemento)
        //Pulsar ALT+ENTER y "Cast to android.widget.button"

    //  SETUP DE LA PANTALLA //
        questionNumber = (TextView) findViewById(R.id.activity_main_question_number);
        imageView = (ImageView) findViewById(R.id.activity_main_image_view);
        titleTextView = (TextView) findViewById(R.id.activity_main_title_text);
        questionTextView = (TextView) findViewById(R.id.activity_main_question_text);
        yesButton = (Button) findViewById(R.id.activity_main_button_yes);
        noButton = (Button) findViewById(R.id.activity_main_button_no);
        textViewCorrects = (TextView) findViewById(R.id.activity_main_corrects);
        textViewErrors = (TextView) findViewById(R.id.activity_main_errors);

        questionBank = new QuestionBank(this);

    //  ESCOGER LA PRIMERA PREGUNTA //
        currentQuestion = questionBank.nextQuestion();
        questionNumber.setText(getString(R.string.question) + questionBank.getIndex(currentQuestion));
        questionTextView.setText(currentQuestion.getText());
        textViewCorrects.setText(getString(R.string.corrects) + corrects);
        textViewErrors.setText(getString(R.string.errors) + errors);


        //Se declaran las funciones que se ejecutarán al pulsar en los botones.
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( currentQuestion.isCorrectAnswer() == true){
                    titleTextView.setText(R.string.is_correct);
                    titleTextView.setTextColor(Color.GREEN);
                    imageView.setImageResource(R.drawable.ok);
                    corrects = corrects + 1;
                }else{
                    titleTextView.setText(R.string.is_error);
                    titleTextView.setTextColor(Color.RED);
                    imageView.setImageResource(R.drawable.no);
                    errors = errors + 1;
                }
                Log.d("INFORMACION","Se ha pulsado YES");
                currentQuestion = questionBank.nextQuestion();
                questionNumber.setText(getString(R.string.question) + questionBank.getIndex(currentQuestion));
                questionTextView.setText(currentQuestion.getText());
                textViewCorrects.setText(getString(R.string.corrects) + corrects);
                textViewErrors.setText(getString(R.string.errors) + errors);
                fadeOutAndHideView(imageView);
                fadeOutAndHideView(titleTextView);
            }
        });

        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( currentQuestion.isCorrectAnswer() == false){
                    titleTextView.setText(R.string.is_correct);
                    titleTextView.setTextColor(Color.GREEN);
                    imageView.setImageResource(R.drawable.ok);
                    corrects = corrects + 1;
                }else{
                    titleTextView.setText(R.string.is_error);
                    titleTextView.setTextColor(Color.RED);
                    imageView.setImageResource(R.drawable.no);
                    errors = errors + 1;
                }
                Log.d("INFORMACION","Se ha pulsado NO");
                currentQuestion = questionBank.nextQuestion();
                questionNumber.setText(getString(R.string.question) + questionBank.getIndex(currentQuestion));
                questionTextView.setText(currentQuestion.getText());
                textViewCorrects.setText(getString(R.string.corrects) + corrects);
                textViewErrors.setText(getString(R.string.errors) + errors);
                fadeOutAndHideView(imageView);
                fadeOutAndHideView(titleTextView);
            }
        });


    }

    private void fadeOutAndHideView(final View view)
    {
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(1000);

        fadeOut.setAnimationListener(new Animation.AnimationListener()
        {
            public void onAnimationEnd(Animation animation)
            {
                view.setVisibility(View.GONE);
            }
            public void onAnimationRepeat(Animation animation) {}
            public void onAnimationStart(Animation animation) {}
        });

        view.startAnimation(fadeOut);
    }


    /*private void fadeOutAndHideImage(final ImageView img)
    {
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(1000);

        fadeOut.setAnimationListener(new Animation.AnimationListener()
        {
            public void onAnimationEnd(Animation animation)
            {
                img.setVisibility(View.GONE);
            }
            public void onAnimationRepeat(Animation animation) {}
            public void onAnimationStart(Animation animation) {}
        });

        img.startAnimation(fadeOut);
    }
    private void fadeOutAndHideText(final TextView img)
    {
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(1000);

        fadeOut.setAnimationListener(new Animation.AnimationListener()
        {
            public void onAnimationEnd(Animation animation)
            {
                img.setVisibility(View.GONE);
            }
            public void onAnimationRepeat(Animation animation) {}
            public void onAnimationStart(Animation animation) {}
        });

        img.startAnimation(fadeOut);
    }
    */
}
