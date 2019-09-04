package com.example.simplegitreviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Train extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);

        // Get intent contents
        Intent intent = getIntent();
        Deck deck = (Deck) intent.getParcelableExtra(MainActivity.INTENT_EXTRA);
    }
}
