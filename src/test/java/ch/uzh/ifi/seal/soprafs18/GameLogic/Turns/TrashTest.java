package ch.uzh.ifi.seal.soprafs18.GameLogic.Turns;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TrashTest {
    Player nimra = new Player("Test");
    List<Card> selection = new ArrayList<>();

    @Test
    public void turnfunction() {
        nimra.drawCards();
        selection.add(nimra.handcards.get(0));
        Trash trash = new Trash(selection,nimra);
        trash.turnfunction();
        Assert.assertEquals(1,nimra.trashpile.size());
        Assert.assertEquals(3,nimra.handcards.size());



    }
}