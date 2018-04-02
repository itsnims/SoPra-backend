package ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ExpeditionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Market;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarketActionCardTest {
    MarketActionCard buyone = new MarketActionCard("test","color",true,1);
    Market TestMarket = new Market();
    Player player = new Player("Test");

    @Test
    public void setMarket() {

    }

    @Test
    public void setChoice() {
    }

    @Test
    public void setPlayer() {
    }

    @Test
    public void doSpecialFunction() {
        System.out.println(player.discardpile.size());
        ExpeditionCard Explorer1 = new ExpeditionCard("test","test",true,1,1);
        buyone.setMarket(TestMarket);
        buyone.setChoice(Explorer1);
        buyone.setPlayer(player);
        buyone.doSpecialFunction();
        System.out.println(player.discardpile.size());
        Card Actual = player.discardpile.get(0);

        Assert.assertEquals(Explorer1,Actual);

    }

    @Test
    public void getName() {
        String result = buyone.getCardColour();
        Assert.assertEquals("color",result);
    }

    @Test
    public void getCardColour() {
        String result = buyone.getCardColour();
        Assert.assertEquals("color",result);
    }

    @Test
    public void getReusable() {
        boolean result = buyone.getReusable();
        Assert.assertEquals(true,result);
    }

    @Test
    public void getPrice() {
        double result = buyone.getPrice();
        Assert.assertEquals(1,result,0);
    }
}