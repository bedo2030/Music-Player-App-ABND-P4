package com.example.android.peoject_4_musicplayer;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Affandy on 02/06/2018.
 */

public class song implements Parcelable{
    private String mSongName;
    private String mSongArtist;
    private boolean mIsInFavourites;
    private boolean mIsPlayingNow;

    public song(String songName, String songArtist, boolean isInFavourites, boolean isPlayingNow){
        mSongName = songName;
        mSongArtist = songArtist;
        mIsInFavourites = isInFavourites;
        mIsPlayingNow = isPlayingNow;
    }

    public String getmSongName(){
        return mSongName;
    }

    public String getmSongArtist(){
        return mSongArtist;
    }

    public boolean getmIsInFavourites(){
        return mIsInFavourites;
    }

    public void setmIsInFavourites(boolean isInfavourites){
        mIsInFavourites = isInfavourites;
    }

    public boolean getmIsPlayingNow(){
        return mIsPlayingNow;
    }

    public void setmIsPlayingNow(boolean isPlayingNow){
        mIsPlayingNow = isPlayingNow;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSongName);
        dest.writeString(mSongArtist);
        dest.writeInt(mIsInFavourites ? 1:0);
        dest.writeInt(mIsPlayingNow ? 1:0);
    }

    public song(Parcel in){
        mSongName = in.readString();
        mSongArtist = in.readString();
        mIsInFavourites = (in.readInt() == 0) ? false : true;
        mIsPlayingNow = (in.readInt() == 0) ? false : true;

    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        public song createFromParcel(Parcel in){
            return new song(in);
        }

        public song[] newArray(int size){
            return new song[size];
        }
    };
}
