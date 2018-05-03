package ch.uzh.ifi.seal.soprafs18.Service;

import ch.uzh.ifi.seal.soprafs18.Constant.GameStatus;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Blockade;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Game;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Path;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Turns.BuyTurn;
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

    public List<Integer> getCurrent(String name){
        Game game =gameRepository.findByName(name);
        List<Integer> updates = new ArrayList<>();
        updates.add(game.getCurrent());
        updates.add(game.getMaxplayer());
        return updates;
    }

    public Game getOneGame(String room){
        Game game = gameRepository.findByName(room);
        return game;
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
                game.getPlayers().get(0).setTurn(true);
                for (int i = 0; i < game.getMaxplayer(); i++) {
                    game.getPlayers().get(i).drawCards();
                }

            }
            gameRepository.save(game);

            return true;
        }


        return false;

    }

    public Player getCurrentPlayer(String room){
        Game game = gameRepository.findByName(room);
        return game.getCurrentPlayer();
    }


    public List<Blockade> getBlockade(String room){
        Game game = gameRepository.findByName(room);
        return game.getBlockades();
    }

    public Integer getCurrBottom(String room){
        Game game = gameRepository.findByName(room);
        return game.getMarket().currentBottomCards;
    }

    public void FastForward(String room){
        Game game = gameRepository.findByName(room);
        Player player = game.getCurrentPlayer();
        List<Card> selection = null;
        Card card = game.getMarket().wanted("TravelDiary");
        player.handcards.add(card);

        Card card2 = game.getMarket().wanted("Compass");
        player.handcards.add(card2);

        gameRepository.save(game);



    }
}
