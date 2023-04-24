package com.crio.jukebox.services;

import java.util.List;
import com.crio.jukebox.Entities.PlayList;
import com.crio.jukebox.Entities.Song;

public interface IPlaylistService {
    public PlayList create(String id, String name,List<String> list );
    public PlayList delete(String userId,String playListId);
    public Song playPlayList(String userId,String playListId);
    public PlayList modifyAdd(String userId,String playListId, String id);
    public PlayList modifyDelete(String userId,String playListId, String id);
    public Song playSong(String userId,String songId);
}
