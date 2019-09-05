package com.example.simplegitreviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


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

        // Get intent contents
        Intent intent = getIntent();
        Deck deck = (Deck) intent.getParcelableExtra(MainActivity.INTENT_EXTRA);

        // Get references to Views
        mButtons[0] = (Button) findViewById(R.id.button_optionA);
        mButtons[1] = (Button) findViewById(R.id.button_optionB);
        mButtons[2] = (Button) findViewById(R.id.button_optionC);
        mButtons[3] = (Button) findViewById(R.id.button_optionD);
        mDefinition = (TextView) findViewById(R.id.definition);

        mDefinition.setText(deck.getName());
    }


    public void whichButton(View view) {
        Button btn = (Button) view;
        Toast toast = Toast.makeText(getApplicationContext(), "Button: " + btn.getText(), Toast.LENGTH_SHORT);
        toast.show();
    }

}
