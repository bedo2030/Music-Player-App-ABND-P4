package com.example.android.peoject_4_musicplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Affandy on 03/06/2018.
 */

public class SongAdapter extends ArrayAdapter<song> {
    Activity mContext;
    public SongAdapter(Activity context, ArrayList<song> songs){
        super(context,0,songs);
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        final song currentSong = getItem(position);
        TextView songName = (TextView) listItemView.findViewById(R.id.song_name_textView);
        TextView songArtist = (TextView) listItemView.findViewById(R.id.song_artist_textView);
        ImageView playImageView = (ImageView) listItemView.findViewById(R.id.play_icon_imageView);
        final ImageView favouriteImageView = (ImageView) listItemView.findViewById(R.id.favourite_icon_imageView);
        //specifying what will happen when clicking on play/pause icon
        playImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentSong.setmIsPlayingNow(true);
                Intent goToPlayingNowActivity = new Intent(mContext, NowPlayingActivity.class);
                goToPlayingNowActivity.putExtra("playingNowSongObject", (Parcelable) currentSong);
                mContext.startActivity(goToPlayingNowActivity);
            }
        });
        //specifying what will happen when clicking on favourite icon
        favouriteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentSong.getmIsInFavourites()){
                    currentSong.setmIsInFavourites(false);
                    favouriteImageView.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                    Toast.makeText(mContext,"Song Removed From Favourites", Toast.LENGTH_SHORT).show();
                }else{
                    currentSong.setmIsInFavourites(true);
                    favouriteImageView.setImageResource(R.drawable.ic_favorite_black_24dp);
                    Toast.makeText(mContext,"Song Added To Favourites", Toast.LENGTH_SHORT).show();
                }
            }
        });

        songName.setText(currentSong.getmSongName());
        songArtist.setText(currentSong.getmSongArtist());
        if(currentSong.getmIsPlayingNow()) playImageView.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        else playImageView.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);

        if(currentSong.getmIsInFavourites()) favouriteImageView.setImageResource(R.drawable.ic_favorite_black_24dp);
        else favouriteImageView.setImageResource(R.drawable.ic_favorite_border_black_24dp);

        return listItemView;

    }
}
