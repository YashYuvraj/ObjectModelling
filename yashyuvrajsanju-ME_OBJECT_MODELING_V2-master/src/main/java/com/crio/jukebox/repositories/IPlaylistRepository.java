package com.crio.jukebox.repositories;

import java.util.Optional;
import com.crio.jukebox.Entities.PlayList;

public interface IPlaylistRepository {
    public PlayList save(PlayList playList);
    public Optional<PlayList> findById(String id);
    public void delete(PlayList playList);
}
