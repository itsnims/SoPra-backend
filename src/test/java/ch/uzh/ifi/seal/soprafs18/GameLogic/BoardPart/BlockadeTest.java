package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Game;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BlockadeTest {

    private Blockade blockade= new Blockade(1, "green", false, false);
    private Player player= new Player("TestColor");
    private Field A = new Field(0,"Green",false,false,true);

    @Test
    public void setCrossed() {
        blockade.setCrossed();
        Assert.assertEquals(true, blockade.getCrossed());
    }

    @Test
    public void removeBlockade() {
        blockade.setCrossed();
        blockade.removeBlockade();
        Assert.assertEquals(0, blockade.getStrenght());
        Assert.assertEquals("pink", blockade.getColor());
    }

    @Test
    public void getcrossed() {
        boolean result = blockade.getCrossed();
        Assert.assertEquals(false,result);
    }

    @Test
    public void addNeighbour() {
       // blockade.addNeighbour(A);
       // Assert.assertEquals(1, blockade.neighbours.size());
       // Assert.assertEquals( A, blockade.neighbours.get(0));
    }

    @Test
    public void givePoints() {
        blockade.givePoints(player);
        Assert.assertEquals(1, player.getBlockadePoints());
    }
}