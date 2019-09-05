package com.example.simplegitreviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class Train extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);

        // Get intent contents
        Intent intent = getIntent();
        Deck deck = (Deck) intent.getSerializableExtra(MainActivity.INTENT_EXTRA);

        TextView mTextView = (TextView) findViewById(R.id.textView);
        mTextView.setText(deck.getDescription());
    }
}
