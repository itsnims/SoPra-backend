package ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Figure;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveActionCardTest {
    Player nimra = new Player("Green");
    Figure smallnimra = new Figure();
    MoveActionCard MoveOne = new MoveActionCard("test","purple",true,1);

    @Test
    public void setPlayer() {
        nimra.setMyFigure(smallnimra);
        nimra.myFigure.setCurrentPosition(0);
        nimra.myFigure.setColor("green");

        MoveOne.positionChoice(2);
        MoveOne.setPlayer(nimra);
        MoveOne.doSpecialFunction();

        int Actual = nimra.myFigure.getCurrentPosition();
        Assert.assertEquals(2,Actual);
    }


}