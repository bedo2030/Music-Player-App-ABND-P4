package com.example.android.peoject_4_musicplayer;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NowPlayingActivity extends AppCompatActivity {
    @BindView(R.id.song_name_textView) TextView songName;
    @BindView(R.id.song_artist_textView) TextView songArtist;
    @BindView(R.id.favourite_icon_imageView) ImageView favouriteIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        ButterKnife.bind(this);
        //Setting up action bar for the activity
        Toolbar toolbar = (Toolbar)findViewById(R.id.now_playing_actionBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setTitle("Now Playing");
        //checking if intent extras is there or not
        if(getIntent().getExtras() != null){
            song nowPlayingSong = getIntent().getParcelableExtra("playingNowSongObject");
            songName.setText(nowPlayingSong.getmSongName());
            songArtist.setText(nowPlayingSong.getmSongArtist());
            if(nowPlayingSong.getmIsInFavourites()) favouriteIcon.setImageResource(R.drawable.ic_favorite_black_24dp);
            else favouriteIcon.setImageResource(R.drawable.ic_favorite_border_black_24dp);
        }else{
            songName.setText("Song Name Example");
            songArtist.setText("Song Artist Example");
            favouriteIcon.setImageResource(R.drawable.ic_favorite_black_24dp);
        }

    }
}
