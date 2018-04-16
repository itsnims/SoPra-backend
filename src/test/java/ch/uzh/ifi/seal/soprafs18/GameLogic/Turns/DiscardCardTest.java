package ch.uzh.ifi.seal.soprafs18.GameLogic.Turns;

import ch.uzh.ifi.seal.soprafs18.Constant.PlayerColor;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DiscardCardTest {
    Player nimra = new Player();
    List<Card> selected = new ArrayList<>();

    @Test
    public void turnfunction() {
        nimra.setPlayerColor(PlayerColor.values()[1]);
        nimra.drawCards();
        selected.add(nimra.handcards.get(0));
        selected.add(nimra.handcards.get(2));
        selected.add(nimra.handcards.get(3));
        DiscardCard discardtest = new DiscardCard(selected,nimra);
        discardtest.turnfunction();
        Assert.assertEquals(selected,nimra.discardpile);


    }
}