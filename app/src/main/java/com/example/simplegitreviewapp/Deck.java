package com.example.simplegitreviewapp;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Deck implements Serializable {

    /* Fields */
    private ArrayList<Flashcard> mFlashcards;
    private ArrayList<Flashcard> mPlayingFlashcards;
    private String mName;
    private String mDescription;


    /* Methods */
    // Contructor
    public Deck(String mName, String mDescription, ArrayList<Flashcard> mFlashcards) {
        this.mFlashcards = mFlashcards;
        this.mPlayingFlashcards = (ArrayList<Flashcard>) mFlashcards.clone();
        this.mName = mName;
        this.mDescription = mDescription;
    }

    public Deck(String mName, String mDescription) {
        this.mFlashcards = new ArrayList<Flashcard>();
        this.mPlayingFlashcards = new ArrayList<Flashcard>();
        this.mName = mName;
        this.mDescription = mDescription;
    }


    // Getters and setters
    public ArrayList<Flashcard> getFlashcards() {
        return mFlashcards;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public void addFlashcard(Flashcard flashcard) {
        mFlashcards.add(flashcard);
        mPlayingFlashcards.add(flashcard);
    }

    public void addFlashcards(ArrayList<Flashcard> flashcards) {
        mFlashcards.addAll(flashcards);
        mPlayingFlashcards.addAll(flashcards);
    }

    public Flashcard getFlashcard(int index) {
        return mPlayingFlashcards.get(index);
    }

    public void resetPlayingCards() {
        mPlayingFlashcards = (ArrayList<Flashcard>) mFlashcards.clone();
    }

    public ArrayList<String> getNextQuestion() {
        ArrayList<String> result = new ArrayList<String>();
        Random rand = new Random();

        if (mPlayingFlashcards.size() == 0) {
            return null;
        }

        // Get random Flashcard and remove from PlayingDeck
        Flashcard random = mPlayingFlashcards.remove(rand.nextInt(mPlayingFlashcards.size()));
        result.add(random.getDefinition());
        result.add(random.getKey());


        // Get three random keys
        while (result.size() < 5) {
            Flashcard randKey = mFlashcards.get(rand.nextInt(mFlashcards.size()));

            if (!result.contains(randKey.getKey())) {
                result.add(randKey.getKey());
            }
        }

        return result;
    }


    // Parcelable stuff
//    protected Deck(Parcel in) {
//        mName = in.readString();
//        mDescription = in.readString();
//    }
//
//    public static final Creator<Deck> CREATOR = new Creator<Deck>() {
//        @Override
//        public Deck createFromParcel(Parcel in) {
//            return new Deck(in);
//        }
//
//        @Override
//        public Deck[] newArray(int size) {
//            return new Deck[size];
//        }
//    };
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel parcel, int i) {
//        parcel.writeString(mName);
//        parcel.writeString(mDescription);
//        parcel.writeTypedArray(mFlashcards);
//    }
}
