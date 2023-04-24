package com.crio.jukebox.repositories;

import java.util.Optional;
import com.crio.jukebox.Entities.User;

public interface IUserRepository {
    
    public User save(User user);
    public Optional<User> findById(String id);
}
