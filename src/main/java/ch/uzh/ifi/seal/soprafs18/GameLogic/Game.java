package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> Players = new ArrayList<>(4);
    List<Card> TrashedCards = new ArrayList<>(80);

    public Game(){

    }

    public void addPlayer(Player player){
        Players.add(player);
    }



}
