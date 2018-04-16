package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MarketTest {
    Market testmarket = new Market();

    @Test
    public void isfree() {
        boolean full;
        full = testmarket.isfree();
        Assert.assertEquals(false,full);
    }

    @Test
    public void getCardsfromUpper() {
        testmarket.BottomCards.remove(0);
        List<Card> wanteddeck;
        Object object= testmarket.UpperCards.get(0);
        wanteddeck = (List<Card>) object;
        testmarket.getCardsfromUpper(wanteddeck);
        List<Card>actualdeck;
        actualdeck = testmarket.BottomCards.get(testmarket.BottomCards.size()-1);
        Assert.assertEquals(wanteddeck,actualdeck);

    }

    @Test
    public void leftonDeckBottom() {
        List<Card> wanted;
        int actual;
        Object object= testmarket.BottomCards.get(3);
        wanted = (List<Card>) object;
        actual = testmarket.LeftonDeckBottom(wanted);
        Assert.assertEquals(3,actual);
    }

    @Test
    public void leftonDeckUpper() {
        List<Card> wanted;
        int actual;
        Object object= testmarket.UpperCards.get(5);
        wanted = (List<Card>) object;
        testmarket.UpperCards.get(5).clear();
        actual = testmarket.LeftonDeckUpper(wanted);
        Assert.assertEquals(0,actual);
    }
}