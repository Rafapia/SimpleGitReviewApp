package com.example.simplegitreviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Random;

public class Play extends AppCompatActivity {

    // UI Elements
    Button[] mButtons = new Button[4];
    TextView mDefinition;

    // Flashcards
    ArrayList<Flashcard> mFlashcards;
    ArrayList<Flashcard> mFlashcardsCopy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        // Get references to Views
        mButtons[0] = (Button) findViewById(R.id.button_optionA);
        mButtons[1] = (Button) findViewById(R.id.button_optionB);
        mButtons[2] = (Button) findViewById(R.id.button_optionC);
        mButtons[3] = (Button) findViewById(R.id.button_optionD);
        mDefinition = (TextView) findViewById(R.id.definition);


    }
}
