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
    Player player = new Player("green");
    MoveActionCard Natives1 = new MoveActionCard("Natives","Purple",true,5);
    DrawActionCard Cartographer1 = new DrawActionCard("Cartographer","Purple",true,4,2,false);
    MarketActionCard TelephoneTerminal1 = new MarketActionCard("Telephone Terminal","Purple",false,4);
    Figure smallplayer = new Figure();
    Field A1 = new Field(1,"green",true,true,true);


    @Test
    public void turnfunctiondrawtest() {
        PlayActionCard executeDrawCard = new PlayActionCard(Cartographer1,player);
        executeDrawCard.turnfunction();
        int actual = player.handcards.size();
        Assert.assertEquals(2,actual);
    }

    @Test
    public void turnfunctionmovetest(){
        player.setMyFigure(smallplayer);
        player.myFigure.setColor(player.Playercolor);
        PlayActionCard executeMoveCard = new PlayActionCard(Natives1,player);
        Natives1.positionChoice(A1);
        executeMoveCard.turnfunction();
        Field actual = player.myFigure.getCurrentPosition();
        Assert.assertEquals(A1,actual);
    }

    @Test
    public void turnfunctionmarkettest(){
        MarketActionCard TelephoneTerminal2 = new MarketActionCard("Telephone Terminal","Purple",false,4);
        TelephoneTerminal1.setChoice(TelephoneTerminal2);
        PlayActionCard executemarketcard = new PlayActionCard(TelephoneTerminal1,player);
        executemarketcard.turnfunction();

        System.out.println(testmarket.BottomCards.get(5).size()); /** doesn't delete it.. doesn't execute the loop **/
        System.out.println(player.discardpile.get(0));  /** but adds it to discardpile??'**/

    }
}