package com.example.simplegitreviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Play extends AppCompatActivity {

    // UI Elements
    private Button mButtonA;
    private Button mButtonB;
    private Button mButtonC;
    private Button mButtonD;
    private TextView mDefinition;
    private FloatingActionButton fab;
    private TextView mScoreBoard;

    // Cards
    private Deck deck;
    private ArrayList<String> nextQuestion;
    private String correctAnswer;
    private ArrayList<String> keys;

    // Helper variables
    private int questionsPlayed = 0;
    private int correctQuestions = 0;

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
        fab = (FloatingActionButton) findViewById(R.id.fab);
        mScoreBoard = (TextView) findViewById(R.id.score_board);

        // Reset all view.
        reset(getCurrentFocus());

    }


    // Logic for whenever an answer button is clicked.
    public void buttonPressed(View view) {
        Button btn = (Button) view;

        // If answer is correct.
        if (btn.getText().equals(nextQuestion.get(1))) {
            correctQuestions++;
            questionsPlayed++;
            setButtonAnswer();
            mScoreBoard.setText("Score: " + correctQuestions + "/" + questionsPlayed);
            Toast toast = Toast.makeText(getApplicationContext(), "Correct answer! :)", Toast.LENGTH_SHORT);
            toast.show();
            fab.setVisibility(FloatingActionButton.VISIBLE);

        // If answer is wrong.
        } else {
            questionsPlayed++;
            setButtonAnswer();
            mScoreBoard.setText("Score: " + correctQuestions + "/" + questionsPlayed);
            Toast toast = Toast.makeText(getApplicationContext(), "Wrong answer... :(", Toast.LENGTH_SHORT);
            toast.show();
            fab.setVisibility(FloatingActionButton.VISIBLE);
        }
    }


    /* Helper methods */
    // Colors buttons according to the answer. Green for right and red for wrong.
    private void setButtonAnswer() {

        if (mButtonA.getText().equals(correctAnswer)) {
            mButtonA.setBackgroundColor(getResources().getColor(R.color.Green));
            mButtonA.setTextColor(getResources().getColor(R.color.White));
        } else {
            mButtonA.setBackgroundColor(getResources().getColor(R.color.Magenta));
            mButtonA.setTextColor(getResources().getColor(R.color.White));
        }

        if (mButtonB.getText().equals(correctAnswer)) {
            mButtonB.setBackgroundColor(getResources().getColor(R.color.Green));
            mButtonB.setTextColor(getResources().getColor(R.color.White));
        } else {
            mButtonB.setBackgroundColor(getResources().getColor(R.color.Magenta));
            mButtonB.setTextColor(getResources().getColor(R.color.White));
        }

        if (mButtonC.getText().equals(correctAnswer)) {
            mButtonC.setBackgroundColor(getResources().getColor(R.color.Green));
            mButtonC.setTextColor(getResources().getColor(R.color.White));
        } else {
            mButtonC.setBackgroundColor(getResources().getColor(R.color.Magenta));
            mButtonC.setTextColor(getResources().getColor(R.color.White));
        }

        if (mButtonD.getText().equals(correctAnswer)) {
            mButtonD.setBackgroundColor(getResources().getColor(R.color.Green));
            mButtonD.setTextColor(getResources().getColor(R.color.White));
        } else {
            mButtonD.setBackgroundColor(getResources().getColor(R.color.Magenta));
            mButtonD.setTextColor(getResources().getColor(R.color.White));
        }
    }

    // resets buttons to original color.
    private void resetButtons() {

        mButtonA.setBackgroundColor(getResources().getColor(R.color.White));
        mButtonA.setTextColor(getResources().getColor(R.color.Light_Green));

        mButtonB.setBackgroundColor(getResources().getColor(R.color.White));
        mButtonB.setTextColor(getResources().getColor(R.color.Light_Green));

        mButtonC.setBackgroundColor(getResources().getColor(R.color.White));
        mButtonC.setTextColor(getResources().getColor(R.color.Light_Green));

        mButtonD.setBackgroundColor(getResources().getColor(R.color.White));
        mButtonD.setTextColor(getResources().getColor(R.color.Light_Green));

    }

    // Resets all elements necessary when the view is loaded or the user goes to the next question.
    private void reset(View view) {

        resetButtons();
        nextQuestion = deck.getNextQuestion();

        // If nextQuestion is not null (flag for empty deck)
        if (nextQuestion != null) {
            keys = new ArrayList<String>();
            correctAnswer = nextQuestion.get(1);
            keys.add(nextQuestion.get(1));
            keys.add(nextQuestion.get(2));
            keys.add(nextQuestion.get(3));
            keys.add(nextQuestion.get(4));
            Collections.shuffle(keys, new Random());
            fab.setVisibility(FloatingActionButton.INVISIBLE);

            // Populate elements
            mDefinition.setText(nextQuestion.get(0));
            mButtonA.setText(keys.get(0));
            mButtonB.setText(keys.get(1));
            mButtonC.setText(keys.get(2));
            mButtonD.setText(keys.get(3));


        } else {    // End of game
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }


}
