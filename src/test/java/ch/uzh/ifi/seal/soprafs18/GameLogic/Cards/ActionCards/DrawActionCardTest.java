package ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ExpeditionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class DrawActionCardTest {

    private DrawActionCard DrawTwoCards = new DrawActionCard("Test","TestColor",true,1,2,true);
    @Test
    public void doSpecialFunction() {
        Player TestPlayer = new Player();
        List<Card> choice = new ArrayList<>();
        TestPlayer.drawCards();
        DrawTwoCards.setPlayer(TestPlayer);
        ExpeditionCard Tester1 = new ExpeditionCard("TestName","TestColour",true,1,1);
        ExpeditionCard Tester2 = new ExpeditionCard("TestName","TestColour",true,1,1);
        choice.add(Tester1);
        choice.add(Tester2);
        DrawTwoCards.getTrash(choice);
        DrawTwoCards.doSpecialFunction();
        int result = TestPlayer.handcards.size();
        Assert.assertEquals(6,result);

    }

    @Test
    public void TrashingCards(){
        Player TestPlayer = new Player();
        DrawTwoCards.setPlayer(TestPlayer);
        List<Card> choice = new ArrayList<>();
        ExpeditionCard Tester1 = new ExpeditionCard("TestName","TestColour",true,1,1);
        ExpeditionCard Tester2 = new ExpeditionCard("TestName","TestColour",true,1,1);
        choice.add(Tester1);
        choice.add(Tester2);
        DrawTwoCards.getTrash(choice);
        DrawTwoCards.doSpecialFunction();
        int actual = TestPlayer.trashpile.size();
        Assert.assertEquals(2,actual);


    }

    @Test
    public void getName() {
        String result = DrawTwoCards.getName();
        Assert.assertEquals("Test",result);


    }

    @Test
    public void getCardColour() {
        String result = DrawTwoCards.getCardColour();
        Assert.assertEquals("TestColor",result);
    }

    @Test
    public void getReusable() {
        boolean result = DrawTwoCards.getReusable();
        Assert.assertEquals(true,result);
    }

    @Test
    public void getPrice() {
        double result = DrawTwoCards.getPrice();
        Assert.assertEquals(1,result,0);

    }
}