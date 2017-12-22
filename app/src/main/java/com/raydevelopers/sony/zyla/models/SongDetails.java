package com.raydevelopers.sony.zyla.models;

/**
 * Created by SONY on 22-12-2017.
 */

public class SongDetails {
    public String mName;
     public  String  mArtist;
    public String mAlbum;
    public SongDetails(String name,String artist,String album)
    {
        this.mName=name;
        this.mArtist=artist;
        this.mAlbum=album;
    }

    public String getmName()
{
    return  mName;
}
public String getmArtist()
{
    return  mArtist;
}
public  String getmAlbum()
{
    return mAlbum;
}
}
