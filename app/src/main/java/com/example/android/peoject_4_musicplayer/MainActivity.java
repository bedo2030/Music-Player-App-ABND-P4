package com.example.android.peoject_4_musicplayer;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.android.peoject_4_musicplayer.R.id.music_library_textview;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.now_playing_textview) TextView nowPlayingTextView;
    @BindView(R.id.music_library_textview) TextView musicLibraryTextView;
    @BindView(R.id.favourites_textview) TextView favouritesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //Setting up action bar for the activity
        Toolbar toolbar = (Toolbar)findViewById(R.id.main_activity_actionBar);
        setSupportActionBar(toolbar);
        Drawable logo = ContextCompat.getDrawable(this,R.drawable.ic_main_activity_aaction_bar);
        toolbar.setTitle("Bedo Player");
        toolbar.setLogo(logo);
        // Setting OnClickListeners for each  category
        nowPlayingTextView.setOnClickListener(this);
        musicLibraryTextView.setOnClickListener(this);
        favouritesTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int clickedItem = v.getId(); // id of clicked item
        Intent goToClickedItem;
        //Checking the id of clicked item and intializing the Intent variable with appropriate data
        //I used if else if statement instead of switch as a change
        if(clickedItem == R.id.now_playing_textview){
            goToClickedItem = new Intent(MainActivity.this, NowPlayingActivity.class);
        }else if(clickedItem == music_library_textview){
            goToClickedItem = new Intent(MainActivity.this, MusicLibraryActivity.class);
        }else{
            goToClickedItem = new Intent(MainActivity.this, FavouritesActivity.class);
        }
        //move to the specified activity from above if else if statement
        startActivity(goToClickedItem);
    }
}
