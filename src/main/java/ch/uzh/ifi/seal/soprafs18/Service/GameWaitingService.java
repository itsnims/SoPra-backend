package ch.uzh.ifi.seal.soprafs18.Service;

import ch.uzh.ifi.seal.soprafs18.Entity.User;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Game;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import ch.uzh.ifi.seal.soprafs18.Repository.GameRepository;
import ch.uzh.ifi.seal.soprafs18.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameWaitingService {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private UserRepository userRepository;

    public List<User> getUser(String gamename) {
        List<User> users = new ArrayList<>();
        Game game = gameRepository.findByName(gamename);
        users = game.getUsers();
        return users;
    }

    public void leaveGame(String gamename, String username){
        Game game = gameRepository.findByName(gamename);
        User user =  userRepository.findByName(username);
        game.deleteUser(user);
        Game newgame = game;
        gameRepository.deleteByName(gamename);
        gameRepository.save(newgame);







    }

}
