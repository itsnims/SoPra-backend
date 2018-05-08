package ch.uzh.ifi.seal.soprafs18.Service;

import ch.uzh.ifi.seal.soprafs18.Constant.CardWrapper;
import ch.uzh.ifi.seal.soprafs18.GameLogic.*;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Blockade;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.BoardPiece;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Field;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards.DrawActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ExpeditionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Turns.*;
import ch.uzh.ifi.seal.soprafs18.Repository.GameRepository;
import ch.uzh.ifi.seal.soprafs18.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
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

    public List<Card> Discard(String gamename,String playername,CardWrapper cards){
        List<String>  cardnames = cards.getCards();
        Game game = gameRepository.findByName(gamename);
        Player player = userRepository.findByName(playername);

        List<Card> tobediscared = new ArrayList<>();
        List<Card> copy = new ArrayList<>(player.handcards);

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

    public void Endturn(String gamename, String playername){
        Game game = gameRepository.findByName(gamename);
        Player player = userRepository.findByName(playername);
        int numRound = game.getRoundNum();
        EndTurn endTurn = new EndTurn(player);
        player.executeTurn(endTurn);
        Integer i = game.getPlayers().indexOf(player);
        game.getCurrentPlayer().drawCards();
        if(i == game.getMaxplayer()-1){
            i=-1;
            numRound = numRound + 1;
        }

        game.setCurrentPlayer(game.getPlayers().get(i+1));
        gameRepository.save(game);


    }

    public List<BoardPiece> GetPossibleFields(String gamename,String playername,String cardname){
        List<BoardPiece> options;
        Game game = gameRepository.findByName(gamename);
        Player player = userRepository.findByName(playername);
        List<Field> gamePath= game.getGamePath().getStandardPathFields();

        Field currentPosition = player.getMyFigure().getCurrentPosition();
        Field actual = new Field();

        for (int i = 0; i < gamePath.size(); i++){
            if(gamePath.get(i).getName().equals(currentPosition.getName())){
                actual = gamePath.get(i);
            }
        }

        ExpeditionCard Card = (ExpeditionCard) player.getWantedCard(cardname);
       
        System.out.println(actual.getNeighbours());
        options = actual.getAll(Card.getCardColour(),Card.getCardStrenght(),actual);
        System.out.println(options);
        gameRepository.save(game);

        return options;
    }

    public void crossBlockade(String gamename,String playername){
        Game game = gameRepository.findByName(gamename);
        Player player = userRepository.findByName(playername);
        List<Blockade> blockadeList = game.getBlockades();

        List<Field> newp = new ArrayList<>();


        List<Field> gamePath= game.getGamePath().getStandardPathFields();

        newp.add(gamePath.get(0));
        newp.add(gamePath.get(1));
        newp.add(gamePath.get(2));
        StandardPath eh = new StandardPath();
        eh.setStandardPathFields(newp);

        game.setGamePath(eh);
        game.getGamePath().setStandardPathFields(null);

        gameRepository.save(game);




    }


    public Field moveFigure(String gamename,String playername,String card, String fieldtomove){
        Field newposition = new Field();
        Game game = gameRepository.findByName(gamename);
        Player player = userRepository.findByName(playername);
        Card cardused = player.getWantedCard(card);
        List<Field> gamePath= game.getGamePath().getStandardPathFields();
        Figure playerFigure= player.getMyFigure();
        List<Blockade> blockadeList = game.getBlockades();
        Blockade blockade;

        Field currentPosition = player.getMyFigure().getCurrentPosition();
        Field actual = new Field();

        for (int i = 0; i < gamePath.size(); i++){
            if(gamePath.get(i).getName().equals(currentPosition.getName())){
                actual = gamePath.get(i);
                System.out.println(actual.getName());
                System.out.println(i);
            }
        }

        for(int i = 0; i < blockadeList.size(); i++){
            if(fieldtomove.equals(blockadeList.get(i).getName())){
                if(i == 0){
                    gamePath.indexOf(actual);
                    gamePath.remove(actual);
                    blockade = blockadeList.get(0);
                    blockade.BlockadeCross(true);
                    actual.getNeighbours().remove(blockade);
                    System.out.println("update pos");
                    System.out.print(actual.getNeighbours());
                    gamePath.add(actual);
                    System.out.println("gamepath neighbour");
                    System.out.println(gamePath.get(187).getNeighbours());
                    System.out.println("gamepath");

                    player.myFigure.setCurrentPosition(actual);
                    System.out.println("Players neighbout");
                    System.out.println(player.getMyFigure().getCurrentPosition().getNeighbours());
                    System.out.println(player.getMyFigure().getCurrentPosition().getName());

                    gameRepository.save(game);

                    return null;

                }
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
        player.selection.add(cardused);
        player.handcards.remove(cardused);
        gameRepository.save(game);

        return playerFigure.getCurrentPosition();
    }

    /** Blockade remove function and give points if newposition=Blockade**/

    public Market getCurrentMarket(String room){
        Game game = gameRepository.findByName(room);
        return game.getMarket();

    }


    public Player buyCard(String room, String player, String cardname, CardWrapper cards){
        List<String> cardnames = cards.getCards();
        Game game = gameRepository.findByName(room);
        Player buyer = userRepository.findByName(player);
        Card card = game.getMarket().wanted(cardname);
        List<Card> money = new ArrayList<>();
        List<Card> cards1 = new ArrayList<>(buyer.handcards);


        outerloop:
        for (int i = 0; i < cardnames.size(); i++){
            for (int j = 0; j < cards1.size(); j++){
                if(cardnames.get(i).equals(cards1.get(j).getName())){
                    money.add(cards1.get(j));
                    cards1.remove(j);
                    System.out.println(money);
                    continue outerloop;
                }

            }
        }

        BuyTurn buyTurn = new BuyTurn(money,buyer);
        if (buyTurn.enoughmoney() >= card.getPrice()){
            buyTurn.setMarket(game.getMarket());
            buyTurn.getCardtoBuy(card);
            buyTurn.turnfunction();
        }


        gameRepository.save(game);

        return buyer;



    }

    public List<Card> getCurrenthandCards(String room, String player){
        Game game = gameRepository.findByName(room);
        Player current = userRepository.findByName(player);
        gameRepository.save(game);
        return current.handcards;

    }


    public Player isGameWon(String room){
        Game game= gameRepository.findByName(room);
        EndGameManager endGameManager = new EndGameManager(game);
        if(endGameManager.CheckifReached()){
            Player winner = endGameManager.getWinner();
            return winner;
        }

        return null;
    }

    public void DrawActionCard(String room, String player, String card){
        Game game = gameRepository.findByName(room);
        Player current = userRepository.findByName(player);
        Object cardwanted = current.getWantedCard(card);
        DrawActionCard draw = (DrawActionCard) cardwanted;

        PlayActionCard playActionCard = new PlayActionCard(draw,current);
        playActionCard.turnfunction();

        gameRepository.save(game);


    }

    public List<BoardPiece> MoveActionCard(String room, String player){
        Game game = gameRepository.findByName(room);
        Player current = userRepository.findByName(player);
        List<Field> gamePath = game.getGamePath().getStandardPathFields();
        List<BoardPiece> options = new ArrayList<>();

        Field currentPosition = current.getMyFigure().getCurrentPosition();
        Field actual = new Field();

        for (int i = 0; i < gamePath.size(); i++){
            if(gamePath.get(i).getName().equals(currentPosition.getName())){
                actual = gamePath.get(i);

            }
        }



        for (int i = 0; i < actual.getNeighbours().size(); i++){


            if( actual.getNeighbours().get(i) instanceof Blockade){
                options.add(actual.getNeighbours().get(i));
            }

            if(actual.getNeighbours().get(i) instanceof Field && ((Field) actual.getNeighbours().get(i)).getAccessable() && ((Field) actual.getNeighbours().get(i)).getStrenght() != 0){
                options.add(actual.getNeighbours().get(i));
            }


        }

        return options;

    }

    public void MarketActionCard(String room, String player, String usedcard, String marketCard){
        Game game = gameRepository.findByName(room);
        Player current = userRepository.findByName(player);
        Card cardWanted = current.getWantedCard(usedcard);
        current.selection.add(cardWanted);
        current.handcards.remove(cardWanted);

        Card card = game.getMarket().wanted(marketCard);


        if (game.getMarket().getUpperdict().get(marketCard) != 0){
            System.out.println("Here");
            game.getMarket().getUpperdict().put(card.getName(),game.getMarket().getUpperdict().get(card.getName())-1);

        }
        else
        {
            game.getMarket().getBottomdict().put(card.getName(),game.getMarket().getBottomdict().get(card.getName())-1);

        }

        current.discardpile.add(card);
        gameRepository.save(game);


    }

    public void swapdap(String gamen){
        Game game = gameRepository.findByName(gamen);
        StandardPath path = game.getGamePath();
        List<Field> org = path.getStandardPathFields();
        List<Field> news = new ArrayList<>();
        news.add(org.get(0));
        news.add(org.get(0));
        news.add(org.get(0));
        news.add(org.get(0));

        path.setStandardPathFields(news);

        game.setGamePath(path);
        gameRepository.save(game);
    }









}


