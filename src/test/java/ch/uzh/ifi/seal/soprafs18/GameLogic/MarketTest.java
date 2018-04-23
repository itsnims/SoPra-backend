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
        testmarket.marketsetup();
        boolean full;
        full = testmarket.isfree();
        Assert.assertEquals(false,full);
    }

    @Test
    public void getCardsfromUpper() {
        testmarket.marketsetup();
        testmarket.BottomCards.remove(0);
        List<Card> wanteddeck;
        Object object= testmarket.UpperCards.get(0);
        wanteddeck = (List<Card>) object;
        testmarket.getCardsfromUpper(wanteddeck);
        List<Card>actualdeck;
        actualdeck = testmarket.BottomCards.get(testmarket.BottomCards.size()-1);
        Assert.assertEquals(wanteddeck,actualdeck);

    }





}