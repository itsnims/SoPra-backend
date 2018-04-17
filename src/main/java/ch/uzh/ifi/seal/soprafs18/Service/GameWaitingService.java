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
        List<Player> users = new ArrayList<>();
        Game game = gameRepository.findByName(gamename);
        users = game.getPlayers();
        return users;
    }

    @Transactional
    public List<Player> leaveGame(String gamename, String username){
        Game game = gameRepository.findByName(gamename);
        Player player =  userRepository.findByName(username);
        List<Player> players = game.getPlayers();
        players.remove(player);
        gameRepository.save(game);

        return players;







    }

}
