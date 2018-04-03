package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;


import java.util.ArrayList;
import java.util.List;

public class Game {
    public List<Player> Players = new ArrayList<>(4);
    public List<Card> TrashedCards = new ArrayList<>(80);
    public Market GameMarket = new Market();

    public Game(){

    }

    public void addPlayer(Player player){
        Players.add(player);
    }

    public void round(){

    }




}
