package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards.MoveActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;



public class PlayerTest {

    private Player TestPlayer = new Player("TestColor");

    @Test
    public void TestdrawCards() {
        int original = TestPlayer.handcards.size();
        TestPlayer.drawCards();
        int ExpectedResult = original + 4;
        int ActualResult = TestPlayer.handcards.size();
        Assert.assertEquals(ExpectedResult,ActualResult);
    }

    @Test
    public void TestdiscardCard() {
        TestPlayer.drawCards();
        int originalLenghtofDiscardPile = TestPlayer.discardpile.size();
        List<Card> selection = new ArrayList<>();
        selection.add(TestPlayer.handcards.get(1));
        TestPlayer.discardCard(selection);
        int Actual = TestPlayer.discardpile.size();

        Assert.assertEquals(1,Actual);

    }

    @Test
    public void TestaddtoDrawPile() {
        MoveActionCard TelephoneTerminal1 = new MoveActionCard("Telephone Terminal","Purple",false,4);
        MoveActionCard TelephoneTerminal2 = new MoveActionCard("Telephone Terminal","Purple",false,4);
        MoveActionCard TelephoneTerminal3 = new MoveActionCard("Telephone Terminal","Purple",false,4);
        List<Card> DiscardedCards = new ArrayList<>();
        DiscardedCards.add(TelephoneTerminal1);
        DiscardedCards.add(TelephoneTerminal2);
        DiscardedCards.add(TelephoneTerminal3);

        int Expected = TestPlayer.drawpile.size() + DiscardedCards.size();
        TestPlayer.addtoDrawPile(DiscardedCards);
        int Actual = TestPlayer.drawpile.size();
        Assert.assertEquals(Expected,Actual);

        }


    @Test
    public void TestSetBlockadePoints() {
        TestPlayer.setBlockadePoints(3);
        int result = TestPlayer.getBlockadePoints();

        Assert.assertEquals(3,result);

    }

    @Test
    public void addtoTrash(){
        MoveActionCard TelephoneTerminal1 = new MoveActionCard("Telephone Terminal","Purple",false,4);
        MoveActionCard TelephoneTerminal2 = new MoveActionCard("Telephone Terminal","Purple",false,4);
        MoveActionCard TelephoneTerminal3 = new MoveActionCard("Telephone Terminal","Purple",false,4);
        List<Card> Cards = new ArrayList<>();
        Cards.add(TelephoneTerminal1);
        Cards.add(TelephoneTerminal2);
        Cards.add(TelephoneTerminal3);
        TestPlayer.addtoTrash(Cards);
        int actual = TestPlayer.trashpile.size();
        Assert.assertEquals(3,actual);

    }
}