package com.example.simplegitreviewapp;

public class Flashcard {

    /* Fields */
    private String key;
    private String definition;


    /* Methods */
    //Constructor
    public Flashcard(String key, String definition) {
        this.key = key;
        this.definition = definition;
    }


    // Getters and Setters
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
