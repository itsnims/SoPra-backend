package ch.uzh.ifi.seal.soprafs18.GameLogic.Turns;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ExpeditionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndTurnTest {
    Player nimra = new Player("Green");
    ExpeditionCard trashcard = new ExpeditionCard("test","test",false,1,1);


    @Test
    public void turnfunction() {
        nimra.drawCards();
        nimra.selection.addAll(nimra.handcards);
        nimra.selection.add(trashcard);
        EndTurn endTurn = new EndTurn(nimra);
        endTurn.turnfunction();
        Assert.assertEquals(5,nimra.discardpile.size()+nimra.trashpile.size());

    }
}