package ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards;

import ch.uzh.ifi.seal.soprafs18.Constant.PlayerColor;
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
    Player player = new Player();

    @Test
    public void doSpecialFunction() {
        player.setPlayerColor(PlayerColor.BLUE);
        player.setup();
        TestMarket.marketsetup();
        ExpeditionCard Scout1 = new ExpeditionCard("Scout","Green",true,1,2);
        buyone.setChoice(Scout1);
        buyone.setPlayer(player);
        buyone.setMarket(TestMarket);
        buyone.doSpecialFunction();
        int size = TestMarket.BottomCards.get(0).size();
        Card Actual = player.discardpile.get(0);

        Assert.assertEquals(Scout1,Actual);

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