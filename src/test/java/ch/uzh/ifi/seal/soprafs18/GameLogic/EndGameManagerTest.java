package ch.uzh.ifi.seal.soprafs18.GameLogic;

import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.ElDorado;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndGameManagerTest {
    Player nimra = new Player();
    Player angela = new Player();
    Player clara = new Player();
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
        angela.setBlockadePoints(1);
        elDorado.getInstance().AddReacher(angela);
        winner = endGameManager.getWinner();
        Assert.assertEquals(angela,winner);
        clara.setBlockadePoints(0);
        elDorado.getInstance().AddReacher(clara);
        winner = endGameManager.getWinner();
        Assert.assertEquals(angela,winner);
        nimra.setBlockadePoints(2);
        elDorado.getInstance().AddReacher(nimra);
        winner = endGameManager.getWinner();
        Assert.assertEquals(nimra,winner);

    }
}