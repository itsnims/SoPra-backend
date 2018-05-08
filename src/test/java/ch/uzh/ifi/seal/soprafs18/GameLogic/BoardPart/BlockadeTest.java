package ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart;

import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Field;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BlockadeTest {

    private Blockade blockade= new Blockade("test",1, "green", false);
    private Player player= new Player();
    private Field A = new Field(0,"Green",true, "test");

    @Test
    public void setCrossed() {
        blockade.setCrossed();
        Assert.assertEquals(true, blockade.getCrossed());
    }

    @Test
    public void getcrossed() {
        boolean result = blockade.getCrossed();
        Assert.assertEquals(false,result);
    }


    @Test
    public void givePoints() {
        blockade.givePoints(player);
        int actual = player.getBlockadePoints();
        Assert.assertEquals(1,actual);
    }
}
