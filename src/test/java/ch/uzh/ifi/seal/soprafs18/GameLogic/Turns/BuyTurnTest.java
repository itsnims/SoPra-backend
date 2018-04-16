package ch.uzh.ifi.seal.soprafs18.GameLogic.Turns;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ExpeditionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Market;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BuyTurnTest {
    ExpeditionCard Scout1 = new ExpeditionCard("Scout","Green",true,1,2);
    Player player = new Player();
    Market test = new Market();


    @Test
    public void getCardtoBuy() {
        player.drawCards();
        List<Card> selection = player.handcards;
        BuyTurn buysth = new BuyTurn(selection,player);
        buysth.getCardtoBuy(Scout1);
        Assert.assertEquals(Scout1,buysth.CardToBuy());

    }

    @Test
    public void deletefromMarket() {
        player.drawCards();
        List<Card> selection = player.handcards;
        BuyTurn buysth = new BuyTurn(selection,player);
        buysth.getCardtoBuy(Scout1);
        buysth.setMarket(test);
        buysth.DeleteFromMarket();
        Assert.assertEquals(2,test.BottomCards.get(0).size());


    }

    @Test
    public void isUpperCard() {
        player.drawCards();
        List<Card> selection = player.handcards;
        BuyTurn buysth = new BuyTurn(selection,player);
        buysth.getCardtoBuy(Scout1);
        buysth.setMarket(test);
        boolean upper = buysth.IsUpperCard();
        Assert.assertEquals(false,upper);



    }

    @Test
    public void turnfunction() {
        player.drawCards();
        List<Card> selection = player.handcards;
        BuyTurn buysth = new BuyTurn(selection,player);
        buysth.getCardtoBuy(Scout1);
        buysth.setMarket(test);
        buysth.turnfunction();
        Assert.assertEquals(1,player.discardpile.size());
        Assert.assertEquals(4,player.selection.size());
        Assert.assertEquals(0,player.handcards.size());


    }
}