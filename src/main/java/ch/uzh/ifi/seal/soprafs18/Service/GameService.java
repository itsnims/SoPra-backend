package ch.uzh.ifi.seal.soprafs18.Service;

import ch.uzh.ifi.seal.soprafs18.Constant.GameStatus;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Game;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import ch.uzh.ifi.seal.soprafs18.Repository.GameRepository;
import ch.uzh.ifi.seal.soprafs18.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Game> getGames() {
        List<Game> games = new ArrayList<>();
        gameRepository.findAll().forEach(games::add);
        return games;
    }

    public void addGame(Game game){
        String ownername = game.getOwner();
        Player owner =userRepository.findByName(ownername);
        game.addUser(owner);
        game.setGameStatus(GameStatus.WAITING);
        gameRepository.save(game);
    }

    public void deleteGame(String gamename){
        gameRepository.deleteByName(gamename);
    }

    public Boolean joinGame(String gamename, String username,String password){
        Game game = gameRepository.findByName(gamename);
        Player player =  userRepository.findByName(username);
        if ((game.getCurrent() < game.getMaxplayer() && game.getProtection().equals(false)) || (game.getCurrent() < game.getMaxplayer() && game.getPassword().equals(password))){
            game.addUser(player);


            if( game.getPlayers().size() == game.getMaxplayer()){
                game.setGameStatus(GameStatus.STARTING);
                game.gameSetup();

            }
            gameRepository.save(game);

            return true;
        }


        return false;

    }
}
