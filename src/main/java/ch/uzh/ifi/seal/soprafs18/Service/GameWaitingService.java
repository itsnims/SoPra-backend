package ch.uzh.ifi.seal.soprafs18.Service;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Game;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import ch.uzh.ifi.seal.soprafs18.Repository.GameRepository;
import ch.uzh.ifi.seal.soprafs18.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class GameWaitingService {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Player> getUser(String gamename) {
        List<Player> users;
        Game game = gameRepository.findByName(gamename);
        users = game.getPlayers();
        return users;
    }

    public List<Player> leavegame(String gamen, String user) {
        Game game = gameRepository.findByName(gamen);
        Player player = userRepository.findByName(user);
        List<Player> playerList = game.getPlayers();
        if(playerList.size() == 1){
            game.deletePlayer(player);
            game.setOwner(null);
            gameRepository.deleteByName(gamen);
        }

        if(playerList.size() > 1 && player.getName().equals(game.getOwner())){
            game.setOwner(playerList.get(1).getName());
            game.deletePlayer(player);
        }

        if(playerList.size() >1 && !(player.getName().equals(game.getOwner()))){
            game.deletePlayer(player);
        }

        gameRepository.save(game);
        return game.getPlayers();



    }








}
