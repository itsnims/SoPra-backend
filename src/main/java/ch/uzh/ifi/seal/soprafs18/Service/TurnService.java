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

        if(player.getDiscard() != 0){
            player.setDiscard(0);
        }

        DiscardCard discardCard = new DiscardCard(tobediscared,player);
        player.executeTurn(discardCard);
        gameRepository.save(game);
        return player.handcards;
    }


    public List<Card> Trash(String gamename, String playername, CardWrapper cards){
        List<String>  cardnames = cards.getCards();
        Game game = gameRepository.findByName(gamename);
        Player player = userRepository.findByName(playername);
        List<Card> tobetrashed = new ArrayList<>();
        List<Card> copy = new ArrayList<>(player.handcards);

        outerloop:
        for (int i = 0; i < cardnames.size(); i ++){
            for (int j = 0; j < copy.size(); j++){
                if (cardnames.get(i).equals(copy.get(j).getName())){
                    tobetrashed.add(copy.get(j));
                    copy.remove(j);
                    continue outerloop;
                }
            }
        }
        if(player.getTrash() != 0){
            player.setTrash(0);
        }
        Trash trash = new Trash(tobetrashed,player);
        player.executeTurn(trash);
        gameRepository.save(game);
        return player.handcards;

    }

    public void Endturn(String gamename, String playername){
        Game game = gameRepository.findByName(gamename);
        Player player = userRepository.findByName(playername);
        EndTurn endTurn = new EndTurn(player);
        player.executeTurn(endTurn);
        Integer i = game.getPlayers().indexOf(player);
        game.getCurrentPlayer().drawCards();
        if(i == game.getMaxplayer()-1){
            EndGameManager endGameManager = new EndGameManager(game);
            Boolean reached = endGameManager.checkifReached();
            if(reached){
                System.out.println("reached endturn");
                endGameManager.getWinner();
            }
            i=-1;

        }

        game.setCurrentPlayer(game.getPlayers().get(i+1));
        gameRepository.save(game);


    }

    public List<BoardPiece> GetPossibleFields(String gamename,String playername,String cardname){
        List<BoardPiece> options;
        Game game = gameRepository.findByName(gamename);
        Player player = userRepository.findByName(playername);
        //List<Field> gamePath= game.getGamePath().getStandardPathFields();

         String pathname = game.getPathname();
         List<Field> gamePath= game.getGamePath().getCurrentPath(pathname);


        Field currentPosition = player.getMyFigure().getCurrentPosition();
        Field actual = new Field();

        for (int i = 0; i < gamePath.size(); i++){
            if(gamePath.get(i).getName().equals(currentPosition.getName())){
                actual = gamePath.get(i);
            }
        }

        ExpeditionCard Card = (ExpeditionCard) player.getWantedCard(cardname);
       
        System.out.println(actual.getNeighbours());
        options = actual.getAll(Card.getCardColour(),Card.getCardStrenght(),player.handcards.size(),actual);
        System.out.println(options);
        gameRepository.save(game);

        return options;
    }

    public List<BoardPiece> getPossibleFieldsTwoPlayerMode(String gamename, String playername, String cardname, String figure){
        Game game = gameRepository.findByName(gamename);
        Player player = userRepository.findByName(playername);

        Figure actualFig = new Figure();
        List<Figure> figList= player.getMyFigures();
        for (int i=0; i < figList.size();i++){
            if (figList.get(0).getName().equals(figure)){
                actualFig = figList.get(0);
            } else if (figList.get(1).getName().equals(figure)) {
                actualFig = figList.get(1);
            }
        }

        String pathname = game.getPathname();
        List<Field> gamePath= game.getGamePath().getCurrentPath(pathname);

        List<BoardPiece> options;
        Field currentPosition = actualFig.getCurrentPosition();
        Field actual = new Field();
        for (int i = 0; i < gamePath.size(); i++){
            if(gamePath.get(i).getName().equals(currentPosition.getName())){
                actual = gamePath.get(i);
            }
        }
        ExpeditionCard Card = (ExpeditionCard) player.getWantedCard(cardname);

        System.out.println(actual.getNeighbours());
        options = actual.getAll(Card.getCardColour(),Card.getCardStrenght(),player.handcards.size()-1,actual);
        System.out.println(options);
        gameRepository.save(game);

        return options;

    }


    /**
     * Blockade remove function and give points if newposition=Blockade
     **/
    public void crossBlockade(String gamename, String playername, String cardname) {
        Game game = gameRepository.findByName(gamename);
        Player player = userRepository.findByName(playername);

        Integer counter = game.getBlockcount();
        game.setBlockcount(counter+1);


        Blockade nextBlockade = game.getGamePath().removeBlockade(game.getPathname(),counter + 1);

        if(nextBlockade.getColor().equals("Camp")){
            player.setTrash(nextBlockade.getStrenght());
        }

        if(nextBlockade.getColor().equals("White")){
            player.setDiscard(nextBlockade.getStrenght());
        }

        nextBlockade.givePoints(player);
        nextBlockade.setCrossed();


        ExpeditionCard Card = (ExpeditionCard) player.getWantedCard(cardname);
        player.selection.add(Card);
        player.handcards.remove(Card);



        gameRepository.save(game);


    }


    public Field moveFigure(String gamename,String playername,String card, String fieldtomove){
        Field newposition = new Field();
        Game game = gameRepository.findByName(gamename);
        Player player = userRepository.findByName(playername);
        Card cardused = player.getWantedCard(card);
        List<Field> gamePath = game.getGamePath().getCurrentPath(game.getPathname());


        Figure playerFigure= player.getMyFigure();


        Field currentPosition = player.getMyFigure().getCurrentPosition();
        Field actual = new Field();

        for (int i = 0; i < gamePath.size(); i++){
            if(gamePath.get(i).getName().equals(currentPosition.getName())){
                actual = gamePath.get(i);
                System.out.println(actual.getName());
                System.out.println(i);
            }
        }


        for (int i = 0; i < gamePath.size(); i++){
            if(gamePath.get(i).getName().equals(fieldtomove)){
                newposition = gamePath.get(i);
            }
        }

        newposition.setAccessable(false);
        playerFigure.setCurrentPosition(newposition);


        if(newposition.getName().equals("EDBlue1")){
            game.getWinners().add(player);
            newposition.setAccessable(true);
        }
        if(newposition.getName().equals("EDBlue2")){
            game.getWinners().add(player);
            newposition.setAccessable(true);
        }
        if(newposition.getName().equals("EDBlue3")){
            game.getWinners().add(player);
            newposition.setAccessable(true);
        }

        if(newposition.getName().equals("EDGreen1")){
            game.getWinners().add(player);
            newposition.setAccessable(true);
        }
        if(newposition.getName().equals("EDGreen2")){
            game.getWinners().add(player);
            newposition.setAccessable(true);
        }
        if(newposition.getName().equals("EDGreen3")){
            game.getWinners().add(player);
            newposition.setAccessable(true);
        }




        actual.setAccessable(true);
        player.selection.add(cardused);
        player.handcards.remove(cardused);

        if(player.getMyFigure().getCurrentPosition().getColor().equals("Camp")){
            player.setTrash(player.getMyFigure().getCurrentPosition().getStrenght());
        }
        if(player.getMyFigure().getCurrentPosition().getColor().equals("White")){
            player.setDiscard(player.getMyFigure().getCurrentPosition().getStrenght());
        }
        gameRepository.save(game);

        return playerFigure.getCurrentPosition();
    }




    public Field moveFigureTwoPlayerMode(String gamename,String playername,String card, String fieldtomove,String figure){
        Field newposition = new Field();
        Game game = gameRepository.findByName(gamename);
        Player player = userRepository.findByName(playername);
        Card cardused = player.getWantedCard(card);
        //List<Field> gamePath = game.getGamePath().getStandardPathFields();
        List<Field> gamePath = game.getGamePath().getCurrentPath(game.getPathname());


        Figure actualFig = new Figure();
        List<Figure> figList= player.getMyFigures();
        for (int i=0; i < figList.size();i++){
            if (figList.get(0).getName().equals(figure)){
                actualFig = figList.get(0);
            } else if (figList.get(1).getName().equals(figure)) {
                actualFig = figList.get(1);
            }
        }


        Field currentPosition = actualFig.getCurrentPosition();
        Field actual = new Field();

        for (int i = 0; i < gamePath.size(); i++){
            if(gamePath.get(i).getName().equals(currentPosition.getName())){
                actual = gamePath.get(i);

            }
        }

        System.out.println("the current position is" + actual.getName());


        for (int i = 0; i < gamePath.size(); i++){
            if(gamePath.get(i).getName().equals(fieldtomove)){
                newposition = gamePath.get(i);
            }
        }

        System.out.println("the wanted position" + actual.getName());

        newposition.setAccessable(false);
        actualFig.setCurrentPosition(newposition);

        if(newposition.getName().equals("Camp")) {
            int cardstotrash = newposition.getStrenght();
            if (actual.getNeighbours().contains(newposition)) {
                int cardtotrash = newposition.getStrenght();
                if (cardstotrash > 1) {
                    player.setTrash(cardstotrash - 1);

                }
                player.addtoTrash(cardused);
                player.handcards.remove(cardused);

            }
            else{
                player.setTrash(newposition.getStrenght());
            }

        }

        if(newposition.getName().equals("White")) {
            int cardstodiscard = newposition.getStrenght();
            if (actual.getNeighbours().contains(newposition)) {
                int cardtotrash = newposition.getStrenght();
                if (cardstodiscard > 1) {
                    player.setTrash(cardstodiscard - 1);

                }
                player.discardpile.add(cardused);
                player.handcards.remove(cardused);

            }
            else{
                player.setDiscard(newposition.getStrenght());
            }

        }

        else{
            player.selection.add(cardused);
            player.handcards.remove(cardused);
        }





        if(newposition.getName().equals("EDBlue1")){
            if (game.getWinners().contains(player)){
                newposition.setAccessable(true);
            }else { game.getWinners().add(player);
                newposition.setAccessable(true);}
        }
        if(newposition.getName().equals("EDBlue2")){
            if (game.getWinners().contains(player)){
                newposition.setAccessable(true);
            }else { game.getWinners().add(player);
                newposition.setAccessable(true);}
        }
        if(newposition.getName().equals("EDBlue3")){
            if (game.getWinners().contains(player)){
                newposition.setAccessable(true);
            }else { game.getWinners().add(player);
                newposition.setAccessable(true);}
        }

        if(newposition.getName().equals("EDGreen1")){
            if (game.getWinners().contains(player)){
                newposition.setAccessable(true);
            }else { game.getWinners().add(player);
                newposition.setAccessable(true);}
        }
        if(newposition.getName().equals("EDGreen2")){
            if (game.getWinners().contains(player)){
                    newposition.setAccessable(true);
            }else { game.getWinners().add(player);
            newposition.setAccessable(true);
        }}
        if(newposition.getName().equals("EDGreen3")){
            if (game.getWinners().contains(player)){
                newposition.setAccessable(true);
            }else { game.getWinners().add(player);
                newposition.setAccessable(true);}
        }

        actual.setAccessable(true);





        if(actualFig.getCurrentPosition().getColor().equals("White")){
            actualFig.getCurrentPosition().getStrenght();
        }
        gameRepository.save(game);

        return actualFig.getCurrentPosition();
    }



    /** Blockade remove function and give points if newposition=Blockade**/

    public Market getCurrentMarket(String room){
        Game game = gameRepository.findByName(room);
        return game.getMarket();

    }


    public boolean buyCard(String room, String player, String cardname, CardWrapper cards){
        List<String> cardnames = cards.getCards();
        Boolean worked = false;
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
            worked = true;
        }


        gameRepository.save(game);
        return worked;
    }

    public List<Card> getCurrenthandCards(String room, String player){
        Game game = gameRepository.findByName(room);
        Player current = userRepository.findByName(player);
        gameRepository.save(game);
        return current.handcards;

    }


    public Boolean isGameWon(String room){
        Game game= gameRepository.findByName(room);
        return game.isWon();

    }

    public Player Winner(String room){
        Game game= gameRepository.findByName(room);
        return game.getWinner();
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
        List<Field> gamePath = game.getGamePath().getCurrentPath(game.getPathname());
        List<BoardPiece> options = new ArrayList<>();

        Field currentPosition = current.getMyFigure().getCurrentPosition();
        Field actual = new Field();

        System.out.println(current);
        System.out.println(current.getMyFigure());
        System.out.println(currentPosition);
        System.out.println(gamePath);

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

    public List<BoardPiece> MoveActionCardTwoPlayerMode(String room, String player,String figure){
        Game game = gameRepository.findByName(room);
        Player current = userRepository.findByName(player);

        Figure actualFig = new Figure();
        List<Figure> figList= current.getMyFigures();
        for (int i=0; i < figList.size();i++){
            if (figList.get(0).getName().equals(figure)){
                actualFig = figList.get(0);
            } else if (figList.get(1).getName().equals(figure)) {
                actualFig = figList.get(1);
            }
        }

        List<Field> gamePath = game.getGamePath().getCurrentPath(game.getPathname());
        List<BoardPiece> options = new ArrayList<>();

        Field currentPosition = actualFig.getCurrentPosition();
        Field actual = new Field();

        System.out.println(current);
        System.out.println(current.getMyFigure());
        System.out.println(currentPosition);
        System.out.println(gamePath);

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



        if (game.getMarket().getUpperdict().get(marketCard) != null){
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

    public Integer HowManyTrash(String room,String field){
        Game game = gameRepository.findByName(room);
        List<Field> gamePath = game.getGamePath().getCurrentPath(game.getPathname());

        Field actual = new Field();
        for (int i = 0; i < gamePath.size(); i++){
            if(gamePath.get(i).getName().equals(field)){
                actual = gamePath.get(i);

            }
        }
        List<Integer> strings = new ArrayList<>();
        strings.add(actual.getStrenght());
        return actual.getStrenght();
    }











}


