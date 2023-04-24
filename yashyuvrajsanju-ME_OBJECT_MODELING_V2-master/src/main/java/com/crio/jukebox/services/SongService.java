package com.crio.jukebox.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.crio.jukebox.Entities.Song;
import com.crio.jukebox.repositories.ISongRepository;

public class SongService implements ISongService {

    ISongRepository songRepository;
    
    public SongService(ISongRepository songRepository) {
      this.songRepository = songRepository;
    }

    @Override
    public Song create(String id, String name, String album, List<String> artists) {
        // TODO Auto-generated method stub
        Song song=new Song(id,name,album,artists);
         songRepository.save(song);
        return song;
    }
    
    @Override
    public void loadSongs() {
      // TODO Auto-generated method stub
      String line = "";  
      String splitBy = ",";  
  try   
   {  
     BufferedReader br = new BufferedReader(new FileReader("songs.csv")); 
     while ((line = br.readLine()) != null)    
        {  
         String[] song = line.split(splitBy); 
         String id=song[0];
         String name=song[1];
         String album=song[3];
         String artists=song[5];
         String[] artistList=artists.split("#");
         //System.out.println(id+" "+name+" "+album+" "+Arrays.asList(artistList));
         create(id, name, album, Arrays.asList(artistList));
         }
         br.close();
      }
      catch (IOException e)   
         {  
           e.printStackTrace();  
         }  
      
    }

   
   
    /*public static void main(String args[])
    {
        loadSongs();

    }*/
}
