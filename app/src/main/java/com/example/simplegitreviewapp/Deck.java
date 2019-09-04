package com.example.simplegitreviewapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Deck implements Parcelable {

    /* Fields */
    private ArrayList<Flashcard> mFlashcards;
    private String mName;
    private String mDescription;


    /* Methods */
    // Contructor
    public Deck(String mName, String mDescription, ArrayList<Flashcard> mFlashcards) {
        this.mFlashcards = mFlashcards;
        this.mName = mName;
        this.mDescription = mDescription;
    }

    public Deck(String mName, String mDescription) {
        this.mFlashcards = new ArrayList<Flashcard>();
        this.mName = mName;
        this.mDescription = mDescription;
    }


    // Getters and setters
    public ArrayList<Flashcard> getFlashcards() {
        return (ArrayList<Flashcard>) mFlashcards.clone();
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public void addFlashcard(Flashcard flashcard) {
        mFlashcards.add(flashcard);
    }

    public void addFlashcards(ArrayList<Flashcard> flashcards) {
        mFlashcards.addAll(flashcards);
    }




    // Parcelable stuff
    protected Deck(Parcel in) {
        mName = in.readString();
        mDescription = in.readString();
    }

    public static final Creator<Deck> CREATOR = new Creator<Deck>() {
        @Override
        public Deck createFromParcel(Parcel in) {
            return new Deck(in);
        }

        @Override
        public Deck[] newArray(int size) {
            return new Deck[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
        parcel.writeString(mDescription);
    }
}
