package com.crio.jukebox.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import com.crio.jukebox.Entities.Song;

public class SongRepository implements ISongRepository {
    private final Map<String,Song> songMap;

   private String active="";
  
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public SongRepository(){
        songMap = new HashMap<String,Song>();
    }

    public SongRepository(Map<String, Song> songMap) {
        this.songMap = songMap;
    }

    @Override
    public Song save(Song song) {
        // TODO Auto-generated method stub
        songMap.put(song.getId(),song);

        return song;
    }

    public Optional<Song> findById(String id)
    {
        return Optional.ofNullable(songMap.get(id));
    }


    public Song getSong(String id)
    {
        return songMap.get(id);
    }
    
    
}
