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
    private Field B = new Field(0,"Green",true, "test");

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



    @Test
    public void getCrossed() {
        blockade.setCrossed();
        Assert.assertEquals(true,blockade.crossed);
    }


    @Test
    public void setName() {
        blockade.setName("name");
        Assert.assertEquals("name",blockade.getName());
    }

    @Test
    public void getName() {
        blockade.setName("name");
        Assert.assertEquals("name",blockade.getName());
    }

    @Test
    public void getStrenght() {
        blockade.setStrenght(2);
        Assert.assertEquals(2,blockade.getStrenght());
    }


    @Test
    public void getNeighbours() {
        List<Field> fields = blockade.getNeighbours();
        Assert.assertEquals(0,fields.size());
        blockade.addNeighbour(A,B);
    }

    @Test
    public void setNeighbours() {
        List<Field> nah = new ArrayList<>();
        nah.add(A);
        blockade.setNeighbours(nah);
    }


    @Test
    public void setId() {
        long i = 12456;
        blockade.setId(i);
        long ex = blockade.getId();
        Assert.assertEquals(ex,12456);
    }


}
