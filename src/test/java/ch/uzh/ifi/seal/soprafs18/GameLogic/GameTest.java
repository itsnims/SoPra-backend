package ch.uzh.ifi.seal.soprafs18.GameLogic;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    private Game game= new Game();
    private Player dPlaya= new Player("testCol");

    @Test
    public void AddPlayer() {
        game.addPlayer(dPlaya);
        Assert.assertEquals(dPlaya, game.getPlayer(0));
    }

    @Test
    public void round() {
    }

    @Test
    public void getRoundNum() {
        int result= game.getRoundNum();
        Assert.assertEquals(0, result);
    }

    @Test
    public void getNumFigures() {
        game.addPlayer(dPlaya);
        int result = game.getNumFigures();
        Assert.assertEquals(1, result);
    }
}