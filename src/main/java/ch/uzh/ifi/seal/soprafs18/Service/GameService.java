package ch.uzh.ifi.seal.soprafs18.Service;

import ch.uzh.ifi.seal.soprafs18.Constant.GameStatus;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Blockade;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Field;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Game;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import ch.uzh.ifi.seal.soprafs18.GameLogic.StandardPath;
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

    public List<Integer> getCurrent(String name) {
        Game game = gameRepository.findByName(name);
        List<Integer> updates = new ArrayList<>();
        updates.add(game.getCurrent());
        updates.add(game.getMaxplayer());
        return updates;
    }

    public Game getOneGame(String room) {
        Game game = gameRepository.findByName(room);
        return game;
    }

    public void addGame(Game game) {
        String ownername = game.getOwner();
        Player owner = userRepository.findByName(ownername);
        game.addUser(owner);
        game.setGameStatus(GameStatus.WAITING);
        gameRepository.save(game);
    }

    public void deleteGame(String gamename) {
        gameRepository.deleteByName(gamename);
    }

    public Boolean joinGame(String gamename, String username, String password) {
        Game game = gameRepository.findByName(gamename);
        Player player = userRepository.findByName(username);
        if ((game.getCurrent() < game.getMaxplayer() && game.getProtection().equals(false)) || (game.getCurrent() < game.getMaxplayer() && game.getPassword().equals(password))) {
            game.addUser(player);


            if (game.getPlayers().size() == game.getMaxplayer()) {
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

    public Player getCurrentPlayer(String room) {
        Game game = gameRepository.findByName(room);
        return game.getCurrentPlayer();
    }


    public List<Blockade> getBlockade(String room) {
        Game game = gameRepository.findByName(room);
        return game.getBlockades();
    }

    public List<Blockade> getCurrBlockade(String room) {
        Game game = gameRepository.findByName(room);
        return game.getGamePath().getRemovalList();
    }

    public Integer getCurrBottom(String room) {
        Game game = gameRepository.findByName(room);
        return game.getMarket().currentBottomCards;
    }

    public void FastForward(String room) {
        Game game = gameRepository.findByName(room);
        Player player = game.getCurrentPlayer();
        List<Card> selection = null;
        Card card = game.getMarket().wanted("TravelDiary");
        player.handcards.add(card);

        Card card2 = game.getMarket().wanted("Compass");
        player.handcards.add(card2);

        Card card3 = game.getMarket().wanted("Transmitter");
        player.handcards.add(card3);

        Card card4 = game.getMarket().wanted("Natives");
        player.handcards.add(card4);

        Card card5 = game.getMarket().wanted("Scout");
        player.handcards.add(card5);



        Field currentPosition = player.getMyFigures().get(0).getCurrentPosition();
        Field actual = new Field();
        Field newposition = new Field();

        List<Field> gamePath = game.getGamePath().getCurrentPath(game.getPathname());

        for (int i = 0; i < gamePath.size(); i++){
            if(gamePath.get(i).getName().equals(currentPosition.getName())){
                actual = gamePath.get(i);

            }
        }

        System.out.println("the current position is" + actual.getName());


        for (int i = 0; i < gamePath.size(); i++){
            if(gamePath.get(i).getName().equals("E29")){
                newposition = gamePath.get(i);
            }
        }

        System.out.println("the wanted position" + actual.getName());

        newposition.setAccessable(false);
        player.getMyFigures().get(0).setCurrentPosition(newposition);


        gameRepository.save(game);


    }

    public void FastForwardClara(String room) {
        Game game = gameRepository.findByName(room);
        Player player = game.getCurrentPlayer();
        Card card = game.getMarket().wanted("Natives");
        player.handcards.add(card);

        Card card2 = game.getMarket().wanted("Sailor");
        player.handcards.add(card2);

        Card card3 = game.getMarket().wanted("Pioneer");
        player.handcards.add(card3);

        Card card5 = game.getMarket().wanted("Scout");
        player.handcards.add(card5);
        gameRepository.save(game);

    }

    public void FastForwardSecond(String room) {
        Game game = gameRepository.findByName(room);
        Player player = game.getCurrentPlayer();
        List<Card> selection = null;
        Card card = game.getMarket().wanted("Allrounder");
        player.handcards.add(card);

        Card card2 = game.getMarket().wanted("Sailor");
        player.handcards.add(card2);

        Card card3 = game.getMarket().wanted("Pioneer");
        player.handcards.add(card3);

        Card card5 = game.getMarket().wanted("Scout");
        player.handcards.add(card5);



        Field currentPositionOne = player.getMyFigures().get(0).getCurrentPosition();
        Field currentPositionTwo = player.getMyFigures().get(1).getCurrentPosition();
        Field actualOne = new Field();
        Field actualTwo = new Field();
        Field newOne = new Field();
        Field newTwo = new Field();

        List<Field> gamePath = game.getGamePath().getCurrentPath(game.getPathname());

        for (int i = 0; i < gamePath.size(); i++){
            if(gamePath.get(i).getName().equals(currentPositionOne.getName())){
                actualOne = gamePath.get(i);

            }
        }

        System.out.println("the current position of One is" + actualOne.getName());

        for (int i = 0; i < gamePath.size(); i++){
            if(gamePath.get(i).getName().equals("M34")){
                newOne = gamePath.get(i);

            }
        }


        for (int i = 0; i < gamePath.size(); i++){
            if(gamePath.get(i).getName().equals(currentPositionTwo.getName())){
                actualTwo = gamePath.get(i);
            }
        }

        System.out.println("the current position of Two is" + actualTwo.getName());

        for (int i = 0; i < gamePath.size(); i++){
            if(gamePath.get(i).getName().equals("M35")){
                newTwo= gamePath.get(i);

            }
        }

        newOne.setAccessable(false);
        newTwo.setAccessable(false);
        player.getMyFigures().get(0).setCurrentPosition(newOne);
        player.getMyFigures().get(1).setCurrentPosition(newTwo);


        gameRepository.save(game);


    }

    public Integer getPoints(String gamen, String user) {
        Game game = gameRepository.findByName(gamen);
        Player player = userRepository.findByName(user);

        Integer points = player.getBlockadePoints();
        gameRepository.save(game);
        return points;
    }



    public Integer getTrash(String room, String user){
        Game game = gameRepository.findByName(room);
        Player player = userRepository.findByName(user);
        gameRepository.save(game);
        return player.getTrash();

    }

    public Integer getDiscard(String room, String user) {
        Game game = gameRepository.findByName(room);
        Player player = userRepository.findByName(user);
        gameRepository.save(game);
        return player.getDiscard();
    }




}
