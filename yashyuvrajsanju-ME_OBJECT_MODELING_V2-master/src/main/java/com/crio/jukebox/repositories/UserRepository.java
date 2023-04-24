package com.crio.jukebox.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import com.crio.jukebox.Entities.User;

public class UserRepository implements IUserRepository {

    private final Map<String,User> userMap;
    private Integer autoIncrement = 0;
  
    public UserRepository(){
        userMap = new HashMap<String,User>();
    }

    public UserRepository(Map<String, User> userMap) {
        this.userMap = userMap;
        this.autoIncrement = userMap.size();
    }

    

    @Override
    public User save(User entity) {
        // TODO Auto-generated method stub
        if( entity.getId() == null ){
            autoIncrement++;
            User u = new User(Integer.toString(autoIncrement),entity.getName());
            userMap.put(u.getId(),u);
            return u;
        }
        userMap.put(entity.getId(),entity);
        return entity;
    }

    @Override
    public Optional<User> findById(String id) {
        // TODO Auto-generated method stub
        return Optional.ofNullable(userMap.get(id));
    }

    

    
    
}
