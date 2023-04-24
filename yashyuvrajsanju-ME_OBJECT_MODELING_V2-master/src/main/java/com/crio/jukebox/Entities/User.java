package com.crio.jukebox.Entities;

import java.util.ArrayList;
import java.util.List;

public class User extends BaseEnity {
   
   private final String name;
   public String getName() {
    return name;
}
private List<PlayList> userPlayList;

public List<PlayList> getUserPlayList() {
    return userPlayList;
}

public User(User user)
{
    this(user.id,user.name,user.userPlayList);
}

public User(String name, List<PlayList> userPlayList) {
    this.name = name;
    this.userPlayList = userPlayList;
}

public User(String name) {
    this.name = name;
    this.userPlayList=new ArrayList<>();
}
public User(String id, String name) {
    this(name);
    this.id = id;
}
public User(String id, String name, List<PlayList> userPlayList) {
    this(id,name);
    this.userPlayList = userPlayList;
}

public void deletePlayList(PlayList playList)
{
    userPlayList.removeIf(p -> p.getId() == playList.getId());
}

public boolean checkIfPlayListExists(String id){
    for(PlayList p: userPlayList)
    {
        if(p.getId().equals(id))
        return true;
    }
    return false;
}

public PlayList getPlayList(String id)
{
    for(PlayList p: userPlayList)
    {
        if(p.getId().equals(id))
        return p;
    }
    return null;
}

@Override
public String toString() {
    return id + name ;
}


}
