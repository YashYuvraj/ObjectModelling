package com.crio.jukebox.Entities;

import java.util.List;

public class PlayList extends BaseEnity {
    private final String userId;
    private final String name; 
    private final List<Song> songList;
    

    public String getUserId() {
        return userId;
    }

   
    public String getName() {
        return name;
    }

    
    public List<Song> getSongList() {
        return songList;
    }

    public int curr=0;
    public PlayList(String userId,String name, List<Song> songList) {
        this.userId = userId;
        this.name=name;
        this.songList = songList;
    }

    public PlayList(String id, String userId,String name, List<Song> songList) {
        this(userId,name,songList);
        this.id=id;
    }

    public PlayList(PlayList playList)
    {
        this(playList.id,playList.userId,playList.name,playList.songList);
    }
    
    public Song next() 
    {
        if(curr==songList.size()-1)
        {
            curr=0;
            return songList.get(curr);
        }
        return songList.get(++curr);
    }
    public Song back()
    {
        if(curr==0)
        {
            curr=songList.size()-1;
            return songList.get(curr);
        }
        return songList.get(--curr);
    }

    @Override
    public String toString() {
        return "PlayList ID - " + id;
    }
}
