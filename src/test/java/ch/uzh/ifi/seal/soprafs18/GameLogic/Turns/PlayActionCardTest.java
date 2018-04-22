package ch.uzh.ifi.seal.soprafs18.GameLogic.Turns;

import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Field;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards.DrawActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards.MarketActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards.MoveActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Figure;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Market;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayActionCardTest {
    Market testmarket = new Market();
    Player player = new Player();
    MoveActionCard Natives1 = new MoveActionCard("Natives","Purple",true,5);
    DrawActionCard Cartographer1 = new DrawActionCard("Cartographer","Purple",true,4,2,false);
    MarketActionCard TelephoneTerminal1 = new MarketActionCard("Telephone Terminal","Purple",false,4);
    Figure smallplayer = new Figure();
    Field A1 = new Field(1,"green",true, "test");


    @Test
    public void turnfunctiondrawtest() {
        player.setup();
        PlayActionCard executeDrawCard = new PlayActionCard(Cartographer1,player);
        executeDrawCard.turnfunction();
        int actual = player.handcards.size();
        Assert.assertEquals(2,actual);
    }

    @Test
    public void turnfunctionmovetest(){
        player.setup();
        player.setMyFigure(smallplayer);
        PlayActionCard executeMoveCard = new PlayActionCard(Natives1,player);
        Natives1.positionChoice(A1);
        executeMoveCard.turnfunction();
        Field actual = player.myFigure.getCurrentPosition();
        Assert.assertEquals(A1,actual);
    }

    @Test
    public void turnfunctionmarkettest(){
        testmarket.getInstance().marketsetup();
        player.setup();
        MarketActionCard TelephoneTerminal2 = new MarketActionCard("Telephone Terminal","Purple",false,4);
        TelephoneTerminal1.setChoice(TelephoneTerminal2);
        PlayActionCard executemarketcard = new PlayActionCard(TelephoneTerminal1,player);
        executemarketcard.turnfunction();
        int actualleft = testmarket.getInstance().BottomCards.get(5).size();
        Assert.assertEquals(3,actualleft);




    }
}