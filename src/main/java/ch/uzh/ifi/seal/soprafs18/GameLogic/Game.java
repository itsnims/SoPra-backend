package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.ElDorado;


import java.util.ArrayList;
import java.util.List;

public class Game {
    public List<Player> Players = new ArrayList<>(4);
    public int roundNum=0;
    private int i;
    private EndGameManager endGameManager= new EndGameManager();
    private  Player winner;


    public Game(){

        /** do gamesetup here... **/

    }

    public void addPlayer(Player player){ Players.add(player); }

    public Player round(){
        while(!endGameManager.CheckifReached()) {

            for (i = 0; i < Players.size(); i++) {
                Players.get(i).setTurn(true);
                while (Players.get(i).getTurn() && Players.get(i).handcards.size() > 0) {
                    /**Turn choice = get user input of what his choice is--
                     Players.get(i).executeTurn(choice); **/
                }

            }
            roundNum = roundNum + 1;

        }
        winner = endGameManager.getWinner();
        return winner;

    }



    public int getRoundNum(){
        return roundNum;
    }



    public int getNumFigures(){
        return Players.size();
    }

}
