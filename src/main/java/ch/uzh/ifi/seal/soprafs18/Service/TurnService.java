package ch.uzh.ifi.seal.soprafs18.Service;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Game;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Turns.DiscardCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Turns.EndTurn;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Turns.Trash;
import ch.uzh.ifi.seal.soprafs18.Repository.GameRepository;
import ch.uzh.ifi.seal.soprafs18.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        outerloop:
        for (int i = 0; i < cardnames.size(); i ++){
            for (int j = 0; j < player.handcards.size(); j++){
                if (cardnames.get(i).equals(player.handcards.get(j).getName())){
                    tobediscared.add(player.handcards.get(j));
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
        outerloop:
        for (int i = 0; i < cardnames.size(); i ++){
            for (int j = 0; j < player.handcards.size(); j++){
                if (cardnames.get(i).equals(player.handcards.get(j).getName())){
                    tobetrashed.add(player.handcards.get(j));
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
}
