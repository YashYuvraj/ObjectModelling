package com.crio.jukebox.appConfig;




import com.crio.jukebox.Commands.CommandInvoker;
import com.crio.jukebox.Commands.CreatePlayListCommand;
import com.crio.jukebox.Commands.CreateUserCommand;
import com.crio.jukebox.Commands.DeletePlayListCommand;
import com.crio.jukebox.Commands.LoadDataCommand;
import com.crio.jukebox.Commands.ModifyCommand;
import com.crio.jukebox.Commands.PlayPlayListCommand;
import com.crio.jukebox.Commands.PlaySongCommand;
import com.crio.jukebox.repositories.IPlaylistRepository;
import com.crio.jukebox.repositories.ISongRepository;
import com.crio.jukebox.repositories.IUserRepository;
import com.crio.jukebox.repositories.PlaylistRepository;
import com.crio.jukebox.repositories.SongRepository;
import com.crio.jukebox.repositories.UserRepository;
import com.crio.jukebox.services.IPlaylistService;
import com.crio.jukebox.services.ISongService;
import com.crio.jukebox.services.IUserService;
import com.crio.jukebox.services.PlaylistService;
import com.crio.jukebox.services.SongService;
import com.crio.jukebox.services.UserService;

public class ApplicationConfig {
    private final IUserRepository userRepository=new UserRepository();
    private final ISongRepository songRepository=new SongRepository();
    private final IPlaylistRepository playlistRepository=new PlaylistRepository();

    private final IUserService userService=new UserService(userRepository);
    private final ISongService songService=new SongService(songRepository);
    private final IPlaylistService playlistService=new PlaylistService(userRepository, playlistRepository, songRepository);

    private final CreateUserCommand createUserCommand=new CreateUserCommand(userService);
    private final LoadDataCommand loadDataCommand=new LoadDataCommand(songService);
    private final CreatePlayListCommand createPlayListCommand=new CreatePlayListCommand(playlistService);
    private final ModifyCommand modifyCommand=new ModifyCommand(playlistService);
    private final PlayPlayListCommand playPlayListCommand=new PlayPlayListCommand(playlistService);
    private final DeletePlayListCommand deletePlayListCommand=new DeletePlayListCommand(playlistService);
    private final PlaySongCommand playSongCommand=new PlaySongCommand(playlistService);

    private final CommandInvoker commandInvoker=new CommandInvoker();

    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("CREATE-USER",createUserCommand);
        commandInvoker.register("CREATE-PLAYLIST",createPlayListCommand);
        commandInvoker.register("DELETE-PLAYLIST",deletePlayListCommand);
        commandInvoker.register("PLAY-PLAYLIST",playPlayListCommand);
        commandInvoker.register("MODIFY-PLAYLIST",modifyCommand);
        commandInvoker.register("LOAD-DATA",loadDataCommand);
        commandInvoker.register("PLAY-SONG", playSongCommand);
        return commandInvoker;
    }


}
