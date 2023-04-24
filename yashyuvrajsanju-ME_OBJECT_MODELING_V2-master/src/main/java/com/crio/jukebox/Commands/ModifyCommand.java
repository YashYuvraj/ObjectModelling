package com.crio.jukebox.Commands;

import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.Entities.PlayList;
import com.crio.jukebox.Entities.Song;
import com.crio.jukebox.services.IPlaylistService;

public class ModifyCommand implements ICommand {

IPlaylistService playlistService;

    public ModifyCommand(IPlaylistService playlistService) {
    this.playlistService = playlistService;
}

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
     if(tokens.get(1).equals("ADD-SONG"))
    {           
       PlayList p=playlistService.modifyAdd(tokens.get(2), tokens.get(3),tokens.get(4));
      // List<String> list=new ArrayList<>();
       String res="";
       List<Song> s=new ArrayList<>();
       s=p.getSongList();
       for(int i=0;i<s.size();i++)
       {
        //list.add(s.get(i).getId());
        if(i!=s.size()-1)
        res=res+s.get(i).getId()+" ";
        else
        res=res+s.get(i).getId();
       }
        System.out.println("Playlist ID - "+p.getId());
        System.out.println("Playlist Name - "+p.getName());
        System.out.println("Song IDs - "+res);
    }
    else
    {
       PlayList p=playlistService.modifyDelete(tokens.get(2), tokens.get(3), tokens.get(4));
       //List<String> list=new ArrayList<>();
       String res="";
       List<Song> s=new ArrayList<>();
       s=p.getSongList();
       for(int i=0;i<s.size();i++)
       {
        //list.add(s.get(i).getId());
        if(i!=s.size()-1)
        res=res+s.get(i).getId()+" ";
        else
        res=res+s.get(i).getId();
       }
        System.out.println("Playlist ID - "+p.getId());
        System.out.println("Playlist Name - "+p.getName());
        System.out.println("Song IDs - "+res);
    }
    }
    
}
