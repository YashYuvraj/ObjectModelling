package com.crio.jukebox.Commands;

import java.util.List;
import com.crio.jukebox.services.ISongService;

public class LoadDataCommand implements ICommand {

    ISongService songService;

    public LoadDataCommand(ISongService songService) {
        this.songService = songService;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        
      songService.loadSongs();
      System.out.println("Songs Loaded successfully");  
    }
    
}
