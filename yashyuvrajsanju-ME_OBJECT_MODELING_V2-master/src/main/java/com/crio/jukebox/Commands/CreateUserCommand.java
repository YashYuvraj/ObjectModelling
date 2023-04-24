package com.crio.jukebox.Commands;

import java.util.List;
import com.crio.jukebox.Entities.User;
import com.crio.jukebox.services.IUserService;

public class CreateUserCommand implements ICommand {
 private final IUserService userService;

 public CreateUserCommand(IUserService userService) {
    this.userService = userService;
}
    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        User user=userService.create(tokens.get(1));
        System.out.println(user.getId()+" "+user.getName());
    }
    
}
