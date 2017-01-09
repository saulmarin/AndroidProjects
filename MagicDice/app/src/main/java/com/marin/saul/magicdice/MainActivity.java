package com.marin.saul.magicdice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button rollButton;
    ImageView number;
    TextView numberText;
    ToggleButton normalButton;
    ToggleButton percentilButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollButton = (Button) findViewById(R.id.activity_main_roll_button);
        number = (ImageView) findViewById(R.id.activity_main_number);
        numberText = (TextView) findViewById(R.id.activity_main_number_text);
        normalButton = (ToggleButton) findViewById(R.id.activity_main_normal_button);
        percentilButton = (ToggleButton) findViewById(R.id.activity_main_percentil_button);

        normalButton.setChecked(true);
        number.setImageResource(R.drawable.dice_face_0);
        numberText.setVisibility(View.INVISIBLE);

        normalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                normalButton.setChecked(true);
                percentilButton.setChecked(false);
                number.setVisibility(View.VISIBLE);
                number.setImageResource(R.drawable.dice_face_0);
                numberText.setVisibility(View.INVISIBLE);
                numberText.setText("");
            }
        });

        percentilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                normalButton.setChecked(false);
                percentilButton.setChecked(true);
                number.setVisibility(View.INVISIBLE);
                numberText.setVisibility(View.VISIBLE);
                numberText.setText("00");
            }
        });

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();


                if ( normalButton.isChecked() == true) {
                    int numberShown = random.nextInt(6)+1;
                    int images[] = new int[]{
                            R.drawable.dice_face_1,
                            R.drawable.dice_face_2,
                            R.drawable.dice_face_3,
                            R.drawable.dice_face_4,
                            R.drawable.dice_face_5,
                            R.drawable.dice_face_6,
                    };

                    int numberImage = images[numberShown - 1];
                    number.setImageResource(numberImage);
                }

                if ( percentilButton.isChecked() == true ){
                    int numberShown = random.nextInt(100)+1;
                    numberText.setText("" + numberShown);
                }

            }
        });

    }
}
