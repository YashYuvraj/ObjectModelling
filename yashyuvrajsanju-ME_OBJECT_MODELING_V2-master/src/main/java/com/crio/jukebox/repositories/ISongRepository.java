package com.crio.jukebox.repositories;

import java.util.Optional;
import com.crio.jukebox.Entities.Song;


public interface ISongRepository {
    public Song save(Song song);
    public Optional<Song> findById(String id);
    public Song getSong(String id);
    public void setActive(String id);
    public String getActive();
}
