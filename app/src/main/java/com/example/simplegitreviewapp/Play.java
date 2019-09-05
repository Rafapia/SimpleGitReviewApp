package com.example.simplegitreviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Random;

public class Play extends AppCompatActivity {

    // UI Elements
    Button mButtonA;
    Button mButtonB;
    Button mButtonC;
    Button mButtonD;
    TextView mDefinition;

    // Cards
    Deck deck;
    ArrayList<String> nextQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        // Get intent contents
        Intent intent = getIntent();
        deck = (Deck) intent.getSerializableExtra(MainActivity.INTENT_EXTRA);

        // Get references to Views
        mButtonA = (Button) findViewById(R.id.button_optionA);
        mButtonB = (Button) findViewById(R.id.button_optionB);
        mButtonC = (Button) findViewById(R.id.button_optionC);
        mButtonD = (Button) findViewById(R.id.button_optionD);
        mDefinition = (TextView) findViewById(R.id.definition);

        // Get next question
        nextQuestion = deck.getNextQuestion();


        // Populate elements
        mDefinition.setText(nextQuestion.get(0));
        mButtonA.setText(nextQuestion.get(1));
        mButtonB.setText(nextQuestion.get(2));
        mButtonC.setText(nextQuestion.get(3));
        mButtonD.setText(nextQuestion.get(4));

    }


    public void whichButton(View view) {
        Button btn = (Button) view;

        if (btn.getText().equals(nextQuestion.get(1))) {
            setButtonAnswer(btn);
            Toast toast = Toast.makeText(getApplicationContext(), "Correct answer! :)", Toast.LENGTH_SHORT);
            toast.show();

        } else {
            setButtonAnswer(btn);
            Toast toast = Toast.makeText(getApplicationContext(), "Wrong answer... :(", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


    // Helper methods
    public void setButtonAnswer(Button btn) {

        mButtonA.setBackgroundColor(getResources().getColor(R.color.Magenta));
        mButtonA.setTextColor(getResources().getColor(R.color.White));

        mButtonB.setBackgroundColor(getResources().getColor(R.color.Magenta));
        mButtonB.setTextColor(getResources().getColor(R.color.White));

        mButtonC.setBackgroundColor(getResources().getColor(R.color.Magenta));
        mButtonC.setTextColor(getResources().getColor(R.color.White));

        mButtonD.setBackgroundColor(getResources().getColor(R.color.Magenta));
        mButtonD.setTextColor(getResources().getColor(R.color.White));

        btn.setBackgroundColor(getResources().getColor(R.color.Green));
        btn.setTextColor(getResources().getColor(R.color.White));
    }

    public void resetButtons() {

        mButtonA.setBackgroundColor(getResources().getColor(R.color.White));
        mButtonA.setTextColor(getResources().getColor(R.color.Light_Green));

        mButtonB.setBackgroundColor(getResources().getColor(R.color.White));
        mButtonB.setTextColor(getResources().getColor(R.color.Light_Green));

        mButtonC.setBackgroundColor(getResources().getColor(R.color.White));
        mButtonC.setTextColor(getResources().getColor(R.color.Light_Green));

        mButtonD.setBackgroundColor(getResources().getColor(R.color.White));
        mButtonD.setTextColor(getResources().getColor(R.color.Light_Green));

    }

    public void reset() {

        resetButtons();
        nextQuestion = deck.getNextQuestion();
    }

    // TODO randomly get a question and provide alternatives

}
