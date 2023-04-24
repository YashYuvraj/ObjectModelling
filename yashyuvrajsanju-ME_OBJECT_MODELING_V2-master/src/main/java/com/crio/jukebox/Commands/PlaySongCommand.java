package com.crio.jukebox.Commands;

import java.util.List;
import com.crio.jukebox.Entities.Song;
import com.crio.jukebox.exceptions.InvalidOperationException;
import com.crio.jukebox.services.IPlaylistService;

public class PlaySongCommand implements ICommand{

    private IPlaylistService playlistService;
    
    public PlaySongCommand(IPlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        try
        {
          Song song=playlistService.playSong(tokens.get(1),tokens.get(2));
          System.out.println("Current Song Playing");
          System.out.println("Song - "+song.getName());
          System.out.println("Album - "+song.getAlbum());
          String st="";
          for(int i=0;i<song.getArtists().size();i++)
          {
            if(i!=song.getArtists().size()-1)
            st=st+song.getArtists().get(i)+",";
            else
            st=st+song.getArtists().get(i);
          }
          System.out.println("Artists - "+st);
        }
        catch(InvalidOperationException e)
        {
            System.out.println("Given song id is not a part of the active playlist");
        }
        
    }
    
}
