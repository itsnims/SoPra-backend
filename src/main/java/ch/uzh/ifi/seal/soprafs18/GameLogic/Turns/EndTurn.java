package ch.uzh.ifi.seal.soprafs18.GameLogic.Turns;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Turn;

import java.util.List;

public class EndTurn implements Turn {

    Player currentPlayer;


    public EndTurn(Player currentPlayer) {
        this.currentPlayer=currentPlayer;
    }
    @Override
    public void turnfunction(){
        currentPlayer.setTurn(false);


        int listlen = currentPlayer.selection.size();

        for (int i = 0; i < listlen; i++){
            if(currentPlayer.selection.get(0).getReusable() == true){

                /** discards played cards if useable since we always trash the first card, the
                 * list gets always a step smaller, so throw away the new first card
                 * **/
                currentPlayer.discardpile.add(currentPlayer.selection.get(0));
                currentPlayer.selection.remove(0);
            }
            else{
                currentPlayer.trashpile.add(currentPlayer.selection.get(0));
                currentPlayer.selection.remove(0);
                /** throws away if one time use..
                 * **/
            }
        }

    }
}
