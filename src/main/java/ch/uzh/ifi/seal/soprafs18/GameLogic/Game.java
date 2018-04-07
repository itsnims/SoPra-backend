package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.ElDorado;


import java.util.ArrayList;
import java.util.List;

public class Game {
    public List<Player> Players = new ArrayList<>(4);
    public List<Card> TrashedCards = new ArrayList<>(80);
    public Market GameMarket = new Market();
    public ElDorado elDorado =new ElDorado();
    public int roundNum=0;
    public Player Winner;
    public List<Player> Winners = new ArrayList<>(4);
    private int i, j;
    private Player k;

    public Game(){

    }

    public void addPlayer(Player player){ Players.add(player); }

    public void round(){
        for(i=0;i<Players.size();i++){
            /** Players[i].execute...? turn of player */
        }
        if(elDorado.isReached()){
            if (Winners.size() == 1) {
                Winner = Winners.get(0);
            } else if (Winners.size() > 1) {
                k= Winners.get(0);
                for(j=0;j<Winners.size();j++){
                    if(k.getBlockadePoints()< Winners.get(j).getBlockadePoints()){
                        k= Winners.get(j);
                    }
                }
            }
        }
        roundNum=roundNum+1;

    }

    public int getRoundNum() { return roundNum; }

    public void Win(Player player) { Winners.add(player); }

    public int getNumFigures() { return Players.size(); }

}
