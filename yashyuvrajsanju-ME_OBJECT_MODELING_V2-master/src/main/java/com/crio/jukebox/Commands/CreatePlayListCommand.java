package com.crio.jukebox.Commands;

import java.util.ArrayList;
import java.util.List;
import com.crio.codingame.exceptions.UserNotFoundException;
import com.crio.jukebox.Entities.PlayList;
import com.crio.jukebox.exceptions.SongNotFoundException;
import com.crio.jukebox.services.IPlaylistService;

public class CreatePlayListCommand implements ICommand {

private IPlaylistService playlistService;

    public CreatePlayListCommand(IPlaylistService playlistService) {
    this.playlistService = playlistService;
}

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        List<String> list=new ArrayList<>();
        for(int i=3;i<tokens.size();i++)
        {
            list.add(tokens.get(i));
        }
        try{
        PlayList playList=playlistService.create(tokens.get(1),tokens.get(2),list);
        System.out.println("Playlist ID - "+playList.getId());
        }
        catch(SongNotFoundException s)
        {
            System.out.println("Some Requested Songs Not Available. Please try again.");
        }
        catch(UserNotFoundException u)
        {
            System.out.println("User Not Found");
        }
    }
    
}
