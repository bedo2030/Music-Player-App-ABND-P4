package com.example.android.peoject_4_musicplayer;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;

public class MusicLibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);
        //Setting up action bar for the activity
        Toolbar toolbar = (Toolbar)findViewById(R.id.song_list_actionBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setTitle("Music Library");
        //Creating and initializing songs array list
        ArrayList<song> songs = new ArrayList<song>();
        songs.add(new song("Nice For What","Drake",false,false));
        songs.add(new song("This Is America","Childish Gambino",false,false));
        songs.add(new song("God's Plan","Drake",false,false));
        songs.add(new song("The Middle","Zedd, Maren Morris & Grey",false,false));
        songs.add(new song("Yes Indeed","Lil Baby & Drake",false,false));
        //Creating songs adapter
        SongAdapter adapter = new SongAdapter(this,songs);
        //finding songs ListView and setting songs adapter to it
        ListView songsList = (ListView) findViewById(R.id.song_list);
        songsList.setAdapter(adapter);
    }
}
