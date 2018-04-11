package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.ElDorado;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndGameManagerTest {
    Player nimra = new Player("Green");
    Player angela = new Player("Red");
    ElDorado elDorado = new ElDorado();
    EndGameManager endGameManager= new EndGameManager();
    Player winner;

    @Test
    public void checkifReached() {
        elDorado.getInstance().setReached();
        boolean actual = endGameManager.CheckifReached();
        Assert.assertEquals(true,actual);
    }

    @Test
    public void getWinner() {
        elDorado.getInstance().AddReacher(nimra);
        elDorado.getInstance().AddReacher(angela);
        nimra.setBlockadePoints(2);
        angela.setBlockadePoints(0);
        winner = endGameManager.getWinner();
        Assert.assertEquals(nimra,winner);
    }
}