package com.crio.jukebox.Commands;

import java.util.List;
import com.crio.jukebox.services.IPlaylistService;

public class DeletePlayListCommand implements ICommand{

    private IPlaylistService playlistService;

    public DeletePlayListCommand(IPlaylistService playlistService) {
    this.playlistService = playlistService;
}

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        playlistService.delete(tokens.get(1),tokens.get(2));
        //System.out.println("Delete Successful");
        
    }
    
}
