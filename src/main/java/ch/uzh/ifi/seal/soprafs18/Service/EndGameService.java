package ch.uzh.ifi.seal.soprafs18.Service;

import ch.uzh.ifi.seal.soprafs18.GameLogic.EndGameManager;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Game;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import ch.uzh.ifi.seal.soprafs18.Repository.GameRepository;
import ch.uzh.ifi.seal.soprafs18.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EndGameService {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private UserRepository userRepository;

    public boolean endgame(String gamename){
        Game game = gameRepository.findByName(gamename);
        Boolean reached = new EndGameManager().CheckifReached();
        return reached;
    }

    public Player getWinner(String gamename){
        Game game = gameRepository.findByName(gamename);
        Player winner = new EndGameManager().getWinner();
        return winner;
    }


}
