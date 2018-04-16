package ch.uzh.ifi.seal.soprafs18.GameLogic.Cards.ActionCards;

import ch.uzh.ifi.seal.soprafs18.Constant.PlayerColor;
import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Field;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Figure;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveActionCardTest {
    Player nimra = new Player();
    Figure smallnimra = new Figure();
    MoveActionCard MoveOne = new MoveActionCard("test","purple",true,1);
    Field A1 = new Field(1,"green",true,true,true);

    @Test
    public void setPlayer() {
        nimra.setup();
        nimra.setPlayerColor(PlayerColor.BLUE);
        nimra.setMyFigure(smallnimra);
        nimra.myFigure.setCurrentPosition(A1);
        nimra.myFigure.setColor(nimra.getPlayerColor());

        MoveOne.positionChoice(A1);
        MoveOne.setPlayer(nimra);
        MoveOne.doSpecialFunction();

        Field Actual = nimra.myFigure.getCurrentPosition();
        Assert.assertEquals(A1,Actual);
    }

}