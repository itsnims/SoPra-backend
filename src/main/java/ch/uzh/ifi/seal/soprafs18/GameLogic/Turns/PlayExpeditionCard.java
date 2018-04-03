package ch.uzh.ifi.seal.soprafs18.GameLogic.Turns;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ExpeditionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Turn;

import java.util.List;

public class PlayExpeditionCard implements Turn {

    List<ExpeditionCard> selectedCard;
    Player currentPlayer;

    public PlayExpeditionCard(List<ExpeditionCard> selectedCard, Player currentPlayer) {
        this.selectedCard=selectedCard;
        this.currentPlayer=currentPlayer;


    }

    @Override
    public void turnfunction() {
        currentPlayer.selection.addAll(selectedCard);
        currentPlayer.handcards.removeAll(selectedCard);


    }
}
