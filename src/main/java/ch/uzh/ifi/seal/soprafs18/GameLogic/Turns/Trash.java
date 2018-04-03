package ch.uzh.ifi.seal.soprafs18.GameLogic.Turns;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Turn;

import java.util.List;

public class Trash implements Turn {

    List<Card> selectedCard;
    Player currentPlayer;

    public Trash(List<Card> selectedCard, Player currentPlayer) {
        this.currentPlayer= currentPlayer;
        this.selectedCard = selectedCard;
    }
    @Override
    public void turnfunction(){
        currentPlayer.trashpile.addAll(selectedCard);
        currentPlayer.handcards.removeAll(selectedCard);
    }
}
