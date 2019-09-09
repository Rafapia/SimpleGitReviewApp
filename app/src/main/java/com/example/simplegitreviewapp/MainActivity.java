package com.example.simplegitreviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    /**
     * Main App page. Nothing special here, just two buttons that
     * take the user to different Activities and the git terms Deck.
     */

    // Create flashcards.
    Deck gitTerms = new Deck("Git Terms", "A review for GIT terms!");


    // Intent id.
    public static final String INTENT_EXTRA = "com.example.simplegitreviewapp.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateGitTerms(gitTerms);
    }


    // button_play method for onClick
    public void startPlayActivity(View view) {

        Intent intent = new Intent(this, Play.class);
        intent.putExtra(INTENT_EXTRA, gitTerms);
        // TODO figure out how to pass ArrayList<Flashcard> through the intent.
        startActivity(intent);
    }

    // button_train method for onClick
    public void startTrainActivity(View view) {

        Intent intent = new Intent(this, Train.class);
        intent.putExtra(INTENT_EXTRA, gitTerms);
        startActivity(intent);
    }


    private void populateGitTerms(Deck deck) {

        deck.addFlashcard(new Flashcard("Blame",
                "The ______ feature in Git describes the last modification to each " +
                        "line of a file, which generally displays the revision, author and time. " +
                        "This is helpful, for example, in tracking down when a feature was added, " +
                        "or which commit led to a particular bug."));
        deck.addFlashcard(new Flashcard("Branch",
                "A ______ is a parallel version of a repository. It is contained within " +
                        "the repository, but does not affect the primary or master ______ allowing" +
                        " you to work freely without disrupting the \"live\" version. When you've " +
                        "made the changes you want to make, you can merge your ______ back into " +
                        "the master ______ to publish your changes."));
        deck.addFlashcard(new Flashcard("Clone",
                "A ______ is a copy of a repository that lives on your computer instead " +
                        "of on a website's server somewhere, or the act of making that copy. With" +
                        " your ______ you can edit the files in your preferred editor and use Git " +
                        "to keep track of your changes without having to be online. It is, however," +
                        " connected to the remote version so that changes can be synced between the" +
                        " two. You can push your local changes to the remote to keep them synced" +
                        " when you're online."));
        deck.addFlashcard(new Flashcard("Collaborator",
                "A ______ is a person with read and write access to a repository " +
                        "who has been invited to contribute by the repository owner."));
        deck.addFlashcard(new Flashcard("Commit",
                "A ______, or \"revision\", is an individual change to a file (or set " +
                        "of files). It's like when you save a file, except with Git, every time " +
                        "you save it creates a unique ID (a.k.a. the \"SHA\" or \"hash\") that " +
                        "allows you to keep record of what changes were made when and by who. " +
                        "______ usually contain a commit message which is a brief description " +
                        "of what changes were made."));
        deck.addFlashcard(new Flashcard("Diff",
                "A ______ is the difference in changes between two commits, or saved" +
                        " changes. The ______ will visually describe what was added or removed from" +
                        " a file since its last commit."));
        deck.addFlashcard(new Flashcard("Fetch",
                "______ refers to getting the latest changes from an online " +
                        "repository without merging them in. Once these changes are ______ you" +
                        " can compare them to your local branches (the code residing on your " +
                        "local machine)."));
        deck.addFlashcard(new Flashcard("Fork",
                "A ______ is a personal copy of another user's repository that lives on " +
                        "your account. ______ allow you to freely make changes to a project without" +
                        " affecting the original. ______ remain attached to the original, allowing" +
                        " you to submit a pull request to the original's author to update with your" +
                        " changes. You can also keep your fork up to date by pulling in updates " +
                        "from the original."));
        deck.addFlashcard(new Flashcard("Issue",
                "______ are suggested improvements, tasks or questions related to the" +
                        " repository. ______ can be created by anyone (for public repositories)," +
                        " and are moderated by repository collaborators. Each ______ contains its" +
                        " own discussion forum, can be labeled and assigned to a user."));
        deck.addFlashcard(new Flashcard("Merge",
                "______ takes the changes from one branch (in the same repository or " +
                        "from a fork), and applies them into another. This often happens as a " +
                        "pull request (which can be thought of as a request to merge), or via" +
                        " the command line. A ______ can be done automatically via a pull request" +
                        " via the GitHub web interface if there are no conflicting changes, or can" +
                        " always be done via the command line."));
        deck.addFlashcard(new Flashcard("Private Repository",
                "______ are repositories that can only be viewed or " +
                        "contributed to by their creator and collaborators the creator specified."));
        deck.addFlashcard(new Flashcard("Pull",
                "______ refers to when you are fetching in changes and merging them. For" +
                        " instance, if someone has edited the remote file you're both working on," +
                        " you'll want to ______ in those changes to your local copy so that it's " +
                        "up to date."));
        deck.addFlashcard(new Flashcard("Pull Request",
                "______ are proposed changes to a repository submitted by a user" +
                        " and accepted or rejected by a repository's collaborators."));
        deck.addFlashcard(new Flashcard("Repository",
                "A ______ is the most basic element of GitHub. They're easiest to " +
                        "imagine as a project's folder. A ______ contains all of the project " +
                        "files (including documentation), and stores each file's revision history." +
                        " ______ can have multiple collaborators and can be either public " +
                        "or private."));
    }
}
