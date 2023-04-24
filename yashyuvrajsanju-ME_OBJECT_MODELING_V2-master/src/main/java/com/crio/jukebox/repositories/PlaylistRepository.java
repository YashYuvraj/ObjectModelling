package com.crio.jukebox.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import com.crio.jukebox.Entities.PlayList;

public class PlaylistRepository implements IPlaylistRepository {

    private final Map<String,PlayList> playListMap;
    private Integer autoIncrement = 0;

    
    
    public PlaylistRepository() {
        playListMap = new HashMap<String,PlayList>();
    }

    public PlaylistRepository(Map<String, PlayList> playListMap) {
        this.playListMap = playListMap;
        this.autoIncrement = playListMap.size();
    }


    @Override
    public PlayList save(PlayList entity) {
        // TODO Auto-generated method stub
        if( entity.getId() == null ){
            autoIncrement++;
            PlayList p = new PlayList(Integer.toString(autoIncrement),entity.getUserId(),entity.getName(),entity.getSongList());
            playListMap.put(p.getId(),p);
            return p;
        }
        playListMap.put(entity.getId(),entity);
        return entity;
    }

    public void delete(PlayList entity)
    {
      playListMap.remove(entity.getId());
    }

    @Override
    public Optional<PlayList> findById(String id) {
        // TODO Auto-generated method stub
        return Optional.ofNullable(playListMap.get(id));
    
    }
    
}
