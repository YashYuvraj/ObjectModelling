package com.crio.jukebox.services;

import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.Entities.PlayList;
import com.crio.jukebox.Entities.Song;
import com.crio.jukebox.Entities.User;
import com.crio.jukebox.exceptions.InvalidOperationException;
import com.crio.jukebox.exceptions.PlayListNotFoundException;
import com.crio.jukebox.exceptions.SongNotFoundException;
import com.crio.jukebox.exceptions.UserNotFoundException;
import com.crio.jukebox.repositories.IPlaylistRepository;
import com.crio.jukebox.repositories.ISongRepository;
import com.crio.jukebox.repositories.IUserRepository;

public class PlaylistService implements IPlaylistService {
    private final IUserRepository userRepository;
    private final IPlaylistRepository playListRepository;
    private final ISongRepository songRepository;

    public PlaylistService(IUserRepository userRepository, IPlaylistRepository playListRepository,
    ISongRepository songRepository)
     {
       this.userRepository = userRepository;
       this.playListRepository = playListRepository;
       this.songRepository = songRepository;
     } 
     
        
        @Override
        public PlayList create(String userId, String name, List<String> list) {
            // TODO Auto-generated method stub
            List<Song> songList=new ArrayList<>();
            final User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("Cannot Create PlaList for given id: " + userId + " not found!"));
            for(int i=0;i<list.size();i++)
            {
                String st=list.get(i);
                Song s=songRepository.findById(list.get(i)).orElseThrow(() -> new SongNotFoundException("Cannot find Song for given id: " + st+ " not found!"));
                songList.add(s);
            }
            PlayList playList=new PlayList(userId,name,songList);
            PlayList res= playListRepository.save(playList);
            List<PlayList> pl=user.getUserPlayList();
            pl.add(res);
            return res;
        }

        public PlayList delete(String userId,String playListId)
        {
            final User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("Cannot find User for given id: " + userId + " not found!"));
            final PlayList playList = playListRepository.findById(playListId).orElseThrow(() -> new PlayListNotFoundException("Cannot find PlaList for given id: " + playListId + " not found!"));
             if(user.checkIfPlayListExists(playListId)==false)
             throw new InvalidOperationException("Cannot Delete PlayList. User does mot have the given playlist with id:"+playListId);
             user.deletePlayList(playList);
             userRepository.save(user);
             playListRepository.delete(playList);
             System.out.println("Delete Successful");
             return playList;
        }

        public Song playPlayList(String userId,String playListId)
        {
            final User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("Cannot find User for given id: " + userId + " not found!"));
            final PlayList playList = playListRepository.findById(playListId).orElseThrow(() -> new PlayListNotFoundException("Cannot find PlaList for given id: " + playListId + " not found!"));
            if(user.checkIfPlayListExists(playListId)==false)
            throw new InvalidOperationException("Cannot Play PlayList. User does mot have the given playlist with id:"+playListId);
            if(playList.getSongList().isEmpty())
            throw new InvalidOperationException("Cannot Play PlayList.PlayList is Empty");
            songRepository.setActive(playListId);
            playList.curr=0;
            return playList.getSongList().get(0);
        }


        @Override
        public PlayList modifyAdd(String userId, String playListId, String id) {
            // TODO Auto-generated method stub
            final User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("Cannot Create PlaList for given id: " + userId + " not found!"));
            final PlayList playList = playListRepository.findById(playListId).orElseThrow(() -> new PlayListNotFoundException("Cannot find PlaList for given id: " + playListId + " not found!"));
            if(user.checkIfPlayListExists(playListId)==false)
            throw new InvalidOperationException("Cannot Delete PlayList. User does mot have the given playlist with id:"+playListId);
            PlayList pl=user.getPlayList(playListId);
            List<Song> l=pl.getSongList();
                Song song=songRepository.getSong(id);
                //System.out.println("song= "+song);
                if(!l.contains(song))
                l.add(song);
            return pl;
        }


        @Override
        public PlayList modifyDelete(String userId, String playListId, String id) {
            // TODO Auto-generated method stub
            final User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("Cannot Create PlaList for given id: " + userId + " not found!"));
            final PlayList playList = playListRepository.findById(playListId).orElseThrow(() -> new PlayListNotFoundException("Cannot find PlaList for given id: " + playListId + " not found!"));
            if(user.checkIfPlayListExists(playListId)==false)
            throw new InvalidOperationException("Cannot Delete PlayList. User does mot have the given playlist with id:"+playListId);
            PlayList pl=user.getPlayList(playListId);
            List<Song> l=pl.getSongList();
                Song song=songRepository.getSong(id);
                if(l.contains(song))
                l.remove(song);
            return pl;
        }


        @Override
        public Song playSong(String userId, String songId) {
            // TODO Auto-generated method stub
            String active=songRepository.getActive();
            PlayList p=playListRepository.findById(active).orElseThrow(() -> new PlayListNotFoundException("Cannot find PlaList for given id: " + active + " not found!"));
            
            if(songId.equals("NEXT"))
            return p.next();
            else  
            if(songId.equals("BACK"))
            return p.back();
            else
            {
                List<Song> list=p.getSongList();
                Song song=songRepository.findById(songId).orElseThrow(() -> new InvalidOperationException());
                if(list.contains(song))
                {
                    p.curr=list.indexOf(song);
                return song;
                }
 
                else
                throw new InvalidOperationException();
            }
           
        }

  
        
}
