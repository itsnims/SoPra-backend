package ch.uzh.ifi.seal.soprafs18.GameLogic.Turns;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Turn;

import java.util.List;

public class DiscardCard implements Turn {

    List<Card> selectedCards;
    Player currentPlayer;

    public DiscardCard(List<Card> selection, Player currentPlayer){
        this.selectedCards = selection;
        this.currentPlayer=currentPlayer;
    }
    @Override
    public void turnfunction(){
        currentPlayer.discardpile.addAll(selectedCards);
        currentPlayer.handcards.removeAll(selectedCards);

    }
}