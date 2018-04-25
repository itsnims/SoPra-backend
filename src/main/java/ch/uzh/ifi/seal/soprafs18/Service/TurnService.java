package ch.uzh.ifi.seal.soprafs18.Service;

import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Blockade;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.BoardPiece;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Field;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ExpeditionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Figure;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Game;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Market;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Turns.BuyTurn;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Turns.DiscardCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Turns.EndTurn;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Turns.Trash;
import ch.uzh.ifi.seal.soprafs18.Repository.GameRepository;
import ch.uzh.ifi.seal.soprafs18.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class TurnService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameRepository gameRepository;


    public List<Card> TurnSetup(String gamename, String playername){
        Game game = gameRepository.findByName(gamename);
        Player player = userRepository.findByName(playername);
        player.drawCards();
        player.setTurn(true);
        gameRepository.save(game);

        return player.handcards;


    }

    public List<Card> Discard(String gamename,String playername,List<String> cardnames){
        Game game = gameRepository.findByName(gamename);
        Player player = userRepository.findByName(playername);
        List<Card> tobediscared = new ArrayList<>();
        List<Card> copy = player.handcards;
        outerloop:
        for (int i = 0; i < cardnames.size(); i ++){
            for (int j = 0; j < copy.size(); j++){
                if (cardnames.get(i).equals(copy.get(j).getName())){
                    tobediscared.add(copy.get(j));
                    copy.remove(j);
                    continue outerloop;

                }
            }
        }
        DiscardCard discardCard = new DiscardCard(tobediscared,player);
        player.executeTurn(discardCard);
        gameRepository.save(game);
        return player.handcards;
    }


    public List<Card> Trash(String gamename, String playername, List<String> cardnames){
        Game game = gameRepository.findByName(gamename);
        Player player = userRepository.findByName(playername);
        List<Card> tobetrashed = new ArrayList<>();
        List<Card> copy = player.handcards;
        outerloop:
        for (int i = 0; i < cardnames.size(); i ++){
            for (int j = 0; j < copy.size(); j++){
                if (cardnames.get(i).equals(copy.get(j).getName())){
                    tobetrashed.add(copy.get(j));
                    continue outerloop;
                }
            }
        }
        Trash trash = new Trash(tobetrashed,player);
        player.executeTurn(trash);
        gameRepository.save(game);
        return player.handcards;

    }

    public List<Card> Endturn(String gamename, String playername){
        Game game = gameRepository.findByName(gamename);
        Player player = userRepository.findByName(playername);
        EndTurn endTurn = new EndTurn(player);
        player.executeTurn(endTurn);
        gameRepository.save(game);

        return player.drawpile;

    }

    public List<BoardPiece> GetPossibleFields(String gamename,String playername,String cardname){
        List<BoardPiece> options;
        Game game = gameRepository.findByName(gamename);
        Player player = userRepository.findByName(playername);
        List<Field> gamePath= game.getGamePath();

        Field currentPosition = player.getMyFigure().getCurrentPosition();
        Field actual = new Field();

        for (int i = 0; i < gamePath.size(); i++){
            if(gamePath.get(i).getName().equals(currentPosition.getName())){
                actual = gamePath.get(i);
            }
        }

        ExpeditionCard Card = (ExpeditionCard) player.getWantedCard(cardname);
        options = actual.getAll(Card.getCardColour(),Card.getCardStrenght(),actual);


        return options;
    }


    public Field moveFigure(String gamename,String playername, String fieldtomove){
        Field newposition = new Field();
        Game game = gameRepository.findByName(gamename);
        Player player = userRepository.findByName(playername);
        List<Field> gamePath= game.getGamePath();
        Figure playerFigure= player.getMyFigure();



        Field currentPosition = player.getMyFigure().getCurrentPosition();
        Field actual = new Field();

        for (int i = 0; i < gamePath.size(); i++){
            if(gamePath.get(i).getName().equals(currentPosition.getName())){
                actual = gamePath.get(i);
            }
        }


        for (int i = 0; i < gamePath.size(); i++){
            if(gamePath.get(i).getName().equals(fieldtomove)){
                newposition = gamePath.get(i);
            }
        }

        playerFigure.setCurrentPosition(newposition);
        newposition.setAccessable(false);
        actual.setAccessable(true);
        gameRepository.save(game);

        return playerFigure.getCurrentPosition();
    }

    /** Blockade remove function and give points if newposition=Blockade**/

    public Market getCurrentMarket(String room){
        Game game = gameRepository.findByName(room);
        return game.getMarket();

    }


    public Player buyCard(String room, String player, String cardname, List<String> cardnames){
        Game game = gameRepository.findByName(room);
        Player buyer = userRepository.findByName(player);
        Card card = game.getMarket().wanted(cardname);
        System.out.println(game.getMarket().MarketBottom);
        System.out.println(card);
        List<Card> money = new ArrayList<>();

        outerloop:
        for (int i = 0; i < cardnames.size(); i++){
            for (int j = 0; j < buyer.handcards.size(); j++){
                if(cardnames.get(i).equals(buyer.handcards.get(j).getName())){
                    money.add(buyer.handcards.get(j));
                    continue outerloop;
                }

            }
        }

        System.out.println(card.getPrice());


        BuyTurn buyTurn = new BuyTurn(money,buyer);
        if (buyTurn.enoughmoney() <= card.getPrice()){
            buyTurn.setMarket(game.getMarket());
            buyTurn.getCardtoBuy(card);
            buyTurn.turnfunction();
        }


        gameRepository.save(game);

        return buyer;



    }





}


