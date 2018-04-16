package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.Constant.PlayerColor;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Field;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards.DrawActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards.MoveActionCard;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.Card;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Turns.PlayActionCard;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayerTest {

    private Player TestPlayer = new Player();
    private DrawActionCard TestCard = new DrawActionCard("Nimra","blue",true,2,2,false);
    Field A1 = new Field(1,"green",true,true,true);

    @Test
    public void TestdrawCards() {
        TestPlayer.setPlayerColor(PlayerColor.values()[1]);
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
    @Test
    public void setMyFigure(){
        Figure small = new Figure();
        TestPlayer.setMyFigure(small);
        TestPlayer.myFigure.setCurrentPosition(A1);
        TestPlayer.myFigure.setColor(TestPlayer.getPlayerColor());

        Assert.assertEquals(small,TestPlayer.myFigure);

    }

    @Test
    public void executeTurn(){
        PlayActionCard executethecard = new PlayActionCard(TestCard,TestPlayer);
        TestPlayer.executeTurn(executethecard);
        /** the player hasn't drawn any cards so far so it would be only the additionally drawn cards **/
        int actual = TestPlayer.handcards.size();
        Assert.assertEquals(2,actual);


    }





}